/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Comentario;
import Modelo.Usuario;
import ModeloDAO.ComentarioDAO;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author artem
 */
public class SvControlador extends HttpServlet {
   /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    UsuarioDAO usuD=new UsuarioDAO();
    Comentario comen;
    ComentarioDAO comenD=new ComentarioDAO();
        Usuario usu;
        List list=  usuD.principal();
        Iterator <Usuario> a=list.iterator();
        String pestaña="./paginaPrincipal.jsp";        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String usuario=request.getParameter("Usu");
        String contra=request.getParameter("contra");
        String accion=request.getParameter("accion");
        String mail=request.getParameter("mail");
        Usuario prueba= new Usuario();
        boolean encontrado = false;
        HttpSession session = request.getSession();
        switch(accion){
            case "inicio":
                 List list=  usuD.principal();
        Iterator <Usuario> a=list.iterator();
                if(a.hasNext()){
                while (a.hasNext()){
                    prueba=a.next();
                    if(prueba.getUsuario().equalsIgnoreCase(usuario)&&prueba.getContraseña().equalsIgnoreCase(contra)){
                    session.setAttribute("usuario",usuario );
                        response.sendRedirect("/paginaPrincipal.jsp");
                    }
                    else{
                     out.print("<script>location.replace('index.jsp');</script>");  
                    }
                }
            }
            else{
                out.print("<script>location.replace('index.jsp');</script>");  
            }
                break;
            case "registro":
                usu = new Usuario(request.getParameter("nombre"), request.getParameter("apPa"), request.getParameter("apMa"), mail, usuario, contra);
                List<Usuario> lista = usuD.principal();
                encontrado = lista.stream().anyMatch((user) -> (user.getUsuario().equalsIgnoreCase(usuario) || user.getCorreo().equalsIgnoreCase(mail)));
                if(!encontrado){
                    
                    usuD.registrar(usu);
                    session.setAttribute("usuario", usuario);
                    response.sendRedirect("./paginaPrincipal.jsp");
                } else {
                    out.print("<script>location.replace('index.jsp');</script>");  

                }
                break;
            default:
                break;
            case "editar":
                int ids=Integer.parseInt(request.getParameter("iden"));
                String comentario=request.getParameter("edit");
                System.out.println(comentario);
                comenD.editar(ids,comentario);
                out.print("<script>location.replace('paginaPrincipal.jsp');</script>");
            break;
            case "eliminar":
                int id=Integer.parseInt(request.getParameter("iden"));
                comenD.eliminar(id);
                out.print("<script>location.replace('paginaPrincipal.jsp');</script>");
            break;
            case "agregar":
                String usuarioC=request.getParameter("usuario");
                String fecha=request.getParameter("fecha");
                String comentarios=request.getParameter("comentario");
                int idss=comenD.id();
                comen=new Comentario(comentarios,idss,usuario,usuarioC,fecha);
                comenD.registrar(comen);
                out.print("<script>location.replace('paginaPrincipal.jsp');</script>");
            break;
            case"cerrar":
                session.invalidate();
                out.print("<script>location.replace('index.jsp');</script>");
            break;
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                processRequest(request, response);
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}