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
        String genero = txtGenero.getText();
        String dni = txtDNI.getText();
        String especialidad = txtEspecialidad.getText();
        String numRegistro = txtNumRegistro.getText();

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
