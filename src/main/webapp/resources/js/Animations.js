

$(document).ready(function () {

    $("#docInfo").hide();
    $(".iconosPrincipal").hide();
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
   // $(".alert").hide();
    $("#DespiezarFinal").hide();
    $("#IntentarArreglar").hide();
    $("#ArreglarOrdenadorAlmacen").hide();
    $("#componentesAlmacen").hide();
    $("#icoMenosModelos").hide();
    $("#NuevoModelo").hide();
    $("#icoMenosMarcas").hide();
    $("#NuevaMarca").hide();
    $("#modelo").hide();
    $("#icoMasModelos").hide();
    $("#mensajeCambioAula").hide();

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

    $("#icoMasModelos").click(function () {

        $("#icoMasModelos").hide();
        $("#icoMenosModelos").show();
        $("#modelo").hide(400);
        setTimeout(inputCompraModelo, 400);
    });
    function inputCompraModelo() {
        $("#NuevoModelo").show(400);
    }

    $("#icoMenosModelos").click(function () {
        $("#icoMasModelos").show();
        $("#icoMenosModelos").hide();
        $("#NuevoModelo").hide(400);
        $("#NuevoModelo").val(null);
        
        setTimeout(inputCompraMenosModelo, 400);
    });
    function inputCompraMenosModelo() {
        $("#modelo").show(400);
    }

    $("#icoMasMarcas").click(function () {
        $("#icoMasMarcas").hide();
        $("#icoMenosMarcas").show();
        $("#Marca").hide(400);
        $("#modelo").hide(400);
        setTimeout(inputCompraMenosMarca, 400);
    });
    function inputCompraMenosMarca() {
        $("#NuevaMarca").show(400);
        $("#NuevoModelo").show(400);
    }
    ;

    $("#icoMenosMarcas").click(function () {
        $("#NuevaMarca").hide(400);
        $("#NuevaMarca").val(null);
        $("#icoMasMarcas").show();
        $("#icoMenosMarcas").hide();
        setTimeout(inputCompraMasMarca, 400);
    });
    function inputCompraMasMarca() {
        $("#Marca").show(400);

    };
    
     

    $("#guardar").click(function(){
        $("#guardar").fadeOut(300);
        $("#modelo").fadeOut(400);
        $("#icoMasModelos").fadeOut(400);
        $("#icoMenosModelos").fadeOut(400);
        $("#icoMasMarcas").fadeOut(500);
        $("#icoMenosMarcas").fadeOut(500);
        $("#NuevoModelo").fadeOut(500);
        $("#Marca").fadeOut(500);
        $("#NuevaMarca").fadeOut(500);        
        $("#discoDuro").fadeOut(600); 
        $("#placa").fadeOut(700);
        $("#ram").fadeOut(800);
        $("#procesador").fadeOut(900);    
        $("#categoria").fadeOut(1000);
        $("#estancia").fadeOut(1100);
        $("#estado").fadeOut(1200);
        $("#ubicacion").fadeOut(1300);
        $("#precio").fadeOut(1400);
    });

$("#BotonActualizarOrdenador").click(function(){
     $("#mensajeCambioAula").show(500);
});

$("#selectAulaOrdenador").click(function(){
     $("#mensajeCambioAula").hide(500);
});

});


