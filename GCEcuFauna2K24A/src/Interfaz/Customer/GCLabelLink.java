package Interfaz.Customer;

import javax.swing.ImageIcon;

import Interfaz.GCIAStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GCLabelLink extends GCLabel implements MouseListener{
    GCLabelLink(String text){
        super(text);
        setPersonalizacion();
    }

    GCLabelLink(String text, String iconGC){
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconGC));
    }
    
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(true);
        setForeground(GCIAStyle.GCCOLOR_FONT);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(GCIAStyle.GCCURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(GCIAStyle.GCCURSOR_DEFAULT);
    }
}
