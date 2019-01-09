package board;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class ChessBoard extends Group {
	public static ArrayList<ArrayList<Square>> map = new ArrayList<ArrayList<Square>>();

	public ChessBoard() {

		for (int row = 0; row < 8; row++) {
			ArrayList<Square> rad = new ArrayList<Square>();
			for (int col = 0; col < 8; col++) {

				Color bg = Color.SANDYBROWN;
				if ((row + col) % 2 == 0) {
					bg = Color.WHITE;
				}

				Square s = new Square(bg);
				rad.add(s);
				s.setTranslateX(col * Square.SIZE);
				s.setTranslateY(row * Square.SIZE);
				this.getChildren().add(s);

				
				if (row == 1) {
					s.addPiece(new Pawn(Color.BLACK));
				}	
				if (row == 6) {
					s.addPiece(new Pawn(Color.WHITE));
				}
				if (row == 0 && (col == 2 || col == 5)) {
					s.addPiece(new Bishop(Color.BLACK));
				}
				if (row == 7 && (col == 2 || col == 5)) {
					s.addPiece(new Bishop(Color.WHITE));
				}
				if (row == 0 && (col == 0 || col == 7)) {
					s.addPiece(new Rook(Color.BLACK));
				}
				if (row == 7 && (col == 0 || col == 7)) {
					s.addPiece(new Rook(Color.WHITE));
				}
				if (row == 0 && (col == 1 || col == 6)) {
					s.addPiece(new Knight(Color.BLACK));
				}
				if (row == 7 && (col == 1 || col == 6)) {
					s.addPiece(new Knight(Color.WHITE));
				}
				if (row == 0 && (col == 4)) {
					s.addPiece(new King(Color.BLACK));
				}
				if (row == 7 && (col == 4)) {
					s.addPiece(new King(Color.WHITE));
				}
				if (row == 0 && (col == 3)) {
					s.addPiece(new Queen(Color.BLACK));
				}
				if (row == 7 && (col == 3)) {
					s.addPiece(new Queen(Color.WHITE));
				}
				
			}
			map.add(rad);

		}
	}
	
	public static Square getSquare(int x, int y){
		return map.get(y).get(x);
	}
	
}