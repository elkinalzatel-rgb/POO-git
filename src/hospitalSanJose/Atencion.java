package hospitalSanJose;

/**
 * clase que representa la atencion a un paciente
 */
public class Atencion {
    /**
     * envia a un paciente según su eps
     *
     * @param paciente paciente a enviar
     */
    public void enviarPaciente(Paciente paciente) {
        System.out.println("El paciente con eps " + paciente.getEps() + "es enviado a un pabellon");
    }
}
