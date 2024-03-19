/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginsystem;

//classes import
import classes.loginChecker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author okker
 */
public class LoginSystem {

  private static JLabel label;
  private static JLabel lastNameLabel;
  private static JTextField enterLastName;
  private static JTextField userText;
  private static JTextField enterName;
  private static JLabel passwordLabel;
  private static JPasswordField userPassword;
  private static JButton button;
  private static JLabel success;
  private static JPanel panel;
 //------------------------------------start-of-code----------------------------------//
  public static void main(String[] args) {
    //Create the GUI instance here// 
//     JFrame frame = new JFrame();
     LoginSystem loginSystem = new LoginSystem();
     loginSystem.createGUI();
     
    //user text and input 
    userName();
    //password text and input
    userPassword();
    //name
    name();
    //lastName
    lastName();
    //button
    //login user Button
    //success
    success();
       
//    frame.setVisible(true);
    
     
  }
   
//methods for text fields and name instance on the GUI
  private void createGUI() {
      panel = new JPanel();
    JFrame frame = new JFrame();
    frame.setSize(350, 250);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    panel.setLayout(null);
    registerButton(); // Call methods to create buttons
    loginButton();
    frame.setVisible(true);
  }
  public static void userName() {
    label = new JLabel("user");
    label.setBounds(10, 20, 80, 25);
    panel.add(label);
     
    userText = new JTextField(20);
    userText.setBounds(100, 20, 165,25);
    panel.add(userText);
}
   public static void userPassword() {
    passwordLabel = new JLabel("password");
    passwordLabel.setBounds(10, 50, 80,25);
    panel.add(passwordLabel);
     
    userPassword = new JPasswordField();
    userPassword.setBounds(100, 50, 165,25);
    panel.add(userPassword);
}
   
   public static void name() {
    passwordLabel = new JLabel("name");
    passwordLabel.setBounds(10, 80, 80,25);
    panel.add(passwordLabel);
     
    enterName = new JTextField();
    enterName.setBounds(100, 80, 165,25);
    panel.add(enterName);
   }
   
  public static void lastName() {
    lastNameLabel = new JLabel("lastName");
    lastNameLabel.setBounds(10, 110, 80,25);
    panel.add(lastNameLabel);
     
    enterLastName = new JTextField();
    enterLastName.setBounds(100, 110, 165,25);
    panel.add(enterLastName);
   }
   
   public void registerButton() {
    button = new JButton("Register");
    button.setBounds(10, 150, 80, 25);
    button.addActionListener(new RegisterButtonListener());
    panel.add(button);
   }
   
   public void loginButton() {
    button = new JButton("Login");
    button.setBounds(100, 150, 80, 25);
    button.addActionListener(new LoginButtonListener());
    panel.add(button);
   }
  public static void success() {
    success = new JLabel("");
    success.setBounds(10, 180, 300, 25);
    panel.add(success);
  }
   
  class RegisterButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = userPassword.getText();
        String name = enterName.getText();
        String lastName = enterLastName.getText();

        // Call registerUser method with additional name and lastName
        var message = loginChecker.registerUser(user, password);
        success.setText(message);
    }
} 
  
  class LoginButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = new String(userPassword.getPassword()); // Retrieve password securely
        
        // Check if username and password fields are empty
//        if (user.isEmpty() || password.isEmpty()) {
//            success.setText("Please enter both username and password.");
//            return;
//        }

        // Call the loginUser method
        boolean loginSuccessful = loginChecker.loginUser(user, password);

        // Handle the login result (display success or failure message)
        if (loginSuccessful == true) {
            // Redirect to the appropriate logged-in view
            success.setText("Login successful!");
            // ... navigate to logged-in screen
        } else {
              success.setText("Please enter both username and password.");
        }
    }
}
   
}