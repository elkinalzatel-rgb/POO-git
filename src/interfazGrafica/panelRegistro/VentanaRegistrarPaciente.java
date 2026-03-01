package interfazGrafica.panelRegistro;

import logica.gestionHospital.GestionHospital;
import logica.personas.Paciente;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaRegistrarPaciente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtGenero;
    private JTextField txtDNI;
    private JLabel nombre;
    private JLabel edad;
    private JLabel dni;
    private JLabel genero;
    final GestionHospital hospital;
    final PanelRegistro panelRegistro;

    public VentanaRegistrarPaciente(GestionHospital hospital, PanelRegistro panelRegistro) {
        this.hospital = hospital;
        this.panelRegistro = panelRegistro;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        // acciones de botones...
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

        // cerrar con X o ESC
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        contentPane.registerKeyboardAction(e -> onCancel(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    private void onOK() {
        String nombre = txtNombre.getText();
        String edadStr = txtEdad.getText();
        String genero = txtGenero.getText();
        String dni = txtDNI.getText();

        if (nombre.isEmpty() || edadStr.isEmpty() || genero.isEmpty() || dni.isEmpty()) {
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
        Paciente p = new Paciente(nombre, dni, edad, genero);
        if (hospital.registrarPaciente(p)) {
            panelRegistro.actualizarTabla();
            JOptionPane.showMessageDialog(this, "El paciente ha sido registrado correctamente.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un error al registrar el paciente.");
        }
    }


    private void onCancel() {
        dispose();
    }
}
