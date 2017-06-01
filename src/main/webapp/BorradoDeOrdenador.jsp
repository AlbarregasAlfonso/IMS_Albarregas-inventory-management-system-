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
        <link rel="stylesheet" href="resources/css/style2.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body ng-app="miApp" >
        <div ng-controller="controladorPractica">
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-4">

                    <h1>Eliminemos un ordenador</h1>

                    <div class="form-group">
                        <input ng-model="codigoBarras" placeholder="codigo de barras" type="text" class="form-control" id="codigoBarras"/>
                    </div>
                    <select class="form-control" ng-model="estado" id="estado">
                        <option value="">ordenadores</option> 
                        <c:forEach items="#{producto.listaProductos}" var="lp">
                            <option ng-value="${lp.id}"><c:out value="${lp.marca.nombre}"/></option>               
                        </c:forEach>
                    </select>
               
                    <br/>
                    <label>{{ordenador}}</label>
                  
                    <button id="borrar" ng-click="borrar()" ng-model="botonBorrar" class="btn btn-warning">Borrar</button>

                </div>
                <div class="col-sm-4">
                        <br/>
                        <br/>
                        <br/>
                       <img id="info" src="resources/imagenes/inf.png" alt="" > 
                    
                       <label id="docInfo">En este nuevo apartado podremos indicar mediante el código de barras que tiene el ordenador pegado en la parte superior, el ordenador que queremos eliminar</label>
             
                </div>
                
            </div>
        </div>
    </body>
</html>
