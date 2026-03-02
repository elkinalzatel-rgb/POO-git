package logica.gestionHospital;

import interfazGrafica.panelPrincipal.PanelPrincipal;
import logica.personas.Medico;
import logica.personas.MedicoCirujano;
import logica.personas.Paciente;
import logica.personas.Persona;

import javax.swing.*;
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

    public void asignarPacienteSegunEspecialidad(Paciente p) {

        String especialidadNecesaria = null;

        switch (p.getSintomas().trim()) {

            case "Infarto":
                especialidadNecesaria = "Cardiologia";
                break;

            case "Apendicitis":
                especialidadNecesaria = "Cirugia General";
                break;

            case "Asma":
                especialidadNecesaria = "Neumologia";
                break;

            case "Hernia inguinal":
                especialidadNecesaria = "Ortopedia";
                break;
        }

        if (especialidadNecesaria == null) {
            return;
        }

        for (Persona persona : personas) {

            if (persona instanceof Medico) {

                Medico m = (Medico) persona;

                if (m.getEspecialidad().equalsIgnoreCase(especialidadNecesaria)) {
                    m.asignarPaciente(p);
                    p.setMedicoAsignado(m);
                    break;
                }
            }
        }
    }


    public void reasignarPacientesPendientes() {

        for (Paciente p : pacientes) {

            if (!p.estaAsignado()) {
                asignarPacienteSegunEspecialidad(p);
            }
        }
    }

    public boolean registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        personas.add(paciente);
        return true;
    }

    public boolean registrarMedicoCirujano(MedicoCirujano medicoCirujano) {
        cirujanos.add(medicoCirujano);
        personas.add(medicoCirujano);
        return true;
    }

    public boolean registrarMedico(Medico medico) {
        medicos.add(medico);
        personas.add(medico);
        return true;
    }


//    public void cargarDatos() {
//        Medico m1 = new Medico("Karolay Garcia", "1094050692", "Femenino", 18, "Oftanmologa", "1234", new ArrayList<>());
//        Medico m2 = new Medico("Santiago Sanchez", "1454035691", "Masculino", 19, "Rinologo", "4321", new ArrayList<>());
//        Medico m3 = new Medico("Elkin Alzate", "2364050456", "Masculino", 20, "Cardiologo", "2314", new ArrayList<>());
//        Medico m4 = new Medico("Luis Garcia", "1294050634", "Masculino", 18, "Ginecologo", "1423", new ArrayList<>());
//
//        medicos.add(m1);
//        medicos.add(m2);
//        medicos.add(m3);
//        medicos.add(m4);
//
//        personas.add(m1);
//        personas.add(m2);
//        personas.add(m3);
//        personas.add(m4);
//
//        MedicoCirujano c1 = new MedicoCirujano("Law", "2345235", 26, "Masculino", "Cirugia General", "12345", new ArrayList<>(), 3);
//        MedicoCirujano c2 = new MedicoCirujano("Sofia", "4235252", 23, "Femenino", "Cirugia Cardiaca", "54321", new ArrayList<>(), 1);
//        MedicoCirujano c3 = new MedicoCirujano("Mateo", "3523522", 23, "Masculino", "Neurocirugia", "12543", new ArrayList<>(), 2);
//        MedicoCirujano c4 = new MedicoCirujano("Paula", "5235255", 56, "Femenino", "Cirugia Plastica", "32145", new ArrayList<>(), 4);
//        registrarMedicoCirujano(c1);
//        registrarMedicoCirujano(c2);
//        registrarMedicoCirujano(c3);
//        registarMedicoCirujano(c4);
//        personas.add(c1);
//        personas.add(c2);
//        personas.add(c3);
//        personas.add(c4);
//        Paciente p1 = new Paciente("Ana", "3001", "F", 23, "H001", "Sura", 100, "Infarto");
//        Paciente p2 = new Paciente("Luis", "3002", "M", 30, "H002", "Comeva", 30, "Fiebre");
//        Paciente p3 = new Paciente("Camila", "3003", "F", 21, "H003", "VidaLoca", 80, "Sangrado");
//        Paciente p4 = new Paciente("Pedro", "3004", "M", 35, "H004", "Sura", 10, "Dolor");
//        Paciente p5 = new Paciente("Maria", "3005", "F", 28, "H005", "Comeva", 200, "Dolor");
//        Paciente p6 = new Paciente("Jorge", "3006", "M", 40, "H006", "VidaLoca", 60, "Dolor");
//        Paciente p7 = new Paciente("Valentina", "3007", "F", 19, "H007", "Sura", 50, "Infarto");
//        Paciente p8 = new Paciente("Daniel", "3008", "M", 33, "H008", "Comeva", 0, "Dolor");
//        Paciente p9 = new Paciente("Sara", "3009", "F", 26, "H009", "VidaLoca", 90, "Dolor");
//        Paciente p10 = new Paciente("Felipe", "3010", "M", 29, "H010", "Sura", 150, "Infarto");
//        Paciente p11 = new Paciente("Juliana", "3011", "F", 24, "H011", "Comeva", 40, "Fiebre");
//        Paciente p12 = new Paciente("Sebastian", "3012", "M", 31, "H012", "VidaLoca", 70, "Sangrado");
//
//        registrarPaciente(p1);
//        registrarPaciente(p2);
//        registrarPaciente(p3);
//        registrarPaciente(p4);
//        registrarPaciente(p5);
//        registrarPaciente(p6);
//        registrarPaciente(p7);
//        registrarPaciente(p8);
//        registrarPaciente(p9);
//        registrarPaciente(p10);
//        registrarPaciente(p11);
//        registrarPaciente(p12);
//
//        m1.asignarPaciente(p1);
//        m1.asignarPaciente(p2);
//        m1.asignarPaciente(p3);
//
//        m2.asignarPaciente(p4);
//        m2.asignarPaciente(p5);
//        m2.asignarPaciente(p6);
//
//        m3.asignarPaciente(p9);
//        m3.asignarPaciente(p10);
//
//        m4.asignarPaciente(p11);
//        m4.asignarPaciente(p12);
//    }

//    public void simularDia() {
//        //Presentacion de las personas segun su cargo
//        for (Persona p : personas) {
//            p.presentarse();
//        }
//
//        //Lista de pacientes del medico evaluando su sintoma
//        for (Medico m : medicos) {
//            m.revisarPacientes();
//            for (Paciente p : m.getPacientesAsignados())
//                m.asignarPrioridad(p.getSintomas());
//        }
//
//        //Paciente intenta pagar su consulta
//        for (Paciente paciente : pacientes) {
//            paciente.pagarConsulta(50.0);
//        }
//        boolean estado = true;
//
//        for (MedicoCirujano c : cirujanos) {
//            c.decidirOperacion(estado);
//        }
//        Atencion at1 = new Atencion();
//        for (Paciente p : pacientes) {
//            at1.procesarIngreso(p);
//        }
//    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<MedicoCirujano> getCirujanos() {
        return cirujanos;
    }


    /**
     * Método principal del programa
     */
    public static void main(String[] args) {
        try {
            com.formdev.flatlaf.FlatLightLaf.setup();
            UIManager.put("Component.arc", 20);
            UIManager.put("JButton.arc", 20);


        } catch (Exception ex) {
            System.err.println("Error al cargar FlatLaf");
        }
//        JFrame ventana = new PanelRegistro();
//        ventana.setVisible(true);
        JFrame ventana1 = new PanelPrincipal();
        ventana1.setVisible(true);
    }
}

