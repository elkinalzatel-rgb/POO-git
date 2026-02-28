package logica.personas;

import java.util.List;

/**
 * Clase que representa a un medico del hospital San Jose
 * Hereda de persona
 */
public class Medico extends Persona {

    /**
     * Especialidad del medico
     */
    private String especialidad;

    /**
     * Numero de registro del medico
     */
    private String numRegistro;

    /**
     * Pacientes asignados al medico
     */
    private List<Paciente> pacientesAsignados;

    /**
     * Constructor con parametros para crear un medico
     *
     * @param nombre       Nombre del medico
     * @param dni          Dni del medico
     * @param genero       Genero del medico
     * @param edad         Edad del medico
     * @param especialidad Especialidad del medico
     * @param numRegistro  Numero de registro del medico
     */
    public Medico(String nombre, String dni, String genero, int edad, String especialidad, String numRegistro, List<Paciente> pacientesAsignados) {
        super(nombre, dni, genero, edad);
        this.numRegistro = numRegistro;
        this.especialidad = especialidad;
        this.pacientesAsignados = pacientesAsignados;
    }

    /**
     * Obtiene la especialidad del medicp
     *
     * @return Especialidad del medico
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Obtiene el Numero de registro del medico
     *
     * @return Numero de registro del medico
     */
    public String getNumRegistro() {
        return numRegistro;
    }

    /**
     * Obtiene la lista de pacientes asignados
     *
     * @return Lista de pacientes asignados
     */
    public List<Paciente> getPacientesAsignados() {
        return pacientesAsignados;
    }

    /**
     * Actualiza la especialidad del medico
     *
     * @param especialidad Especialidad del medico
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Actualiza el numero de registro del medico
     *
     * @param numRegistro Numero de registro del medico
     */
    public void setNumRegistro(String numRegistro) {
        this.numRegistro = numRegistro;
    }

    /**
     * Metodo que asigna un nivel de urgencia dependiendo de los sintomas del paciente
     *
     * @param sintoma Sintoma del paciente
     */
    public void asignarPrioridad(String sintoma) {
        System.out.println("El dr: " + getNombre() + " evaluo el sintoma: " + sintoma + "  y asigno: ");
        switch (sintoma) {
            case ("Infarto"):
                System.out.println("Nivel de urgencia: 1");
                break;
            case ("Sangrado"):
                System.out.println("Nivel de urgencia: 2");
                break;
            case ("Fiebre"):
                System.out.println("Nivel de urgencia: 3");
                break;
            case ("Dolor"):
                System.out.println("Nivel de urgencia: 4");
                break;
            default:
                System.out.println("Enfermedad no reconocida");
        }

    }

    /**
     * Asigna un paciente al medico, agregandolo a la lista de pacientes asignados
     * Si el paciente es null, no se asigna
     *
     * @param p Paciente que sera asignado al medico
     */
    public void asignarPaciente(Paciente p) {
        if (p != null) {
            pacientesAsignados.add(p);
        }
    }

    /**
     * Metodo que permite revisar cada paciente enlistandolos
     */
    public void revisarPacientes() {
        System.out.println("Pacientes del dr: " + getNombre());
        for (Paciente p : pacientesAsignados) {
            System.out.println("Revisando paciente: " + p.getNombre());
        }

    }

    /**
     * Metodo abstracto heredado de la superclase Persona
     * Permite al medico presentarse con su nombre
     */
    @Override
    public String presentarse() {
        return "Soy un médico y mi nombre es: " + getNombre();

    }
}
