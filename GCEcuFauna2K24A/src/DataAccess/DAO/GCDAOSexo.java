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
import DataAccess.DTO.GCDTOSexo;

public class GCDAOSexo extends GCDataHelper implements GCIDAO<GCDTOSexo> {

    @Override
    public boolean create(GCDTOSexo entity) throws Exception {
        String query = " INSERT INTO GCCatalogo (IdCatalogoTipo ,Nombre ,Descripcion ) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 2);   //
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
    public List<GCDTOSexo> readAll() throws Exception {
        List <GCDTOSexo> lst = new ArrayList<>();
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
                     +" AND   IdCatalogoTipo = 2 ";
        try {
            Connection conn = openConnection();         // conectar a DB
            Statement  stmt = conn.createStatement();   // CRUD : select * ...
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                GCDTOSexo s = new GCDTOSexo(
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
    public boolean update(GCDTOSexo entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE GCCatalogo SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCatalogo = ?";
        try {
            Connection        conn   = openConnection();
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
    public GCDTOSexo readBy(Integer id) throws Exception {
        GCDTOSexo s  = new GCDTOSexo();
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
        +"     AND IdCatalogoTipo = 2 "
        +" ) sub                    "
        +" WHERE RowNum = " + id.toString();
        try {
            Connection conn = openConnection();         // conectar a DB
            Statement  stmt = conn.createStatement();   // CRUD : select * ...
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            System.out.println(query);
            while (rs.next()) {
                s = new GCDTOSexo(
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
                     +" AND     IdCatalogoTipo = 2";
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



