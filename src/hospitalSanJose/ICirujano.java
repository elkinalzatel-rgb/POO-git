package hospitalSanJose;

public interface ICirujano {
    boolean validarQuirofano(boolean estado);

    String decidirOperacion(boolean estado);
}
