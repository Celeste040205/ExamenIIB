package DataAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAccess.GCDataHelper;
import DataAccess.DTO.GCDTOGenoAlimento;


public class GCDAOGenoAlimento extends GCDataHelper implements GCIDAO<GCDTOGenoAlimento> {

    @Override
    public boolean create(GCDTOGenoAlimento entity) throws Exception {
        String query = " INSERT INTO GCGENOALIMENTO (TipoGeno) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getGCtipoGeno());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }
    

    public List<GCDTOGenoAlimento> readAll() throws Exception {
        List <GCDTOGenoAlimento> lst = new ArrayList<>();
        String query =" SELECT IdGenoAlimento       " 
                     +" ,TipoGeno                   " 
                     +" ,Estado                     " 
                     +" ,FechaCreacion              " 
                     +" ,FechaModifica              "
                     +" FROM    GCGENOALIMENTO      "
                     +" WHERE   Estado ='A'         ";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  gcStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  gcRs   = gcStmt.executeQuery(query);    // ejecutar la
                         while (gcRs.next()) {
                             GCDTOGenoAlimento s = new GCDTOGenoAlimento( gcRs.getInt(1)     // IdSexo
                                                     ,gcRs.getString(2)  // Nombre             
                                                     ,gcRs.getString(3)  // Estado         
                                                     ,gcRs.getString(4)  // FechaCrea      
                                                     ,gcRs.getString(5));// FechaModifica
                             lst.add(s);
                         }
                    } 
                    catch (SQLException e) {
                        throw e;
                    }
                    return lst; 
                }
    

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE GCGENOALIMENTO SET Estado = ? WHERE IdGenoAlimento = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public GCDTOGenoAlimento readBy(Integer id) throws Exception {
        GCDTOGenoAlimento gcOs = new GCDTOGenoAlimento();
        String query =" SELECT IdGenoAlimento       " 
                     +" ,TipoGeno                   " 
                     +" ,Estado                     " 
                     +" ,FechaCreacion              " 
                     +" ,FechaModifica              "
                     +" FROM    GCGENOALIMENTO      "
                     +" WHERE   Estado ='A'  AND IdGenoAlimento"+ id.toString();
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  gcStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  gcRs   = gcStmt.executeQuery(query);    // ejecutar la
                         while (gcRs.next()) {
                             GCDTOGenoAlimento s = new GCDTOGenoAlimento( gcRs.getInt(1)     // IdSexo
                                                     ,gcRs.getString(2)  // Nombre             
                                                     ,gcRs.getString(3)  // Estado         
                                                     ,gcRs.getString(4)  // FechaCrea      
                                                     ,gcRs.getString(5));// FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e; 
        }
        return gcOs;
    }

    @Override
    public boolean update(GCDTOGenoAlimento entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE GCGENOALIMENTO SET TipoGeno = ?,   FechaModifica = ? WHERE IdGenoAlimento = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getGCtipoGeno());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getGCIdGenoAlimento());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }


    




}
