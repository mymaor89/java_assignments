package vehicles;

import java.awt.Rectangle;
/***
 * 
* @author Maor Yatskan 301791380 Anna Rogozin 323686477
* Bordered rectangular area , support negative values 
 */

public class Border {
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;

	/**
	 * 
	 * @param minX minimum x of bordered area  
	 * @param minY minimum y of bordered area   
	 * @param maxX maximum x of bordered area 
	 * @param maxY maximum y of bordered area 
	 */
	public Border(int minX, int minY, int maxX, int maxY) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	/**
	 * 
	 * @param p Point to check if inside Bordered area 
	 * @return if point is inside area 
	 */
	public boolean inBounds(Point p) {
		return p.getX() >= minX && p.getX() <= maxX && p.getY() >= minY && p.getY() <= maxY;

	}

}