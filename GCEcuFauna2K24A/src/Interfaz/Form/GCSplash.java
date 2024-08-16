package Interfaz.Form;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import Interfaz.GCIAStyle;

public abstract class GCSplash {
    private static JFrame       GCfrmSplash;
    private static JProgressBar GCprbLoaging;
    private static ImageIcon    GCicoImagen ;
    private static JLabel       GClblSplash ;

    public static void show() {
        GCicoImagen  = new ImageIcon(GCIAStyle.GCURL_MAIN);
        GClblSplash  = new JLabel(GCicoImagen);
        GCprbLoaging = new JProgressBar(0, 99);

        GCprbLoaging.setStringPainted(true);
        
        GCfrmSplash = new JFrame();
        GCfrmSplash.setUndecorated(true);
        GCfrmSplash.getContentPane().add(GClblSplash, BorderLayout.CENTER);
        GCfrmSplash.add(GCprbLoaging, BorderLayout.SOUTH);
        GCfrmSplash.setSize(GCicoImagen.getIconWidth(), GCicoImagen.getIconHeight());
        GCfrmSplash.setLocationRelativeTo(null);

        GCfrmSplash.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(10); // Espera por 10 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            GCprbLoaging.setValue(i);
        }
        GCfrmSplash.setVisible(false);
    }
}
