<%@page import="app.model.Servicio"%>
<%@page import="app.zelper.Constants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title> Servicio - Nuevo Servicio </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <%@include file="/public/header.jsp" %>
    </head>

    <body>

        <%@include file="/public/menuGeneral.jsp" %>

        <div class="container-fluid">
            <div class="row-fluid">

                <%@include file="/public/menuAdm.jsp" %>

                <div class="span9">
                    <div class="row">
                        <h1> Nuevo servicio  </h1>
                    </div>

                    <form action="<%=contextPath%>/adm/miservicio" method="post">
                        
                        <input hidden="id" value="${servicio.id}" name="id">
                        
                        <div class="control-group">
                            <label class="control-label">Descripción</label>
                            <div class="controls">
                                <input type="text" name="descripcion" value="${servicio.descripcion}">
                            </div>
                        </div>

                            
                        <div class="control-group">
                            <label class="control-label">Costo S/.</label>
                            <div class="controls">
                                <input type="text" name="costo_hora" value="${servicio.costoHora}">
                            </div>
                        </div>
                         
                        <div class="control-group">
                            <div class="controls">
                                <a class="btn" href="<%=contextPath%>/adm/miservicio">Cancelar</a>
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>


            <hr>
        </div>

        <%@include file="/public/footer.jsp" %>
    </body>
</html>




