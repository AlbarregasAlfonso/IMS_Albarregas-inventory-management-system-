

$(document).ready(function () {


    $("#probemos").click(function () {
        alert("funciona");
    });
    
    $("#docInfo").hide();
    $("span").hide();
    $("#panelPrincipal").hide();
    $("#escudo").hide();
    $("#subFooter").hide();
    setTimeout(descargar,1000);

    function descargar() {
        $("#cargando").hide();
        $("#panelPrincipal").fadeIn();
        $("#escudo").fadeIn();
        setTimeout(descargariconos,1000);
        $("#div2").fadeIn("slow");
    }

    $('#botonMenu2').click(function () {
        cambiarVentana();
        return false;
    });

    function cambiarVentana() {
        $("span").fadeOut("slow");
        $("#panelPrincipal").fadeOut("slow");
        $("#escudo").fadeOut("slow");
        $("#subFooter").fadeOut("slow");
        $("#cargando").show();
        window.location("OrdenadorYAlumno.xhtml");
    }
    function descargariconos() {
        $("span").fadeIn(1500);
        $("#subFooter").fadeIn(1500)
    }

$("#info").mouseover(function(){
   $("#docInfo").fadeIn("slow");
});
$("#info").mouseout(function(){
    $("#docInfo").fadeOut("slow");
});



});


