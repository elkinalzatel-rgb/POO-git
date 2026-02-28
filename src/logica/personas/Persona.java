package logica.personas;

/**
 * Clase que representa a una persona cualquiera asociada al hospital
 * Contiene los atributos y metodos comunes
 */
public abstract class Persona {
    /**
     * Nombre de la persona
     */
    private String nombre;
    /**
     * DNI   de la persona
     */
    private String dni;
    /**
     * Edad de la persona
     */
    private int edad;
    /**
     * Genero de la persona
     */
    private String genero;

    /**
     * Constructor sin parametros para crear un objeto persona
     */
    public Persona() {
    }

    /**
     * Constructor con parametros para crear un objeto persona
     *
     * @param nombre Nombre de la persona
     * @param dni    Dni de la persona
     * @param genero Genero de la persona
     * @param edad   Edad de la persona
     */
    public Persona(String nombre, String dni, String genero, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.genero = genero;
        this.edad = edad;
    }

    /**
     * Obtiene el nombre de la persona
     *
     * @return Nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre de la persona
     *
     * @param nombre Nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad de la persona
     *
     * @return Edad de la persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Actualiza la edad de la persona
     *
     * @param edad Edad de la persona
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el dni de la persona
     *
     * @return Dni de la persona
     */
    public String getDni() {
        return dni;
    }


    /**
     * Obtiene el genero de la persona
     *
     * @return Genero de la persona
     */
    public String getGenero() {
        return genero;
    }


    /**
     * Metodo abstracto para que cada persona se presente
     */
    public abstract String presentarse();
}
