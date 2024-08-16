package Interfaz.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import BusinessLogic.GCBLHormiga;
import DataAccess.GCDataHelper;
import DataAccess.DAO.GCDAOHormiga;
import DataAccess.DTO.GCDTOHormiga;
import Interfaz.GCIAStyle;
import Interfaz.Customer.GCButton;
import Interfaz.Customer.GCButton3;
import Interfaz.Customer.GCButton4;
import Interfaz.Customer.GCLabel3;
import Interfaz.Customer.GCTextBox;

public class GCPanelCentral extends JPanel{

    // private Integer gcRowNum = 0, gcIdRowMax = 0;
    // private GCBLHormiga GCBLHormiga = new GCBLHormiga();
    // private GCDTOHormiga gcHormigasDAO = null;

    // private JPanel gcPnlTabla    = new JPanel();

    // private GCLabel3 gcLblTotalReg = new GCLabel3(" 0 de 0 ");


    // private GCTextBox gcTxtRowNum = new GCTextBox();

    private List<String> provincias = new ArrayList<>();
    private DefaultTableModel GCmodel;
    public GCButton3 GCbtnCrear     = new GCButton3("Crear Hormiga Larva");
    public GCButton4 GCbtnEliminar  = new GCButton4("Eliminar");
    public GCButton4 GCbtnGuardar   = new GCButton4("Guardar");

    public GCPanelCentral() {
        // Inicializa el modelo de tabla
        GCmodel = new DefaultTableModel(
            new Object[]{"RegNro", "TipoHormiga", "Ubicacion", "Sexo", "GenoAlimento", "IngestaNativa", "Estado", "ChipIA"}, 0) {
            
            // Hacer las celdas no editables
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer las celdas editables solo si la fila no es la primera
                if (row > 0) {
                    return column == 1 || column == 2 || column == 3 || column == 4 || column == 5 || column == 6;
                }
                return false; // La primera fila no es editable
            }   
        };
        
        cargarDatosDesdeDB();
        cargarProvinciasDesdeDB();
        //configurarAcciones();

        // Configuración del panel superior
        JPanel GCtopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        try {
            Image GClogo = ImageIO.read(GCIAStyle.GCURL_LOGOSF);
            GClogo = GClogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            GCtopPanel.add(new JLabel(new ImageIcon(GClogo)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GCtopPanel.add(new GCLabel3("Hormiguero Virtual                               "));
        GCtopPanel.add(GCbtnCrear, FlowLayout.RIGHT);
        GCbtnCrear.addActionListener(e -> { 
            int respuesta = JOptionPane.showConfirmDialog(
                null, 
                "¿Estás seguro de crear una Hormiga Larva?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE
            );
        
            if (respuesta == JOptionPane.YES_OPTION) {
                int numeroRegistro = GCmodel.getRowCount() + 1;
                if (!provincias.isEmpty()) {
                    int randomIndex = (int) (Math.random() * provincias.size());
                    String provinciaAleatoria = provincias.get(randomIndex);
                    GCmodel.addRow(new Object[]{numeroRegistro, "Larva", provinciaAleatoria, "Asexual", null, null, "VIVA", "Aprendiendo Español" });
                }
        }
        });
        add(GCtopPanel, BorderLayout.NORTH);

        // Configuración del panel central para mostrar la tabla
        JPanel GCgridPanel = new JPanel(new BorderLayout());
        JTable table = new JTable(GCmodel);
        JScrollPane GCscrollPane = new JScrollPane(table);
        GCscrollPane.setPreferredSize(new Dimension(760, 200));
        add(GCgridPanel, BorderLayout.CENTER);
        GCgridPanel.add(GCscrollPane, BorderLayout.CENTER);

        // Configuración del panel inferior
        JPanel GCbottomPanel      = new JPanel(new GridLayout(3, 2, 80, 10));
        GCButton GCGenoAlimento   = new GCButton("GenoAlimento");
        GCButton GCIngestaNativa  = new GCButton("Ingesta Nativa");
        GCButton3 GCbtnAlimenGeno = new GCButton3("Alimentar GenoAlimento");
        GCButton3 GCbtnAlimenNat  = new GCButton3("Alimentar Ingesta Nativa");
        
        JPopupMenu GCGenoAlimentoMenu = new JPopupMenu();
        JMenuItem GCX  = new JMenuItem("X");
        JMenuItem GCXX = new JMenuItem("XX");
        JMenuItem GCXY = new JMenuItem("XY");
        
        JPopupMenu GCIngestaNativaMenu = new JPopupMenu();
        JMenuItem GCCar = new JMenuItem("Carnívoro");
        JMenuItem GCHer = new JMenuItem("Herbívoro");
        JMenuItem GCOmn = new JMenuItem("Omnívoro");
        JMenuItem GCIns = new JMenuItem("Insectívoro");
        JMenuItem GCNec = new JMenuItem("Nectarívoro");
        
        GCX.addActionListener(  e -> GCGenoAlimento.setText(GCX.getText()));
        GCXX.addActionListener( e -> GCGenoAlimento.setText(GCXX.getText()));
        GCXY.addActionListener( e -> GCGenoAlimento.setText(GCXY.getText()));
        GCCar.addActionListener(e -> GCIngestaNativa.setText(GCCar.getText()));
        GCHer.addActionListener(e -> GCIngestaNativa.setText(GCHer.getText()));
        GCOmn.addActionListener(e -> GCIngestaNativa.setText(GCOmn.getText()));
        GCIns.addActionListener(e -> GCIngestaNativa.setText(GCIns.getText()));
        GCNec.addActionListener(e -> GCIngestaNativa.setText(GCNec.getText()));
        
        GCGenoAlimentoMenu.add(GCX);
        GCGenoAlimentoMenu.add(GCXX);
        GCGenoAlimentoMenu.add(GCXY);
        GCIngestaNativaMenu.add(GCCar);
        GCIngestaNativaMenu.add(GCHer);
        GCIngestaNativaMenu.add(GCOmn);
        GCIngestaNativaMenu.add(GCIns);
        GCIngestaNativaMenu.add(GCNec);
        
        GCGenoAlimento.addActionListener(e -> {
            GCGenoAlimentoMenu.show(GCGenoAlimento, 0, GCGenoAlimento.getHeight());
        });

        GCIngestaNativa.addActionListener(e -> {
            GCIngestaNativaMenu.show(GCIngestaNativa, 0, GCIngestaNativa.getHeight());
        });
        
        GCbtnAlimenGeno.addActionListener(e -> {
            int lastRowIndex = GCmodel.getRowCount() - 1; 
            if (lastRowIndex >= 0) {
                String genoAlimento = GCGenoAlimento.getText();

                if ("XX".equals(genoAlimento)) {
                    GCmodel.setValueAt("XX", lastRowIndex, 4);
                    String tipoHormiga = Math.random() < 0.9 ? "Reina" : "Rastreadora";
                    GCmodel.setValueAt(tipoHormiga, lastRowIndex, 1);
                    GCmodel.setValueAt("Femenino", lastRowIndex, 3);
                    GCmodel.setValueAt("Habla Español", lastRowIndex, 7);

                } else if ("XY".equals(genoAlimento)) {
                    GCmodel.setValueAt("XY", lastRowIndex, 4);
                    String tipoHormiga = Math.random() < 0.5 ? "Soldado" : "Zángano";
                    GCmodel.setValueAt(tipoHormiga, lastRowIndex, 1);
                    GCmodel.setValueAt("Masculino", lastRowIndex, 3);
                    GCmodel.setValueAt("Habla Español", lastRowIndex, 7);

                } else {
                    GCmodel.setValueAt(genoAlimento, lastRowIndex, 4);
                    GCmodel.setValueAt("Asexual", lastRowIndex, 3);
                    GCmodel.setValueAt("Larva", lastRowIndex, 1);
                    GCmodel.setValueAt("Aprendiendo Español", lastRowIndex, 7);
                }                
            }
        });
        
        GCbtnAlimenNat.addActionListener(e -> {
            int lastRowIndex = GCmodel.getRowCount() - 1;
            if (lastRowIndex >= 0) {

                String tipoHormiga = (String) GCmodel.getValueAt(lastRowIndex, 1);
                String ingestaNativaSeleccionada = GCIngestaNativa.getText();
        
                String nuevoEstado = "VIVA"; 
                
                if ("Reina".equals(tipoHormiga)) {
                    if (!"Insectívoro".equals(ingestaNativaSeleccionada)) {
                        nuevoEstado = "MUERTA";
                    }
                } else if ("Larva".equals(tipoHormiga)) {
                    if (!"Nectarívoro".equals(ingestaNativaSeleccionada)) {
                        nuevoEstado = "MUERTA";
                    }
                } else if ("Soldado".equals(tipoHormiga)) {
                    if (!"Carnívoro".equals(ingestaNativaSeleccionada)) {
                        nuevoEstado = "MUERTA";
                    }
                } else if ("Rastreadora".equals(tipoHormiga)) {
                    if (!"Herbívoro".equals(ingestaNativaSeleccionada)) {
                        nuevoEstado = "MUERTA";
                    }
                } else if ("Zángano".equals(tipoHormiga)) {
                    if (!"Omnívoro".equals(ingestaNativaSeleccionada)) {
                        nuevoEstado = "MUERTA";
                    }
                }
        
                GCmodel.setValueAt(ingestaNativaSeleccionada, lastRowIndex, 5);
        
                GCmodel.setValueAt(nuevoEstado, lastRowIndex, 6);
            }
        });
        
        
        
        GCbottomPanel.add(GCGenoAlimento);
        GCbottomPanel.add(GCbtnAlimenGeno);
        GCbottomPanel.add(GCIngestaNativa);
        GCbottomPanel.add(GCbtnAlimenNat);
        GCbottomPanel.add(GCbtnEliminar);
        GCbottomPanel.add(GCbtnGuardar);

        GCbtnEliminar.addActionListener(e -> { 
            int respuesta = JOptionPane.showConfirmDialog(
                null, 
                "¿Estás seguro de exterminar a la Hormiga?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE
            );
        
            if (respuesta == JOptionPane.YES_OPTION) {
                
        }
        });

        GCbtnGuardar.addActionListener(e -> { 
            int respuesta = JOptionPane.showConfirmDialog(
                null, 
                "¿Estás seguro de guardar el hormiguero en la base de datos?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE
            );
        
            if (respuesta == JOptionPane.YES_OPTION) {
                
        }
        });
        
        add(GCbottomPanel, BorderLayout.SOUTH);
    }

    private void cargarDatosDesdeDB() {
        String query = "SELECT " +
                       "H.IdHormiga, " +
                       "GCC1.Nombre AS TipoHormiga, " +
                       "GCC2.Nombre AS IngestaNativa, " +
                       "GCC3.Nombre AS GenoAlimento, " +
                       "GCC4.Nombre AS Sexo, " +
                       "U.Provincia AS Ubicacion " +
                       "FROM GCHormiga H " +
                       "JOIN GCCatalogo GCC1 ON H.IdClgTipoHormiga = GCC1.IdCatalogo " +
                       "JOIN GCCatalogo GCC2 ON H.IdClgIngestaNativa = GCC2.IdCatalogo " +
                       "JOIN GCCatalogo GCC3 ON H.IdClgGenoAlimento = GCC3.IdCatalogo " +
                       "JOIN GCCatalogo GCC4 ON H.IdClgSexo = GCC4.IdCatalogo " +
                       "JOIN GCUbicacion U ON H.IdUbicacion = U.IdUbicacion";

        try (Connection conn = GCDataHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Object[] row = new Object[8];
                row[0] = rs.getInt("IdHormiga");
                row[1] = rs.getString("TipoHormiga");
                row[2] = rs.getString("Ubicacion");
                row[3] = rs.getString("Sexo");
                row[4] = rs.getString("GenoAlimento");
                row[5] = rs.getString("IngestaNativa");
                row[6] = rs.getString("Estado");
                row[7] = rs.getString("ChipIA");
                GCmodel.addRow(row);
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar datos desde la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void cargarProvinciasDesdeDB() {
        String query = "SELECT DISTINCT Provincia FROM GCUbicacion";

        try (Connection conn = GCDataHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                provincias.add(rs.getString("Provincia"));
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar provincias desde la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }    
    // private void loadRow()  {
    //     try {
    //         rowNum        = 1;
    //         GCDAOHormiga  = GCBLHormiga.getBy(rowNum);
    //         gcIdRowMax    = GCBLHormiga.getRowCount();
    //     } catch (Exception e) {
    //         GCIAStyle.showMsg(e.getMessage());
    //     }
    // }
    
    // private void showRow() {
    //     boolean mfHormigaNull = (GCDAOHormiga == null);
    //         gcTxtRowNum.setText((mfHormigaNull) ? " " : GCDAOHormiga.getGCIdHormiga().toString());
    //         gcLblTotalReg.setText(gcRowNum.toString() + " de " + gcIdRowMax.toString());
    //     }
    
    
    // private void GCbtnGuardar() {
    //     boolean sexoNull = (GCDAOHormiga == null);
    //     // String buttonText = ((JButton) e.getSource()).getText();
    //     try {
    //         if (GCIAStyle.showConfirmYesNo("¿Seguro que desea " + ((sexoNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
    //             if (sexoNull)
    //                 GCDAOHormiga = new SexoDTO(txtNombre.getText().trim());
    //             else
    //                 GCDAOHormiga.setNombre(txtNombre.getText());
    
    //             if(!((sexoNull) ? GCBLHormiga.add(GCDAOHormiga) : GCBLHormiga.update(GCDAOHormiga)))
    //                 GCIAStyle.showMsgError("Error al guardar...!");
    
    //             loadRow();
    //             showRow();
    //             showTable();
    //         }
    //     } catch (Exception e) {
    //         GCIAStyle.showMsgError(e.getMessage());
    //     }
    // }
    
    // private void GCBtnEliminar() {
    //     try {
    //         if (GCIAStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {
    
    //             if (!GCBLHormiga.delete(GCDAOHormiga.getGCIdHormiga()))
    //                 throw new Exception("Error al eliminar...!");
    //             System.out.println(" ");
    //             loadRow();
    //             showRow();
    //             showTable();
    //         }
    //     } catch (Exception e) {
    //         GCIAStyle.showMsgError(e.getMessage());
    //     }
    // }
    
    // private void showTable() throws Exception {
    //     String[] header ={"RegNro", "TipoHormiga", "Ubicacion", "Sexo", "GenoAlimento", "IngestaNativa", "Estado", "ChipIA"},
    //     Object[][] data = new Object[GCBLHormiga.getAll().size()][4];
    //     int index = 0;
    //         for (GCDTOHormiga gcH : GCBLHormiga.getAll()) {
    //             data[index][0] = gcH.getGCRowNum();
    //             data[index][1] = gcH.getGCIdHormiga();
    //             data[index][2] = gcH.getGCTipoHormiga();
    //             data[index][3] = gcH.getGCSexo();
    //             data[index][4] = gcH.getGCProvincia();
    
    //             data[index][5] = gcH.getGCGenoAlimento();
    //             data[index][6] = gcH.getGCIngestaNativa();
    //             data[index][7] = gcH.getGCEstado();
    //             index++;
    //         }
    
    //     JTable table = new JTable(data, header);
    //     table.setShowHorizontalLines(true);
    //     table.setGridColor(Color.lightGray);
    //     table.setRowSelectionAllowed(true);
    //     table.setColumnSelectionAllowed(false);
    
    //     table.setPreferredScrollableViewportSize(new Dimension(400, 70));
    //     table.setFillsViewportHeight(true);
    
    //     pnlTabla.removeAll();
    //     pnlTabla.add(new JScrollPane(table));
    
    //     table.addMouseListener(new MouseAdapter() {
    //         @Override
    //         public void mouseClicked(MouseEvent e) {
    //             int row = table.rowAtPoint(e.getPoint());
    //             int col = table.columnAtPoint(e.getPoint());
    //             if (row >= 0 && col >= 0) {
    //                 String strrowNum = table.getModel().getValueAt(row, 0).toString();
    //                 rowNum = Integer.parseInt(strrowNum);
    //                 try {
    //                     GCDAOHormiga = GCBLHormiga.getBy(rowNum);
    //                     showRow();
    //                 } catch (Exception ignored) {
    //                 }
    //                 System.out.println("Tabla.Selected: " + strrowNum);
    //             }
    //         }
    //     });
    // }
    
    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    



}    

