package application;
//package Calculator;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class Main extends Application {
	
	@FXML
	public Label result;
	private float num1 = 0;
	private float num2;
	private boolean flag = true;
	private String op = "";
	private Calculator model = new Calculator();

	@FXML
	public void processNumbers (ActionEvent event) {
		
		if (flag) {
			result.setText("");
			flag = false;
		}
		
		String value = ((Button)event.getSource()).getText();
		result.setText(result.getText()+value);
	}

	public void processOperators (ActionEvent event) {
		
		String value = ((Button)event.getSource()).getText();
		
		if(!value.equals("=")) {
			if(!op.isEmpty())
				switch (value) {
				
				case "AC":
							result.setText("");
							this.num1 = 0;
							this.num2 = 0;
							break;
				default:
							break;
							
				}
			
			op = value;
			num1 = Long.parseLong(result.getText());
			result.setText("");
			return;
		
		}
		
		else {
			if(op.isEmpty())
				return;
			num2 = Long.parseLong(result.getText());
			float output = model.Calculate(num1, num2, op);
			result.setText(String.valueOf(output));
			op = "";
			num1 = 0;
			num2 = 0;
			flag = true;
		}
	}

	
	
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,300,400);
			primaryStage.setTitle("Calculator");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
