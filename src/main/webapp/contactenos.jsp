<%-- 
    Document   : contactenos
    Created on : 19/10/2013, 12:59:48 PM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="/public/header.jsp" %>
    </head>
    <body>
        <form id= "formServicio" class="form-horizontal">
            <a href="#myModal" role="button" class="btn" data-toggle="modal">Contactenos</a>

            <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Envie</h3>
                </div>
                <div class="modal-body">
                    <p>Formulario</p>
                    <div class="container">
                        <h1>Solicite su cotización</h1>
                        <p>Ingrese los datos<br> Registro</p>
                        <form id= "formingreso" class="form-horizontal">
                            <div class="control-group">
                                <label class="control-label" for="inputEmail">Tu nombre</label>
                                <div class="controls">
                                    <input class="input-xxlarge" name="nombre" type="text" placeholder=".input-xxlarge">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label" >Tu sistem operativo</label>
                                <div class="controls">
                                    <select class="span3">
                                        <option>Linux</option> 
                                        <option>MAC</option>
                                        <option>Windows</option>
                                    </select>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"> Te gusta el futbol?</label>
                                <div class="controls">
                                    <label class="checkbox">
                                        <input type="checkbox"> 
                                    </label>

                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"> Cual es tu sexo?</label>

                                <div class="controls">
                                    <input type="radio" name="sexo"  value="option1">
                                    Hombre
                                </div>  
                                <div class="controls">
                                    <input type="radio" name="sexo"  value="option2">
                                    Mujer
                                </div>
                                <div class="controls">
                                    <label class="error" for ="sexo"></label>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"> tus aficiones</label>
                                <div class="controls">
                                    <textarea rows="3"></textarea>
                                </div>
                            </div>
                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary">Enviar datos</button>
                                <button type="button" class="btn">Reestablecer</button>
                            </div>
                        </form>
                    </div> 

                </div>
                <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                    <button class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </form>
        <%@include file="/public/footer.jsp" %>

        <script src="public/jvalidation/dist/jquery.validate.min.js"></script>
        <script src="public/jvalidation/dist/messages_es.js"></script>


        <script><!-- /escribir java script-->
            $(function() {
                $('#formingreso').validate({
                    rules: {
                        nombre: {required: true},
                        sexo: {required: true}
                    },
                    highlight: function(element) {
                        $(element).closest('.control-group').removeClass('success').addClass('error');
                    },
                    success: function(element) {
                        element
                                .text('OK!').addClass('valid')
                                .closest('.control-group').removeClass('error').addClass('success');
                    }
                });
            });


        </script>
    </body>
</html>
