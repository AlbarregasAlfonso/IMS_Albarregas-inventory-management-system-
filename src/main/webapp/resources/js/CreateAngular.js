angular.module('miApp', []).controller('controladorPractica', ['$scope', function ($scope) {

$scope.eliminar = [
    ];
    
        $scope.anadir = function () {


            $scope.nuevoOrdenadorPrueba = {
                id:0,
                precio: $scope.precio,
                ubicacion: $scope.ubicacion,
                fecha_baja:"--",
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
//            alert("hola"+JSON.stringify(codigoB));
            
            
             $.ajax({
                data: codigoB,
                url: '../../Controlador',
                type: 'post',
                dataType: "json",
                beforeSend: function(){
                    
                },
                success: function (response){
                    
                 $scope.eliminar = response;
                 
                 
                  alert('Fonnnso'+JSON.stringify($scope.eliminar.ubicacion+' Que si que el amdrid ganara la liga'));
                  $scope.ordenador = $scope.eliminar.marca.nombre+' Que si que el amdrid ganara la liga';
                }, error: function (jqXHR, textStatus, errorThown){
                    alert("Algo fallo");
                }
             });
             
            
            
        };
    }]);





