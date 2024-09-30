package Excecoes;

public class LivroNaoDevolvidoException extends RuntimeException {
    public LivroNaoDevolvidoException(String message) {
        super(message);
    }
}
