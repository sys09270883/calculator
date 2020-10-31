package util;

import java.util.HashMap;

public class OperatorUtils {
	private static OperatorUtils instance;
	private static HashMap<String, Operator> opConverter;

	private OperatorUtils() {
	}

	public static OperatorUtils getInstance() {
		if (instance == null) {
			instance = new OperatorUtils();
			opConverter = new HashMap<>();
			opConverter.put("+", Operator.PLUS);
			opConverter.put("-", Operator.MINUS);
			opConverter.put("¡¿", Operator.TIMES);
			opConverter.put("¡À", Operator.OBELUS);
		}
		return instance;
	}

	public boolean isOperator(String op) {
		if (opConverter.containsKey(op))
			return true;
		return false;
	}

	public boolean isOperator(char op) {
		return isOperator(Character.toString(op));
	}

	public boolean isPlus(String op) {
		return opConverter.get(op) == Operator.PLUS;
	}

	public boolean isMinus(String op) {
		return opConverter.get(op) == Operator.MINUS;
	}

	public boolean isTimes(String op) {
		return opConverter.get(op) == Operator.TIMES;
	}

	public boolean isObelus(String op) {
		return opConverter.get(op) == Operator.OBELUS;
	}

}
