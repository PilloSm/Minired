/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Modelo.Comentario;
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
public class ComentarioDAO {
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    Conexion cn= new Conexion();
    Comentario comen=new Comentario();

    public int id(){
        String sql="select id_registro from mast";
        int n=0;
        int m;
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                m=Integer.parseInt(rs.getString("id_registro"));
                if(m>n){n=m;}
            }            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    return n;
    }
    
    public List principal() {
        ArrayList<Comentario> list= new ArrayList<>();
        String sql="select * from mast";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Comentario comen=new Comentario();
                comen.setId(rs.getInt("id_registro"));
                comen.setComentario(rs.getString("comentario"));
                comen.setFecha(rs.getString("fecha"));
                comen.setComentarista(rs.getString("Usuario"));
                comen.setComentariado(rs.getString("usuarioC"));
                comen.setIdR(rs.getInt("id_respuesta"));
                list.add(comen);
            }
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        return list; 
    }


    public boolean registrar(Comentario comen) {
String sql="insert into mast values('"+comen.getId()+"','"+comen.getFecha()+"','"+comen.getComentarista()+"','"+comen.getComentario()+"','"+comen.getComentariado()+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false; 
    }

    public boolean editar(int id, String comentario) {
    String sql="  UPDATE mast SET comentario = '"+comentario+"' WHERE id_registro = "+id+";";
    try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
    return false;
    }

    public boolean eliminar(int id) {
        String sql="DELETE FROM mast WHERE id_comentario="+id+"";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
    return false;
    }
    public List buscar(String comparar) {
        ArrayList<Comentario> list= new ArrayList<>();
        String sql="select * from mast where Usuario="+comparar+";";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                System.out.println("si");
                Comentario comen=new Comentario();
                comen.setId(rs.getInt("id_registro"));
                comen.setComentario(rs.getString("comentario"));
                comen.setFecha(rs.getString("fecha"));
                comen.setComentarista(rs.getString("Usuario"));
                comen.setComentariado(rs.getString("usuarioC"));
                list.add(comen);
            }   
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        return list; 
    }
}   
