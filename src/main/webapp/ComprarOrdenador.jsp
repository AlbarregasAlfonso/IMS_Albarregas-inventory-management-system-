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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="resources/css/style2.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body ng-app="miApp" >
        <div ng-controller="controladorPractica">
            <div id="top">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">Eliminar ordenador</a>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">

                    <div class="form-group">
                        <input ng-model="precio" placeholder="precio" type="text" class="form-control" id="precio"/>
                    </div>
                    <div class="form-group">
                        <input ng-model="ubicacion" placeholder="ubicacion" type="text" class="form-control" id="ubicacion"/>
                    </div>
                    <select class="form-control" ng-model="estado" id="estado">
                        <option value="">Estado</option> 
                        <c:forEach items="#{Estado.allEstados()}" var="lp">
                            <option ng-value="${lp.id}"><c:out value="${lp.descripcion}"/></option>               
                        </c:forEach>
                    </select>
                    <br/>
                    <select  class="form-control" ng-model="estancia" id="estancia">
                        <option value="">Estancias</option> 
                        <c:forEach items="#{estancia.allEstancias()}" var="lp">
                            <option ng-value="${lp.id}"><c:out value="${lp.nombre}" /></option>               
                        </c:forEach>
                    </select>
                    <br/>
                    <select  class="form-control" ng-model="categoria" id="categoria">
                        <option value="">Categoria</option> 
                        <c:forEach items="#{Categoria.allCategoria()}" var="lp">
                            <option ng-value="${lp.id}"><c:out value="${lp.nombre}" /></option>               
                        </c:forEach>
                    </select>
                    <br/>
                    <div class="form-group">
                        <input ng-model="procesador" placeholder="Procesador" type="text" class="form-control" id="procesador"/>
                    </div>
                    <div class="form-group">
                        <input ng-model="ram" placeholder="Ram" type="text" class="form-control" id="ram"/>
                    </div>
                    <div class="form-group">
                        <input ng-model="placa" placeholder="Placa" type="text" class="form-control" id="placa"/>
                    </div>
                    <div class="form-group">
                        <input ng-model="discoDuro" placeholder="DiscoDuro" type="text" class="form-control" id="discoDuro"/>
                    </div>

                    <select  class="form-control" ng-model="marca" ng-change="mostrarModelos()" id="Marca">
                        <option value="1">Marca</option> 
                        <c:forEach items="#{Marca.allMarcas()}" var="lp">	
                            <option ng-value="${lp.id}"><c:out value="${lp.nombre}"/></option>            
                        </c:forEach>
                    </select>
                    <span class="glyphicon glyphicon-plus" id="icoMasModelos"></span>
                    <span class="glyphicon glyphicon-plus" id="icoMenosModelos"></span>
                    <span class="glyphicon glyphicon-plus" id="icoMasMarcas"></span>
                    <span class="glyphicon glyphicon-plus" id="icoMenosMarcas"></span>
                    <br/>

                    
                    <select class="form-control" id="modelo" ng-model="modelo">
                            <option  ng-repeat="x in modelosSegunMarca" value="{{x.id}}">{{x.nombre}}</option>
                        </select>

                    <div class="form-group">
                        <input ng-model="ModelosNuevos" placeholder="Nueva Modelo" type="text" class="form-control" id="NuevoModelo"/>
                    </div>
                    <div class="form-group">
                        <input ng-model="Marcanueva" placeholder="Nueva Marca" type="text" class="form-control" id="NuevaMarca"/>
                    </div>
                    <br/>
                    <button id="guardar" ng-click="anadir()" ng-model="botonGuardar" class="btn btn-warning">Guardar</button>
                </div>
                <div class="col-sm-4"></div>
            </div>
        </div>
    </body>
</html>
