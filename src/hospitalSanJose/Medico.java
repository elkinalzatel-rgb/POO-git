package hospitalSanJose;

import java.util.List;

public class Medico extends Persona {
    private String especialidad;
    private int numRegistro;
    private List<Paciente> pacientesAsignados;

    Medico(String nombre, String dni, int edad, String genero, String especialidad, int numRegistro, List<Paciente> pacientesAsignados) {
        this.numRegistro = numRegistro;
        this.especialidad = especialidad;
        this.pacientesAsignados = pacientesAsignados;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public int getNumRegistro() {
        return numRegistro;
    }

    public List<Paciente> getPacientesAsignados() {
        return pacientesAsignados;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    public void asignarPaciente() {

    }

    public void revisarPaciente() {

    }

    @Override
    public void presentarse() {
        System.out.println("Soy un médico y mi nombre es: " + getNombre());

    }
}
