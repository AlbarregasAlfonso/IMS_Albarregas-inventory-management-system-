

$(document).ready(function(){

$("span").hide();
$("#panelPrincipal").hide();
$("#escudo").hide();
  setInterval(descargar, 1000);

  function descargar() {
  $("#cargando").hide();
  $("#panelPrincipal").fadeIn();
  $("#escudo").fadeIn();
    setInterval(descargariconos, 1000);
  $("#div2").fadeIn("slow");

  }

  function descargariconos(){
    $("span").fadeIn(2000);
  }

});

var app = angular.module('appWeb',[]);
var botonPulsado=0;


  app.controller('controladorPractica',function($scope){


  });
