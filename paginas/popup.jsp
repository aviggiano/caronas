<!DOCTYPE html>
<html>
<body>

<p>Click the button to open an a new window called "MsgWindow" with some text.</p>

emptyField()

<script>
function emptyField()
{
var myWindow = window.open("","MsgWindow","width=200,height=100");
myWindow.document.write("<p>This is 'MsgWindow'");
}
</script>

</body>
</html>
