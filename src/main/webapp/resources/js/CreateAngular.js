angular.module('miApp', []).controller('controladorPractica', ['$scope', function ($scope) {

        $scope.propiedades = [];
        $scope.piezasAlmacen = [];
        $scope.eliminar = [];
        $scope.modelosSegunMarca = [];

        $scope.patternCodigoOrdenador = /[0-9]/;
        $scope.patternNombre = /^[a-zA-Z]*$/;
        $scope.patternDisco = /[0-9]{4,5}/;
        

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
            $("#componentesAlmacen").hide(1000);
            $("#DespiezarFinal").fadeOut(400);
            setTimeout(botonBorrar, 1000);
        });

        function botonBorrar() {
            $("#borrar").fadeIn(1000);
            $("#infoIcoDespiezar").fadeOut("slow");
            $("#infoIcoEliminar").fadeOut("slow");
            $(".alert").fadeOut("slow");
        }
        
        $("#codigoBarras").focusout(function () {
      
        });
//cuando hacemos seleccionamos alguna marca
        $scope.mostrarModelos = function () {
            $("#modelo").show(400);
            $("#icoMasModelos").show(400);

            var idMarca = {
                "idMarca": $scope.marca
            };
            $.ajax({
                data: idMarca,
                url: '../../Controlador',
                type: 'post',
                async: false,
                beforeSend: function () {

                },
                success: function (response) {
                    $scope.modelosSegunMarca = JSON.parse(response);

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });

        };

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

            var f = new Date();

            $scope.marcaNueva = {id: 0,
                nombre: $scope.Marcanueva};

            $scope.nuevoModelo = {id: 0,
                nombre: $scope.ModelosNuevos,
                marcaNueva: {id: "0", nombre: "null"}
            };

            $scope.nuevoOrdenadorPrueba = {
                id: 0,
                precio: $scope.precio,
                ubicacion: $scope.ubicacion,
                fecha_baja: "--",
                fecha_compra: f.getDate() + "/" + (f.getMonth() + 1) + "/" + f.getFullYear(),
                categoria: {id: $scope.categoria},
                estado: {id: $scope.estado},
                marca: {id: $scope.marca},
                modelo: {id: $scope.modelo},
                caracteristicas: {id: 1},
                estancia: {id: $scope.estancia}
            };

            $scope.nuevaCaracteristicaProcesador = {
                id: 0,
                descripcion: $scope.procesador,
                producto: {id: 0},
                propiedad: {id: 2}
            };

            $scope.nuevaCaracteristicaRam = {
                id: 0,
                descripcion: $scope.ram,
                producto: {id: 0},
                propiedad: {id: 1}
            };

            $scope.nuevaCaracteristicaPlaca = {
                id: 0,
                descripcion: $scope.placa,
                producto: {id: 0},
                propiedad: {id: 3}
            };

            $scope.nuevaCaracteristicaDiscoDuro = {
                id: 0,
                descripcion: $scope.discoDuro,
                producto: {id: 0},
                propiedad: {id: 4}
            };
//        alert(JSON.stringify($scope.nuevoOrdenadorPrueba));

            var nuevoOrdenador = {
                "ordenador": angular.toJson($scope.nuevoOrdenadorPrueba),
                "ram": angular.toJson($scope.nuevaCaracteristicaRam),
                "procesador": angular.toJson($scope.nuevaCaracteristicaProcesador),
                "placa": angular.toJson($scope.nuevaCaracteristicaPlaca),
                "discoDuro": angular.toJson($scope.nuevaCaracteristicaDiscoDuro),
                "nuevaMarca": angular.toJson($scope.marcaNueva),
                "nuevoModelo": angular.toJson($scope.nuevoModelo)
            };


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
                    if ($scope.mensajeDeAlumnos !== "") {
                        $scope.mensajeDeAlumnos = $scope.mensajeDeAlumnos+" es el alumno que se ha quedado sin ordenador debido a que estaba averiado, las piezas que estan bien de este ordenador se han guardado en el almacen";

                    } else {
                        $scope.mensajeDeAlumnos = "Ordenador aliminado, no afecta a ningun alumno";
                    }
                    
                    
                     $("#mensajeOrdenadorSinRecuperacion").show(1000);
                    //$(".alert").fadeIn(2000);

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
                $("#componentesAlmacen").show(1000);
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
                    $scope.arrayPiezasAlmacen = $.parseJSON(response);
              

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };

        $scope.sustituirComponente = function (index) {
//            alert("Id del elemento seleccionado "+$scope.arrayPiezasAlmacen[index].id);
//            alert("Id del ordenador "+$scope.eliminar.id);
//            alert("Tipo propiedad seleccionada "+$scope.SelectPropiedades); 
           $("#componentesAlmacen").hide(1000);

            var UtilidadesParaArreglarOrdenador = {
                "almacenARemplazar": $scope.arrayPiezasAlmacen[index].nombre,
                "idPropiedad": $scope.SelectPropiedades,
                "idProductopropiedadARemplazar": $scope.eliminar.id
            };

            $.ajax({
                data: UtilidadesParaArreglarOrdenador,
                url: '../../ControladorEliminarDespiezar',
                type: 'post',
                async: false,
                beforeSend: function () {

                },
                success: function (response) {

                }, error: function (jqXHR, textStatus, errorThown) {
                    alert("Algo fallo");
                }
            });
        };



        $scope.Inicio = function () {

            var caracteristica = "caracteristicas";

            var codigoB = {
                "caracteristicas": caracteristica

            };

            $.ajax({
                data: codigoB,
                url: 'ControladorEliminarDespiezar',
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

    }]);





