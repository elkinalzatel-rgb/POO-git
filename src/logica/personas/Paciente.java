package logica.personas;

/**
 * Clase que representa a un paciente del hospital San jose
 */
public class Paciente extends Persona {
    /**
     * Numero del historial del paciente
     */
    private String numHistorial;

    /**
     * Eps del paciente
     */
    private String eps;

    /**
     * Saldo disponible del paciente
     */
    private double saldoDisponible;

    /**
     * Sintomas del paciente
     */
    private String sintomas;

    private Medico medicoAsignado;

    /**
     * Constructor vacio para crear un paciente
     */
    public Paciente() {
        super();
    }

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
    public Paciente(String nombre, String dni, String genero, int edad, String numHistorial, String eps, double saldoDisponible, String sintomas) {
        super(nombre, dni, genero, edad);
        this.numHistorial = numHistorial;
        this.eps = eps;
        this.saldoDisponible = saldoDisponible;
        this.sintomas = sintomas;
    }


    /**
     * Obtiene el Numero de historial del paciente
     *
     * @return Numero de historial del paciente
     */
    public String getNumHistorial() {
        return numHistorial;
    }

    /**
     * Obtiene tipo de eps del paciente
     *
     * @return tipo de eps
     */
    public String getEps() {
        return eps;
    }

    /**
     * Obtiene el saldo disponible del paciente
     *
     * @return Saldo disponible
     */
    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    /**
     * Obtiene los sintomas del paciente
     *
     * @return Sintomas del pciente
     */
    public String getSintomas() {
        return sintomas;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(Medico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    /**
     * Actualiza los sintomas del paciente
     *
     * @param sintomas sintomas actualizados del paciente
     */
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    /**
     * Permite que el paciente intente pagar una consulta
     * Si el saldo disponible es suficiente, se descuenta el costo y el pago es exitoso
     * Si no alcanza, el pago es rechazado
     *
     * @param costoConsulta Valor de la consulta a pagar.
     * @return true si el pago fue exitoso, false si fue rechazado.
     */
    public boolean pagarConsulta(double costoConsulta) {
        String resultado;
        if (verificarPresupuesto(costoConsulta)) {
            saldoDisponible -= costoConsulta;
            saldoDisponible = Math.round(saldoDisponible * 100.0) / 100.0;
            resultado = "Éxitoso";
        } else {
            resultado = "Rechazado";
        }
        System.out.println(" El pago ha sido " + resultado +
                "\n Costo de la consulta: " + costoConsulta +
                "\n Saldo restante: " + saldoDisponible);

        return resultado.equals("Éxitoso");
    }

    /**
     * Metodo que verifica el presupuesto del paciente
     *
     * @param costoConsulta Costo de la consulta
     * @return true si tiene saldo suficiente o falso si no tiene saldo suficiente
     */
    public boolean verificarPresupuesto(double costoConsulta) {
        if (saldoDisponible >= costoConsulta) {
            return true;
        }
        return false;
    }


    /**
     * Muestra los sintomas del paciente
     */
    public void mostrarSintomas() {
        System.out.println("Paciente: " + getNombre() + "      Sintomas: " + sintomas);
    }

    /**
     * Metodo abstracto heredado de la superclase Persona
     * Permite al paciente presentarse con su nombre
     */
    @Override
    public String presentarse() {
        return "Soy un paciente y mi nombre es : " + getNombre();
    }

    public boolean estaAsignado() {
        return medicoAsignado != null;
    }

}