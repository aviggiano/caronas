
<%@ page import="java.util.*" %>
<%@ page import="transacoes.Trajeto" %>
<%@ page import="data.TrajetoDO" %>


<html>
    <head>
        <title>CaronUSP - Buscar Carona</title>
        <style type="text/css">
            html, body {width:100%; height: 100%; }
            #map_canvas { height: 100%; width: 100%; }


            a.btn {
                background: #ccc;
                cursor: pointer;
                border-top: solid 2px #eaeaea;
                border-left: solid 2px #eaeaea;
                border-bottom: solid 2px #777;
                border-right: solid 2px #777;
                padding: 5px 5px;   	
            }

            a.down {
                background: #bbb;
                border-top: solid 2px #777;
                border-left: solid 2px #777;
                border-bottom:solid 2px  #eaeaea;
                border-right: solid 2px #eaeaea;
            }

            .ui-slider .ui-slider-handle {
                position: absolute;
                z-index: 2;
                width: 10px !important;
                height: 20px !important;
                cursor: default;
            }


        </style>


    </style>

    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyB0cAKOmLP4UzXReE_7JCbFmHvs3yVvB9E&sensor=false"></script>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

    <script type="text/javascript">
        var map;
      
        var isSelectingOrigin;
        var isSelectingDestination;
        var isOriginSelected;
        var isDestinationSelected;
        var originCoord;
        var destinationCoord;
      
        var originRadius;
        var destinationRadius;
      
        var pathCoordinates = [];
        var route = new google.maps.Polyline({
            path: pathCoordinates,
            strokeColor: "#FF0000",
            strokeOpacity: 1.0,
            strokeWeight: 5
        });
      
      
        var startMarkerImg = {
            url: 'images/startMarker.png',
            origin: new google.maps.Point(0,0),
            anchor: new google.maps.Point(19, 43)
        };
      
        var endMarkerImg = {
            url: 'images/endMarker.png',
            origin: new google.maps.Point(0,0),
            anchor: new google.maps.Point(0,56)
        };
      
      
        var startMarker = new google.maps.Marker({
            map: null,
            icon: startMarkerImg
        });
      
        var endMarker = new google.maps.Marker({
            map: null,
            icon: endMarkerImg
        });
      
      
        var circleOrg = new google.maps.Circle({
            strokeColor: "#0000FF",
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: "#0000FF",
            fillOpacity: 0.4
        });  
      
        var circleDest = new google.maps.Circle({
            strokeColor: "#0000FF",
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: "#0000FF",
            fillOpacity: 0.4
        });
      
      
      
      
      
      
        function Finish() {
          
          
            var departureTime = $('#txtHoraPartida').val();
            var dayinWeek = $('#cbDiaSemana').val();
          
            var searchData = {"originCoord": originCoord, "destinationCoord": destinationCoord, "departureTime": departureTime, "dayinWeek": dayinWeek, "originRadius": originRadius.toString(), "destinationRadius": destinationRadius.toString()};
          
          
            $.ajax({
                url: "SearchRide",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(searchData),
                contentType: 'application/json',
                mimeType: 'application/json',
              
                success: function (data) {
                  
                    var tableHTML = '<font size="5"><b>Resultados da Busca</b></font><br><br>';
                  
                    if (data.anuncios.length >= 1){
                      
                        tableHTML += '<table width="100%" border="1" cellpadding="0" cellspacing="0">';
                        tableHTML += '<tr><td><b>ID Anuncio</b></td>';
                        tableHTML += '<td><b>ID Trajeto</b></td>';
                        tableHTML += '<td><b>Ação</b></td>';
                        tableHTML += '</tr>';
                      
                        $.each(data.anuncios, function(index, value) {
                            tableHTML += '<tr><td><a href="./visualizarAnuncio.jsp&idanuncio=' + data.anuncios[index].idAnuncio + '">' + data.anuncios[index].idAnuncio + '</a></td>';
                            tableHTML += '<td>' + data.anuncios[index].idTrajeto + '</td>';
                            tableHTML += '<td><button onclick="drawRoute(' + data.anuncios[index].idTrajeto + ')">Visualizar trajeto</button></td>';
                        });
                      
                        tableHTML += '</tr></table>';
                    }
                  
                    else {
                        tableHTML += 'Carona não encontrada.';
                    }
                  
                    document.getElementById('routesTable').innerHTML = tableHTML;
                  
                },
                error:function(data,status,er) {
                    alert("error: "+data+" status: "+status+" er:"+er);
                }
            });
          
          
          
        }
      
      
        function drawRoute(routeId) {
          
            pathCoordinates = [];
          
            $.ajax({
                url: "GetRoute?idTrajeto=" + routeId,
                type: 'POST',
                dataType: 'json',
                data: {},
                contentType: 'application/json',
                mimeType: 'application/json',
              
                success: function (data) {
                  
                    var bounds = new google.maps.LatLngBounds();
                  
                    $.each(data.points, function(index, value) {
                        var point = new Object();
                        point.latitude = data.points[index].latitude;
                        point.longitude = data.points[index].longitude;
                      
                      
                        var gMapsPoint = new google.maps.LatLng(point.latitude, point.longitude);
                      
                        if (index == 0) {
                            startMarker.setPosition(gMapsPoint);
                        }
                      
                        else if (index == data.points.length - 1){
                            endMarker.setPosition(gMapsPoint);
                        }
                      
                        pathCoordinates.push(gMapsPoint);                                       
                        bounds.extend(gMapsPoint);
                      
                    });
                  
                  
                    endMarker.setMap(map);
                    startMarker.setMap(map);
                  
                    route.setPath(pathCoordinates);
                    route.setMap(map);	
                    map.fitBounds(bounds);
                  
                },
                error:function(data,status,er) {
                    alert("error: "+data+" status: "+status+" er:"+er);
                }
            });
        }
      
      
      
        function Init() {
          
            isSelectingOrigin = false;
            isSelectingDestination = false;
            iseOriginSelected = false;
            isDestinationSelected = false;
            originCoord = new Object();
            destinationCoord = new Object();
          
            $( "#sliderOrigin" ).slider({
                range: "min",
                value: 1,
                min: 0.1,
                max: 5,
                step: 0.1,
                slide: function( event, ui ) {
                  
                    originRadius = ui.value*1000;
                    $('#originRadiusValue').html(ui.value + ' km');
                  
                },
                change: function( event, ui ) {
                    if (isOriginSelected) {
                        circleOrg.setRadius(ui.value*1000);
                        circleOrg.setMap(map);
                    }
                }
            });
          
            originRadius = $('#sliderOrigin').slider( "value" )*1000;
            $('#originRadiusValue').html($('#sliderOrigin').slider("value") + ' km');
          
            $( "#sliderDestination" ).slider({
                range: "min",
                value: 1,
                min: 0.1,
                max: 5,
                step: 0.1,
                slide: function( event, ui ) {      
                    destinationRadius = ui.value*1000;
                    $('#destinationRadiusValue').html(ui.value + ' km');
                },
                change: function( event, ui ) {
                    if (isDestinationSelected) {
                        circleDest.setRadius(ui.value*1000);
                        circleDest.setMap(map);
                    }
                }
            });
          
            destinationRadius = $('#sliderDestination').slider( "value" )*1000;
            $('#destinationRadiusValue').html($('#sliderOrigin').slider("value") + ' km');
          
          
          
            $('a#btnOrigin').click(function(){
                $(this).toggleClass("down");
                if (isSelectingOrigin == false) {
                    isSelectingOrigin = true;
                }
                else if (isSelectingOrigin == true) {
                    isSelectingOrigin = false;
                }
              
                if (isSelectingDestination == true) {
                    $('#btnDestination').toggleClass("down");
                    isSelectingDestination = false;
                }
            });
          
            $('a#btnDestination').click(function(){
                $(this).toggleClass("down");
                if (isSelectingDestination == false) {
                    isSelectingDestination = true;
                }
                else if (isSelectingDestination == true) {
                    isSelectingDestination = false;
                }
              
                if (isSelectingOrigin == true) {
                    $('#btnOrigin').toggleClass("down");
                    isSelectingOrigin = false;
                }
              
            });
          
          
            var myOptions = {
                zoom: 14,
                center: new google.maps.LatLng(-23.546, -46.638),
                mapTypeId: google.maps.MapTypeId.ROADMAP,
                disableDoubleClickZoom: true,
                scrollwheel: true,
                draggableCursor: "crosshair"
            }
          
            map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
          
            google.maps.event.addListener(map,'click',function(event) { 
              
                if (isSelectingOrigin == true) {
                  
                    var gMapsPoint = new google.maps.LatLng(event.latLng.lat(), event.latLng.lng());
                  
                    originCoord.latitude = gMapsPoint.lat();
                    originCoord.longitude = gMapsPoint.lng();
                    startMarker.setPosition(gMapsPoint);
                    startMarker.setMap(map);
                  
                    circleOrg.setCenter(gMapsPoint);
                    circleOrg.setRadius(originRadius);
                  
                    circleOrg.setMap(map);
                  
                    isOriginSelected = true;
                  
                    $('#btnOrigin').toggleClass("down");
                    isSelectingOrigin = false;                
                }
              
                if (isSelectingDestination == true) {
                  
                    var gMapsPoint = new google.maps.LatLng(event.latLng.lat(), event.latLng.lng());
                  
                    destinationCoord.latitude = gMapsPoint.lat();
                    destinationCoord.longitude = gMapsPoint.lng();
                    endMarker.setPosition(gMapsPoint);
                    endMarker.setMap(map);
                  
                    circleDest.setCenter(gMapsPoint);
                    circleDest.setRadius(destinationRadius);
                  
                    circleDest.setMap(map);
                  
                    isDestinationSelected = true;
                  
                    $('#btnDestination').toggleClass("down");
                    isSelectingDestination = false; 
                }
              
            })
          
        }
      
        function deleteRoute(routeId) {
          
            $.ajax({
                url: "DeleteRoute?idTrajeto=" + routeId,
                type: 'POST',
                dataType: 'json',
                data: {},
                contentType: 'application/json',
                mimeType: 'application/json',
              
                success: function (data) {
                    alert(data.msg);
                    window.location.reload();
                  
                },
                error:function(data,status,er) {
                    alert("error: "+data+" status: "+status+" er:"+er);
                }
            });
          
        }
      
      
    </script>
</head>
<body onload="Init()">

    <table width="100%" height="90%" cellpadding="5" cellspacing="5">
        <tr><td width="70%"><div id="map_canvas"></div></td>
            <td width="30%" valign="top">

                <font size="5"><b>Pesquisar Carona</b></font><br><br>

                Clique nos botões abaixo para selecionar os pontos de origem e destino no mapa.<br><br>
        <center>
            <a id="btnOrigin" title="btnOrigin" class="btn">Selecionar Origem</a>
            <a id="btnDestination" title="btnDestination"  class="btn">Selecionar Destino</a><br><br>
            Selecione raio de abrangência na origem:
            <div id="sliderOrigin" style="height: 10px; width: 200px;"></div>
            <div id="originRadiusValue"></div><br><br>

            Selecione raio de abrangência no destino:
            <div id="sliderDestination" style="height: 10px; width: 200px;"></div>
            <div id="destinationRadiusValue"></div><br><br>

        </center>
        Dia da Semana: <select id="cbDiaSemana">
            <option value="1">Domingo</option>
            <option value="2" selected>Segunda</option>
            <option value="3">Terça</option>
            <option value="4">Quarta</option>
            <option value="5">Quinta</option>
            <option value="6">Sexta</option>
            <option value="7">Sábado</option>                              
        </select><br>

        Hora de Partida: <input type="text" id="txtHoraPartida"/><br><br>
        <center>
            <button onclick="Finish()">Buscar carona</button><br><br><br>
        </center>

        <div id="routesTable"></div>
    </td>
</tr>
</table>
</body>
</html>
