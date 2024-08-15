package Interfaz.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Interfaz.GCIAStyle;
import Interfaz.Customer.GCButton3;
import Interfaz.Customer.GCLabel2;
import Interfaz.Customer.GCLabel3;

public class GCPanelCentral extends JPanel{

    private DefaultListModel<String> listModel;
    private JList<String> lista;

    public GCButton3
    btnCrear = new GCButton3("Crear Hormiga");

    
    public GCPanelCentral(){
        //customizeComponent();

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        try {
            Image logo = ImageIO.read(GCIAStyle.GCURL_LOGOSF);
            logo = logo.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            topPanel.add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel gridPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        listModel = new DefaultListModel<>();
        lista = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(550, 200));
        JPanel bottomPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        
        
        topPanel.add(new GCLabel3("Hormiguero Virtual                        "));
        topPanel.add(btnCrear, FlowLayout.RIGHT);
        gridPanel.add(scrollPane, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
    }
    
    private void customizeComponent() {
        setBackground(GCIAStyle.GCCOLOR_FONDO2);
        //setPreferredSize(new Dimension(0, 685));
        setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        setLayout(new GridLayout(6, 3, 0, 0));

    }

}
