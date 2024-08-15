package Interfaz.Customer;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Interfaz.GCIAStyle;

public class GCTextBox extends JTextField{

    public GCTextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setBackground(GCIAStyle.GCCOLOR_FONDO2);
        setFont(GCIAStyle.GCFONT_SMALL);  
        setForeground(GCIAStyle.GCCOLOR_FONT_LIGHT);  
        setCaretColor(GCIAStyle.GCCOLOR_CURSOR); 
        setMargin(new Insets(10, 10, 10, 10));    
        setOpaque(true);                     
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(GCIAStyle.GCCOLOR_BORDER);
        Border emptyBorder = new EmptyBorder(5, 10, 5, 10);  // Márgenes internos
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }

    public void setBorderLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, GCIAStyle.GCCOLOR_BORDER) 
        ));
    }
}
