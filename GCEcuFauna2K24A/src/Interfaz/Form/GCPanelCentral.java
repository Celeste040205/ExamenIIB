package Interfaz.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import Interfaz.GCIAStyle;
import Interfaz.Customer.GCButton;
import Interfaz.Customer.GCButton3;
import Interfaz.Customer.GCLabel3;

public class GCPanelCentral extends JPanel{

    private DefaultListModel<String> GClistModel;
    private JList<String> GClista;

    public GCButton3
    GCbtnCrear = new GCButton3("Crear Hormiga");

    public GCPanelCentral(){

        JPanel GCtopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        try {
            Image GClogo = ImageIO.read(GCIAStyle.GCURL_LOGOSF);
            GClogo = GClogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            GCtopPanel.add(new JLabel(new ImageIcon(GClogo)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel GCgridPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        GClistModel = new DefaultListModel<>();
        GClista = new JList<>(GClistModel);
        JScrollPane GCscrollPane = new JScrollPane(GClista);
        GCscrollPane.setPreferredSize(new Dimension(550, 200));

        JPanel GCbottomPanel         = new JPanel(new GridLayout(2, 2, 30, 20));
        final int[] count = {0};
        GCButton GCGenoAlimento      = new GCButton("GenoAlimento");
        GCButton GCIngestaNativa     = new GCButton("Ingesta Nativa");
        GCButton3 GCbtnAlimenGeno    = new GCButton3("Alimentar GenoAlimento");
        GCButton3 GCbtnAlimenNat     = new GCButton3("Alimentar Ingesta Nativa");

        JPopupMenu GCGenoAlimentoMenu = new JPopupMenu();
        JMenuItem GCX                 = new JMenuItem("X");
        JMenuItem GCXX                = new JMenuItem("XX");
        JMenuItem GCXY                = new JMenuItem("XY");

        JPopupMenu GCIngestaNativaMenu = new JPopupMenu();
        JMenuItem GCCar                = new JMenuItem("Carnívoro");
        JMenuItem GCHer                = new JMenuItem("Herbívoro");
        JMenuItem GCOmn                = new JMenuItem("Omnívoro");
        JMenuItem GCIns                = new JMenuItem("Insectívoro");

        GCX.addActionListener(      e -> GCGenoAlimento.setText(GCX.getText()));
        GCXX.addActionListener(     e -> GCGenoAlimento.setText(GCXX.getText()));
        GCXY.addActionListener(     e -> GCGenoAlimento.setText(GCXY.getText()));
        GCCar.addActionListener(    e -> GCIngestaNativa.setText(GCCar.getText()));
        GCHer.addActionListener(    e -> GCIngestaNativa.setText(GCHer.getText()));
        GCOmn.addActionListener(    e -> GCIngestaNativa.setText(GCOmn.getText()));
        GCIns.addActionListener(    e -> GCIngestaNativa.setText(GCIns.getText()));

        GCGenoAlimentoMenu.add(GCX);
        GCGenoAlimentoMenu.add(GCXX);
        GCGenoAlimentoMenu.add(GCXY);
        GCIngestaNativaMenu.add(GCCar);
        GCIngestaNativaMenu.add(GCHer);
        GCIngestaNativaMenu.add(GCOmn);
        GCIngestaNativaMenu.add(GCIns);

        GCGenoAlimento.addActionListener( e -> { GCGenoAlimentoMenu.show(GCGenoAlimento, 0, GCGenoAlimento.getHeight());});
        GCIngestaNativa.addActionListener(e -> {GCIngestaNativaMenu.show(GCIngestaNativa, 0, GCIngestaNativa.getHeight());});
        GCbtnAlimenGeno.addActionListener(e -> {
            addItemToList(GCGenoAlimento.getText(), GClistModel, count);
        });

        GCbtnAlimenNat.addActionListener(e -> {
            addItemToList(GCIngestaNativa.getText(), GClistModel, count);
        });
        
        GCtopPanel.add(new GCLabel3("Hormiguero Virtual                 "));
        GCtopPanel.add(GCbtnCrear, FlowLayout.RIGHT);

        GCgridPanel.add(GCscrollPane, BorderLayout.CENTER);

        GCbottomPanel.add(GCGenoAlimento);
        GCbottomPanel.add(GCbtnAlimenGeno);
        GCbottomPanel.add(GCIngestaNativa);
        GCbottomPanel.add(GCbtnAlimenNat);

        add(GCtopPanel, BorderLayout.NORTH);
        add(GCgridPanel, BorderLayout.CENTER);
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

}
