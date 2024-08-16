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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = " INSERT INTO GCHORMIGA (IdClgTipoHormiga, IdClgIngestaNativa, IdClgGenoAlimento, IdClgSexo, IdUbicacion, FechaModifica) VALUES (?,?,?,?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getGCIdClgTipoHormiga());
            pstmt.setInt(2, entity.getGCIdClgIngestaNativa());
            pstmt.setInt(3, entity.getGCIdClgGenoAlimento());
            pstmt.setInt(4, entity.getGCIdClgSexo());
            pstmt.setInt(5, entity.getGCIdUbicacion());
            pstmt.setString(6, dtf.format(now).toString());;

            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new GCException(e.getMessage(), getClass().getName(), "create()");
        }
    }
    

    public List<GCDTOHormiga> readAll() throws Exception {
        List <GCDTOHormiga> lst = new ArrayList<>();
        String query =" SELECT IdHormiga             " 
                     +" ,IdClgTipoHormiga            " 
                     +" ,IdClgIngestaNativa          " 
                     +" ,IdClgGenoAlimento           " 
                     +" ,IdClgSexo                   " 
                     +" ,IdUbicacion                 " 
                     +" ,Estado                      " 
                     +" ,FechaCreacion               " 
                     +" ,FechaModifica               "
                     +" FROM    MJHORMIGA            "
                     +" WHERE   Estado ='A'          ";

        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  gcStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  gcRs   = gcStmt.executeQuery(query);    // ejecutar la
                         while (gcRs.next()) {
                             GCDTOHormiga s = new GCDTOHormiga( gcRs.getInt(1)     // IdHormiga
                                                     ,gcRs.getInt(2)  // Nombre             
                                                     ,gcRs.getInt(3)  // Nombre             
                                                     ,gcRs.getInt(4)  // Nombre             
                                                     ,gcRs.getInt(5)  // Nombre             
                                                     ,gcRs.getInt(6)  // Nombre             
                                                     ,gcRs.getString(7)  // Estado         
                                                     ,gcRs.getString(8)  // FechaCrea      
                                                     ,gcRs.getString(9));// FechaModifica
                             lst.add(s);
                         }
                    } 
                    catch (SQLException e) {
                        throw new GCException(e.getMessage(), getClass().getName(), "readAll()");
                    }
                    return lst; 
                }
    

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE MJHORMIGA SET Estado = ? WHERE IdHormiga = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new GCException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public GCDTOHormiga readBy(Integer id) throws Exception {
        GCDTOHormiga gcOs = new GCDTOHormiga();
        String query =" SELECT IdHormiga                " 
                     +" ,IdClgTipoHormiga               " 
                     +" ,Estado                         " 
                     +" ,FechaCrea                      " 
                     +" ,FechaModifica                  "
                     +" FROM    MJHORMIGA               "
                     +" WHERE   Estado ='A'  AND IdHormiga"+ id.toString();
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  gcStmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  gcRs   = gcStmt.executeQuery(query);    // ejecutar la
                         while (gcRs.next()) {
                            GCDTOHormiga s = new GCDTOHormiga( gcRs.getInt(1)     // IdHormiga
                            ,gcRs.getInt(2)  // Nombre             
                            ,gcRs.getInt(2)  // Nombre             
                            ,gcRs.getInt(2)  // Nombre             
                            ,gcRs.getInt(2)  // Nombre             
                            ,gcRs.getInt(2)  // Nombre             
                            ,gcRs.getString(3)  // Estado         
                            ,gcRs.getString(4)  // FechaCrea      
                            ,gcRs.getString(5));// FechaModifica
            } 
        }catch (SQLException e) {
                throw new GCException(e.getMessage(), getClass().getName(), "readBy()");
            }
            return gcOs; 
        }

    @Override
    public boolean update(GCDTOHormiga entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE GCHORMIGA SET IdClgTipoHormiga = ?, IdClgIngestaNativa = ?, IdClgGenoAlimento = ?, IdClgSexo = ?, IdUbicacion = ?,    FechaModifica = ? WHERE IdHormiga = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getGCIdClgTipoHormiga());
            pstmt.setInt(2, entity.getGCIdClgIngestaNativa());
            pstmt.setInt(3, entity.getGCIdClgGenoAlimento());
            pstmt.setInt(4, entity.getGCIdClgSexo());
            pstmt.setInt(4, entity.getGCIdUbicacion());
            pstmt.setString(5, dtf.format(now).toString());
            pstmt.setInt(6, entity.getGCIdHormiga());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw  new GCException(e.getMessage(), getClass().getName(), "update()");
        }
    }    

}