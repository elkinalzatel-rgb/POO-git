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

    public void cargarDatos() {
        Medico m1 = new Medico("Karolay Garcia", "1094050692", "Femenino", 18, "Oftanmologa", "1234", new ArrayList<>());
        Medico m2 = new Medico("Santiago Sanchez", "1454035691", "Masculino", 19, "Rinologo", "4321", new ArrayList<>());
        Medico m3 = new Medico("Elkin Alzate", "2364050456", "Masculino", 20, "Cardiologo", "2314", new ArrayList<>());
        Medico m4 = new Medico("Luis Garcia", "1294050634", "Masculino", 18, "Ginecologo", "1423", new ArrayList<>());

        medicos.add(m1);
        medicos.add(m2);
        medicos.add(m3);
        medicos.add(m4);

        personas.add(m1);
        personas.add(m2);
        personas.add(m3);
        personas.add(m4);

        MedicoCirujano c1 = new MedicoCirujano("Juan", "2345235", 31, "Masculino", "Cirugia General", "12345", new ArrayList<>(), 3);
        MedicoCirujano c2 = new MedicoCirujano("Sofia", "4235252", 23, "Femenino", "Cirugia Cardiaca", "54321", new ArrayList<>(), 1);
        MedicoCirujano c3 = new MedicoCirujano("Mateo", "3523522", 23, "Masculino", "Neurocirugia", "12543", new ArrayList<>(), 2);
        MedicoCirujano c4 = new MedicoCirujano("Paula", "5235255", 56, "Femenino", "Cirugia Plastica", "32145", new ArrayList<>(), 4);
        cirujanos.add(c1);
        cirujanos.add(c2);
        cirujanos.add(c3);
        cirujanos.add(c4);
        personas.add(c1);
        personas.add(c2);
        personas.add(c3);
        personas.add(c4);
        Paciente p1 = new Paciente("Ana", "3001", "F", 23, "H001", "Sura", 100, "Infarto");
        Paciente p2 = new Paciente("Luis", "3002", "M", 30, "H002", "Comeva", 30, "Fiebre");
        Paciente p3 = new Paciente("Camila", "3003", "F", 21, "H003", "VidaLoca", 80, "Sangrado");
        Paciente p4 = new Paciente("Pedro", "3004", "M", 35, "H004", "Sura", 10, "Dolor");
        Paciente p5 = new Paciente("Maria", "3005", "F", 28, "H005", "Comeva", 200, "Dolor");
        Paciente p6 = new Paciente("Jorge", "3006", "M", 40, "H006", "VidaLoca", 60, "Dolor");
        Paciente p7 = new Paciente("Valentina", "3007", "F", 19, "H007", "Sura", 50, "Infarto");
        Paciente p8 = new Paciente("Daniel", "3008", "M", 33, "H008", "Comeva", 0, "Dolor");
        Paciente p9 = new Paciente("Sara", "3009", "F", 26, "H009", "VidaLoca", 90, "Dolor");
        Paciente p10 = new Paciente("Felipe", "3010", "M", 29, "H010", "Sura", 150, "Infarto");
        Paciente p11 = new Paciente("Juliana", "3011", "F", 24, "H011", "Comeva", 40, "Fiebre");
        Paciente p12 = new Paciente("Sebastian", "3012", "M", 31, "H012", "VidaLoca", 70, "Sangrado");

        pacientes.add(p1);
        pacientes.add(p2);
        pacientes.add(p3);
        pacientes.add(p4);
        pacientes.add(p5);
        pacientes.add(p6);
        pacientes.add(p7);
        pacientes.add(p8);
        pacientes.add(p9);
        pacientes.add(p10);
        pacientes.add(p11);
        pacientes.add(p12);
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        personas.add(p5);
        personas.add(p6);
        personas.add(p7);
        personas.add(p8);
        personas.add(p9);
        personas.add(p10);
        personas.add(p11);
        personas.add(p12);

        m1.asignarPaciente(p1);
        m1.asignarPaciente(p2);
        m1.asignarPaciente(p3);

        m2.asignarPaciente(p4);
        m2.asignarPaciente(p5);
        m2.asignarPaciente(p6);

        m3.asignarPaciente(p9);
        m3.asignarPaciente(p10);

        m4.asignarPaciente(p11);
        m4.asignarPaciente(p12);
    }

    public void simularDia() {
        //Presentacion de las personas segun su cargo
        for (Persona p : personas) {
            p.presentarse();
        }

        //Lista de pacientes del medico evaluando su sintoma
        for (Medico m : medicos) {
            m.revisarPacientes();
            for (Paciente p : m.getPacientesAsignados())
                m.asignarPrioridad(p.getSintomas());
        }

        //Paciente intenta pagar su consulta
        for (Paciente paciente : pacientes) {
            paciente.pagarConsulta(50.0);
        }
        boolean estado = true;

        for (MedicoCirujano c : cirujanos) {
            c.decidirOperacion(estado);
        }
        Atencion at1 = new Atencion();
        for (Paciente p : pacientes) {
            at1.procesarIngreso(p);
        }
    }

    /**
     * Método principal del programa
     */
    public static void main(String[] args) {

        GestionHospital hospital = new GestionHospital();
        hospital.cargarDatos();
        hospital.simularDia();
    }

}
