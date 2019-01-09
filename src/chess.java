import board.ChessBoard;
import board.Square;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class chess extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ChessBoard board = new ChessBoard();
		Scene scene = new Scene(board,Square.SIZE*8,Square.SIZE*8);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
