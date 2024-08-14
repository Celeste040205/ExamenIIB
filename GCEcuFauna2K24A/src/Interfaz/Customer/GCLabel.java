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
        setCustomizeComponent(getText(), GCIAStyle.GCFONT_BOLD, GCIAStyle.GCCOLOR_FONT_LIGHT, GCIAStyle.GCALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
    }
}
