package Excecoes;

import javax.swing.JOptionPane;

public class Excecoes {

    //Metodo para tratar as exceções
    public static void tratar(Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    // Verifica se o livro já está emprestado
    public static void verificarLivroJaEmprestado(boolean livroJaEmprestado) throws LivroJaEmprestadoException {
        if (livroJaEmprestado) {
            throw new LivroJaEmprestadoException();
        }
    }

    // Verifica se o livro não foi encontrado
    public static void verificarLivroNaoEncontrado(boolean livroNaoEncontrado) throws LivroNaoEncontradoException {
        if (livroNaoEncontrado) {
            throw new LivroNaoEncontradoException("Livro não encontrado.");
        }
    }

    // Verifica se o cliente não foi encontrado
    public static void verificarClienteNaoEncontrado(boolean clienteNaoEncontrado) throws ClienteNaoEncontradoException {
        if (clienteNaoEncontrado) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");
        }
    }

    // Verifica se o campo do livro está vazio
    public static void verificarCampoLivroVazio(String campo) throws CampoLivroVazioException {
        if (campo == null || campo.trim().isEmpty()) {
            throw new CampoLivroVazioException("Os campos do livro não podem estar vazios.");
        }
    }

    // Verifica se o campo do cliente está vazio
    public static void verificarCampoClienteVazio(String campo) throws CampoClienteVazioException {
        if (campo == null || campo.trim().isEmpty()) {
            throw new CampoClienteVazioException("Os campos do cliente não podem estar vazios.");
        }
    }

    // Verifica se a quantidade de livros emprestados ultrapassou o limite
    public static void verificarLimiteEmprestimos(int emprestimos) throws LimiteEmprestimosExcedidoException {
        if (emprestimos > 5) { // Exemplo de limite
            throw new LimiteEmprestimosExcedidoException("Limite de empréstimos excedido.");
        }
    }

    // Verifica se o cliente já possui um livro emprestado
    public static void verificarClienteComLivroEmprestado(boolean possuiLivroEmprestado) throws ClienteComLivroEmprestadoException {
        if (possuiLivroEmprestado) {
            throw new ClienteComLivroEmprestadoException("Este cliente já possui um livro emprestado.");
        }
    }

    // Verifica se o livro está na lista de livros disponíveis
    public static void verificarLivroDisponivel(boolean livroDisponivel) throws LivroNaoDisponivelException {
        if (!livroDisponivel) {
            throw new LivroNaoDisponivelException("Livro não disponível para empréstimo.");
        }
    }

    // Verifica se o empréstimo foi feito com sucesso
    public static void verificarEmprestimoSucesso(boolean emprestimoFeito) throws EmprestimoFalhouException {
        if (!emprestimoFeito) {
            throw new EmprestimoFalhouException("Empréstimo do livro falhou.");
        }
    }

    // Exceção para quando o livro não foi devolvido
    public static class LivroNaoDevolvidoException extends Exception {
        public LivroNaoDevolvidoException() {
            super("O livro não foi devolvido.");
        }
    }
}