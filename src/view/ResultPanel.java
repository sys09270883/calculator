package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ResultPanel extends JPanel {
	private static final long serialVersionUID = -3224878654601683089L;
	private JLabel label;

	public ResultPanel() {
		setBackground(Color.BLACK);
		setLayout(new GridLayout(3, 2));

		label = new JLabel("0");
		label.setFont(new Font("Arial", Font.BOLD, 32));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label);
	}

	public void setExpression(String expression) {
		label.setText(expression);
	}

	public String getExpression() {
		return label.getText();
	}
}
