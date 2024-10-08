package Interfaz.Customer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import Interfaz.GCIAStyle;

public class GCLabel extends JLabel {
    public GCLabel(){
        customizeComponent();
    }
    public GCLabel(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), GCIAStyle.GCFONT, GCIAStyle.GCCOLOR_FONT, GCIAStyle.GCALIGNMENT_LEFT);
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
