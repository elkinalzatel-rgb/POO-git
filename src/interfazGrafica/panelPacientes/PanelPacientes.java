package interfazGrafica.panelPacientes;

import interfazGrafica.panelPrincipal.PanelPrincipal;
import logica.atencion.Atencion;
import logica.gestionHospital.GestionHospital;
import logica.personas.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PanelPacientes {
    private JLabel LBuscarPaciente;
    private JTextField txtNombrePaciente;
    private JButton btnPagar;
    private JButton btnPabello;
    private JLabel LInfo;
    private JPanel panel2;
    private JLabel LPabellon;
    private JLabel Llogo;
    private JLabel LPortalPacientes;
    final GestionHospital gestion;
    private Paciente pacienteEncontrado = null;
    final PanelPrincipal panelPrincipal;


    public PanelPacientes(GestionHospital gestion, PanelPrincipal panelPrincipal) {
        this.gestion = gestion;
        this.panelPrincipal = panelPrincipal;
        LPabellon.setVisible(false);
        btnPagar.setVisible(false);
        btnPabello.setVisible(false);
        txtNombrePaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreABuscar = txtNombrePaciente.getText().trim();
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
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                double costoConsulta = Math.round((1 + random.nextDouble() * 49) * 100.0) / 100.0;
                boolean exito = pacienteEncontrado.pagarConsulta(costoConsulta);
                String reporte = "El paciente: " + pacienteEncontrado.getNombre() +
                        "\nPago : " + costoConsulta + "\nResultado: " + (exito ? "Éxitoso" : "Rechazado") +
                        "\n Saldo disponible: " + pacienteEncontrado.getSaldoDisponible() +
                        "\n ";
                panelPrincipal.mostrarMensaje(reporte);
            }
        });
        btnPabello.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Atencion atencion = new Atencion();
                LPabellon.setVisible(true);
                LPabellon.setText(atencion.procesarIngreso(pacienteEncontrado));
            }
        });

        String rutaRelativa = "/imagenes/LogoSanJose.png";
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(rutaRelativa));

        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        Llogo.setIcon(new ImageIcon(imagenEscalada));
    }

    public JPanel getPanel2() {
        return panel2;
    }
}
