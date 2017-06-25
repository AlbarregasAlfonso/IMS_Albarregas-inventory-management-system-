<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="resources/js/angular.min.js"></script>
        <script src="resources/js/login.js"></script>
        <script src="resources/js/Animations.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-animate.js"></script>
        <!--        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>-->
        <link rel="stylesheet" href="resources/css/style1.css" />

        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Inventario</title>
    </head>
    <body ng-app="miApp">
        <div  ng-controller="controladorPractica" class="container">
            <div id="panelPrincipal" class="panel panel-primary">
                <input ng-model="usuario" placeholder="usuario" type="text" class="form-control" id="usuario"/>
                <br/>
                <input ng-model="clave" placeholder="clave" type="password" class="form-control" id="clave"/>
                <img id="imagenCorrecto" src="resources/imagenes/correcto.png" alt=""/>
                <label id="mensajelogincorrecto">{{mensajeLogin}}</label>
                <!--<button id="Despiezar1" ng-click="Inicio()" ng-model="botonDespiezar1"><a href="Principal.xhtml"></a></button>-->
                <button id="acceder" ng-click="Loguearse()" ng-model="acceder" class="btn btn-warning">Acceder</button>

                <a href="Principal.xhtml"><button id="accederAceptado" ng-model="accederAceptado" class="btn btn-warning">Entrar</button></a>
            </div> 
        </div>
    </body>
</html>