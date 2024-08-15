package Interfaz.Form;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Interfaz.GCIAStyle;
import Interfaz.Customer.GCLabel;
import Interfaz.Customer.GCLabelText;

public class GCCedNomPanel extends JPanel{

    public GCCedNomPanel(){
        customizeComponent();
        setBorder(BorderFactory.createEmptyBorder(7, 150, 7, 60));
        setLayout(new GridLayout(2, 2, 0, 10));
        GCLabelText GCCedula = new GCLabelText("175297304-8");
        GCLabelText GCNombre = new GCLabelText("Gallardo Celeste");
        add(new GCLabel("Cédula:"));
        add(GCCedula);
        add(new GCLabel("Nombres:"));
        add(GCNombre);

    }
    private void customizeComponent() {
        setBackground(GCIAStyle.GCCOLOR_FONDO);
        setPreferredSize(new Dimension(40, 60));
        setAlignmentX(BOTTOM_ALIGNMENT);
    }

}