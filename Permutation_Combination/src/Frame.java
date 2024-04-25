import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// components
	JPanel historyPanel, containerPanel, inputPanel, textAreaContainer;
	JTextArea textArea;
	JTextField textField1, textField2;
	JButton clearButton, submitButton, themeContainer;
	JScrollPane scrollPane;
	String selections[] = { "C", "P" };
	JComboBox<String> selection;
	// current theme 1 = light mode 0 = dark mode
	public int currentTheme = 1;

	// colors
	Color lightPrimaryColor = new Color(172, 177, 248);
	Color lightSecondaryColor = new Color(150, 155, 231);
	Color darkPrimaryColor = new Color(16, 20, 73);
	Color darkSecondaryColor = new Color(255, 209, 41);
	Color darkTertiaryColor = new Color(12, 2, 45);

	// icons dark and light theme
	ImageIcon lightTrashIcon = new ImageIcon("trash3.png");
	ImageIcon lightSubmitIcon = new ImageIcon("cursor.png");
	ImageIcon darkTrashIcon = new ImageIcon("trash3dark.png");
	ImageIcon darkSubmitIcon = new ImageIcon("cursordark.png");
	ImageIcon sunIcon = new ImageIcon("sun-fill.png");
	ImageIcon moonIcon = new ImageIcon("moon-fill.png");
	Processes process = new Processes();

	// constructor
	Frame() {
		// frame

		this.setSize(900, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Combination and Permutation");
		this.setResizable(false);

		// container
		containerPanel = new JPanel();
		containerPanel.setBounds(0, 0, 900, 700);
		containerPanel.setBackground(lightPrimaryColor);
		containerPanel.setLayout(null);

		// history container
		historyPanel = new JPanel();
		historyPanel.setBounds(0, 0, 200, 700);
		historyPanel.setLayout(null);
		historyPanel.setBackground(Color.white);

		// button to clear history
		clearButton = new JButton(" Clear history", lightTrashIcon);
		clearButton.setBounds(20, 600, 160, 40);
		clearButton.setFocusable(false);
		clearButton.setBackground(lightSecondaryColor);
		clearButton.setForeground(Color.white);
		clearButton.setFont(new Font("Inter", Font.PLAIN, 15));
		clearButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		clearButton.addActionListener(this);

		// label with sun icon
		themeContainer = new JButton();
		themeContainer.setIcon(sunIcon);
		themeContainer.setBounds(820, 20, 30, 30);
		themeContainer.setBackground(null);
		themeContainer.setBorder(null);
		themeContainer.setFocusable(false);
		themeContainer.addActionListener(this);

		textAreaContainer = new JPanel();
		textAreaContainer.setBounds(233, 150, 620, 300);
		textAreaContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		textAreaContainer.setBorder(null);
		// text area where the answer will dispay
		textArea = new JTextArea("Answer here...");

		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setLayout(new FlowLayout());
		textArea.setFont(new Font("Inter", Font.PLAIN, 17));
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setFocusable(false);

		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(620, 300));

		// container for the textfield and submit button
		inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setBackground(null);
		inputPanel.setBounds(233, 596, 620, 44);

		selection = new JComboBox<String>(selections);
		selection.setBounds(0, 0, 65, 44);
		selection.setFont(new Font("Inter", Font.PLAIN, 15));

		// textfield where user inputs
		textField1 = new JTextField();
		textField1.setBounds(65, 0, 249, 44);
		textField1.setForeground(Color.black);
		textField1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		textField1.setFont(new Font("Inter", Font.PLAIN, 18));

		textField2 = new JTextField();
		textField2.setBounds(315, 0, 250, 44);
		textField2.setForeground(Color.black);
		textField2.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		textField2.setFont(new Font("Inter", Font.PLAIN, 18));

		// submit button with icon
		submitButton = new JButton(lightSubmitIcon);
		submitButton.setBounds(565, 0, 55, 44);
		submitButton.setBackground(lightSecondaryColor);
		submitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		submitButton.setFocusable(false);
		submitButton.addActionListener(this);

		textAreaContainer.add(scrollPane);
		// adding all the components
		historyPanel.add(clearButton);
		inputPanel.add(selection);
		inputPanel.add(textField1);
		inputPanel.add(textField2);
		inputPanel.add(submitButton);

		containerPanel.add(themeContainer);
		containerPanel.add(historyPanel);
		containerPanel.add(inputPanel);
		containerPanel.add(textAreaContainer);
		this.add(containerPanel);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == themeContainer) {
			if (currentTheme == 1) {
				containerPanel.setBackground(darkPrimaryColor);
				submitButton.setBackground(darkSecondaryColor);
				submitButton.setIcon(darkSubmitIcon);
				clearButton.setBackground(darkSecondaryColor);
				clearButton.setIcon(darkTrashIcon);
				clearButton.setForeground(Color.black);
				themeContainer.setIcon(moonIcon);
				historyPanel.setBackground(darkTertiaryColor);
				textArea.setBackground(darkTertiaryColor);
				textArea.setForeground(Color.white);
				currentTheme = 0;
			} else {
				containerPanel.setBackground(lightPrimaryColor);
				submitButton.setBackground(lightSecondaryColor);
				submitButton.setIcon(lightSubmitIcon);
				clearButton.setBackground(lightSecondaryColor);
				clearButton.setIcon(lightTrashIcon);
				clearButton.setForeground(Color.white);
				themeContainer.setIcon(sunIcon);
				historyPanel.setBackground(Color.white);
				textArea.setBackground(Color.white);
				textArea.setForeground(Color.black);

				currentTheme = 1;
			}
		}
		if (e.getSource() == submitButton) {

			String combi = textField1.getText();

			try {
				int r = Integer.parseInt(textField2.getText());
				if (r > combi.length() && !combi.isBlank()) {
					process.typingText("Failed to Combine, your R is greater than the length of your string", textArea,
							submitButton);
				} else {
					if (combi.isBlank()) {
						process.typingText("Please input Something!", textArea, submitButton);
					} else {
						ArrayList<String> result = process.Combinations(combi, r);
						String convertedResult = result.toString();
						process.typingText(convertedResult, textArea, submitButton);
					}
				}
			} catch (NumberFormatException e1) {
				process.typingText("Wrong format, Please Try Again!", textArea, submitButton);

			}
		}

	}

}
