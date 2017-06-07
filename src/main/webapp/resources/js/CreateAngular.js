angular.module('miApp', []).controller('controladorPractica', ['$scope', function ($scope) {

        $("#codigoBarras").focusin(function () {
            //$("#nombreOrdenador").fadeOut("slow");
            $("#Despiezar").fadeOut(1000);
            $("#ElliminarOrdenador").fadeOut(1000);
            $("#info").fadeOut(1000);
            $("#radioDespiece").fadeOut(1000);
            $scope.ordenador = null;
            //$scope.ordenador = "";
            $("#nombreOrdenador").hide("slow");
            setTimeout(botonBorrar, 1000);
        });

        function botonBorrar() {
            $("#borrar").fadeIn(1000);
            $("#infoIcoDespiezar").fadeOut("slow");
            $("#infoIcoEliminar").fadeOut("slow");

        }

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
                async: false,
                dataType: "json",
                beforeSend: function () {

                },
                success: function (response) {

                    $scope.eliminar = response;

                    if ($scope.eliminar.id === 0) {
                        $("#nombreOrdenador").fadeIn("slow");
                        $scope.ordenador = "El ordenador que has seleccionado no existe";

                    } else {
                        $("#nombreOrdenador").fadeIn("slow");
                        $scope.ordenador = 'El ordenador que has seleccionado es el ' + $scope.eliminar.marca.nombre + ' ' + $scope.eliminar.modelo.nombre;

                        //$("#nombreOrdenador").fadeIn("slow");
                        $("#borrar").fadeOut(1000);

                        setTimeout(infoIcono, 1000);

                        function infoIcono() {
                            $("#infoIcoEliminar").fadeIn(1300);   //icono de informacion                  BorradoDeOrdenador.jsp 
                            $("#infoIcoDespiezar").fadeIn(1300);  //icono de informacion                  BorradoDeOrdenador.jsp 
                            $("#Despiezar").fadeIn(1000);         //botones
                            $("#ElliminarOrdenador").fadeIn(1000);//botones
                        }

                    }
                    //  alert('Fonnnso'+JSON.stringify($scope.eliminar.ubicacion));

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });


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

        $scope.despieceFinal = function () {

            var elementoDanadoAEliminar = {
                "procesador": $scope.eliminar.caracteristicas.procesador,
                "ram": $scope.eliminar.caracteristicas.ram,
                "hd": $scope.eliminar.caracteristicas.hd,
                "mal": $scope.selectDespiece,
                "idProducto": $scope.eliminar.id
            };
        
            $.ajax({
                data: elementoDanadoAEliminar,
                url: '../../ControladorEliminarDespiezar',
                type: 'post',
                async: false,
                beforeSend: function () {

                },
                success: function (response) {

                    $scope.alumnosSinOrdenadorJson = response;

                    $scope.alumnosSinOrdenadorArray = JSON.parse($scope.alumnosSinOrdenadorJson);
                    $scope.mensajeDeAlumnos = "";

                    for (var i = 0; i < $scope.alumnosSinOrdenadorArray.length; i++) {
                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos + $scope.alumnosSinOrdenadorArray[i].Nombre + ", ";
                    }
                    
                    $(".alert").fadeIn(2000);
//                    $("#tick").show(1000);
//                    setTimeout(mostrarMensaje, 1000);
//
//                    function mostrarMensaje() {
//                        $("#mensajeAlumnos").fadeIn("slow");
//                       
//                    }

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };
    }]);





