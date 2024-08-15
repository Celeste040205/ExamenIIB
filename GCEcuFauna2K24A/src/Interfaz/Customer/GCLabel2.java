package Interfaz.Customer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import Interfaz.GCIAStyle;

public class GCLabel2 extends JLabel {
    public GCLabel2(){
        customizeComponent();
    }
    public GCLabel2(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), GCIAStyle.GCFONT_SMALL, GCIAStyle.GCCOLOR_FONT, GCIAStyle.GCALIGNMENT_RIGHT);
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
