package interfazGrafica;

import logica.gestionHospital.GestionHospital;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hospital extends JFrame {
    private JButton BRegistrarPacientes;
    private JPanel panel1;
    private JButton BtnRecargar;
    private JButton BRegistrarPaciente;
    private JComboBox CTipoMedico;
    final GestionHospital gestion = new GestionHospital();
    final VentanaRegistrarMCirujano ventanaRegistrarMCirujano = new VentanaRegistrarMCirujano();


    public Hospital() {
        CTipoMedico.setVisible(false);
        add(panel1);
        BRegistrarPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog ventana = new VentanaRegistrarPaciente(Hospital.this);
                ventana.setSize(600, 600);
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
            }
        });

        BRegistrarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CTipoMedico.setVisible(true);
                String tipoMedico = CTipoMedico.getSelectedItem().toString();
                if (tipoMedico.equals("Medico Cirujano")) {
                    ventanaRegistrarMCirujano.setSize(600, 600);
                    ventanaRegistrarMCirujano.setLocationRelativeTo(null);
                    ventanaRegistrarMCirujano.setVisible(true);
                    ventanaRegistrarMCirujano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });
        CTipoMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
