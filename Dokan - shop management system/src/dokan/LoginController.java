/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokan;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {

    @FXML
    private Label forgotPassword;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField password;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    @FXML
    private void Login(ActionEvent event) throws Exception {

        conn = DatabaseConnection.ConnectDb();
        String sql = "Select * from users where email = ? and password = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email.getText());
            ps.setString(2, password.getText());
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
