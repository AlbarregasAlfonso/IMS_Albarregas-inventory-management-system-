<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resources/js/jquery-3.2.1.min.js"></script>
        <script src="resources/js/angular.min.js"></script>
        <script src="resources/js/AnadirAlumno.js"></script>
        <script src="resources/js/Animations.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <!--<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>--> 
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

        <link rel="stylesheet" href="resources/css/style2.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body ng-app="miAppAula" >
        <div ng-controller="controladorPracticaAula">
            <div id="top">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">Agregar un nuevo alumno</a>
                        </div>
                        <a class="botonesPanel" href="/20170222_CRUDHibernateJSF//faces/Principal.xhtml">
                            <span style="width: 50%; color: background" class="glyphicon glyphicon-home iconosPrincipal"></span>
                        </a>
                    </div>
                </nav>
            </div>
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">
                    <form name="miFormulario">
                        <div class="form-group">
                            <input name="nombre" ng-model="apellido" placeholder="nombre Alumno" type="text" class="form-control" id="anadirAlumnoName" required />
                        </div>
                        
                        <div class="form-group">
                            <input name="apellido" ng-model="nombre" placeholder="nombre Apellido" type="text" class="form-control" id="anadirAlumnoApe" required />
                        </div>
                        <div class="form-group">
                            <input name="posicion" ng-model="posicion" placeholder="Posicion" type="text" class="form-control" id="posicion" required />
                        </div>
                        <br/>
                        <select name="estancia" class="form-control" ng-model="estancia" id="estancia" required>
                            <option value="">Estancias</option> 
                            <c:forEach items="#{estancia.allEstancias()}" var="lp">
                                <option ng-value="${lp.id}"><c:out value="${lp.nombre}"/></option>               
                            </c:forEach>
                        </select>

                        <br/>
                        <select class="form-control" id="OrdenadoresSinAlumno" ng-model="SelectOrdenador">
                            <option  ng-repeat="x in ordenadoresSinAlumnos" value="{{x.id}}">{{x.marca.nombre}} {{x.modelo.nombre}} </option>
                        </select>
                        <button id="guardar" ng-show="miFormulario.apellido.$valid && miFormulario.nombre.$valid && estancia > 0" ng-click="anadirAlumno()" ng-model="botonGuardar" class="btn btn-warning">Guardar</button>
                        <button id="buscar" ng-show="miFormulario.apellido.$valid && miFormulario.nombre.$valid && estancia > 0" ng-click="buscarOrdenadoresSinAlumno()" ng-model="botonGuardar" class="btn btn-warning">Buscarle Ordenador</button>
                  <button id="guardarConAlumno" ng-show="miFormulario.apellido.$valid && miFormulario.nombre.$valid && estancia > 0 && SelectOrdenador > 0" ng-click="AnadirAlumnoConSuOrdendor()" ng-model="botonGuardar" class="btn btn-warning">Guardar Con Ordenador</button>
                    <div id="mensajeHasAnadidonuevoAlumno" class="alert alert-danger">¡Has añadido un nuevo Alumno!</div>
                    </form>
                </div>
                <div class="col-sm-4"></div>
            </div>
        </div>
    </body>
</html>
