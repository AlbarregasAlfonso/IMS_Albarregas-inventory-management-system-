angular.module('miAppAula', []).controller('controladorPracticaAula', ['$scope', function ($scope) {

//        $scope.alumnosSinOrdenador = [];
//        $scope.Aulas = [];
//        $scope.Alumnos = [];
//
//        $.ajax({
//            url: '../../ControladorCambiarOrdenadorAlumno',
//            type: 'post',
//            async: false,
//            beforeSend: function () {
//
//            },
//            success: function (response) {
//                $scope.Aulas = JSON.parse(response);
//
//
//            }, error: function (jqXHR, textStatus, errorThown) {
//                alert("Algo fallo");
//            }
//        });
//
//        $("#Aulas").change(function () {
//
//            var idAula = {
//                "idAula": $("#Aulas").val()
//            };
//
//            $.ajax({
//                data: idAula,
//                url: '../../ControladorCambiarOrdenadorAlumno',
//                type: 'post',
//                async: false,
//                beforeSend: function () {
//
//                },
//                success: function (response) {
//                    $scope.Alumnos = JSON.parse(response);
//
//                }, error: function (jqXHR, textStatus, errorThown) {
//                    alert("Algo fallo");
//                }
//            });
//        });
//
//
//
//        /////////////////////////////////////
//        $scope.borrar = function () {
//            var codigoB = {
//                "codigo": $scope.codigoBarras
//            };
//
//            $.ajax({
//                data: codigoB,
//                url: '../../Controlador',
//                type: 'post',
//                async: false,
//                dataType: "json",
//                beforeSend: function () {
//
//                },
//                success: function (response) {
//
//                    $scope.eliminar = response;
//
//                    if ($scope.eliminar === null) {
//                        $("#nombreOrdenador").fadeIn("slow");
//                        $scope.ordenador = "El ordenador que has seleccionado no existe";
//
//                    } else {
//                        $("#nombreOrdenador").fadeIn("slow");
//                        $scope.ordenador = 'El ordenador que has seleccionado es el ' + $scope.eliminar.marca.nombre + ' ' + $scope.eliminar.modelo.nombre;
//
//                        //$("#nombreOrdenador").fadeIn("slow");
//                        $("#borrar").fadeOut(1000);
//
//                        setTimeout(infoIcono, 1000);
//
//                        function infoIcono() {
//                            $("#infoIcoEliminar").fadeIn(1300);   //icono de informacion                  BorradoDeOrdenador.jsp 
//                            $("#infoIcoDespiezar").fadeIn(1300);  //icono de informacion                  BorradoDeOrdenador.jsp 
//                            $("#Despiezar").fadeIn(1000);         //botones
//                            $("#ElliminarOrdenador").fadeIn(1000);//botones
//                        }
//
//                    }
//                    //  alert('Fonnnso'+JSON.stringify($scope.eliminar.ubicacion));
//
//                }, error: function (jqXHR, textStatus, errorThown) {
//                    alert("Algo fallo");
//                }
//            });
//        };
//
//        $scope.asignarUnOrdenador = function () {
//
//
//            var ordenador = {
//                "ordenadorSimple": $scope.codigoBarras,
//                "aula": $scope.SelectAulas,
//                "alumno": $scope.SelectAlumnos
//            };
//
//            $.ajax({
//                data: ordenador,
//                url: '../../ControladorCambiarOrdenadorAlumno',
//                type: 'post',
//                async: false,
//                //dataType: "json",
//                beforeSend: function () {
//
//                },
//                success: function (response) {
//                    $scope.alumnosSinOrdenador = JSON.parse(response);
//                    alert(JSON.stringify($scope.alumnosSinOrdenador));
//                    alert($scope.alumnosSinOrdenador);
//                    
//                        $scope.mensajeDeAlumnos = "";
//
//                    for (var i = 0; i < $scope.alumnosSinOrdenador.length; i++) {
//                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos + $scope.alumnosSinOrdenador[i].Nombre + ", ";
//                    };
//                    alert($scope.mensajeDeAlumnos);
//
//                }, error: function (jqXHR, textStatus, errorThown) {
//                    alert("algo ha fallado");
//                }
//            });
//
//
//        };


    }]);





