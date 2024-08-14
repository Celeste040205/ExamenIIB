package Interfaz.Customer;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import Interfaz.GCIAStyle;

import java.awt.event.MouseListener;

public class GCButton extends JButton implements MouseListener {
    public GCButton(String text){
        customizeComponent(text);
    }
    public GCButton(String text, String iconnew){
        customizeComponent(text, iconnew);
    }

    public void customizeComponent(String text, String iconnew){ 
        
        setSize(20, 70);
        addMouseListener(this);
        customizeComponent(text);
        setBounds(50, 30, 100, 20); 
        
        setIcon(new ImageIcon(iconnew));
        setFont(GCIAStyle.GCFONT);
    }
    public void customizeComponent(String text) {
        setText(text);
        setOpaque(true);
        setFocusPainted(false);
        setBorderPainted(true);
        setContentAreaFilled(false);
        setForeground(GCIAStyle.GCCOLOR_FONT);
        setHorizontalAlignment(GCIAStyle.GCALIGNMENT_CENTER);
        setFont(GCIAStyle.GCFONT); 
        //setBackground(GCIAStyle.GCCOLOR_BORDER);
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        setForeground(Color.BLACK);
        setCursor(GCIAStyle.GCCURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setForeground(Color.GRAY);
        setCursor(GCIAStyle.GCCURSOR_DEFAULT);
    }
    
}
