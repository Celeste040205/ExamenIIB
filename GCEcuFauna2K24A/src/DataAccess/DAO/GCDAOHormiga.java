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
import DataAccess.DTO.GCDTOHormiga;
import Framework.GCException;

public class GCDAOHormiga extends GCDataHelper implements GCIDAO<GCDTOHormiga> {

    @Override
    public boolean create(GCDTOHormiga entity) throws Exception {
        String query = " INSERT INTO gcHORMIGA (TipoHormiga) VALUES (?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getGCTipoHormiga());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; 
        }
    }
    
    public List<GCDTOHormiga> readAll() throws Exception {
        List <GCDTOHormiga> lst = new ArrayList<>();
        String query =" SELECT IdHormiga            " 
                     +" ,TipoHormiga                " 
                     +" ,IdIngestaNativa            " 
                     +" ,IdGenoAlimento             " 
                     +" ,IdSexo                     " 
                     +" ,IdUbicacion                " 
                     +" ,Estado                     " 
                     +" ,FechaCreacion              " 
                     +" ,FechaModifica              "
                     +" FROM    GCHORMIGA           "
                     +" WHERE   Estado ='A'         ";

        try {
            Connection conn   = openConnection();         // conectar a DB     
            Statement  gcStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  gcRs   = gcStmt.executeQuery(query);    // ejecutar la
                         while (gcRs.next()) {
                             GCDTOHormiga s = new GCDTOHormiga( gcRs.getInt(1)     // IdHormiga
                                                     ,gcRs.getString(2)  // Nombre             
                                                     ,gcRs.getInt(2)  // Nombre             
                                                     ,gcRs.getInt(2)  // Nombre             
                                                     ,gcRs.getInt(2)  // Nombre             
                                                     ,gcRs.getInt(2)  // Nombre             
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
        String query = " UPDATE GCHormiga SET Estado = ? WHERE IdHormiga = ?";
        try {
            Connection          gcConn = openConnection();
            PreparedStatement  gcPstmt = gcConn.prepareStatement(query);
            gcPstmt.setString(1, "X");
            gcPstmt.setInt(2, id);
            gcPstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new GCException(e.getMessage(), getClass().getName(), "delete()");
        }

    }

    @Override
    public GCDTOHormiga readBy(Integer id) throws Exception {
        GCDTOHormiga gcOs = new GCDTOHormiga();
        String query =" SELECT IdHormiga                  " 
                     +" ,TipoHormiga                      " 
                     +" ,Estado                           " 
                     +" ,FechaCrea                        " 
                     +" ,FechaModifica                    "
                     +" FROM    GCHORMIGA                 "
                     +" WHERE   Estado ='A'  AND IdHormiga"+ id.toString();
        try {
            Connection conn   = openConnection();         // conectar a DB     
            Statement  gcStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  gcRs   = gcStmt.executeQuery(query);    // ejecutar la
                         while (gcRs.next()) {
                            GCDTOHormiga s = new GCDTOHormiga( gcRs.getInt(1)     // IdHormiga
                            ,gcRs.getString(2)  // Nombre             
                            ,gcRs.getInt(2)  // Nombre             
                            ,gcRs.getInt(2)  // Nombre             
                            ,gcRs.getInt(2)  // Nombre             
                            ,gcRs.getInt(2)  // Nombre             
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

    public Integer getRowCount()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg "
                     +" FROM    MFHormiga         "
                     +" WHERE   Estado ='A'      ";
        try {
            Connection mfConn = openConnection();         // conectar a DB     
            Statement  mfStmt = mfConn.createStatement();   // CRUD : select * ...    
            ResultSet mfRs   = mfStmt.executeQuery(query);  // ejecutar la
            while (mfRs.next()) {
                return mfRs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw new GCException(e.getMessage(), getClass().getName(), "getRowCount()");
        }
        return 0;
    }

    @Override
    public boolean update(GCDTOHormiga entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now     = LocalDateTime.now();
        String query          = "UPDATE GCHORMIGA SET TipoHormiga = ?, IdIngestaNativa = ?, IdGenoAlimento = ?, IdSexo = ?, IdUbicacion = ?,    FechaModifica = ? WHERE IdHormiga = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getGCTipoHormiga());
            pstmt.setInt(2, entity.getGCIdIngestaNativa());
            pstmt.setInt(3, entity.getGCIdGenoAlimento());
            pstmt.setInt(4, entity.getGCIdSexo());
            pstmt.setInt(4, entity.getGCIdUbicacion());
            pstmt.setString(5, dtf.format(now).toString());
            pstmt.setInt(6, entity.getGCIdHormiga());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;
        }
    }
}
