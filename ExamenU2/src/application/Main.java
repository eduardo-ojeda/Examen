/*Resolver multiplicaiones de 2 números aleatorios  al usario y al iniciar,
 *  mediante un hilo, presente un contador de segundos, el cual se detendra cuando el usuario
 *  responda correctamente*/

package application;

import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application{
	@Override
	public void start(Stage primaryStage) {
		 Tiempo c=new Tiempo();
	     c.start();

		primaryStage.setTitle("Multiplicaciones");
		int n1,n2;

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);


		Text scenetitle = new Text("¿Cuánto Es? ");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		n1 = (int)(Math.random()*10);
		Label text = new Label(" "+n1);
		grid.add(text, 0, 1);

		n2 = (int)(Math.random()*10);
		Label text2 = new Label("* "+n2);
		grid.add(text2, 1, 1);

		Label text3 = new Label("Su Respuesta:");
		grid.add(text3, 0, 3);

		TextField Respuesta = new TextField();
		grid.add(Respuesta, 1, 3);

        Button op = new Button();
        op.setText("Validar");

        op.setOnAction(new EventHandler<ActionEvent>() {


            @SuppressWarnings("deprecation")
			@Override
            public void handle(ActionEvent event) {

            	int resp;
            	int Respues = Integer.parseInt(Respuesta.getText());
            	resp = n1* n2;

                Alert result = new Alert(AlertType.INFORMATION);
                result.setTitle("Respuesta");
                result.setHeaderText(null);

            	if (resp == Respues)
            	{
            		c.stop();
                    result.setContentText("Es Correcto!" + "\nHizo un tiempo de: "+c.min +" : "+ c.seg);
                    result.showAndWait();

            	}
            	else
            	{
                    result.setContentText("Es Incorrecto!, Intenta de Nuevo");
                    result.showAndWait();
            	}



            }

        });

        grid.add(op, 1, 4);
        primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
        System.exit(0);
	}

}