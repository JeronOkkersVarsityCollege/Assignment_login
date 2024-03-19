/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.util.regex.*;


/**
 *
 * @author okker
 */
public class loginChecker {
   public static boolean checkUserName(String user) {
    if(user.length() > 5) {
      return false;
    }
    return user.indexOf('_') != -1;
  }
    
   public static boolean checkPassword(String password) {
    String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*!])[A-Za-z\\d@#$%^&*!]{8,}$";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(password);

    return matcher.matches();
   }
   
   public static boolean loginUser(String username, String password) {

    // Verify if the provided credentials match the stored ones
    if (username.isEmpty() || password.isEmpty()) {
        // Credentials match, login successful
        return false;
    } else {
        // Credentials don't match, login failed
        return true;
    }
   }
   
   public static String registerUser(String username, String password) {
    boolean usernameIsValid = checkUserName(username);
    boolean passwordIsValid = checkPassword(password);
     
    if (!usernameIsValid) {
      return "Invalid username format. Please use alphanumeric characters, underscores only, with a length of 5-20 characters.";
    } else if (!passwordIsValid) {
      return "Password must meet complexity requirements: at least 8 characters, one lowercase letter, one uppercase letter, one digit, and one special character.";
    } else {
      // Placeholder for actual registration process (replace with your logic)
      // ...
      return "User registered successfully!";
    }
   }
   
}