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
import DataAccess.DTO.GCDTOUbicacion;


public class GCDAOUbicacion extends GCDataHelper implements GCIDAO<GCDTOUbicacion> {

    @Override
    public boolean create(GCDTOUbicacion entity) throws Exception {
        String query = " INSERT INTO GCUBICACION (Provincia) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getGCProvincia());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  
        }
    }
    

    public List<GCDTOUbicacion> readAll() throws Exception {
        List <GCDTOUbicacion> lst = new ArrayList<>();
        String query =" SELECT IdUbicacion       " 
                     +" ,Pais                    " 
                     +" ,Region                  " 
                     +" ,Provincia               " 
                     +" ,Estado                  " 
                     +" ,FechaCreacion           " 
                     +" ,FechaModifica           "
                     +" FROM    GCUBICACION      "
                     +" WHERE   Estado ='A'      ";

        try {
            Connection conn   = openConnection();         // conectar a DB     
            Statement  gcStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  gcRs   = gcStmt.executeQuery(query);    // ejecutar la
                         while (gcRs.next()) {
                             GCDTOUbicacion s = new GCDTOUbicacion( gcRs.getInt(1)     // IdSexo
                                                     ,gcRs.getString(2)  // Nombre             
                                                     ,gcRs.getString(3)  // Estado         
                                                     ,gcRs.getString(4)  // FechaCrea      
                                                     ,gcRs.getString(5)// FechaModifica
                                                     ,gcRs.getString(6)// FechaModifica
                                                     ,gcRs.getString(7));// FechaModifica
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
        String query = " UPDATE UBICACION SET Estado = ? WHERE IdUbicacion = ?";
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
    public GCDTOUbicacion readBy(Integer id) throws Exception {
        GCDTOUbicacion gcOs = new GCDTOUbicacion();
        String query =" SELECT IdUbicacion                   "   
                     +" ,Pais                                " 
                     +" ,Region                              " 
                     +" ,Provincia                           " 
                     +" ,Estado                              " 
                     +" ,FechaCreacion                       " 
                     +" ,FechaModifica                       "
                     +" FROM    GCUBICACION                  "
                     +" WHERE   Estado ='A'  AND ID UBICACION"+ id.toString();
        try {
            Connection conn   = openConnection();         // conectar a DB     
            Statement  gcStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  gcRs   = gcStmt.executeQuery(query);    // ejecutar la
                         while (gcRs.next()) {
                             GCDTOUbicacion s = new GCDTOUbicacion( gcRs.getInt(1)     
                                                     ,gcRs.getString(2)  // Nombre             
                                                     ,gcRs.getString(3)  // Estado         
                                                     ,gcRs.getString(4)  // FechaCrea      
                                                     ,gcRs.getString(5)// FechaModifica
                                                     ,gcRs.getString(6)// FechaModifica
                                                     ,gcRs.getString(7));// FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e;
        }
        return gcOs;
    }

    @Override
    public boolean update(GCDTOUbicacion entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now     = LocalDateTime.now();
        String query          = "UPDATE GCUBICACION SET Pais = ?, Region = ?, provincia = ?,   FechaModifica = ? WHERE IdUbicacion = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getGCPais());
            pstmt.setString(2, entity.getGCRegion());
            pstmt.setString(3, entity.getGCProvincia());
            pstmt.setString(4, dtf.format(now).toString());
            pstmt.setInt(5, entity.getGCIdUbicacion());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }
}
