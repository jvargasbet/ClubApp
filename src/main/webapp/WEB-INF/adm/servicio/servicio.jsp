<%@page import="app.model.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="app.zelper.Constants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Servicio> miservicio = (List<Servicio>) request.getAttribute("miservicio");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title> Servicio </title>
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
                        <a class=" btn btn-primary pull-right" href="<%=contextPath%>/adm/miservicio?action=<%=Constants.ACTION_CREATE%>"> Nuevo </a>
                        <h1> Mis servicios   </h1>
                    </div>
                    
                    <% if (!miservicio.isEmpty()) {%>
                    <table class="table table-striped table-hover"> 
                        <thead>
                        <th> Descripción </th>
                        <th> Dirección </th>
                        </thead>
                        <tbody>
                            <% for (Servicio servicio : miservicio) {%>
                            <tr>
                                <td> <%=servicio.getDescripcion()%> </td>
                                <td> <%=servicio.getCostoHora()%> </td>
                                <td> 
                                    <div class="btn-group">
                                        <a class="dropdown-toggle" data-toggle="dropdown" role="menu"  href="#">
                                          <i class="icon-cog"></i>
                                        </a>
                                        <ul class="dropdown-menu pull-right">
                                            <li>
                                                <a href="<%=contextPath%>/adm/miservicio?action=<%=Constants.ACTION_UPDATE%>&id=<%=servicio.getId()%>">
                                                Editar<a>
                                            </li>
                                            <li>
                                                <a href="<%=contextPath%>/adm/miservicio?action=<%=Constants.ACTION_DELETE%>&id=<%=servicio.getId()%>">
                                                    Eliminar<a>
                                            </li>
                                        </ul>
                                      </div>
                                </td>
                            </tr>
                            <% }%>
                        </tbody>
                    </table>
                        
                    <% }%>
                </div>
            </div>


            <hr>
        </div>

        <%@include file="/public/footer.jsp" %>
    </body>
</html>




