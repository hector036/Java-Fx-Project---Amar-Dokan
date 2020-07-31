/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokan;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane pane_login;

    @FXML
    private TextField email_login;

    @FXML
    private PasswordField pass_login;

    @FXML
    private ComboBox<?> type_login;

    @FXML
    private Button login_btn;

    @FXML
    private AnchorPane pane_signup;

    @FXML
    private TextField email_signup;

    @FXML
    private TextField username_signup;

    @FXML
    private TextField password_signup;

    @FXML
    private ComboBox<?> type_signup;

    @FXML
    private Button signup;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public void LoginPanelShow() {
        pane_login.setVisible(true);
        pane_signup.setVisible(false);

    }

    public void SignupPanelShow() {
        pane_login.setVisible(false);
        pane_signup.setVisible(true);

    }

    @FXML
    private void Login(ActionEvent event) throws Exception {

        conn = DatabaseConnection.ConnectDb();
        String sql = "Select * from users where username = ? and password = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email_login.getText());
            ps.setString(2, pass_login.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Success");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
