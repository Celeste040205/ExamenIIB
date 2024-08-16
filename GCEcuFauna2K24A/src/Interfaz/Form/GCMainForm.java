package Interfaz.Form;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import Interfaz.GCIAStyle;

public class GCMainForm extends JFrame{
    GCCedNomPanel GCCedNom = new GCCedNomPanel();
    GCPanelCentral GCCentral = new GCPanelCentral();

    public GCMainForm(String tilteApp){
        customizeComponent(tilteApp);
    }

    private void customizeComponent(String tilteApp) {

        setTitle(tilteApp);
        setSize(610, 570);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(GCIAStyle.GCCOLOR_FONDO);

        Container GCcontainer = getContentPane();
        GCcontainer.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        GCcontainer.add(GCCedNom, BorderLayout.NORTH);
        GCcontainer.add(GCCentral, BorderLayout.CENTER);
        setVisible(true);
    }

}
