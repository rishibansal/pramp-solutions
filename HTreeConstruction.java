import java.io.*;
import java.util.*;

public class HTreeConstruction {
	
	public static void main(String[] args) {
		drawHTree(0, 0, 4, 2);
	}

	private static void drawHTree(double x, double y, double length, double depth) {
		if (depth == 0) {
            return;
        }
        // draw horizontal
        drawLine(x - length/2, y, x + length/2, y);
        // draw left vertical
        drawLine(x - length/2, y + length/2, x - length/2, y - length/2);
        // draw right vertical
        drawLine(x + length/2, y + length/2, x + length/2, y - length/2);
        // draw children 
        // top left
        drawHTree(x - length/2, y + length/2, length/Math.sqrt(2), depth - 1);
        // bottom left
        drawHTree(x - length/2, y - length/2, length/Math.sqrt(2), depth - 1);
        // top right
        drawHTree(x + length/2, y + length/2, length/Math.sqrt(2), depth - 1);
        // bottom right
        drawHTree(x + length/2, y - length/2, length/Math.sqrt(2), depth - 1);
	}

	private static void drawLine(double x1, double y1, double x2, double y2) {
		System.out.println("line from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
	}
}