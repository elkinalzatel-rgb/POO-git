package interfazGrafica.panelRegistro;

import logica.gestionHospital.GestionHospital;
import logica.personas.Medico;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaRegistrarMGeneral extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNombre;
    private JTextField txtDNI;
    private JTextField txtGenero;
    private JTextField txtEdad;
    private JTextField txtNumRegistro;
    private JTextField txtEspecialidad;
    private JLabel LNombre;
    private JLabel LDni;
    private JLabel LGenero;
    private JLabel LEdad;
    private JLabel LNumRegistro;
    private JLabel LEspecialidad;
    private JComboBox CEspecialidad;
    private JComboBox CGenero;
    final GestionHospital hospital;
    final PanelRegistro panelRegistro;

    public VentanaRegistrarMGeneral(GestionHospital hospital, PanelRegistro panelRegistro) {
        this.hospital = hospital;
        this.panelRegistro = panelRegistro;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String nombre = txtNombre.getText();
        String edadStr = txtEdad.getText();
        String genero = String.valueOf(CGenero.getSelectedItem());
        String dni = txtDNI.getText();
        String especialidad = String.valueOf(CEspecialidad.getSelectedItem());
        String numRegistro = txtNumRegistro.getText();

        if (CGenero.getSelectedIndex() == 0 || CEspecialidad.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor complete todas las selecciones", "Datos faltantes", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (nombre.isEmpty() || edadStr.isEmpty() || genero.isEmpty() || dni.isEmpty() || especialidad.isEmpty() || numRegistro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Edad debe ser un número.");
            return;
        }
        Medico medico = new Medico(nombre, dni, genero, edad, especialidad, numRegistro, new ArrayList<>());
        if (hospital.registrarMedico(medico)) {
            hospital.reasignarPacientesPendientes();
            panelRegistro.actualizarTabla();
            JOptionPane.showMessageDialog(this, "El Medico General ha sido registrado correctamente.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un error al registrar el medico General .");
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


}
