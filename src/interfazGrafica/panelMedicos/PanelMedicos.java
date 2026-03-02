package interfazGrafica.panelMedicos;

import interfazGrafica.panelPrincipal.PanelPrincipal;
import logica.gestionHospital.GestionHospital;
import logica.personas.Medico;
import logica.personas.MedicoCirujano;
import logica.personas.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelMedicos {
    private JButton BevaluarSintomas;
    private JButton BpacientesAsignados;
    private JTextField txtNumRegistro;
    private JTable tablaPacientesAsignados;
    private JPanel panel3;
    private JLabel LportalMedicos;
    private JLabel LnumeroRegistro;
    private JButton BrealizarCirugia;
    private JLabel Llogo;
    private JLabel LingreseNumRegistro;
    final GestionHospital gestionHospital;
    final PanelPrincipal panelPrincipal1;


    public PanelMedicos(GestionHospital gestion, PanelPrincipal panelPrincipal) {
        this.gestionHospital = gestion;
        this.panelPrincipal1 = panelPrincipal;
        tablaPacientesAsignados.setVisible(false);
        BevaluarSintomas.setVisible(false);
        BrealizarCirugia.setVisible(false);
        BpacientesAsignados.setVisible(false);
        BpacientesAsignados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaPacientesAsignados.setVisible(true);
                actualizarTabla();
            }

            public void actualizarTabla() {

                if (validarMedico() == null) {
                    JOptionPane.showMessageDialog(null,
                            "No existe un médico con ese registro.");
                    return;
                }

                String[] columnas = {"Nombre", "Sintoma"};
                DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

                for (Paciente p : validarMedico().getPacientesAsignados()) {
                    modelo.addRow(new Object[]{
                            p.getNombre(),
                            p.getSintomas()
                    });
                }

                tablaPacientesAsignados.setModel(modelo);
            }
        });

        txtNumRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetearPanel();
                if (validarMedico() == null) {
                    tablaPacientesAsignados.setVisible(false);
                    BevaluarSintomas.setVisible(false);
                    BrealizarCirugia.setVisible(false);
                    BpacientesAsignados.setVisible(false);
                    JOptionPane.showMessageDialog(null, "No existe un médico con ese registro.");
                    return;
                }

                if (validarMedico() instanceof MedicoCirujano) {

                    BevaluarSintomas.setVisible(true);
                    BrealizarCirugia.setVisible(true);
                    BpacientesAsignados.setVisible(true);

                } else {
                    BevaluarSintomas.setVisible(true);
                    BpacientesAsignados.setVisible(true);
                }
            }
        });
        String rutaRelativa = "/imagenes/LogoSanJose.png";
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(rutaRelativa));

        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Llogo.setIcon(new ImageIcon(imagenEscalada));
        BevaluarSintomas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Paciente p : validarMedico().getPacientesAsignados()) {
                    String mnsj = validarMedico().asignarPrioridad(p.getSintomas());
                    panelPrincipal1.mostrarMensaje(mnsj);

                }
            }
        });

    }

    public Medico validarMedico() {
        ArrayList<Medico> todos = new ArrayList<>();
        todos.addAll(gestionHospital.getMedicos());
        todos.addAll(gestionHospital.getCirujanos());
        String registroIngresado = txtNumRegistro.getText().trim();

        for (Medico m : todos) {

            if (m.getNumRegistro().equalsIgnoreCase(registroIngresado)) {
                return m;
            }
        }
        return null;


    }

    private void resetearPanel() {
        tablaPacientesAsignados.setVisible(false);
        BevaluarSintomas.setVisible(false);
        BrealizarCirugia.setVisible(false);
        BpacientesAsignados.setVisible(false);
    }

    public JPanel getPanel3() {
        return panel3;
    }
}
