

$(document).ready(function () {

$("#probemos").click(function(){
   alert("funciona"); 
});

    window.onload = funcion_primera;
    function funcion_primera() {
        alert("Se ha lanzado la PRIMERA función");
    }
    window.onload = funcion_primera;


    $("span").hide();
    $("#panelPrincipal").hide();
    $("#escudo").hide();
    $("#subFooter").hide();
    setInterval(descargar, 1000);

    function descargar() {
        $("#cargando").hide();
        $("#panelPrincipal").fadeIn();
        $("#escudo").fadeIn();
        setInterval(descargariconos, 1000);
        $("#div2").fadeIn("slow");
    }

    $('#botonMenu1').click(function () {
        cambiarVentana();
        return false;
    });

    function cambiarVentana() {
        $("span").fadeOut("slow");;
        $("#panelPrincipal").fadeOut("slow");;
        $("#escudo").fadeOut("slow");;
        $("#subFooter").fadeOut("slow");;
        window.location("OrdenadorYAlumno.xhtml");
    }
    function descargariconos() {
        $("span").fadeIn(1500);
        $("#subFooter").fadeIn(1500)
    }

});

var app = angular.module('appWeb', []);
var botonPulsado = 0;


app.controller('controladorPractica', function ($scope) {


});
