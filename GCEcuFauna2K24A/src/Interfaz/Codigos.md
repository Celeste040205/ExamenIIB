
codigo para que se copien los botones del menu de uno en uno

        GCbtnAlimenGeno.addActionListener(e -> {
            listModel.addElement(GCGenoAlimento.getText());
        });

        GCbtnAlimenNat.addActionListener(e -> {
            listModel.addElement(GCIngestaNativa.getText());
        }); 

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MJHormigaViewer {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:DataBase/ECUAFAUNA.sqlite";
        
        String query = "SELECT " +
                       "H.IdHormiga, " +
                       "H.TipoHormiga, " +
                       "INa.TipoIngesta AS IngestaNativa, " +
                       "GA.TipoGeno AS GenoAlimento, " +
                       "S.TipoSexo AS Sexo, " +
                       "U.Provincia AS Ubicacion, " +
                       "H.Estado, " +
                       "H.FechaCreacion, " +
                       "H.FechaModifica " +
                       "FROM MJHormiga H " +
                       "JOIN MJIngestaNativa INa ON H.IdIngestaNativa = INa.IdIngestaNativa " +
                       "JOIN MJGenoAlimento GA ON H.IdGenoAlimento = GA.IdGenoAlimento " +
                       "JOIN MJSexo S ON H.IdSexo = S.IdSexo " +
                       "JOIN MJUbicacion U ON H.IdUbicacion = U.IdUbicacion";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Convertir ResultSet en un modelo de tabla para mostrarlo en un JTable
            DefaultTableModel model = new DefaultTableModel(
                new Object[]{"IdHormiga", "TipoHormiga", "IngestaNativa", "GenoAlimento", "Sexo", "Ubicacion", "Estado", "FechaCreacion", "FechaModifica"}, 0);

            while (rs.next()) {
                Object[] row = new Object[9];
                row[0] = rs.getInt("IdHormiga");
                row[1] = rs.getString("TipoHormiga");
                row[2] = rs.getString("IngestaNativa");
                row[3] = rs.getString("GenoAlimento");
                row[4] = rs.getString("Sexo");
                row[5] = rs.getString("Ubicacion");
                row[6] = rs.getString("Estado");
                row[7] = rs.getString("FechaCreacion");
                row[8] = rs.getString("FechaModifica");
                model.addRow(row);
            }

            // Crear y mostrar el JFrame con el JTable
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("Datos de MJHormiga");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(scrollPane);
            frame.pack();
            frame.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}