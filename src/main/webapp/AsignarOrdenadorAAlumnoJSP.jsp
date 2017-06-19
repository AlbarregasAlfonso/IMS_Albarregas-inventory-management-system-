<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <!--<script src="resources/js/OrdenadorAlumnoAngular.js"></script>-->
        <script src="resources/js/jquery-3.2.1.min.js"></script>
        <script src="resources/js/angular.min.js"></script>
        <script src="resources/js/Animations.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-animate.js"></script>
<!--        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>-->
        <link rel="stylesheet" href="resources/css/style2.css" />
        <script src="resources/js/OrdenadorAlumnoYAulaAdminAngular.js"></script>

<!--                <script src="resources/js/jquery-3.2.1.min.js"></script>
        <script src="resources/js/angular.min.js"></script>
        <script src="resources/js/OrdenadorAlumnoAngular.js"></script>
        <script src="resources/js/Animations.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-animate.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
        <link rel="stylesheet" href="resources/css/style2.css" />-->
        
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body ng-app="miAppAula" >
        <div id="top">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Eliminar ordenador</a>
                    </div>
                </div>
            </nav>
        </div>
        <div ng-controller="controladorPracticaAula">
            <div class="row">
                <div class="col-sm-4">

                </div>
                <div class="col-sm-4">
                    <select class="form-control" id="AulasAsig" ng-model="SelectAulas">
                        <option  ng-repeat="x in Aulas" value="{{x.id}}">{{x.nombre}}</option>
                    </select>
                    <select class="form-control" id="AlumnosAsig" ng-model="SelectAlumnos">
                        <option  ng-repeat="x in Alumnos" value="{{x.id}}">{{x.Nombre}}</option>
                    </select>
                      <div class="form-group">
                        <input ng-model="codigoBarras" placeholder="Codigo de barras del ordenador" type="text" class="form-control" id="BuscarOrdenadorCodigo"/>
                    </div>
                     <label id="nombreOrdenador">{{ordenador}}</label>
                    <button id="Buscar" ng-click="borrar()" ng-model="botonBorrar" class="btn btn-warning">Borrar</button>
                    <button id="asignarOrdenadorAlumno" ng-click="asignarUnOrdenador()" ng-model="asignarOrdenadorAlumno" class="btn btn-warning">Asignar</button>
                    <label>{{mensajeDeAlumnos}}</label>
                </div>
                <div class="col-sm-4">
                </div>
            </div>

        </div>
    </body>
</html>