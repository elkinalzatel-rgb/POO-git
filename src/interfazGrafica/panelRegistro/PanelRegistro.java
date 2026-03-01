package interfazGrafica.panelRegistro;

import logica.gestionHospital.GestionHospital;
import logica.personas.Medico;
import logica.personas.MedicoCirujano;
import logica.personas.Paciente;
import logica.personas.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistro extends JFrame {
    private JButton BRegistrarPacientes;
    private JPanel panel1;
    private JButton BRegistrarMedico;
    private JComboBox CTipoMedico;
    private JButton BlistaDePersonas;
    private JTable tablaPersonas;
    final GestionHospital gestion = new GestionHospital();


    public PanelRegistro() {

        setContentPane(panel1);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        CTipoMedico.setVisible(false);
        tablaPersonas.setVisible(false);
        BRegistrarPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistrarPaciente ventanaRegistrarPaciente = new VentanaRegistrarPaciente(gestion, PanelRegistro.this);
                ventanaRegistrarPaciente.setSize(700, 600);
                ventanaRegistrarPaciente.setLocationRelativeTo(null);
                ventanaRegistrarPaciente.setVisible(true);
                ventanaRegistrarPaciente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        BRegistrarMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CTipoMedico.setVisible(true);
                String tipoMedico = CTipoMedico.getSelectedItem().toString();
                if (tipoMedico.equals("Medico Cirujano")) {
                    VentanaRegistrarMCirujano ventanaRegistrarMCirujano = new VentanaRegistrarMCirujano(gestion, PanelRegistro.this);
                    ventanaRegistrarMCirujano.setSize(700, 600);
                    ventanaRegistrarMCirujano.setLocationRelativeTo(null);
                    ventanaRegistrarMCirujano.setVisible(true);
                    ventanaRegistrarMCirujano.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                } else if (tipoMedico.equals("Medico General")) {
                    VentanaRegistrarMGeneral ventanaRegistrarMGeneral = new VentanaRegistrarMGeneral(gestion, PanelRegistro.this);
                    ventanaRegistrarMGeneral.setSize(700, 600);
                    ventanaRegistrarMGeneral.setLocationRelativeTo(null);
                    ventanaRegistrarMGeneral.setVisible(true);
                    ventanaRegistrarMGeneral.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });
        BlistaDePersonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaPersonas.setVisible(true);
                actualizarTabla();
            }
        });

    }

    public void actualizarTabla() {
        String[] columnas = {"Nombre", "Rol"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Persona p : gestion.getPersonas()) {
            String rol = "";

            if (p instanceof MedicoCirujano) rol = "Médico Cirujano";
            else if (p instanceof Medico) rol = "Médico General";
            else if (p instanceof Paciente) rol = "Paciente";

            modelo.addRow(new Object[]{p.getNombre(), rol});
        }
        tablaPersonas.setModel(modelo);
    }


    public JPanel getPanel1() {
        return panel1;
    }
}
