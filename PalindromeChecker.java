import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PalindromeChecker extends JFrame {

    // Constructor to set up the GUI
    public PalindromeChecker() {
        // Set the title of the window
        setTitle("Palindrome Checker");

        // Set the layout
        setLayout(new FlowLayout());

        // Create components
        JLabel promptLabel = new JLabel("Enter a word or phrase:");
        JTextField inputField = new JTextField(20);
        JButton checkButton = new JButton("Check");
        JLabel resultLabel = new JLabel("");

        // Add components to the frame
        add(promptLabel);
        add(inputField);
        add(checkButton);
        add(resultLabel);

        // Add action listener to the button
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (isPalindrome(input)) {
                    resultLabel.setText("\"" + input + "\" is a palindrome.");
                } else {
                    resultLabel.setText("\"" + input + "\" is not a palindrome.");
                }
            }
        });

        // Set default close operation and size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String input) {
        // Remove spaces and punctuation, and convert to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize pointers for the start and end of the string
        int left = 0;
        int right = cleanedInput.length() - 1;

        // Check characters from both ends
        while (left < right) {
            if (cleanedInput.charAt(left) != cleanedInput.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // Is a palindrome
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Create the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new PalindromeChecker());
    }
}
