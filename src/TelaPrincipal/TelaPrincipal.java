package TelaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaPrincipal {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel bookPanel;
    private JPanel clientPanel;
    private JTextField bookTitleField;
    private JTextField bookAuthorField;
    private JButton addBookBtn;
    private JTextField clientNameField;
    private JTextField clientEmailField;
    private JButton addClientBtn;
    private JButton showListBtn;

    // Listas para armazenar os livros e clientes
    private ArrayList<String> bookList;
    private ArrayList<String> clientList;
    private JPanel panel1;
    private JButton sairButton;

    public TelaPrincipal() {
        // Inicializando as listas
        bookList = new ArrayList<>();
        clientList = new ArrayList<>();

        frame = new JFrame("Tela Principal");
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1)); // Dividido em três partes: livros, clientes e botão de lista

        // Painel de livros
        bookPanel = new JPanel();
        bookPanel.setLayout(new GridLayout(3, 2));
        bookPanel.setBorder(BorderFactory.createTitledBorder("Cadastrar Livro"));

        JLabel bookTitleLbl = new JLabel("Título:");
        bookTitleField = new JTextField();
        JLabel bookAuthorLbl = new JLabel("Autor:");
        bookAuthorField = new JTextField();
        addBookBtn = new JButton("Add Livro");

        bookPanel.add(bookTitleLbl);
        bookPanel.add(bookTitleField);
        bookPanel.add(bookAuthorLbl);
        bookPanel.add(bookAuthorField);
        bookPanel.add(addBookBtn);

        // Painel de clientes
        clientPanel = new JPanel();
        clientPanel.setLayout(new GridLayout(3, 2));
        clientPanel.setBorder(BorderFactory.createTitledBorder("Cadastrar Cliente"));

        JLabel clientNameLbl = new JLabel("Nome:");
        clientNameField = new JTextField();
        JLabel clientEmailLbl = new JLabel("Email:");
        clientEmailField = new JTextField();
        addClientBtn = new JButton("Add Cliente");

        clientPanel.add(clientNameLbl);
        clientPanel.add(clientNameField);
        clientPanel.add(clientEmailLbl);
        clientPanel.add(clientEmailField);
        clientPanel.add(addClientBtn);

        // Botão para exibir a lista de livros e clientes
        showListBtn = new JButton("Exibir Listas");

        // Adiciona os painéis ao painel principal
        mainPanel.add(bookPanel);
        mainPanel.add(clientPanel);
        mainPanel.add(showListBtn);

        // Configura a janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.setVisible(true);

        // Ação do botão para adicionar livros
        addBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = bookTitleField.getText();
                String author = bookAuthorField.getText();
                if (title.isEmpty() || author.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos do livro.");
                } else {
                    String livro = "Título: " + title + ", Autor: " + author;
                    bookList.add(livro); // Adiciona o livro à lista
                    JOptionPane.showMessageDialog(frame, "Livro adicionado: " + livro);
                }
            }
        });

        // Ação do botão para adicionar clientes
        addClientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = clientNameField.getText();
                String email = clientEmailField.getText();
                if (name.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos do cliente.");
                } else {
                    String cliente = "Nome: " + name + ", Email: " + email;
                    clientList.add(cliente); // Adiciona o cliente à lista
                    JOptionPane.showMessageDialog(frame, "Cliente adicionado: " + cliente);
                }
            }
        });

        // Ação do botão para exibir a lista de livros e clientes
        showListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList(); // Chama o método para mostrar a lista
            }
        });
    }

    // Método que exibe a nova janela com a lista de livros e clientes
    private void showList() {
        JFrame listFrame = new JFrame("Lista de Livros e Clientes");
        listFrame.setSize(400, 300);
        listFrame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        // Preenche a área de texto com os livros e clientes cadastrados
        textArea.append("Livros cadastrados:\n");
        for (String livro : bookList) {
            textArea.append(livro + "\n");
        }

        textArea.append("\nClientes cadastrados:\n");
        for (String cliente : clientList) {
            textArea.append(cliente + "\n");
        }

        // Coloca a área de texto dentro de um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(textArea);
        listFrame.add(scrollPane);

        listFrame.setVisible(true);
    }
}
