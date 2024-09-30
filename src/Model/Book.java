package Model;

import Excecoes.Excecoes.LivroNaoDevolvidoException;
import Excecoes.LivroJaEmprestadoException;

public class Book {
    private String title;
    private String author;
    private boolean isLoaned;
    private Client loanedTo; // Armazena o nome do cliente que pegou o livro emprestado

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isLoaned = false;
        this.loanedTo = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void loanTo(Client clientName) throws LivroJaEmprestadoException {
        if (isLoaned) {
            throw new LivroJaEmprestadoException();
        }
        this.isLoaned = true;
        this.loanedTo = clientName;
    }

    public void returnBook() throws LivroNaoDevolvidoException {
        if (!isLoaned) {
            throw new LivroNaoDevolvidoException();
        }
        this.isLoaned = false;
        this.loanedTo = null;
    }

    @Override
    public String toString() {
        return "Título: " + title + ", Autor: " + author + (isLoaned ? " (Emprestado para: " + loanedTo + ")" : "");
    }
}
