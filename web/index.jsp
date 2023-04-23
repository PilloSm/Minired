<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Inicio de sesion</h1>
        <form action="SvControlador">
            <label>Nombre de usuario</label><input type="text" name="Usu" required><br>
            <label>Contraseña</label><input type="password" name="contra" required><br>
            <input type="submit" name="accion" value="inicio">
        </form>
        <h2><a href="registro.jsp">Registrarse</a></h2>
    </body>
</html>