package TelaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel booksPanel;
    private JPanel clientsPanel;
    private JTextField bookTitleField;
    private JTextField bookAuthorField;
    private JButton addBookButton;
    private JTextField clientNameField;
    private JTextField clientEmailField;
    private JButton addClientButton;
    private JPanel panel1;
    private JButton sairButton;

    public TelaPrincipal() {
        frame = new JFrame("Tela Principal");
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1)); // Divide em duas seções principais

        // Configuração do painel de livros
        booksPanel = new JPanel();
        booksPanel.setLayout(new GridLayout(3, 2));
        booksPanel.setBorder(BorderFactory.createTitledBorder("Cadastrar Livro"));

        JLabel bookTitleLabel = new JLabel("Título:");
        bookTitleField = new JTextField();
        JLabel bookAuthorLabel = new JLabel("Autor:");
        bookAuthorField = new JTextField();
        addBookButton = new JButton("Adicionar Livro");

        booksPanel.add(bookTitleLabel);
        booksPanel.add(bookTitleField);
        booksPanel.add(bookAuthorLabel);
        booksPanel.add(bookAuthorField);
        booksPanel.add(addBookButton);

        // Configuração do painel de clientes
        clientsPanel = new JPanel();
        clientsPanel.setLayout(new GridLayout(3, 2));
        clientsPanel.setBorder(BorderFactory.createTitledBorder("Cadastrar Cliente"));

        JLabel clientNameLabel = new JLabel("Nome:");
        clientNameField = new JTextField();
        JLabel clientEmailLabel = new JLabel("Email:");
        clientEmailField = new JTextField();
        addClientButton = new JButton("Adicionar Cliente");

        clientsPanel.add(clientNameLabel);
        clientsPanel.add(clientNameField);
        clientsPanel.add(clientEmailLabel);
        clientsPanel.add(clientEmailField);
        clientsPanel.add(addClientButton);

        // Adiciona os painéis ao painel principal
        mainPanel.add(booksPanel);
        mainPanel.add(clientsPanel);

        // Configuração da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.setVisible(true);

        // Ações dos botões
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = bookTitleField.getText();
                String author = bookAuthorField.getText();
                if (title.isEmpty() || author.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos do livro.");
                } else {
                    // Aqui você pode adicionar lógica para cadastrar o livro
                    JOptionPane.showMessageDialog(frame, "Livro adicionado: " + title + " por " + author);
                }
            }
        });

        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = clientNameField.getText();
                String email = clientEmailField.getText();
                if (name.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos do cliente.");
                } else {
                    // Aqui você pode adicionar lógica para cadastrar o cliente
                    JOptionPane.showMessageDialog(frame, "Cliente adicionado: " + name + " com email " + email);
                }
            }
        });
    }

}
