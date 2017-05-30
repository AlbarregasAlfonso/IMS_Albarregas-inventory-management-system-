angular.module('miApp', []).controller('controladorPractica', ['$scope', function($scope) {
 
    $scope.anadir = function() {
      alert($scope.categoria);
      
       $scope.nuevoOrdenadorPrueba = {  precio: $scope.precio, 
                                        ubicacion: $scope.ubicacion, 
                                        fechaAlta: $scope.fechaAlta, 
                                        categoria: $scope.categoria, 
                                        estado: $scope.estado, 
                                        marca: $scope.marca,
                                        modelo: $scope.modelo,
                                        caracteristica: $scope.caracteristica,
                                        estancia: $scope.estancia};

        alert(JSON.stringify($scope.nuevoOrdenadorPrueba));
    
    };
}]);





