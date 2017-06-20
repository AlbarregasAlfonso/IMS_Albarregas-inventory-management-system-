angular.module('miAppAula', []).controller('controladorPracticaAula', ['$scope', function ($scope) {

        $(document).ready(function () {
            $("#Aulas1").hide();
            $("#Alumnos1").hide();
            $("#posicionamiento").hide();
            $("#mensajeAlumnosQuitarOrdenador").hide();

            $("#PrefieroAsignarAlumno").click(function () {
                $("#AplicarCambio").hide(200);
                $("#PrefieroAsignarAlumno").hide(400);
                $("#Aulas1").hide(600);
                setTimeout(descargarI, 700);
            });

            function descargarI() {
                $("#Alumnos1").show(200);
                $("#posicionamiento").show(400);
            }
            ;

            $("#codigoBarras1").focusin(function () {
                $("#buscarOrdenador").show();
                $("#Aulas1").hide(400);
                $("#Alumnos1").hide(300);
                $("#posicionamiento").hide(200);
                $("#mensajeAlumnosQuitarOrdenador").hide(100);
                $("#AplicarCambio").hide(200);
                $("#PrefieroAsignarAlumno").hide(400);
                $("#AplicarCambioConAlumno").hide(500);

            });

            $("#codigoBarras1").focusout(function () {

                $("#AplicarCambio").show();
                $("#PrefieroAsignarAlumno").show();
                $("#AplicarCambioConAlumno").show();
                $scope.SelectAulasParaOrdenador = 0;
                $scope.SelectAlumnos = 0;
            });

            $("#AplicarCambioConAlumno").click(function () {
                $("#buscarOrdenador").show();
                $("#Aulas1").hide(400);
                $("#Alumnos1").hide(300);
                $("#posicionamiento").hide(200);
                $("#AplicarCambio").hide(200);
                $("#PrefieroAsignarAlumno").hide(400);
                $("#AplicarCambioConAlumno").hide(500);
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
                        $("#buscarOrdenador").fadeOut(200);
                        setTimeout(descargarIc, 200);

                        function descargarIc() {
                            $("#Aulas1").fadeIn(200);
                        }
                        ;

                    }
                    //  alert('Fonnnso'+JSON.stringify($scope.eliminar.ubicacion));
                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };

        $scope.AsignarSinAlumno = function () {
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
                    $scope.mensajeDeAlumnos = "";
                    for (var i = 0; i < $scope.alumnosSinOrdenador.length; i++) {
                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos + $scope.alumnosSinOrdenador[i].Nombre + " " + $scope.alumnosSinOrdenador[i].Apellidos + ", ";
                    }
                    ;
                    if ($scope.mensajeDeAlumnos !== "") {
                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos+"es el antiguo propietario de este ordenador por lo que actualmente no tiene ninguno ";

                    } else {
                        $scope.mensajeDeAlumnos = "Cambio realizado con exito";
                    }
                    $("#mensajeAlumnosQuitarOrdenador").show(1000);

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("algo ha fallado");
                }
            });

        };

        $scope.AsignarConAlumno = function () {
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

                    $scope.mensajeDeAlumnos = "";
                    for (var i = 0; i < $scope.alumnosSinOrdenador.length; i++) {
                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos + $scope.alumnosSinOrdenador[i].Nombre + " " + $scope.alumnosSinOrdenador[i].Apellidos + ", ";
                    }
                    ;
                    if ($scope.mensajeDeAlumnos !== "") {
                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos+"es el antiguo propietario de este ordenador por lo que actualmente no tiene ninguno ";

                    } else {
                        $scope.mensajeDeAlumnos = "Cambio realizado con exito";
                    }
                    $("#mensajeAlumnosQuitarOrdenador").show(1000);



                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("algo ha fallado");
                }
            });

        };

    }]);





