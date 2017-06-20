angular.module('miAppAula', []).controller('controladorPracticaAula', ['$scope', function ($scope) {

        $("#OrdenadoresSinAlumno").hide();
        


        $scope.ordenadoresSinAlumnos = [];

        $scope.anadirAlumno = function () {
            
            $("#anadirAlumnoName").hide(700);
            $("#anadirAlumnoApe").hide(700);
            $("#posicion").hide(600);
            $("#estancia").hide(600);
            $("#OrdenadoresSinAlumno").hide(500);
            $("#guardar").hide(400);
            $("#buscar").hide(400);
            $("#guardarConAlumno").hide(400);
            $("#mensajeHasAnadidonuevoAlumno").show(1500);
            
            var nuevoAlumno = {nombre: $scope.nombre,
                apellido: $scope.apellido,
                estancia: $scope.estancia
            };

            $.ajax({
                data: nuevoAlumno,
                url: '../../ControladorNuevoAlumno',
                type: 'post',
                async: false,
                beforeSend: function () {

                },
                success: function (response) {
                    $scope.Aulas = JSON.parse(response);

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });

        };

        $scope.buscarOrdenadoresSinAlumno = function () {


            $("#OrdenadoresSinAlumno").show(300);
            var buscarOrdenador = {ordenador: "Ordenador"
            };

            $.ajax({
                data: buscarOrdenador,
                url: '../../ControladorNuevoAlumno',
                type: 'post',
                async: false,
                beforeSend: function () {

                },
                success: function (response) {
                    $scope.ordenadoresSinAlumnos = JSON.parse(response);

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });

        };

        $scope.AnadirAlumnoConSuOrdendor = function () {
            $("#anadirAlumnoName").hide(700);
            $("#anadirAlumnoApe").hide(700);
            $("#posicion").hide(600);
            $("#estancia").hide(600);
            $("#OrdenadoresSinAlumno").hide(500);
            $("#guardar").hide(400);
            $("#buscar").hide(400);
            $("#guardarConAlumno").hide(400);
            $("#mensajeHasAnadidonuevoAlumno").show(1500);

            var nuevoAlumnoConOrdenador = {nombre: $scope.nombre,
                apellido: $scope.apellido,
                estancia: $scope.estancia,
                ordenadorSinAlumno: $scope.SelectOrdenador,
                posicion: $scope.posicion
            };

            $.ajax({
                data: nuevoAlumnoConOrdenador,
                url: '../../ControladorNuevoAlumno',
                type: 'post',
                beforeSend: function () {

                },
                success: function (response) {
                    $scope.ordenadoresSinAlumnos = JSON.parse(response);

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });

        };
    }]);





