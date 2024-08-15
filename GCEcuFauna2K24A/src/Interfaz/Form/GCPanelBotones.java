package Interfaz.Form;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Interfaz.GCIAStyle;
import Interfaz.Customer.GCButton;
import Interfaz.Customer.GCLabel2;

public class GCPanelBotones extends JPanel{
    public GCButton
    btnGuardar = new GCButton("Guardar"),
    btnEliminar = new GCButton("Eliminar");

    public GCPanelBotones(){
        customizeComponent();
        customizeComponent2();
        configurarAcciones();
    }

    private void customizeComponent() {
        setBackground(GCIAStyle.GCCOLOR_FONDO);
        setBorder(BorderFactory.createEmptyBorder(10, 30, 0, 30));
        setPreferredSize(new Dimension(40, 75));
        setLayout(new GridLayout(2, 3, 100, 0));

        add(btnEliminar);
        add(btnGuardar);
    }

    private void customizeComponent2() {
        add(new GCLabel2(" "));
        add(new GCLabel2("\u00A9 2024 GCEcuFauna"));
    }

    private void configurarAcciones() {
        
        btnEliminar.addActionListener(e -> {
        });
        
        btnGuardar.addActionListener(e -> {
        });
        
    }



}
