package Interfaz;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
//import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class GCIAStyle {
    public static final Color GCCOLOR_FONT        = Color.BLACK; //Azul marino (0,34,141)
    public static final Color GCCOLOR_FONT_LIGHT  = new Color(25, 25, 25 ); //Gris oscuro (58,58,58)
    public static final Color GCCOLOR_FONDO       = new Color(0, 211, 132); //mostaza claro (232,211,132)
    public static final Color GCCOLOR_FONDO2      = new Color(35, 246, 232); //amarillo pastel (255,252,236)
    public static final Color GCCOLOR_CURSOR      = Color.blue;
    public static final Color GCCOLOR_BORDER      = Color.black;
    public static final Font  GCFONT              = new Font("JetBrains Mono", Font.BOLD, 20);
    public static final Font  GCFONT_BOLD         = new Font("JetBrains Mono", Font.BOLD | Font.PLAIN, 20);
    public static final Font  GCFONT_SMALL        = new Font("JetBrains Mono", Font.PLAIN| Font.PLAIN, 10);
    
    public static final int GCALIGNMENT_LEFT  = SwingConstants.LEFT;
    public static final int GCALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int GCALIGNMENT_CENTER= SwingConstants.CENTER;

    public static final Cursor GCCURSOR_HAND    = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor GCCURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    // public static final URL GCURL_MAIN  = IAStyle.class.getResource("/Interface/Image/Principal.png");
    // public static final URL GCURL_LOGO  = IAStyle.class.getResource("/Interface/Image/logo.png.png");
    // public static final URL GCURL_FONDO  = IAStyle.class.getResource("/Interface/Image/libreria.png");

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
