package carRental;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Slf4j

public class LoginForm extends JDialog {
    private JTextField lflogin;
    private JTextField lfpassword;
    private JButton lfconfirm;
    private JButton lfcancel;
    private JPanel loginPanel;
    private JLabel login1;
    private JLabel password1;
    private JLabel login2;
    private JLabel password;

    public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        lfcancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        setVisible(true);
    }

}
