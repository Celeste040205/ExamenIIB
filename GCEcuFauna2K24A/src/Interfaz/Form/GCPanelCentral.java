package Interfaz.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.GCDataHelper;
import Interfaz.GCIAStyle;
import Interfaz.Customer.GCButton;
import Interfaz.Customer.GCButton3;
import Interfaz.Customer.GCLabel3;

public class GCPanelCentral extends JPanel {

    private DefaultListModel<String> GClistModel;
    private DefaultTableModel GCmodel;
    public GCButton3 GCbtnCrear = new GCButton3("Crear Hormiga");

    public GCPanelCentral() {

        configurarAcciones();
        // Configuración del panel superior
        JPanel GCtopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        try {
            Image GClogo = ImageIO.read(GCIAStyle.GCURL_LOGOSF);
            GClogo = GClogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            GCtopPanel.add(new JLabel(new ImageIcon(GClogo)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GCtopPanel.add(new GCLabel3("Hormiguero Virtual                 "));
        GCtopPanel.add(GCbtnCrear, FlowLayout.RIGHT);
        add(GCtopPanel, BorderLayout.NORTH);

        // Configuración del panel central para mostrar la tabla
        JPanel GCgridPanel = new JPanel(new BorderLayout());
        GCmodel = new DefaultTableModel(
            new Object[]{"IdHormiga", "TipoHormiga", "IngestaNativa", "GenoAlimento", "Sexo", "Ubicacion"}, 0) {
            
            // Hacer las celdas no editables
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Ninguna celda es editable
            }
        };
        
        // Cargar datos desde la base de datos
        cargarDatosDesdeDB();
        
        JTable table = new JTable(GCmodel);
        JScrollPane GCscrollPane = new JScrollPane(table);
        GCscrollPane.setPreferredSize(new Dimension(550, 200));
        GCgridPanel.add(GCscrollPane, BorderLayout.CENTER);
        add(GCgridPanel, BorderLayout.CENTER);

        
        // Configuración del panel inferior
        JPanel GCbottomPanel = new JPanel(new GridLayout(2, 2, 30, 20));
        final int[] count = {0};
        GCButton GCGenoAlimento = new GCButton("GenoAlimento");
        GCButton GCIngestaNativa = new GCButton("Ingesta Nativa");
        GCButton3 GCbtnAlimenGeno = new GCButton3("Alimentar GenoAlimento");
        GCButton3 GCbtnAlimenNat = new GCButton3("Alimentar Ingesta Nativa");
        
        JPopupMenu GCGenoAlimentoMenu = new JPopupMenu();
        JMenuItem GCX = new JMenuItem("X");
        JMenuItem GCXX = new JMenuItem("XX");
        JMenuItem GCXY = new JMenuItem("XY");
        
        JPopupMenu GCIngestaNativaMenu = new JPopupMenu();
        JMenuItem GCCar = new JMenuItem("Carnívoro");
        JMenuItem GCHer = new JMenuItem("Herbívoro");
        JMenuItem GCOmn = new JMenuItem("Omnívoro");
        JMenuItem GCIns = new JMenuItem("Insectívoro");
        
        GCX.addActionListener(e -> GCGenoAlimento.setText(GCX.getText()));
        GCXX.addActionListener(e -> GCGenoAlimento.setText(GCXX.getText()));
        GCXY.addActionListener(e -> GCGenoAlimento.setText(GCXY.getText()));
        GCCar.addActionListener(e -> GCIngestaNativa.setText(GCCar.getText()));
        GCHer.addActionListener(e -> GCIngestaNativa.setText(GCHer.getText()));
        GCOmn.addActionListener(e -> GCIngestaNativa.setText(GCOmn.getText()));
        GCIns.addActionListener(e -> GCIngestaNativa.setText(GCIns.getText()));
        
        GCGenoAlimentoMenu.add(GCX);
        GCGenoAlimentoMenu.add(GCXX);
        GCGenoAlimentoMenu.add(GCXY);
        GCIngestaNativaMenu.add(GCCar);
        GCIngestaNativaMenu.add(GCHer);
        GCIngestaNativaMenu.add(GCOmn);
        GCIngestaNativaMenu.add(GCIns);
        
        GCGenoAlimento.addActionListener(e -> {
            GCGenoAlimentoMenu.show(GCGenoAlimento, 0, GCGenoAlimento.getHeight());
        });

        GCIngestaNativa.addActionListener(e -> {
            GCIngestaNativaMenu.show(GCIngestaNativa, 0, GCIngestaNativa.getHeight());
        });
        
        GCbtnAlimenGeno.addActionListener(e -> {
            addItemToList(GCGenoAlimento.getText(), GClistModel, count);
        });

        GCbtnAlimenNat.addActionListener(e -> {
            addItemToList(GCIngestaNativa.getText(), GClistModel, count);
        });
        
        GCbottomPanel.add(GCGenoAlimento);
        GCbottomPanel.add(GCbtnAlimenGeno);
        GCbottomPanel.add(GCIngestaNativa);
        GCbottomPanel.add(GCbtnAlimenNat);
        
        add(GCbottomPanel, BorderLayout.SOUTH);
    }
    
    private static void addItemToList(String text, DefaultListModel<String> listModel, int[] count) {
        if (listModel.isEmpty() || count[0] == 2) {
            listModel.addElement(text);
            count[0] = 1;
        } else {
            String currentText = listModel.getElementAt(listModel.size() - 1);
            listModel.setElementAt(currentText + " " + text, listModel.size() - 1);
            count[0]++;
        }
    }
    private void cargarDatosDesdeDB() {
        String query = "SELECT                                                          " +
                       "H.IdHormiga,                                                    " +
                       "GCC1.Nombre AS TipoHormiga,                                     " +
                       "GCC2.Nombre AS IngestaNativa,                                   " +
                       "GCC3.Nombre AS GenoAlimento,                                    " +
                       "GCC4.Nombre AS Sexo,                                            " +
                       "U.Provincia AS Ubicacion,                                       " +
                       "H.Estado,                                                       " +
                       "H.FechaCreacion,                                                " +
                       "H.FechaModifica                                                 " +
                       "FROM GCHormiga H                                                " +
                       "JOIN GCCatalogo GCC1 ON H.IdClgTipoHormiga   = GCC1.IdCatalogo  " +
                       "JOIN GCCatalogo GCC2 ON H.IdClgIngestaNativa = GCC2.IdCatalogo  " +
                       "JOIN GCCatalogo GCC3 ON H.IdClgGenoAlimento  = GCC3.IdCatalogo  " +
                       "JOIN GCCatalogo GCC4 ON H.IdClgSexo          = GCC4.IdCatalogo  " +
                       "JOIN GCUbicacion U ON H.IdUbicacion          = U.IdUbicacion    ";
    
        try (Connection conn = GCDataHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
    
            while (rs.next()) {
                Object[] row = new Object[6];
                row[0] = rs.getInt("IdHormiga");
                row[1] = rs.getString("TipoHormiga");
                row[2] = rs.getString("IngestaNativa");
                row[3] = rs.getString("GenoAlimento");
                row[4] = rs.getString("Sexo");
                row[5] = rs.getString("Ubicacion");
                GCmodel.addRow(row);
            }
    
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void configurarAcciones() {
        
        GCbtnCrear.addActionListener(e -> { 
        });
          
    }
}
