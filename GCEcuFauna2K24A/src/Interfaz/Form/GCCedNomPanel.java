package Interfaz.Form;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Interfaz.GCIAStyle;
import Interfaz.Customer.GCLabel;
import Interfaz.Customer.GCLabelText;

public class GCCedNomPanel extends JPanel{

    private GCLabelText GCcedula, GCnombre;

    public GCCedNomPanel(){
        customizeComponent();
        setBorder(BorderFactory.createEmptyBorder(7, 150, 7, 60));
        setLayout(new GridLayout(2, 2, 0, 10));
        add(new GCLabel("Cedula:"));
        add(GCcedula = new GCLabelText("175297304-8"));
        add(new GCLabel("Nombres:"));
        add(GCnombre = new GCLabelText(" Gallardo Celeste "));

    }
    private void customizeComponent() {
        setBackground(GCIAStyle.GCCOLOR_FONDO);
        setPreferredSize(new Dimension(40, 60));
        setAlignmentX(BOTTOM_ALIGNMENT);
    }

}