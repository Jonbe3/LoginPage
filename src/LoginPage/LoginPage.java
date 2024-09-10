package LoginPage;

import TelaPrincipal.TelaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    private JPasswordField passwordField1;
    private JPanel panel1;
    private JTextField textField1;
    private JButton entrarButton;

    public LoginPage() {
        JFrame frame = new JFrame("Biblioteca Twitter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());

                // Validação simples do login
                if (username.equals("admin") && password.equals("12345")) {
                    JOptionPane.showMessageDialog(frame, "Login bem-sucedido!");

                    // Fechar a tela de login
                    frame.dispose();

                    // Abrir a tela principal
                    new TelaPrincipal();
                } else {
                    JOptionPane.showMessageDialog(frame, "Login falhou. Tente novamente.");
                }
            }
        });
    }


}
