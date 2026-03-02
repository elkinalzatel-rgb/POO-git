package interfazGrafica.panelRegistro;

import logica.gestionHospital.GestionHospital;
import logica.personas.MedicoCirujano;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaRegistrarMCirujano extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNombre;
    private JTextField txtNumeroQuirofano;
    private JTextField txtDni;
    private JTextField txtNumRegistro;
    private JTextField txtGenero;
    private JTextField txtEdad;
    private JLabel LNombre;
    private JLabel LDni;
    private JLabel LEdad;
    private JLabel LGenero;
    private JLabel LEspecialidad;
    private JLabel LNumRegistro;
    private JLabel LNumeroQuirofano;
    private JComboBox CTipoEspecialidad;
    private JComboBox CGenero;
    private JTextField txtEspecialidad;
    final GestionHospital hospital;
    final PanelRegistro panelRegistro;

    public VentanaRegistrarMCirujano(GestionHospital hospital, PanelRegistro panelRegistro) {
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
        String dni = txtDni.getText();
        String especialidad = String.valueOf(CTipoEspecialidad.getSelectedItem());
        String numRegistro = txtNumRegistro.getText();
        String numQuirofanoStr = txtNumeroQuirofano.getText();

        if (CGenero.getSelectedIndex() == 0 || CTipoEspecialidad.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor complete todas las selecciones", "Datos faltantes", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (nombre.isEmpty() || edadStr.isEmpty() || genero.isEmpty() || dni.isEmpty() || especialidad.isEmpty() || numRegistro.isEmpty() || numQuirofanoStr.isEmpty()) {
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
        int numQuirofano;
        try {
            numQuirofano = Integer.parseInt(numQuirofanoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Numero quirofano debe ser un numero. ");
            return;
        }
        MedicoCirujano medicoCirujano = new MedicoCirujano(nombre, dni, edad, genero, especialidad, numRegistro, new ArrayList<>(), numQuirofano);
        if (hospital.registrarMedicoCirujano(medicoCirujano)) {
            hospital.reasignarPacientesPendientes();
            panelRegistro.actualizarTabla();
            JOptionPane.showMessageDialog(this, "El Medico Cirujano ha sido registrado correctamente.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un error al registrar el medico cirujano .");
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
