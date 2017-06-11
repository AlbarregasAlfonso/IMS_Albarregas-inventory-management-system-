angular.module('miApp', []).controller('controladorPractica', ['$scope', function ($scope) {

        $scope.propiedades = [];
        $scope.piezasAlmacen = [];

        $("#codigoBarras").focusin(function () {
            //$("#nombreOrdenador").fadeOut("slow");
            $("#Despiezar").fadeOut(1000);
            $("#ElliminarOrdenador").fadeOut(1000);
            $("#info").fadeOut(1000);
            $("#radioDespiece").fadeOut(1000);
            $scope.ordenador = null;
            //$scope.ordenador = "";
            $("#nombreOrdenador").hide("slow");
            $("#IntentarArreglar").fadeOut("slow");
            setTimeout(botonBorrar, 1000);
        });

        function botonBorrar() {
            $("#borrar").fadeIn(1000);
            $("#infoIcoDespiezar").fadeOut("slow");
            $("#infoIcoEliminar").fadeOut("slow");
            $(".alert").fadeOut("slow");
        }

        $scope.eliminar = [
        ];

        $scope.cargarCaracteristicas = function () {

            var caracteristica = "caracteristicas";

            var codigoB = {
                "caracteristicas": caracteristica

            };

            $.ajax({
                data: codigoB,
                url: '../../ControladorEliminarDespiezar',
                type: 'post',
                async: false,
                dataType: "json",
                beforeSend: function () {

                },
                success: function (response) {

                    $scope.propiedades = response;
                    //  $scope.propiedades = JSON.parse($scope.propiedadesJson);              
                    //  alert(JSON.stringify($scope.propiedades));

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });


        };


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

            $scope.nuevaCaracteristicaProcesador = {
                id: 0,
                compatibilidad: $scope.placa,
                descripcion: $scope.procesador,
                producto: {id: 6},
                propiedad: {id: 2}
            };

            $scope.nuevaCaracteristicaRam = {
                id: 0,
                compatibilidad: $scope.placa,
                descripcion: $scope.ram,
                producto: {id: 6},
                propiedad: {id: 1}
            };

            $scope.nuevaCaracteristicaPlaca = {
                id: 0,
                compatibilidad: $scope.placa,
                descripcion: $scope.placa,
                producto: {id: 6},
                propiedad: {id: 3}
            };

            $scope.nuevaCaracteristicaDiscoDuro = {
                id: 0,
                compatibilidad: $scope.placa,
                descripcion: $scope.discoDuro,
                producto: {id: 6},
                propiedad: {id: 4}
            };
//        alert(JSON.stringify($scope.nuevoOrdenadorPrueba));

            var nuevoOrdenador = {
                "ordenador": angular.toJson($scope.nuevoOrdenadorPrueba),
                "ram": angular.toJson($scope.nuevaCaracteristicaRam),
                "procesador": angular.toJson($scope.nuevaCaracteristicaProcesador),
                "placa": angular.toJson($scope.nuevaCaracteristicaPlaca),
                "discoDuro": angular.toJson($scope.nuevaCaracteristicaDiscoDuro)
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

                    if ($scope.eliminar === null) {
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
                "mal": $scope.SelectPropiedades,
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

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };

        $scope.arreglar = function () {

            var elementoDanadoAEliminar = {
                "Arreglarmal": $scope.SelectPropiedades,
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

                    $scope.HayComponenteParaReparar = response;
                    alert($scope.HayComponenteParaReparar);
                    $("#productosParaArreglar").fadeIn("slow");
//                    $scope.alumnosSinOrdenadorArray = JSON.parse($scope.alumnosSinOrdenadorJson);
//                    $scope.mensajeDeAlumnos = "";
//
//                    for (var i = 0; i < $scope.alumnosSinOrdenadorArray.length; i++) {
//                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos + $scope.alumnosSinOrdenadorArray[i].Nombre + ", ";
//                    }                    
//                    $(".alert").fadeIn(2000);

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };

        $scope.buscarPiezas = function () {

            //Animations
            //
            $("#componentesDanados").fadeOut(1000);
            $("#IntentarArreglar").fadeOut(1000);
            $("#infoIcoEliminar").fadeOut(1000);
            $("#infoIcoDespiezar").fadeOut(1000);
            $("#productosParaArreglar").fadeOut(1000);
            setTimeout(botonBorrarArreglar, 1000);
            function botonBorrarArreglar() {
                $("#ArreglarOrdenadorAlmacen").fadeIn(1000);
                $("#componentesAlmacen").fadeIn(1000);
            }
            ;

            var elementoDanadoAEliminar = {
                "componenteMalAMostrar": $scope.SelectPropiedades
            };

            $.ajax({
                data: elementoDanadoAEliminar,
                url: '../../ControladorEliminarDespiezar',
                type: 'post',
                async: false,
                beforeSend: function () {

                },
                success: function (response) {
                    $scope.piezasAlmacen = response;
                    alert($scope.piezasAlmacen);
                    $scope.arrayPiezasAlmacen = $.parseJSON(response);
                    alert(arrayPiezasAlmacen);
                    
                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };
    }]);





