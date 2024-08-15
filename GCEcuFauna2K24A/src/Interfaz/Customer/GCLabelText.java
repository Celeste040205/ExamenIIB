package Interfaz.Customer;

import javax.swing.*;

import Interfaz.GCIAStyle;

import java.awt.*;

public class GCLabelText extends JPanel{
    private GCLabel    lblEtiq = new GCLabel();
    private GCTextBox  txtCont= new GCTextBox();

    public GCLabelText(String etiqueta) {
        setLayout(new BorderLayout());
        lblEtiq.setCustomizeComponent(  etiqueta, 
                                            GCIAStyle.GCFONT_BOLD, 
                                            GCIAStyle.GCCOLOR_FONT_DARK,
                                            GCIAStyle.GCALIGNMENT_CENTER); 
        txtCont.setBorderLine();
        add(lblEtiq, BorderLayout.NORTH);
        add(txtCont, BorderLayout.CENTER);
    }
}
