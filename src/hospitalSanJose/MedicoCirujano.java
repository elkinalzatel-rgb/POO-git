package hospitalSanJose;

import java.util.List;

public class MedicoCirujano extends Medico implements ICirujano {
    private int numQuirofano;


    MedicoCirujano(String nombre, String dni, int edad, String genero, String especialidad, int numRegistro, List<Paciente> pacientesAsignados, int numQuirofano) {
        super(nombre, dni, edad, genero, especialidad, numRegistro, pacientesAsignados);
        this.numQuirofano = numRegistro;
    }

    public int getNumQuirofano() {
        return numQuirofano;
    }

    public void setNumQuirofano(int numQuirofano) {
        this.numQuirofano = numQuirofano;
    }


    @Override
    public boolean validarQuirofano() {
        
    }

    @Override
    public boolean decidirOperacion() {
        return false;
    }

    @Override
    public void presentarse() {
        System.out.println("Hola soy un medico y me llamo: " + getNombre());
    }
}
