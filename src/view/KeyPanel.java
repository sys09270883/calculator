package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class KeyPanel extends JPanel {
	private static final long serialVersionUID = 2847649416420413966L;
	final private String[] keys = { "7", "8", "9", "÷", "4", "5", "6", "×", "1", "2", "3", "-", "C", "0", "=", "+" };
	private JButton[] buttons;

	public KeyPanel() {
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(4, 4, 5, 5));

		buttons = new JButton[16];
		for (int i = 0; i < 16; i++) {
			buttons[i] = new JButton(keys[i]);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 24));
			buttons[i].setBackground(i % 4 != 3 ? Color.DARK_GRAY : Color.GRAY);
			buttons[i].setForeground(Color.WHITE);
			this.add(buttons[i]);
		}
	}

	public JButton[] getButtons() {
		return this.buttons;
	}
}
