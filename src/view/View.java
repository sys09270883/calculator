package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import util.Observer;

public class View extends JPanel implements Observer {
	private static final long serialVersionUID = 3732813183110323266L;
	private ResultPanel resultPanel;
	private KeyPanel keyPanel;

	public View() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.setBackground(Color.BLACK);

		setLayout(new BorderLayout());

		resultPanel = new ResultPanel();
		keyPanel = new KeyPanel();

		add(resultPanel, BorderLayout.NORTH);
		add(keyPanel, BorderLayout.CENTER);

		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setSize(500, 400);
	}

	public JButton[] getKeyButtons() {
		return keyPanel.getButtons();
	}

	public void setExpression(String data) {
		resultPanel.setExpression(data);
	}

	@Override
	public void update(String data) {
		setExpression(data);
	}
}
