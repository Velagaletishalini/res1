import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame1 extends Frame implements ActionListener {
    TextField userText, passText;
    Button loginButton, registerButton;
    Label statusLabel;

    public LoginFrame1() {
        setTitle("Login Form");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));

        Label userLabel = new Label("Username:");
        userText = new TextField();
        Label passLabel = new Label("Password:");
        passText = new TextField();
        passText.setEchoChar('*');
        loginButton = new Button("Login");
        loginButton.addActionListener(this);
        registerButton = new Button("Register");
        registerButton.addActionListener(this);
        statusLabel = new Label("");

        add(userLabel);
        add(userText);
        add(passLabel);
        add(passText);
        add(loginButton);
        add(registerButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = userText.getText();
            String password = passText.getText();
            if (authenticate(username, password)) {
                statusLabel.setText("Login successful!"); // Changed message
            } else {
                statusLabel.setText("Invalid username or password!");
            }
        } else if (e.getSource() == registerButton) {
            // Add registration logic here
        }
    }

    private boolean authenticate(String username, String password) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_username", "your_password");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                con.close();
                return true;
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new LoginFrame1();
    }
}
