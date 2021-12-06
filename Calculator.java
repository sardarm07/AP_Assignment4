package application;

import javafx.scene.control.Label;

public class Calculator {
	public float Calculate (float n1, float n2, String operator) {
		switch (operator) {
		case "+":
				return n1 + n2;
		case "-":
				return n1 - n2;
		case "X":
				return n1 * n2;
		case "/":
				if (n2 == 0)
					return 0;
				return n1/n2;
		default:
				return 0;
		 
		}
		
	}

}
