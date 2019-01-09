package board;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import pieces.Piece;

public class Square extends Group {

	public static final double SIZE = 80;

	private static Square active;
	private static ArrayList<Square> marked = new ArrayList<Square>();

	private Rectangle bg;
	private Color originalColor;
	private Piece piece;



	public Square(Color c) {
		originalColor = c;
		bg = new Rectangle(SIZE, SIZE, c);
		this.getChildren().add(bg);

		this.setOnMouseClicked(event -> {
			
			
			
		if(marked.contains(this)) {
			Piece p = active.piece;
			this.addPiece(active.piece);
			active.makeInactive();
			this.addPiece(p);
			p.move();
			return;
		}

			// EXEMPEL:
			if (hasPiece()) {
				makeActive();
			} else {
				if (active != null) {
					active.makeInactive();
				}
			}

		});
	}

	public void makeInactive() {
		this.getBackground().setFill(originalColor);
		active = null;
		removeMoveMarks();
	}

	public void makeActive() {
		if (active != null) {
			active.makeInactive();
		}

		piece.showMove(getX(), getY());
		active = this;
		this.getBackground().setFill(Color.RED);
	}

	public void addPiece(Piece p) {
		this.piece = p;
		this.getChildren().add(p);
	}

	public boolean hasPiece() {
		return this.piece != null;
	}

	public Rectangle getBackground() {
		return this.bg;
	}

	public int getX() {
		int y = getY();
		for (int i = 0; i < 8; i++) {
			if (ChessBoard.map.get(getY()).get(i) == this) {
				return i;
			}
		}
		return -1;

	}

	public int getY() {
		for (int i = 0; i < 8; i++) {
			if (ChessBoard.map.get(i).contains(this)) {
				return i;
			}
		}
		return -1;
	}

	public static void removeMoveMarks() {
		for (Square square : marked) {
			square.getChildren().remove(square.getChildren().size() - 1);
		}
		marked.clear();
	}

	public void moveMark() {

		Circle cir = new Circle(Square.SIZE / 2, Square.SIZE / 2, Square.SIZE / 8, Color.LIGHTGRAY);
		this.getChildren().add(cir);

		marked.add(this);

	}

	public Color getPieceColor() {
		// TODO Auto-generated method stub
		return this.piece.getColor();
	}

	public void attckMark() {
		Circle cir = new Circle(Square.SIZE/2,Square.SIZE/2,Square.SIZE/5,Color.RED);
		this.getChildren().add(cir);
		marked.add(this);
		// TODO Auto-generated method stub
		
	}

}
