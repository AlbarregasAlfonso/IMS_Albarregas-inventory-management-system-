<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resources/js/jquery-3.2.1.min.js"></script>
        <script src="resources/js/angular.min.js"></script>
        <script src="resources/js/CreateAngular.js"></script>
        <script src="resources/js/Animations.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-animate.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
        <link rel="stylesheet" href="resources/css/style2.css" />
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Borrar ordenador</title>
    </head>
    <body ng-app="miApp" >
        <div id="top">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Eliminar ordenador</a>
                    </div>
                    <a class="botonesPanel" href="/InventoryManagerSystem//faces/Principal.xhtml">
                        <span style="width: 50%; color: background" class="glyphicon glyphicon-home iconosPrincipal"></span>
                    </a>
                </div>
            </nav>
        </div>
        <div ng-controller="controladorPractica">
            <form name="miFormulario">
                <div class="row">
                    <div class="col-sm-4">
                        <br/>
                        <img  ng-model="infoIcoDespiezar" id="infoIcoDespiezar" src="resources/imagenes/inf.png" alt="" >
                        <label id="InfoDespiezar">Esta opción es interesante si queremos reparar algún componente que que haya sido dañado o dejarlo deshabilitado temporalmente</label>
                    </div>
                    <div class="col-sm-4">
                        <div class="form-group">
                            <input name="codigo" ng-model="codigoBarras" placeholder="codigo de barras" type="text" class="form-control" id="codigoBarras" ng-pattern="patternCodigoOrdenador" required/>
                        </div>
                        <br/>
                        <br/>

                        <button id="borrar" ng-show="miFormulario.codigo.$valid" ng-click="borrar()" ng-model="botonBorrar" class="btn btn-warning">Borrar</button>
                        <button id="ElliminarOrdenador" ng-click="cargarCaracteristicas()" ng-model="botonElimiar" class="btn btn-danger">Inservible</button>
                        <button id="Despiezar" ng-click="cargarCaracteristicas()" ng-model="botonDespiezar" class="btn btn-warning">Arreglar</button>
                        <div id="radioDespiece">
                            <select class="form-control" id="componentesDanados" ng-model="SelectPropiedades">
                                <option  ng-repeat="x in propiedades" value="{{x.id}}">{{x.nombre}}</option>
                            </select>
                            <!--                        <select ng-model="selectDespiece" class="form-control" id="componentesDanados">
                                                        <option value="1">Ram</option>
                                                        <option value="2">Procesador</option>
                                                        <option value="4">Disco</option>
                                                        <option value="3">Otro</option>
                                                    </select>-->
                        </div>
                        <button id="DespiezarFinal" ng-click="despieceFinal()" ng-model="botonDespiezarFinal" class="btn btn-warning">Despiezar</button>
                        <button id="IntentarArreglar" ng-show="SelectPropiedades > 0"ng-click="arreglar()"  ng-model="IntentarArreglar" class="btn btn-warning">Arreglar</button>

                    </div>
                    <div class="col-sm-4">
                        <br/>
                        <br/>
                        <br/>
                        <img id="info" src="resources/imagenes/inf.png" alt="" > 
                        <label id="docInfo">mediante el código de barras podremos seleccionar el ordenador que queremos eliminar o despiezar</label>
                        <br/>
                        <br/>
                        <br/>
                        <br/>
                        <label id="docEliminar">Si lo que deseas es eliminar producto definitivamente pero mantener algunos de los componentes que te puedan servir para otros ordenadores seleccione esta opción</label>
                        <img id="infoIcoEliminar" src="resources/imagenes/inf.png" alt="" > 
                    </div>
                </div>
                <!--            <img id="tick" src="resources/imagenes/correcto.png" alt="" > 
                            <label id="mensajeAlumnos">El ordenador que hemos seleccionado lamentablemente no tenia recuperación posible por loq eu lo hemos retirado y hemos guardado las piezas que aún servian en el almacen, los alumnos que se han quedado sin ordenador temporalmente son:{{mensajeDeAlumnos}}</label>-->
                <div id="mensajeOrdenadorSinRecuperacion" class="alert alert-danger">{{mensajeDeAlumnos}}</div> 
                <div ng-click="buscarPiezas()" id="productosParaArreglar" class="alert alert-danger">{{HayComponenteParaReparar}}</div> 
                <!--            <select class="form-control" id="componentesAlmacen" ng-model="SelectPropiedadesAlmacen">
                                <option  ng-repeat="x in [1, 1, 1] track by piezasAlmacen" value="{{x.id}}">{{x.nombre}}</option>
                            </select>-->
                <table class="table border-bordered" id="componentesAlmacen" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Caracteristica</th>
                            <th>Compatibilidad (Placa)</th>
                            <th>Arreglar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr  ng-repeat="componente in arrayPiezasAlmacen">
                            <td >{{componente.nombre}}</td>
                            <td >{{componente.compatibilidad}}</td>
                            <td><span ng-model="controladorPractica.editar" ng-click="sustituirComponente($index)" class="glyphicon glyphicon-plus" id="icoArreglar"></span></td>
                            <!--<td><span ng-model="practicas.editar" ng-click="practicas.seleccionarTabla($index)" class="glyphicon glyphicon-plus"></span><span ng-click="practicas.eliminarSeleccion($index)" class="glyphicon glyphicon-minus"></span></td>-->
                        </tr>
                    </tbody>
                </table>
                <label id="nombreOrdenador">{{ordenador}}</label>
            </form>
        </div>
    </body>
</html>