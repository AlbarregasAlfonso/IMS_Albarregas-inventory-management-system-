angular.module('miAppAula', []).controller('controladorPracticaAula', ['$scope', function ($scope) {

 $scope.ordenadoresSinAlumnos= [];

        $scope.anadirAlumno = function () {

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

            var buscarOrdenador = {ordenador: "Ordenador"
            };

            $.ajax({
                data: buscarOrdenador,
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

$scope.AnadirAlumnoConSuOrdendor = function () {


            var nuevoAlumnoConOrdenador = {nombre: $scope.nombre,
                apellido: $scope.apellido,
                estancia: $scope.estancia,
                ordenadorSinAlumno: $scope.SelectOrdenador,
                posicion : $scope.posicion
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





