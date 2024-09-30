package TelaPrincipal;

import Model.Book;
import Model.Client;
import Excecoes.Excecoes;
import Excecoes.LivroJaEmprestadoException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaPrincipal {
    private JFrame frame;
    private ArrayList<Book> bookList;
    private ArrayList<Client> clientList;
    private JPanel panel1;
    private JButton sairButton;

    public TelaPrincipal() {
        bookList = new ArrayList<>();
        clientList = new ArrayList<>();

        frame = new JFrame("Tela Principal");
        JPanel mainPanel = new JPanel(new GridLayout(5, 1));

        // Painel de Cadastro de Livros
        JPanel bookPanel = new JPanel(new GridLayout(2, 2));
        JLabel bookTitleLbl = new JLabel("Título:");
        JTextField bookTitleField = new JTextField();
        JLabel bookAuthorLbl = new JLabel("Autor:");
        JTextField bookAuthorField = new JTextField();
        JButton addBookBtn = new JButton("Add Livro");
        bookPanel.add(bookTitleLbl);
        bookPanel.add(bookTitleField);
        bookPanel.add(bookAuthorLbl);
        bookPanel.add(bookAuthorField);
        bookPanel.add(addBookBtn);

        // Painel de Cadastro de Clientes
        JPanel clientPanel = new JPanel(new GridLayout(2, 2));
        JLabel clientNameLbl = new JLabel("Nome:");
        JTextField clientNameField = new JTextField();
        JLabel clientEmailLbl = new JLabel("Email:");
        JTextField clientEmailField = new JTextField();
        JButton addClientBtn = new JButton("Add Cliente");
        clientPanel.add(clientNameLbl);
        clientPanel.add(clientNameField);
        clientPanel.add(clientEmailLbl);
        clientPanel.add(clientEmailField);
        clientPanel.add(addClientBtn);

        // Botões de Empréstimo e Devolução
        JButton loanBookBtn = new JButton("Emprestar Livro");
        JButton returnBookBtn = new JButton("Devolver Livro");
        JButton showListBtn = new JButton("Exibir Listas");

        // Adiciona os painéis ao painel principal
        mainPanel.add(bookPanel);
        mainPanel.add(clientPanel);
        mainPanel.add(loanBookBtn);
        mainPanel.add(returnBookBtn);
        mainPanel.add(showListBtn);

        frame.add(mainPanel);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Ação para adicionar livros
        addBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = bookTitleField.getText();
                    String author = bookAuthorField.getText();
                    if (title.isEmpty() || author.isEmpty()) {
                        throw new IllegalArgumentException("Preencha todos os campos do livro.");
                    }
                    bookList.add(new Book(title, author));
                    JOptionPane.showMessageDialog(frame, "Livro adicionado!");
                } catch (Exception ex) {
                    Excecoes.tratar(ex);
                }
            }
        });

        // Ação para adicionar clientes
        addClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = clientNameField.getText();
                    String email = clientEmailField.getText();
                    if (name.isEmpty() || email.isEmpty()) {
                        throw new IllegalArgumentException("Preencha todos os campos do cliente.");
                    }
                    clientList.add(new Client(name, email));
                    JOptionPane.showMessageDialog(frame, "Cliente adicionado!");
                } catch (Exception ex) {
                    Excecoes.tratar(ex);
                }
            }
        });

        // Ação para emprestar livro
        loanBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String bookTitle = JOptionPane.showInputDialog(frame, "Título do livro:");
                    String clientName = JOptionPane.showInputDialog(frame, "Nome do cliente:");
                    Book book = findBookByTitle(bookTitle);
                    Client client = findClientByName(clientName);

                    if (book == null || client == null) {
                        throw new Exception("Livro ou cliente não encontrados.");
                    }
                    if (book.isLoaned()) {
                        throw new LivroJaEmprestadoException();
                    }
                    book.loanTo(client);
                    JOptionPane.showMessageDialog(frame, "Livro emprestado com sucesso!");
                } catch (Exception ex) {
                    Excecoes.tratar(ex);
                }
            }
        });

        // Ação para devolver livro
        returnBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String bookTitle = JOptionPane.showInputDialog(frame, "Título do livro:");
                    Book book = findBookByTitle(bookTitle);

                    if (book == null) {
                        throw new Exception("Livro não encontrado.");
                    }
                    if (!book.isLoaned()) {
                        throw new Exception("O livro não está emprestado.");
                    }
                    book.returnBook();
                    JOptionPane.showMessageDialog(frame, "Livro devolvido com sucesso!");
                } catch (Exception ex) {
                    Excecoes.tratar(ex);
                }
            }
        });

        // Ação para exibir listas
        showListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });
    }

    // Métodos auxiliares para encontrar livro ou cliente
    private Book findBookByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private Client findClientByName(String name) {
        for (Client client : clientList) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }

    private void showList() {
        JFrame listFrame = new JFrame("Lista de Livros e Clientes");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        textArea.append("Livros:\n");
        for (Book book : bookList) {
            textArea.append(book + "\n");
        }
        textArea.append("\nClientes:\n");
        for (Client client : clientList) {
            textArea.append(client + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        listFrame.add(scrollPane);
        listFrame.setSize(400, 300);
        listFrame.setLocationRelativeTo(null);
        listFrame.setVisible(true);
    }
}
