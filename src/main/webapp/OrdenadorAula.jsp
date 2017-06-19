<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resources/js/jquery-3.2.1.min.js"></script>
        <script src="resources/js/angular.min.js"></script>
        <script src="resources/js/OrdenadorAula.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-animate.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>-->
        <link rel="stylesheet" href="resources/css/style3.css" />
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body ng-app="miAppAula" >
        <div id="top">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">Mover Ordenador</a>
                    </div>
                </div>
            </nav>
        </div>
        <div ng-controller="controladorPracticaAula">
            <form name="miFormulario">

                <div class="form-group">
                    <input name="codigo" ng-model="codigoBarras" placeholder="Codigo de barras del ordenador" type="text" class="form-control" id="codigoBarras1" ng-pattern="patternCodigoOrdenador" required/>
                </div>
                <label id="nombreOrdenador1">{{ordenador}}</label>
                <button id="buscarOrdenador" ng-show="miFormulario.codigo.$valid" ng-click="borrar()" ng-model="botonBorrar" class="btn btn-warning" >Seleccionar</button>

                <select class="form-control" id="Aulas1" ng-model="SelectAulasParaOrdenador">
                    <option value="0">Seleccione Aula</option>                       
                    <option  ng-repeat="x in Aulas" value="{{x.id}}">{{x.nombre}}</option>
                </select>

                <select class="form-control" id="Alumnos1" ng-model="SelectAlumnos">
                    <option value="0">Seleccione Alumno</option>
                    <option  ng-repeat="x in Alumnos" value="{{x.id}}">{{x.Nombre}} {{x.Apellidos}}</option>
                </select>

                <div class="form-group">
                    <input name="posicionamiento" ng-model="posicionamiento" placeholder="Posición que ocupará" type="text" class="form-control" id="posicionamiento" required/>
                </div>

                <button id="AplicarCambio" ng-show="SelectAulasParaOrdenador > 0" ng-click="AsignarSinAlumno()" ng-model="botonBorrar" class="btn btn-warning">Aplicar Cambios</button>
                <button id="PrefieroAsignarAlumno" ng-show="SelectAulasParaOrdenador > 0" ng-model="PrefieroAsignarAlumno" class="btn btn-warning">Prefiero asignarselo a un alumno</button>
                <button id="AplicarCambioConAlumno" ng-show="SelectAlumnos > 0 && miFormulario.posicionamiento.$valid" ng-click="AsignarConAlumno()" ng-model="AplicarCambioConAlumno" class="btn btn-warning">Asignarselo A Alumnos</button>
                <div id="mensajeAlumnosQuitarOrdenador" class="alert alert-danger">El alumno {{mensajeDeAlumnos}} de este aula era el antiguo propietario del ordenador y actualmetne no posee ninguno</div> 
            </form>
        </div>



    </body>
</html>