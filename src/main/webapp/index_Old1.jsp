<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Club APP</title>

        <%@include file="/public/header.jsp" %>

        <style>
            body {
                padding-top: 60px; 
            }
        </style>
    </head>
    <body>

        <%@include file="/public/menuGeneral.jsp" %>

        <div class="container">
            <h1>Mantenimiento de Servicios</h1>
            <p>Ingrese los datos del serivicio<br> Registro</p>
            <form id= "formServicio" class="form-horizontal">
                <div class="control-group">
                    <label class="control-label" for="inputServi">Servicio</label>
                    <div class="controls">
                        <input type="text" name="idservi" placeholder="servicio">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputCosto">Costo S/.</label>
                    <div class="controls">
                        <input type="text" name="idcosto" placeholder="costo">
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <button type="submit" class="btn btn-primary">Grabar</button>
                        <button type="button" class="btn">Cancelar</button>
                    </div>
                </div>
                <div class="control-group">
                    <table class="table table-striped">
                        HOLA, COMO ESTAN TODOS
                    </table>
                 
                </div>

            </form>
        </div> 


        <%@include file="/public/footer.jsp" %>
        <!--%@include file="/public/validation.jsp" %-->

        <!--script src="http://code.jquery.com/jquery.js"></script-->
        <!--script src="public/bootstrap/js/bootstrap.js"></script-->

        <script src="public/jvalidation/dist/jquery.validate.min.js"></script>
        <script src="public/jvalidation/dist/messages_es.js"></script>


        <script><!-- /escribir java script-->
            $(function() {
                $('#formServicio').validate({
                    rules: {
                        idservi: {required: true},
                        idcosto: {required: true}
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

