package interfazGrafica.panelRegistro;

import logica.gestionHospital.GestionHospital;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistro extends JFrame {
    private JButton BRegistrarPacientes;
    private JPanel panel1;
    private JButton BRegistrarMedico;
    private JComboBox CTipoMedico;
    final GestionHospital gestion = new GestionHospital();
    final VentanaRegistrarMCirujano ventanaRegistrarMCirujano = new VentanaRegistrarMCirujano();
    final VentanaRegistrarMGeneral ventanaRegistrarMGeneral = new VentanaRegistrarMGeneral();


    public PanelRegistro() {
        setContentPane(panel1);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CTipoMedico.setVisible(false);
        BRegistrarPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog ventana = new VentanaRegistrarPaciente(PanelRegistro.this);
                ventana.setSize(700, 600);
                ventana.setLocationRelativeTo(null);
                ventana.setVisible(true);
            }
        });

        BRegistrarMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CTipoMedico.setVisible(true);
                String tipoMedico = CTipoMedico.getSelectedItem().toString();
                if (tipoMedico.equals("Medico Cirujano")) {
                    ventanaRegistrarMCirujano.setSize(700, 600);
                    ventanaRegistrarMCirujano.setLocationRelativeTo(null);
                    ventanaRegistrarMCirujano.setVisible(true);
                    ventanaRegistrarMCirujano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else if (tipoMedico.equals("Medico General")) {
                    ventanaRegistrarMGeneral.setSize(700, 600);
                    ventanaRegistrarMGeneral.setLocationRelativeTo(null);
                    ventanaRegistrarMGeneral.setVisible(true);
                    ventanaRegistrarMCirujano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
