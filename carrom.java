package net.ripper.carrom.model;

import net.ripper.carrom.model.components.Circle;
import android.graphics.Rect;

/**
 * this class represents the carrom board. Describes the holes in the corner,
 * the circle in the center, shooting regions(which are basically rectangles)
 * bounds of the board and the friction on the surface of the board.
 * 
 * The Renderer uses this class to draw the board. The Collision manager uses
 * this class to check collisions with the the holes and walls
 * 
 * @author Kapil Ratnani
 * 
 */
public class Board {
	/**
	 * Represent the 4 holes in the corner
	 */
	public Circle[] holes;
	public Circle centerCircle;
	public Rect[] shootingRect;
	public Rect boundsRect;
	// public float damping;

	private float holeRadius = 10.0f;
	private float centreCircleRadius = 41.0f;
	private float boardSize = 300;
	private float boardOffset = 18;

	public static final int TOP_SHOOTING_RECT = 2;
	public static final int RIGHT_SHOOTING_RECT = 1;
	public static final int BOTTOM_SHOOTING_RECT = 0;
	public static final int LEFT_SHOOTING_RECT = 3;

	public static final int TOP_LEFT_HOLE = 0;
	public static final int TOP_RIGHT_HOLE = 1;
	public static final int BOTTOM_LEFT_HOLE = 3;
	public static final int BOTTOM_RIGHT_HOLE = 2;

	public int posXOffset = 0;
	public int posYOffset = 0;

	// board
	// 300X300
	// bounds 264X264
	// center circle 82X82
	// holes 20x20
	private void init() {
		holes = new Circle[4];
		// top left
		holes[TOP_LEFT_HOLE] = new Circle(holeRadius, posXOffset + boardOffset
				+ holeRadius, posYOffset + boardOffset + holeRadius);
		// top right
		holes[TOP_RIGHT_HOLE] = new Circle(holeRadius, boardSize - holeRadius
				- boardOffset + posXOffset, holeRadius + boardOffset
				+ posYOffset);
		// bottom right
		holes[BOTTOM_RIGHT_HOLE] = new Circle(holeRadius, boardSize
				- holeRadius - boardOffset + posXOffset, boardSize - holeRadius
				- boardOffset + posYOffset);
		// bottom left
		holes[BOTTOM_LEFT_HOLE] = new Circle(holeRadius, posXOffset
				+ boardOffset + holeRadius, boardSize - holeRadius
				- boardOffset + posYOffset);

		// init center Circle
		centerCircle = new Circle(centreCircleRadius, posXOffset + boardSize
				/ 2, posYOffset + boardSize / 2);

		// shooting rects
		shootingRect = new Rect[4];
		// top
		shootingRect[TOP_SHOOTING_RECT] = new Rect(posXOffset
				+ (int) (0.24 * boardSize), posYOffset
				+ (int) (0.19 * boardSize), posXOffset
				+ (int) (0.76 * boardSize), posYOffset
				+ (int) (0.24 * boardSize));

		// right
		shootingRect[RIGHT_SHOOTING_RECT] = new Rect(posXOffset
				+ (int) (0.76 * boardSize), posYOffset
				+ (int) (0.24 * boardSize), posXOffset
				+ (int) (0.81 * boardSize), posYOffset
				+ (int) (0.76 * boardSize));
		// bottom
		shootingRect[BOTTOM_SHOOTING_RECT] = new Rect(posXOffset
				+ (int) (0.24 * boardSize), posYOffset
				+ (int) (0.76 * boardSize), posXOffset
				+ (int) (0.76 * boardSize), posYOffset
				+ (int) (0.81 * boardSize));
		// left
		shootingRect[LEFT_SHOOTING_RECT] = new Rect(posXOffset
				+ (int) (0.19 * boardSize), posYOffset
				+ (int) (0.24 * boardSize), posXOffset
				+ (int) (0.24 * boardSize), posYOffset
				+ (int) (0.76 * boardSize));

		boundsRect = new Rect((int) (posXOffset + boardOffset),
				(int) (posYOffset + boardOffset), (int) (boardSize
						- boardOffset + posXOffset), (int) (boardSize
						- boardOffset + posYOffset));

		// damping = 0.25F;
	}

	public Board(int posXOffset, int posYOffset, int boardSize) {
		this.boardSize = boardSize;
		this.boardOffset = 0.06f * boardSize;
		this.holeRadius = android.util.FloatMath.ceil(0.033f * boardSize);
		this.centreCircleRadius = 0.14f * boardSize;
		this.posXOffset = posXOffset;
		this.posYOffset = posYOffset;
		init();
	}

}
