angular.module('miApp', []).controller('controladorPractica', ['$scope', function ($scope) {

        $scope.eliminar = [
        ];

        $scope.anadir = function () {


            $scope.nuevoOrdenadorPrueba = {
                id: 0,
                precio: $scope.precio,
                ubicacion: $scope.ubicacion,
                fecha_baja: "--",
                categoria: {id: $scope.categoria},
                estado: {id: $scope.estado},
                marca: {id: $scope.marca},
                modelo: {id: $scope.modelo},
                caracteristicas: {id: $scope.caracteristica},
                estancia: {id: $scope.estancia}
            };

//        alert(JSON.stringify($scope.nuevoOrdenadorPrueba));

            var nuevoOrdenador = {
                "ordenador": angular.toJson($scope.nuevoOrdenadorPrueba)
            };

            alert(JSON.stringify(nuevoOrdenador));

            $.ajax({
                data: nuevoOrdenador,
                url: '../../Controlador',
                type: 'post'});
        };

        $scope.borrar = function () {

            var codigoB = {
                "codigo": $scope.codigoBarras               
            };

            $.ajax({
                data: codigoB,
                url: '../../Controlador',
                type: 'post',
                dataType: "json",
                beforeSend: function () {

                },
                success: function (response) {

                    $scope.eliminar = response;

                    //  alert('Fonnnso'+JSON.stringify($scope.eliminar.ubicacion+' Que si que el amdrid ganara la liga'));
                    $scope.ordenador = 'El ordenador que has seleccionado es el ' + $scope.eliminar.marca.nombre + ' ' + $scope.eliminar.modelo.nombre;
               
                
              
                
                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };

        //Animations
        $scope.MostrarDocBorrrar = function () {
            // $scope.mostrar=true;
            $("#InfoDespiezar").show();

        };

        $scope.eliminarProducto = function () {
                        
            var eliminarOrdenador = {
                "ordenadorEliminar": angular.toJson($scope.eliminar)
            };
            
            $.ajax({
                data: eliminarOrdenador,
                url: '../../ControladorEliminarDespiezar',
                type: 'post'});
            
        };
        
        $scope.despieceFinal = function (){
               
            var elementoDanadoAEliminar = {
                "procesador":   $scope.eliminar.caracteristicas.procesador,
                "ram":          $scope.eliminar.caracteristicas.ram,
                "hd":           $scope.eliminar.caracteristicas.hd,
                "mal":          $scope.selectDespiece,
                "idProducto":   $scope.eliminar.id  
            };
            alert(elementoDanadoAEliminar);
            $.ajax({
                data: elementoDanadoAEliminar,
                url: '../../ControladorEliminarDespiezar',
                type: 'post',
                beforeSend: function () {

                },
                success: function (response) {
                    
                    alert(response);
                    $scope.atencion=response;
               
                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };


    }]);





