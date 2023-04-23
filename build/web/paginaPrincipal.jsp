<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Comentario"%>
<%@page import="ModeloDAO.ComentarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Comentarios</h1>
        <form action="SvControlador">
            <input type="input" name="accion" value="cerrar">   
        </form>
        <input type="button" value="Lista usuarios" onclick="window.location.href='/usuarios.jsp'">
        <form action="SvControlador">
            <input type="date" name="dias">
            <input type="submit">
        </form>
        <table border="0">
            <thead>
                <tr>
                    <th>Comentario</th>
                    <th>Fecha</th>
                    <th>Usuario</th>
                    <th>Al que le comentaron</th>
                    <th>Botones</th>
                </tr>
            </thead>
            <%
           
            ComentarioDAO comenD= new ComentarioDAO();
            List<Comentario>lista=comenD.principal();
            Iterator<Comentario>iters=lista.iterator();
            Comentario comen;
            while(iters.hasNext()){
                comen=iters.next();
            %>
            <tbody>
                <tr>
                    <td><%=comen.getComentario()%></td>
                    <td><%=comen.getFecha()%></td>
                    <td><%=comen.getComentarista()%></td>
                    <td><%=comen.getComentariado()%></td>
                    <%String usuario=session.getAttribute("usuario").toString();%>
                    <%if(comen.getComentarista().equals(usuario)){%><td>
                        <input type="text" name="comen" id="comenInput">
                <a href="SvControlador?accion=eliminar&iden=<%=comen.getId()%>">Eliminar</a>
                <a href="SvControlador?accion=editar&iden=<%=comen.getId()%>&edit=" id="editarLink">Editar</a>
                
            </td><%}%></tr><%}%>
            </tbody>
            
        </table>
            <form action="SvControlador">   
            Comentario<input type="text" name="comentario" required>
            A quien<input type="text" name="usuario" required>
            <input type="datetime-local" id="fecha" name="fecha" value="<%=java.time.LocalDateTime.now().toString().substring(0, 16)%>">
            <input type="submit" name="accion" value="agregar">
            </form>
    </body>
</html>