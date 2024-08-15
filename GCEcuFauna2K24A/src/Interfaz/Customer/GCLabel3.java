package Interfaz.Customer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import Interfaz.GCIAStyle;

public class GCLabel3 extends JLabel {
    public GCLabel3(){
        customizeComponent();
    }
    public GCLabel3(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), GCIAStyle.GCFONT_BOLD2, GCIAStyle.GCCOLOR_FONT_DARK, GCIAStyle.GCALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
    public void setCustomizeComponent(String etiqueta, Font gcfontBold, Color gccolorFontLight, Color gccolorFondo2,
            int gcalignmentCenter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCustomizeComponent'");
    }
}