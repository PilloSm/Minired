<%-- 
    Document   : usuarios
    Created on : 22 abr. 2023, 17:03:45
    Author     : artem
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Comentario"%>
<%@page import="Modelo.Usuario"%>
<%@page import="ModeloDAO.ComentarioDAO"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body>
        <table border="0">
            <thead>
                <tr>
                    <th>Usuario</th>
                    <th>Correo electrónico</th>
                    <th>Comentario</th>
                </tr>
            </thead>
            <%
            UsuarioDAO usuD=new UsuarioDAO();
            List<Usuario> lisUsu=usuD.principal();
            Iterator<Usuario> iter=lisUsu.iterator();
            Usuario usu;
            while(iter.hasNext()){
                usu=iter.next();
                String comparar=usu.getUsuario();
            %>
            <tbody>
                <tr>
                    <td><%=usu.getUsuario()%></td>
                    <td><%=usu.getCorreo()%></td>
                    <td>Comentario
                        <table>
                            <%
                            ComentarioDAO comenD=new ComentarioDAO();
                            List<Comentario> lisComen=comenD.buscar(comparar);
                            Iterator<Comentario> itera=lisComen.iterator();
                            Comentario comen;
                            while(itera.hasNext()){
                                comen=itera.next();
                            %>
                            <tbody>
                                <tr><td><%=comen.getComentario()%></td></tr><%}%>
                            </tbody>
                        </table>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>

    </body>
</html>
