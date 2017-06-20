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
       <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script> 
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
                            <a class="navbar-brand" href="#">Comprar ordenador</a>
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
                        <input name="precio" ng-model="precio" placeholder="precio" type="text" class="form-control" id="precio" ng-pattern="patternCodigoOrdenador" required/>
                    </div>
                    <div class="form-group">
                        <input name="ubicacion" ng-model="ubicacion" placeholder="ubicacion" type="text" class="form-control" id="ubicacion" required/>
                    </div>
                    <select name="estado" class="form-control" ng-model="estado" id="estado" required>
                        <option value="">Estado</option> 
                        <c:forEach items="#{Estado.allEstados()}" var="lp" >
                            <option ng-value="${lp.id}"><c:out value="${lp.descripcion}" /></option>               
                        </c:forEach>
                    </select>
                    <br/>
                    <select name="estancia" class="form-control" ng-model="estancia" id="estancia" required>
                        <option value="">Estancias</option> 
                        <c:forEach items="#{estancia.allEstancias()}" var="lp">
                            <option ng-value="${lp.id}"><c:out value="${lp.nombre}"/></option>               
                        </c:forEach>
                    </select>
                    <br/>
                    <select name="categoria" class="form-control" ng-model="categoria" id="categoria" required>
                        <option value="">Categoria</option> 
                        <c:forEach items="#{Categoria.allCategoria()}" var="lp">
                            <option ng-value="${lp.id}"><c:out value="${lp.nombre}"/></option>               
                        </c:forEach>
                    </select>
                    <br/>
                    <div class="form-group">
                        <input name="procesador" ng-model="procesador" placeholder="Procesador" type="text" class="form-control" id="procesador" required/>
                    </div>
                    <div class="form-group">
                        <input  name="ram" ng-model="ram" placeholder="Ram" type="text" class="form-control" id="ram" required/>
                    </div>
                    <div class="form-group">
                        <input name="placa" ng-model="placa" placeholder="Placa" type="text" class="form-control" id="placa" required/>
                    </div>
                    <div class="form-group">
                        <input name="disco" ng-model="discoDuro" placeholder="DiscoDuro" type="text" class="form-control" id="discoDuro" required ng-pattern="patternCodigoOrdenador"/>
                    </div>

                    <select  class="form-control" ng-model="marca" ng-change="mostrarModelos()" id="Marca" required>
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
                        <input name="nuevoModelo" ng-model="ModelosNuevos" placeholder="Nueva Modelo" type="text" class="form-control" id="NuevoModelo" required/>
                    </div>
                    <div class="form-group">
                        <input name="nuevaMarca" ng-model="Marcanueva" placeholder="Nueva Marca" type="text" class="form-control" id="NuevaMarca" required/>
                    </div>
                    <br/>
                    <button id="guardar" ng-show="miFormulario.procesador.$valid && miFormulario.precio.$valid && miFormulario.ubicacion.$valid && estancia>0  && miFormulario.placa.$valid && categoria>0 && estado>0 && miFormulario.disco.$valid && marca>0 || miFormulario.nuevaMarca.$valid && modelo>0 || miFormulario.nuevoModelo.$valid" ng-click="anadir()" ng-model="botonGuardar" class="btn btn-warning">Guardar</button>
                </form>
                </div>
                <div class="col-sm-4"></div>
            </div>
        </div>
    </body>
</html>
