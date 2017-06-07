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
        <link rel="stylesheet" href="resources/css/style2.css" />
        <meta http-equiv="Content-Type" content="text/html" charset=utf-8">
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
                    <img  ng-model="infoIcoDespiezar" id="infoIcoDespiezar" src="resources/imagenes/inf.png" alt="" >
                    <label id="InfoDespiezar">Esta opción es interesante si queremos reparar algún componente que que haya sido dañado o dejarlo deshabilitado temporalmente</label>
                </div>
                <div class="col-sm-4">

                    <div class="form-group">
                        <input ng-model="codigoBarras" placeholder="codigo de barras" type="text" class="form-control" id="codigoBarras"/>
                    </div>
                    <br/>
                    <br/>

                    <label id="nombreOrdenador">{{ordenador}}</label>

                    <button id="borrar" ng-click="borrar()" ng-model="botonBorrar" class="btn btn-warning">Borrar</button>
                    <button id="ElliminarOrdenador" ng-model="botonElimiar" class="btn btn-danger">Inservible</button>
                    <button id="Despiezar" ng-model="botonDespiezar" class="btn btn-warning">Arreglar</button>
                    <div id="radioDespiece">
                        <select ng-model="selectDespiece" class="form-control" id="componentesDanados">
                            <option>Ram</option>
                            <option>Procesador</option>
                            <option>Disco</option>
                            <option>Otro</option>
                        </select>
                        <button id="DespiezarFinal" ng-click="despieceFinal()" ng-model="botonDespiezarFinal" class="btn btn-warning">Despiezar</button>
                    </div>
 
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
            <div class="alert alert-danger">El ordenador que hemos seleccionado lamentablemente no tenia recuperación posible por loq eu lo hemos retirado y hemos guardado las piezas que aún servian en el almacen, los alumnos que se han quedado sin ordenador temporalmente son:{{mensajeDeAlumnos}}</div> 
        </div>
    </body>
</html>
