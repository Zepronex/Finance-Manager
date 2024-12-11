package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

class startApplicationGraphics extends JFrame {

	// input fields
	//private JTextField idTextField;
	private JTextField amountTextField;
	//private JTextField dateTextField;
	private JTextField categoryTextField;
	private JTextField descriptionTextField;
	private JTextField typeTextField;

	private JButton sendUserInputData; // button to insert data

	public startApplicationGraphics() {
		super("Personal Finance Manager"); // title in application window
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		initializeComponents();
	}

	private void initializeComponents() {

		// Create components
		//idTextField = new JTextField(20);
		amountTextField = new JTextField(20);
		//dateTextField = new JTextField(20);
		categoryTextField = new JTextField(20);
		descriptionTextField = new JTextField(20);
		typeTextField = new JTextField(20);
		sendUserInputData = new JButton("Send Data");

		// Input panel with
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(BorderFactory.createTitledBorder("Enter data"));
		inputPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components

		
		// place input fields in gui
		gbc.gridx = 0;
		gbc.gridy = 0;
		inputPanel.add(new JLabel("Amount: "), gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		inputPanel.add(amountTextField, gbc);

		gbc.gridx = 4;
		gbc.gridy = 0;
		inputPanel.add(new JLabel("Category: "), gbc);
		
		gbc.gridx = 6;
		gbc.gridy = 0;
		inputPanel.add(categoryTextField, gbc);
		
		gbc.gridx = 8;
		gbc.gridy = 0;
		inputPanel.add(new JLabel("Description: "), gbc);
		
		gbc.gridx = 10;
		gbc.gridy = 0;
		inputPanel.add(descriptionTextField, gbc);
		
		gbc.gridx = 12;
		gbc.gridy = 0;
		inputPanel.add(new JLabel("Type"), gbc);
		
		gbc.gridx = 14;
		gbc.gridy = 0;
		inputPanel.add(typeTextField, gbc);

		// Result area with titled border and adjusted font
		resultTextArea = new JTextArea(10, 30);
		resultTextArea.setEditable(false); // Make result area read-only
		resultTextArea.setFont(new Font("Serif", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(resultTextArea);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Weather Data"));

		// Add action listener to the button
		getWeatherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city = cityTextField.getText();
				if (city == null || city.trim().isEmpty()) {
					// Show error message if city name is empty
					JOptionPane.showMessageDialog(WeatherAppGUI.this, "Please enter a city name.");
					return;
				}

				// Fetch and display weather data for the entered city
				fetchAndDisplayWeatherData(city);
			}
		});

		// Set layout manager for the frame and add components
		getContentPane().setLayout(new BorderLayout(10, 10));
		getContentPane().add(inputPanel, BorderLayout.NORTH);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	public void createAndShowGui() {

	}

}
