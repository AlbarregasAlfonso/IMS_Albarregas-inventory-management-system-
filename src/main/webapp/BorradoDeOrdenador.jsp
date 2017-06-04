<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script src="resources/js/CreateAngular.js"></script>
        <script src="resources/js/Animations.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-animate.js"></script>
        <link rel="stylesheet" href="resources/css/style2.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body ng-app="miApp" >
        <div id="top">
               
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="#">Eliminar ordenador</a>
                            </div>
                        </div>
                    </nav>
            </div>
        <div ng-controller="controladorPractica">
            <div class="row">
                <div class="col-sm-4">
                    <br/>
                    <img  ng-model="infoIcoDespiezar" ng-mouseover="MostrarDocBorrrar()" ng-mouseleave="OcultarDocBorrar()" id="infoIcoDespiezar" src="resources/imagenes/inf.png" alt="" >
                    <label id="InfoDespiezar">Esta opción se recomienda si lo que quieres es quedarte con alguno de los componentes del ordenador</label>
                </div>
                <div class="col-sm-4">

                    <div class="form-group">
                        <input ng-model="codigoBarras" placeholder="codigo de barras" type="text" class="form-control" id="codigoBarras"/>
                    </div>
                    <br/>
                    <br/>

                    <label id="nombreOrdenador">{{ordenador}}</label>

                    <button id="borrar" ng-click="borrar()" ng-model="botonBorrar" class="btn btn-warning">Borrar</button>
                    <button id="ElliminarOrdenador" ng-click="eliminarProducto()" ng-model="botonElimiar" class="btn btn-danger">Eliminar</button>
                    <button id="Despiezar" ng-click="borrar()" ng-model="botonDespiezar" class="btn btn-warning">Despiezar</button>
                </div>
                <div class="col-sm-4">
                    <br/>
                    <br/>
                    <br/>
                    <img id="info" src="resources/imagenes/inf.png" alt="" > 

                    <label id="docInfo">mediante el código de barras podremos seleccionar el ordenador que queremos eliminar</label>

                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <label id="docEliminar">Si lo que deseas es eliminar producto definitivamente pulse el boton eliminar</label>
                    <img id="infoIcoEliminar" src="resources/imagenes/inf.png" alt="" > 
                </div>

            </div>
        </div>
    </body>
</html>
