package hospitalSanJose;

import java.util.List;

/**
 * Clase que representa a un paciente del hospital San Josè
 *
 */
public class Medico extends Persona {

    /**
     * Numero del historial del paciente
     */
    private String especialidad;

    /**
     * Numero del historial del paciente
     */
    private int numRegistro;

    /**
     * Numero del historial del paciente
     */
    private List<Paciente> pacientesAsignados;

    /**
     * Constructor con parametros para crear un paciente
     *
     * @param nombre          Nombre del paciente
     * @param dni             Dni del paciente
     * @param genero          Genero del paciente
     * @param edad            Edad del paciente
     * @param numHistorial    Numero de historial del paciente
     * @param eps             Eps del paciente
     * @param saldoDisponible Saldo disponible del paciente
     * @param sintomas        Sintomas del paciente
     */
    Medico(String nombre, String dni, int edad, String genero, String especialidad, int numRegistro, List<Paciente> pacientesAsignados) {
        this.numRegistro = numRegistro;
        this.especialidad = especialidad;
        this.pacientesAsignados = pacientesAsignados;
    }

    /**
     * Obtiene el Numero de historial del paciente
     *
     * @return Numero de historial del paciente
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Obtiene el Numero de historial del paciente
     *
     * @return Numero de historial del paciente
     */
    public int getNumRegistro() {
        return numRegistro;
    }

    /**
     * Obtiene el Numero de historial del paciente
     *
     * @return Numero de historial del paciente
     */
    public List<Paciente> getPacientesAsignados() {
        return pacientesAsignados;
    }

    /**
     * Actualiza los sintomas del paciente
     *
     * @param sintomas sintomas actualizados del paciente
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Actualiza los sintomas del paciente
     *
     * @param sintomas sintomas actualizados del paciente
     */
    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    /**
     * Metodo abstracto heredado de la superclase Persona
     * Permite al paciente presentarse con su nombre
     */
    public void asignarPaciente() {

    }

    /**
     * Metodo abstracto heredado de la superclase Persona
     * Permite al paciente presentarse con su nombre
     */
    public void revisarPaciente() {

    }

    /**
     * Metodo abstracto heredado de la superclase Persona
     * Permite al paciente presentarse con su nombre
     */
    @Override
    public void presentarse() {
        System.out.println("Soy un médico y mi nombre es: " + getNombre());

    }
}
