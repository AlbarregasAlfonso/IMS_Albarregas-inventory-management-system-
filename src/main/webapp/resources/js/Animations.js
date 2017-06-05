

$(document).ready(function () {


    $("#probemos").click(function () {
        alert("funciona");
    });

    $("#docInfo").hide();
    $("span").hide();
    $("#panelPrincipal").hide();
    $("#escudo").hide();
    $("#subFooter").hide();
    $("#nombreOrdenador").hide();   //Ordenador que vamos a eliminar        BorradoDeOrdenador.jsp
    $("#Despiezar").hide();         //Boton de despiezar                    BorradoDeOrdenador.jsp 
    $("#ElliminarOrdenador").hide();//Boton de eliminar definitivamente     BorradoDeOrdenador.jsp 
    $("#infoIcoEliminar").hide();   //icono de informacion                  BorradoDeOrdenador.jsp 
    $("#infoIcoDespiezar").hide();  //icono de informacion                  BorradoDeOrdenador.jsp 
    $("#docEliminar").hide();       //icono de informacion                  BorradoDeOrdenador.jsp
    $("#InfoDespiezar").hide();     //icono de informacion                  BorradoDeOrdenador.jsp
    $("#radioDespiece").hide();     //check de despiece                     BorradoDeOrdenador.jsp

    setTimeout(descargar, 1000);

    function descargar() {
        $("#cargando").hide();
        $("#panelPrincipal").fadeIn();
        $("#escudo").fadeIn();
        setTimeout(descargariconos, 1000);
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

//Iconos de informacio
    $("#info").mouseover(function () {
        $("#docInfo").fadeIn("slow");
    });

    $("#info").mouseout(function () {
        $("#docInfo").fadeOut("slow");
    });
    //Iconos de informacio
    $("#borrar").click(function () {
        $("#nombreOrdenador").fadeIn("slow");
        $("#borrar").fadeOut(1000);
        $("#Despiezar").fadeIn(1000);
        $("#ElliminarOrdenador").fadeIn(1000);
        setTimeout(infoIcono, 1000);
    })
    function infoIcono() {
        $("#infoIcoEliminar").fadeIn(1300);   //icono de informacion                  BorradoDeOrdenador.jsp 
        $("#infoIcoDespiezar").fadeIn(1300);  //icono de informacion                  BorradoDeOrdenador.jsp 
    }
     
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
    
    $("#codigoBarras").focusin(function(){
        $("#nombreOrdenador").fadeOut("slow");
        $("#Despiezar").fadeOut(1000);
        $("#ElliminarOrdenador").fadeOut(1000);
        $("#info").fadeOut(1000);
        $("#radioDespiece").fadeOut(1000);
        setTimeout(botonBorrar, 1000);
    });
    
    function botonBorrar() {
               $("#borrar").fadeIn(1000); 
               $("#infoIcoDespiezar").fadeOut("slow");
               $("#infoIcoEliminar").fadeOut("slow");
              
    }
    
 
        $("#ElliminarOrdenador").click(function(){
            $("#radioDespiece").fadeIn(1000);
        });
        
        
    
});


