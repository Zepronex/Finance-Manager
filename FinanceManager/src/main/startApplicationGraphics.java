package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

class startApplicationGraphics extends JFrame {

    // Input fields
    private JTextField amountTextField;
    private JTextField categoryTextField;
    private JTextField descriptionTextField;
    private JTextField typeTextField;

    private JTextArea displayText; // Area to display transaction info
    private JButton sendUserInputData; // Button to insert data

    public startApplicationGraphics() {
        super("Personal Finance Manager"); // Title in the application window
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createAndShowGui() {
        // Create tabs
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add tabs
        tabbedPane.addTab("Stock Prices", createStockPricesTab());
        tabbedPane.addTab("Calculator", createCalculatorTab());
        tabbedPane.addTab("Income/Expenses", createIncomeExpensesTab());

        // Add tabbed pane to frame
        add(tabbedPane);

        setSize(800, 600);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private JPanel createStockPricesTab() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Stock Prices", SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);

        // Components for stock price input
        JTextField stockInput = new JTextField("Enter stock symbol...");
        JButton fetchButton = new JButton("Fetch Prices");
        JTextArea stockDisplay = new JTextArea(10, 30);
        stockDisplay.setEditable(false);

        // Add components
        panel.add(stockInput, BorderLayout.CENTER);
        panel.add(fetchButton, BorderLayout.SOUTH);

        // Action listener for fetching stock data
        fetchButton.addActionListener(e -> {
            String stockSymbol = stockInput.getText();
            stockDisplay.setText("Fetching data for: " + stockSymbol + "\n(Not yet implemented)");
        });

        panel.add(new JScrollPane(stockDisplay), BorderLayout.EAST);
        return panel;
    }

    private JPanel createCalculatorTab() {
        JPanel panel = new JPanel(new GridLayout(4, 4));

        // Add buttons for calculator functionality
        JTextField display = new JTextField();
        display.setEditable(false);
        panel.add(display);

        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+"};
        for (String text : buttons) {
            JButton button = new JButton(text);
            panel.add(button);

            // Add action listeners (logic to be implemented later)
            button.addActionListener(e -> {
                display.setText(display.getText() + text);
            });
        }

        return panel;
    }

    private JPanel createIncomeExpensesTab() {
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Data"));
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components

        // Add input fields
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Amount: "), gbc);
        amountTextField = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(amountTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Category: "), gbc);
        categoryTextField = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(categoryTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Description: "), gbc);
        descriptionTextField = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(descriptionTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Type (Income/Expense): "), gbc);
        typeTextField = new JTextField(20);
        gbc.gridx = 1;
        inputPanel.add(typeTextField, gbc);

        // Button to add data
        sendUserInputData = new JButton("Send Data");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        inputPanel.add(sendUserInputData, gbc);

        // Display area
        displayText = new JTextArea(10, 30);
        displayText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayText);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Transaction History"));

        // Add action listener for the button
        sendUserInputData.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountTextField.getText());
                String category = categoryTextField.getText();
                String description = descriptionTextField.getText();
                String type = typeTextField.getText();

                if (category.isEmpty() || description.isEmpty() || type.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        startApplicationGraphics.this,
                        "Please fill in all fields.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                // Create a new transaction
                Transaction transaction = new Transaction(0, amount, new Date(), category, description, type);

                // Append transaction to the display area
                displayText.append(transaction.toString() + "\n");

                // Clear input fields
                amountTextField.setText("");
                categoryTextField.setText("");
                descriptionTextField.setText("");
                typeTextField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    startApplicationGraphics.this,
                    "Invalid amount. Please enter a numeric value.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // Combine input panel and scroll pane
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            startApplicationGraphics app = new startApplicationGraphics();
            app.createAndShowGui();
        });
    }
}
