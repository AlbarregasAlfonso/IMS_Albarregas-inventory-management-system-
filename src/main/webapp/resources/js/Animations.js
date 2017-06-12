

$(document).ready(function () {

    $("#docInfo").hide();
    $("span").hide();
    $("#panelPrincipal").hide();
    $("#escudo").hide();
    $("#subFooter").hide();
    $("#Despiezar").hide();         //Boton de despiezar                    BorradoDeOrdenador.jsp 
    $("#ElliminarOrdenador").hide();//Boton de eliminar definitivamente     BorradoDeOrdenador.jsp 
    $("#infoIcoEliminar").hide();   //icono de informacion                  BorradoDeOrdenador.jsp 
    $("#infoIcoDespiezar").hide();  //icono de informacion                  BorradoDeOrdenador.jsp 
    $("#docEliminar").hide();       //icono de informacion                  BorradoDeOrdenador.jsp
    $("#InfoDespiezar").hide();     //icono de informacion                  BorradoDeOrdenador.jsp
    $("#radioDespiece").hide();     //check de despiece                     BorradoDeOrdenador.jsp
    $("#mensajeAlumnos").hide();
    $(".alert").hide();
    $("#DespiezarFinal").hide();
    $("#IntentarArreglar").hide();
    $("#ArreglarOrdenadorAlmacen").hide();
    $("#componentesAlmacen").hide();
    $("#NuevaMarca").hide();
    $("#icoMenosMarca").hide();

    setTimeout(descargar, 1000);

    function descargar() {
        $("#cargando").hide();
        $("#panelPrincipal").fadeIn();
        $("#escudo").fadeIn();
        setTimeout(descargariconos, 1000);
        $("#div2").fadeIn("slow");
    }
    ;

    $('#botonMenu2').click(function () {
        cambiarVentana();
        return false;
    });

    function cambiarVentana() {
        $(".iconosPrincipal").fadeOut("slow");
        $("#panelPrincipal").fadeOut("slow");
        $("#escudo").fadeOut("slow");
        $("#subFooter").fadeOut("slow");
        $("#cargando").show();
        window.location("OrdenadorYAlumno.xhtml");
    }
    ;
    function descargariconos() {
        $(".iconosPrincipal").fadeIn(1500);
        $("#subFooter").fadeIn(1500);
    }
    ;

//Iconos de informacio
    $("#info").mouseover(function () {
        $("#docInfo").fadeIn("slow");
    });

    $("#info").mouseout(function () {
        $("#docInfo").fadeOut("slow");
    });

    $("#infoIcoEliminar").mouseover(function () {
        $("#docEliminar").fadeIn("slow");
    });

    $("#infoIcoEliminar").mouseout(function () {
        $("#docEliminar").fadeOut("slow");
    });

    $("#infoIcoDespiezar").mouseover(function () {
        $("#infoDespiezar").fadeIn("slow");
    });

    $("#infoIcoDespiezar").mouseout(function () {
        $("#infoDespiezar").fadeOut("slow");
    });

    $("#ElliminarOrdenador").click(function () {
        $("#ElliminarOrdenador").fadeOut(1000);
        $("#Despiezar").fadeOut(1000);
        $("#infoIcoDespiezar").fadeOut(1000);
        setTimeout(iconosDespiece, 1000);

    });

    function iconosDespiece() {
        $("#radioDespiece").fadeIn(1000);
        $("#DespiezarFinal").fadeIn(1000);
    }
    ;

    $("#Despiezar").click(function () {
        $("#Despiezar").fadeOut("slow");
        $("#ElliminarOrdenador").fadeOut("slow");
        setTimeout(botonesArreglar, 1000);
    });

    function botonesArreglar() {
        $("#radioDespiece").fadeIn("slow");
        $("#IntentarArreglar").fadeIn("slow");
    }

    $("#icoMasMarcas").click(function () {
        $("#marca").hide(1000);
        $("#icoMenosMarcas ").show();
        $("#icoMasMarcas").hide();
        setTimeout(masMarcas, 1000);
    });
    function masMarcas() {
        $("#NuevaMarca").show(1000);
    }
    ;
    $("#icoMenosMarcas").click(function () {
        $("#NuevaMarca").hide(1000);
        $("#icoMasMarcas ").show();
        $("#icoMenosMarcas").hide();
        setTimeout(masMarcas, 1000);
    });
    function masMarcas() {
        $("#marca").show(1000);

    }
    ;

});


