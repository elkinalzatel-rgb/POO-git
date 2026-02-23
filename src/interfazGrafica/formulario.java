package interfazGrafica;

import logica.gestionHospital.GestionHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formulario {
    private JButton registrarPaciente;
    private JButton registrarMedico;
    private JLabel logo;
    private GestionHospital hospital;


    public formulario() {


        hospital = new GestionHospital();
        registrarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaRegistrarPaciente();
            }
        });
        ImageIcon icon = new ImageIcon("C:\\Users\\carol\\Downloads\\Logo elegante del Hospital San José.png");

        Image img = icon.getImage();

        Image imgEscalada = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

        ImageIcon iconEscalado = new ImageIcon(imgEscalada);


        logo.setIcon(iconEscalado);
    }
}
