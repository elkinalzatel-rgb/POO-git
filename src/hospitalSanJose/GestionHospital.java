package hospitalSanJose;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal del proyecto
 * permite simular el funcionamiento del hospital
 */
public class GestionHospital {

    private List<Persona> personas;
    private List<Medico> medicos;
    private List<MedicoCirujano> cirujanos;
    private List<Paciente> pacientes;


    public GestionHospital() {
        personas = new ArrayList<>();
        medicos = new ArrayList<>();
        cirujanos = new ArrayList<>();
        pacientes = new ArrayList<>();
    }

    /**
     * Método principal del programa
     */
    public static void main(String[] args) {

        GestionHospital hospital = new GestionHospital();
    }

    public void cargarDatos() {

    }

    public void simularDia() {
        Persona medico1 = new Medico("Karolay Garcia", "1094050692", "Femenino", 18, "Oftanmologa", "1234", new ArrayList<>());
        
    }
}
