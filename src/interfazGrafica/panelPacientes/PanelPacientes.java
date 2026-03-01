package interfazGrafica.panelPacientes;

import logica.gestionHospital.GestionHospital;
import logica.personas.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPacientes {
    private JLabel LBuscarPaciente;
    private JTextField txtNombrePaciente;
    private JButton btnPagar;
    private JButton btnPabello;
    private JLabel LInfo;
    private JPanel panel2;
    final GestionHospital gestion;

    public PanelPacientes(GestionHospital gestion) {
        this.gestion = gestion;
        btnPagar.setVisible(false);
        btnPabello.setVisible(false);
        txtNombrePaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreABuscar = txtNombrePaciente.getText().trim();
                Paciente pacienteEncontrado = null;
                for (Paciente p : gestion.getPacientes()) {
                    if (p.getNombre().equalsIgnoreCase(nombreABuscar)) {
                        pacienteEncontrado = p;
                        break;
                    }
                }

                if (pacienteEncontrado != null) {
                    btnPagar.setVisible(true);
                    btnPabello.setVisible(true);

                    LInfo.setText("Paciente seleccionado: " + pacienteEncontrado.getNombre());
                } else {
                    btnPagar.setVisible(false);
                    btnPabello.setVisible(false);
                    LInfo.setText("No se encontró el paciente.");

                    JOptionPane.showMessageDialog(null, "No existe el paciente: " + nombreABuscar);
                }
            }
        });
    }

    public JPanel getPanel2() {
        return panel2;
    }
}
