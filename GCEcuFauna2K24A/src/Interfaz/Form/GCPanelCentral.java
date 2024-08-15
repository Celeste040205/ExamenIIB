package Interfaz.Form;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Interfaz.GCIAStyle;

public class GCPanelCentral extends JPanel{

    

    public GCPanelCentral(){
        customizeComponent();
    }

    private void customizeComponent() {
        setBackground(GCIAStyle.GCCOLOR_FONDO2);
        // setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 30));
        // setPreferredSize(new Dimension(40, 75));
        // setLayout(new GridLayout(2, 3, 100, 0));

    }

}
