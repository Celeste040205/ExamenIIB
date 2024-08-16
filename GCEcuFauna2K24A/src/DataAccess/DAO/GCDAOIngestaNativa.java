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
import DataAccess.DTO.GCDTOIngestaNativa;

public class GCDAOIngestaNativa extends GCDataHelper implements GCIDAO<GCDTOIngestaNativa> {

    @Override
    public boolean create(GCDTOIngestaNativa entity) throws Exception {
        String query = " INSERT INTO GCCatalogo (IdCatalogoTipo ,Nombre ,Descripcion ) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 3);   //
            pstmt.setString(2, entity.getGCNombre());
            pstmt.setString(3, entity.getGCDescripcion());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
             throw e; 
        }
    }

    @Override
    public List<GCDTOIngestaNativa> readAll() throws Exception {
        List <GCDTOIngestaNativa> lst = new ArrayList<>();
        String query =" SELECT ROW_NUMBER () OVER ( ORDER BY IdCatalogo ) RowNum "
                     +" ,IdCatalogo              "
                     +" ,IdCatalogoTipo          "
                     +" ,Nombre                  "
                     +" ,Descripcion             "
                     +" ,Estado                  "
                     +" ,FechaCreacion           "
                     +" ,FechaModifica           "
                     +" FROM    GCCatalogo       "
                     +" WHERE   Estado ='A'      "
                     +" AND   IdCatalogoTipo = 3 ";
        try {
            Connection conn = openConnection();         // conectar a DB
            Statement  stmt = conn.createStatement();   // CRUD : select * ...
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                GCDTOIngestaNativa s = new GCDTOIngestaNativa(
                                         rs.getInt(1)     // RowNum
                                        ,rs.getInt(2)     // IdCatalogo
                                        ,rs.getInt(3)     // IdCatalogoTipo
                                        ,rs.getString(4)  // Nombre
                                        ,rs.getString(5)  // Descripcion
                                        ,rs.getString(6)  // Estado
                                        ,rs.getString(7)  // FechaCreacion
                                        ,rs.getString(8));// FechaModifica
                lst.add(s);
            }
        }
        catch (SQLException e) {
            throw e;
        }
        return lst;
    }

    @Override
    public boolean update(GCDTOIngestaNativa entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE GCCatalogo SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCatalogo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getGCNombre());
            pstmt.setString(2, entity.getGCDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getGCIdCatalogo());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE GCCatalogo SET Estado = ? WHERE IdCatalogo = ?";
        try {
            Connection         conn  = openConnection();
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
    public GCDTOIngestaNativa readBy(Integer id) throws Exception {
        GCDTOIngestaNativa s = new GCDTOIngestaNativa();
        String query =
         " SELECT RowNum            "
        +"     ,IdCatalogo          "
        +"     ,IdCatalogoTipo      "
        +"     ,Nombre              "
        +"     ,Descripcion         "
        +"     ,Estado              "
        +"     ,FechaCreacion       "
        +"     ,FechaModifica       "
        +" FROM (                   "
        +"     SELECT ROW_NUMBER() OVER (ORDER BY IdCatalogo) AS RowNum "
        +"         ,IdCatalogo      "
        +"         ,IdCatalogoTipo  "
        +"         ,Nombre          "
        +"         ,Descripcion     "
        +"         ,Estado          "
        +"         ,FechaCreacion   "
        +"         ,FechaModifica   "
        +"     FROM GCCatalogo      "
        +"     WHERE Estado = 'A'   "
        +"     AND IdCatalogoTipo = 3 "
        +" ) sub                    "
        +" WHERE RowNum = " + id.toString();
        try {
            Connection conn = openConnection();         // conectar a DB
            Statement  stmt = conn.createStatement();   // CRUD : select * ...
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            System.out.println(query);
            while (rs.next()) {
                s = new GCDTOIngestaNativa(
                                 rs.getInt(1)     // RowNum
                                ,rs.getInt(2)     // IdCatalogo
                                ,rs.getInt(3)     // IdCatalogoTipo
                                ,rs.getString(4)  // Nombre
                                ,rs.getString(5)  // Descripcion
                                ,rs.getString(6)  // Estado
                                ,rs.getString(7)  // FechaCreacion
                                ,rs.getString(8));// FechaModifica
            }
        }
        catch (SQLException e) {
            throw e; 
        }
        return s;
    }

    public Integer getRowCount()  throws Exception  {
        String query =" SELECT COUNT(*) TotalReg  "
                     +" FROM    GCCatalogo        "
                     +" WHERE   Estado ='A'       "
                     +" AND     IdCatalogoTipo = 3";
        try {
            Connection conn = openConnection();         // conectar a DB
            Statement  stmt = conn.createStatement();   // CRUD : select * ...
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        }
        catch (SQLException e) {
            throw e; 
        }
        return 0;
    }


    

}