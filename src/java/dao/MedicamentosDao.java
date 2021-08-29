package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Medicamentos;

public class MedicamentosDao {
    
    Conexion conn;
    
    public MedicamentosDao(Conexion conn){
        this.conn = conn;
    }
    
    public boolean insert(Medicamentos medi){
        String sql = "INSERT INTO Medicamentos VALUES (?,?,?,?,?);";
        
        try{
           PreparedStatement ps = conn.conectar().prepareStatement(sql);
           ps.setInt(1, medi.getId_medicamento());
           ps.setString(2, medi.getMedicamento());
           ps.setString(3, medi.getDescripcion());
           ps.setInt(4, medi.getCantidad());
           ps.setString(5, medi.getFecha_vencimiento());
           ps.executeUpdate();
           return true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    public List<Medicamentos> selectTodo(){
        String sql = "SELECT * FROM Medicamentos";
        
        try{
           PreparedStatement ps = conn.conectar().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           List<Medicamentos> lista = new LinkedList<>();
           Medicamentos medi;
           while(rs.next()){
               medi = new Medicamentos(rs.getInt("id_medicamento"));
               medi.setMedicamento(rs.getString("medicamento"));
               medi.setDescripcion(rs.getString("descripcion"));
               medi.setCantidad(rs.getInt("cantidad"));
               medi.setFecha_vencimiento(rs.getString("fecha_vencimiento"));
               lista.add(medi);
           }
           return lista;
                   
        }catch(Exception e){
            System.out.println("Error: " + e );
            return null;
        }
    }
        
    
    
}
