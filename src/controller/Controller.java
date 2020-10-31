package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.Model;
import view.View;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		this.model.setObserver(view);
		setButtonActionListener();
	}

	public void setButtonActionListener() {
		JButton[] buttons = view.getKeyButtons();
		for (int i = 0; i < 16; i++) {
			if (i == 12) { // reset
				buttons[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.reset();
					}
				});
			} else if (i == 14) { // calculate
				buttons[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						model.calculate();
					}
				});
			} else { // number & operator
				buttons[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (!model.isPossible())
							return;
						model.append(((JButton) e.getSource()).getText());
					}
				});
			}
		}
	}

}
