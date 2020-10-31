package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import util.Observer;
import util.OperatorUtils;

public class Model {
	private String data;
	private ArrayList<Observer> list;

	public Model() {
		data = "0";
		list = new ArrayList<>();
	}

	public void setObserver(Observer o) {
		list.add(o);
	}

	public void notifyObservers() {
		for (Observer o : list) {
			o.update(data);
		}
	}

	public void calculate() {
		StringTokenizer tokenizer = new StringTokenizer(data, "+-¡¿¡À", true);

		double n1;
		if (tokenizer.countTokens() == 4) {
			tokenizer.nextToken();
			n1 = -Double.parseDouble(tokenizer.nextToken());
		} else {
			n1 = Double.parseDouble(tokenizer.nextToken());
		}
		if (!tokenizer.hasMoreElements())
			return;
		String op = tokenizer.nextToken();
		double n2 = Double.parseDouble(tokenizer.nextToken());

		DecimalFormat df = new DecimalFormat("#.######");

		if (OperatorUtils.getInstance().isPlus(op))
			data = df.format(n1 + n2);
		else if (OperatorUtils.getInstance().isMinus(op))
			data = df.format(n1 - n2);
		else if (OperatorUtils.getInstance().isTimes(op))
			data = df.format(n1 * n2);
		else if (OperatorUtils.getInstance().isObelus(op))
			data = df.format(n1 / n2);
		else
			throw new RuntimeException("Calculate error occurs.");

		notifyObservers();
	}

	public boolean isPossible() {
		return data.length() < 20;
	}

	public void reset() {
		data = "0";
		notifyObservers();
	}

	public void append(String input) {
		if (OperatorUtils.getInstance().isOperator(data.charAt(data.length() - 1))
				&& OperatorUtils.getInstance().isOperator(input)) {
			StringBuilder tmpData = new StringBuilder(data);
			tmpData.setCharAt(tmpData.length() - 1, input.charAt(0));
			data = tmpData.toString();
			notifyObservers();
			return;
		}

		data += input;
		if (data.length() == 2) {
			if (data.charAt(0) == '0' && !OperatorUtils.getInstance().isOperator(input))
				data = data.substring(1, data.length());
		}
		notifyObservers();
	}

}
