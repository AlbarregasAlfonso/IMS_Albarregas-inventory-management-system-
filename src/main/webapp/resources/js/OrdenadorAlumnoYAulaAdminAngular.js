angular.module('miAppAula', []).controller('controladorPracticaAula', ['$scope', function ($scope) {
        
$(document).ready(function () {
        $("#BuscarOrdenadorCodigo66").focusin(function () {
            $("#Aulas1").hide(200);
            $("#Alumnos1").hide(400);
            $("#alertAsignarOrdenador").hide(1000);
            $("#asignarOrdenadorAlumno1").hide();
            $scope.SelectAulas=0;
            $scope.SelectAlumnos=0;
        });
        $("#BuscarOrdenadorCodigo66").focusout(function () {
            $("#asignarOrdenadorAlumno1").show();
        });
    
});
        $scope.alumnosSinOrdenador = [];
        $scope.Aulas = [];
        $scope.Alumnos = [];

        $scope.patternCodigoOrdenador = /[0-9]/;

        

        $.ajax({
            url: '../../ControladorCambiarOrdenadorAlumno',
            type: 'post',
            async: false,
            beforeSend: function () {

            },
            success: function (response) {
                $scope.Aulas = JSON.parse(response);
            },
            error: function (jqXHR, textStatus, errorThown) {
                alert("Algo fallo");
            }
        });



        $("#Aulas1").change(function () {

            var idAula = {
                "idAula": $("#Aulas1").val()
            };

            $.ajax({
                data: idAula,
                url: '../../ControladorCambiarOrdenadorAlumno',
                type: 'post',
                async: false,
                beforeSend: function () {

                },
                success: function (response) {
                    $scope.Alumnos = JSON.parse(response);

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        });

        $scope.borrar = function () {
            var codigoB = {
                "codigo": $scope.codigoBarras
            };

            $.ajax({
                data: codigoB,
                url: '../../Controlador',
                type: 'post',
                async: false,
                dataType: "json",
                beforeSend: function () {

                },
                success: function (response) {

                    $scope.eliminar = response;

                    if ($scope.eliminar === null) {
                        $("#nombreOrdenador").fadeIn("slow");
                        $scope.ordenador = "El ordenador que has seleccionado no existe";

                    } else {
                        $("#nombreOrdenador").fadeIn("slow");
                        $scope.ordenador = 'El ordenador que has seleccionado es el ' + $scope.eliminar.marca.nombre + ' ' + $scope.eliminar.modelo.nombre;

                        //$("#nombreOrdenador").fadeIn("slow");
                        $("#Aulas1").show(400);
                        $("#Alumnos1").show(700);
                        $("#borrar").fadeOut(1000);
                        $("#buscarOrdenador").fadeOut(700);
                        setTimeout(descargarMas, 500);

                        function descargarMas() {
                            $("#Aulas").fadeIn(300);
                            //$("#AplicarCambio").fadeIn(300);
                            //$("#PrefieroAsignarAlumno").fadeIn(1000);
                        }
                    }
                    //  alert('Fonnnso'+JSON.stringify($scope.eliminar.ubicacion));
                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };

        $scope.asignarUnOrdenador = function () {

            var ordenador = {
                "ordenadorSimple": $scope.codigoBarras,
                "aula": $scope.SelectAulas,
                "alumno": $scope.SelectAlumnos
            };

            $.ajax({
                data: ordenador,
                url: '../../ControladorCambiarOrdenadorAlumno',
                type: 'post',
                async: false,
                beforeSend: function () {

                },
                success: function (response) {
                    $scope.alumnosSinOrdenador = JSON.parse(response);

                    $scope.mensajeDeAlumnos = "";

                    for (var i = 0; i < $scope.alumnosSinOrdenador.length; i++) {
                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos + $scope.alumnosSinOrdenador[i].Nombre + ", ";
                    };
                    if ($scope.mensajeDeAlumnos !== "") {
                        $scope.mensajeDeAlumnos=$scope.mensajeDeAlumnos+" es el antiguo alumno que tenia el ordenador, ahora no tiene ninguno";
                        $("#alertAsignarOrdenador").show(1000);
                    }else{
                        $scope.mensajeDeAlumnos = "Cambio realizado con exito";
                        $("#alertAsignarOrdenador").show(1000);
                    }
                    

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("algo ha fallado");
                }
            });


        };

        $scope.AsignarSinAlumno = function () {

            alert($scope.codigoBarras);
            alert($scope.SelectAulasParaOrdenador);
            alert($scope.posicionamiento);

            var compnentesCambio = {
                "ordenadorSimpleCambioDeAula": $scope.codigoBarras,
                "aulaCambioDeOrdenador": $scope.SelectAulasParaOrdenador,
                "posicionamiento": $scope.posicionamiento
                        // "alumno": $scope.SelectAlumnos
            };

            $.ajax({
                data: compnentesCambio,
                url: '../../ControladorEliminarDespiezar',
                type: 'post',
                async: false,
                //dataType: "json",
                beforeSend: function () {

                },
                success: function (response) {
                    $scope.alumnosSinOrdenador = JSON.parse(response);
                    alert(JSON.stringify($scope.alumnosSinOrdenador));
                    alert($scope.alumnosSinOrdenador);

                    $scope.mensajeDeAlumnos = "";
                    for (var i = 0; i < $scope.alumnosSinOrdenador.length; i++) {
                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos + $scope.alumnosSinOrdenador[i].Nombre + " " + $scope.alumnosSinOrdenador[i].Apellidos + ", ";
                    }
                    ;
                    alert($scope.mensajeDeAlumnos);

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("algo ha fallado");
                }
            });

        };

        $scope.AsignarConAlumno = function () {

            alert($scope.codigoBarras);
            alert($scope.SelectAulasParaOrdenador);
            alert($scope.posicionamiento);
            alert($scope.SelectAlumnos);

            var compnentesCambio = {
                "ordenadorSimpleCambioDeAula": $scope.codigoBarras,
                "aulaCambioDeOrdenador": $scope.SelectAulasParaOrdenador,
                "posicionamiento": $scope.posicionamiento,
                "alumno": $scope.SelectAlumnos
            };

            $.ajax({
                data: compnentesCambio,
                url: '../../ControladorEliminarDespiezar',
                type: 'post',
                async: false,
                //dataType: "json",
                beforeSend: function () {

                },
                success: function (response) {
                    $scope.alumnosSinOrdenador = JSON.parse(response);
                    alert(JSON.stringify($scope.alumnosSinOrdenador));
                    alert($scope.alumnosSinOrdenador);

                    $scope.mensajeDeAlumnos = "";
                    for (var i = 0; i < $scope.alumnosSinOrdenador.length; i++) {
                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos + $scope.alumnosSinOrdenador[i].Nombre + ", ";
                    }
                    ;
                    alert($scope.mensajeDeAlumnos);

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("algo ha fallado");
                }
            });

        };

    }]);





