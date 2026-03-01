package interfazGrafica.panelPrincipal;

import interfazGrafica.panelPacientes.PanelPacientes;
import interfazGrafica.panelRegistro.PanelRegistro;
import logica.gestionHospital.GestionHospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JFrame {
    private JPanel panel1;
    private JButton BSistema;
    private JButton BPaciente;
    private JButton BMedico;
    private JPanel panelContenedor;
    private JPanel CardR;
    private JPanel CardP;
    private JPanel CardM;
    private JPanel PanelConsolaContenedor;
    private JTextArea consola;
    final GestionHospital gestion = new GestionHospital();

    public PanelPrincipal() {
        setContentPane(panel1);
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        PanelRegistro panelRegistro = new PanelRegistro(gestion);
        PanelPacientes panelPacientes = new PanelPacientes(gestion);
        CardR.setLayout(new BorderLayout());
        CardR.add(panelRegistro.getPanel1(), BorderLayout.CENTER);
        CardR.revalidate();
        CardR.repaint();
        CardP.setLayout(new BorderLayout());
        CardP.add(panelPacientes.getPanel2());
        CardP.revalidate();
        CardP.repaint();

        BSistema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPanel("cardRegistro");
            }
        });


        BPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPanel("cardPacientes");
            }
        });
        BMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPanel("cardMedicos");
            }
        });
    }

    public void cambiarPanel(String nombreCard) {
        CardLayout cl = (CardLayout) panelContenedor.getLayout();
        cl.show(panelContenedor, nombreCard);
    }

    public void mostrarMensaje(String msj) {
        consola.append(msj);
        consola.setCaretPosition(consola.getDocument().getLength());
    }
}

