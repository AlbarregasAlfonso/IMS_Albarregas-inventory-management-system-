angular.module('miApp', []).controller('controladorPractica', ['$scope', function ($scope) {
        
$scope.mensajeLogin="";

        $scope.Loguearse = function () {

            var loguearse = {
                "usuario": $scope.clave,
                "clave": $scope.usuario
            };

            $.ajax({
                data: loguearse,
                url: 'ControladorLogin',
                type: 'post',
                async: false,
                //dataType: "json",
                beforeSend: function () {

                },
                success: function (response) {
                    if (response === "false") {
                        $scope.mensajeLogin="Usuario incorrecto";
                        $("#usuario").fadeOut(200);
                        $("#clave").fadeOut(350);
                        $("#acceder").fadeOut(500);
                        setTimeout(descargarLoginIncorrecto, 500);

                        function descargarLoginIncorrecto() {
                                $("#mensajelogincorrecto").show(600);  
                                 setTimeout(descargarLoginIncorrectoInput, 1500);
                                
                        }
                        function descargarLoginIncorrectoInput() {
                            $("#mensajelogincorrecto").hide(200); 
                            $("#usuario").fadeIn(400);
                        $("#clave").fadeIn(550);
                        $("#acceder").fadeIn(700);
                        }
                    } else {
                        $scope.mensajeLogin="Usuario correcto";
                        $("#usuario").fadeOut(400);
                        $("#clave").fadeOut(550);
                        $("#acceder").fadeOut(700);
                        setTimeout(descargarLogin, 700);

                        function descargarLogin() {
                                $("#accederAceptado").show(200);
                                $("#imagenCorrecto").show(400);
                                $("#mensajelogincorrecto").show(600);
                                
                        }

                        
                    }


                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };
    }]);