package Interfaz.Form;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import Interfaz.GCIAStyle;

public class GCMainForm extends JFrame{
    GCCedNomPanel pGcCedNom = new GCCedNomPanel();
    GCPanelCentral pCentral = new GCPanelCentral();
    GCPanelBotones pBotones = new GCPanelBotones();

    public GCMainForm(String tilteApp){
        customizeComponent(tilteApp);
    }

    private void customizeComponent(String tilteApp) {
        setTitle(tilteApp);
        setSize(600, 815);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(GCIAStyle.GCCOLOR_FONDO);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pGcCedNom, BorderLayout.NORTH);
        container.add(pCentral, BorderLayout.CENTER);
        container.add(pBotones, BorderLayout.SOUTH);
        setVisible(true);
    }

}
