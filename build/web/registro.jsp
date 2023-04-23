<%-- 
    Document   : registro
    Created on : 22 abr. 2023, 11:20:18
    Author     : artem
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Ingrese sus datos</h1>
        <form action="SvControlador">
            <label>Nombre</label><input type="text" name="nombre" required><br>
            <label>Apellido Paterno</label><input type="text" name="apPa" required><br>
            <label>Apellido Materno</label><input type="text" name="apMa" required><br>
            <label>Correo</label><input type="email" name="mail" required><br>
            <label>Usuario</label><input type="text" name="Usu" required><br>
            <label>Contraseña</label><input type="password" name="contra" required><br>
            <input type="submit" name="accion" value="registro" >
        </form>
    </body>
</html>
