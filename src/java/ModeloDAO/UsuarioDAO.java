/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Modelo.Comentario;
import Modelo.Usuario;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author artem
 */
public class UsuarioDAO{
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    Conexion cn= new Conexion();
    Usuario usu=new Usuario();

    public List principal() {
        ArrayList<Usuario> list= new ArrayList<>();
        String sql="select * from usuario";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                Usuario usu=new Usuario();
                usu.setUsuario(rs.getString("Usuario"));
                usu.setNombre("nombre");
                usu.setApellidoPa(rs.getString("apellidoPa"));
                usu.setApellidoMa("apellidoMa");
                usu.setCorreo(rs.getString("correo"));
                usu.setContraseña(rs.getString("contraseña"));
                list.add(usu);
            }
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        return list;
    }

    public boolean registrar(Usuario usu) {
        String sql="insert into usuario values('"+usu.getUsuario()+"','"+usu.getNombre()+"','"+usu.getApellidoPa()+"','"+usu.getApellidoMa()+"','"+usu.getCorreo()+"','"+usu.getContraseña()+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false; 
    }


    public boolean eliminar(String id) {
        String sql="DELETE FROM usuario WHERE usuario="+id+";";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
    return true;
    }

}
