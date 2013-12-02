
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
    <title>CaronUSP - Inserir Trajeto</title>
        <style type="text/css">
            html, body {width:100%; height: 100%; }
            #map_canvas { height: 70%; width: 90%; }
        </style>
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyB0cAKOmLP4UzXReE_7JCbFmHvs3yVvB9E&sensor=false"></script>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script type="text/javascript">
      
            var map, path = new google.maps.MVCArray(), service = new google.maps.DirectionsService(), shiftPressed = false, poly;

            google.maps.event.addDomListener(document, "keydown", function(e) { shiftPressed = e.shiftKey; });
            google.maps.event.addDomListener(document, "keyup", function(e) { shiftPressed = e.shiftKey; });
    
    
            window.onunload = refreshParent;
    
            function refreshParent() {
                window.opener.location.reload();
            }
    
	
            function Finish() {
		
                var points = [];
            
                for (var i = 0; i < path.length; i++) {
                    var latLng = path.getAt(i);
                    var pointsItem = new Object();
                    pointsItem.lat = latLng.lat().toString();
                    pointsItem.lng = latLng.lng().toString();                   
                        
                    points.push(pointsItem);
                }
                var routeName = $('#txtNomeTrajeto').val();
                var idUser = 1;
                var pathData = {"points": points, "routeName": routeName, "idUser": idUser};
                
                
                $.ajax({
                    url: "AddRoute",
                    type: 'POST',
                    dataType: 'json',
                    data: JSON.stringify(pathData),
                    contentType: 'application/json',
                    mimeType: 'application/json',
 
                    success: function (data) {
                        alert(data.msg);
                        window.close();
                                        
                    },
                    error:function(data,status,er) {
                        alert("error: "+data+" status: "+status+" er:"+er);
                    }
                });
                        
                        

            }
	


            function Init() {
    
                var myOptions = {
                    zoom: 14,
                    center: new google.maps.LatLng(-23.546, -46.638),
                    mapTypeId: google.maps.MapTypeId.ROADMAP,
                    disableDoubleClickZoom: true,
                    scrollwheel: false,
                    draggableCursor: "crosshair"
                }

                map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
                poly = new google.maps.Polyline({ map: map });
                google.maps.event.addListener(map, "click", function(evt) {
                    if (shiftPressed || path.getLength() === 0) {
                        path.push(evt.latLng);
                        if(path.getLength() === 1) {
                            poly.setPath(path);
                        }
                    } else {
                        service.route({ origin: path.getAt(path.getLength() - 1), destination: evt.latLng, travelMode: google.maps.DirectionsTravelMode.DRIVING }, function(result, status) {
                            if (status == google.maps.DirectionsStatus.OK) {
                                for(var i = 0, len = result.routes[0].overview_path.length; i < len; i++) {
                                    path.push(result.routes[0].overview_path[i]);
                                }
                            }
                        });
                    }
                });
            }
        </script>

    <title>CaronUSP - O maior site de caronas do Brasil!</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
      
      <script type="text/javascript">

$(function(){
       Init();
});

</script>

    <div class="container">
      <div class="row">
            <h2>Inserir Trajeto</h2>
            <br>
            <div class="col-3 col-sm-3 col-lg-3">
                <p align="justify">Desenhe seu trajeto no mapa ao lado, partindo de seu ponto inicial até o final.</p><br><br>
              Dê um nome para seu trajeto: <input type="text" id="txtNomeTrajeto" style="width:100%"/><br><br>
              <center><a class="btn btn-success btn-sm" href="javascript:Finish()" role="button">Finalizar</a></center>
            </div><!--/span-->
            
            <div class="col-9 col-sm-9 col-lg-9">            
            <div id="map_canvas" width="100%" height="100%"></div>
            </div>
            
        </div><!--/span-->

      <hr>

      <footer>
        <p>&copy; CaronUSP 2013</p>
      </footer>
  </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>

