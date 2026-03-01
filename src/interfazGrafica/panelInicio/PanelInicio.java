package interfazGrafica.panelInicio;

import interfazGrafica.panelPrincipal.PanelPrincipal;
import logica.gestionHospital.GestionHospital;

import javax.swing.*;
import java.awt.*;

public class PanelInicio {
    private JLabel LblLogo;
    private JPanel panelPrincipal;
    private JPanel panel1;
    private JLabel txtHospital;
    private JLabel txtSanJose;
    private JPanel Logo;
    final GestionHospital gestion;
    final PanelPrincipal principal;

    public PanelInicio(GestionHospital gestion, PanelPrincipal principal) {
        this.gestion = gestion;
        this.principal = principal;
        String rutaRelativa = "/imagenes/LogoSanJose.png";
        ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(rutaRelativa));

        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        LblLogo.setIcon(new ImageIcon(imagenEscalada));
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
