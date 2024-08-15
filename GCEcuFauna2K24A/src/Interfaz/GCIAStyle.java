package Interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class GCIAStyle {
    public static final Color GCCOLOR_FONT        = Color.WHITE; 
    public static final Color GCCOLOR_FONT_DARK   = Color.DARK_GRAY;
    public static final Color GCCOLOR_FONT_LIGHT  = Color.WHITE;
    public static final Color GCCOLOR_FONDO       = new Color(10, 30, 70); 
    public static final Color GCCOLOR_FONDO2      = new Color(229, 255, 253); 
    public static final Color GCCOLOR_CURSOR      = Color.BLUE;
    public static final Color GCCOLOR_BORDER      = Color.BLACK;

    //Azul (0,34,141), Verde (0, 128, 0), Rojo (255, 0, 0), Amarillo (255, 255, 0)
    //Naranja (255, 165, 0), amarillo pastel (255,252,236), mostaza claro (232,211,132), Azul oscuro (10,30,70)
    //Azul claro (0, 0, 255), Negro (0,0,0), celeste claro (casi blanco) (229.255.253)

    public static final Font  GCFONT              = new Font("JetBrains Mono", Font.BOLD, 20);
    public static final Font  GCFONT_BOLD         = new Font("JetBrains Mono", Font.PLAIN | Font.PLAIN, 15);
    public static final Font  GCFONT_SMALL        = new Font("JetBrains Mono", Font.PLAIN| Font.PLAIN, 10);
    
    public static final int GCALIGNMENT_LEFT   = SwingConstants.LEFT;
    public static final int GCALIGNMENT_RIGHT  = SwingConstants.RIGHT;
    public static final int GCALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor GCCURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor GCCURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final URL GCURL_MAIN    = GCIAStyle.class.getResource("/Interfaz/Image/Inicio.png");
    public static final URL GCURL_LOGO    = GCIAStyle.class.getResource("/Interfaz/Image/Logo.png");
    public static final URL GCURL_LOGOSF  = GCIAStyle.class.getResource("/Interfaz/Image/LogoSF.png");

    public static final CompoundBorder createBorderRect(){
        return BorderFactory.createCompoundBorder(  new LineBorder(Color.BLACK),
                                                    new EmptyBorder(5, 5, 5, 5));
    }

    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "😏 GCEcuFauna2K2024A", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        JOptionPane.showMessageDialog(null, msg, "💀 GCEcuFauna2K2024A", JOptionPane.OK_OPTION);
    }
    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "😞 GCEcuFauna2K2024A", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }

}
