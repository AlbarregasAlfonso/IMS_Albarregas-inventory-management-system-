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
            <form name="miFormulario">
                        <select class="form-control" id="Aulas1" ng-model="SelectAulas">
                            <option value="0">Seleccione Aula</option>                       
                            <option  ng-repeat="x in Aulas" value="{{x.id}}">{{x.nombre}}</option>
                        </select>

                        <select class="form-control" id="Alumnos1" ng-model="SelectAlumnos">
                            <option value="0">Seleccione Alumno</option>
                            <option  ng-repeat="x in Alumnos" value="{{x.id}}">{{x.Nombre}} {{x.Apellidos}}</option>
                        </select>
                        <div class="form-group">
                            <input name="codigo" ng-model="codigoBarras" placeholder="Codigo de barras del ordenador" type="text" class="form-control" id="BuscarOrdenadorCodigo66" ng-pattern="patternCodigoOrdenador" required />
                        </div>
                        <label id="nombreOrdenadorAsignacion">{{ordenador}}</label>
                        <button id="Buscar1" ng-click="borrar()" ng-show="miFormulario.codigo.$valid"ng-model="botonBorrar" class="btn btn-warning">Buscar</button>
                        <button id="asignarOrdenadorAlumno1" ng-show="SelectAulas>0 && SelectAlumnos>0 " ng-click="asignarUnOrdenador()" ng-model="asignarOrdenadorAlumno" class="btn btn-warning">Asignar</button>
           <div id="alertAsignarOrdenador" class="alert alert-danger"> {{mensajeDeAlumnos}}</div> 
            </form>
        </div>
    </body>
</html>