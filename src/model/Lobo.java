package model;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Lobo {
	private ImageIcon imagemObj;
	private int x,y;
	private int largura,altura;
	private Rectangle rectangle;
	
	public Lobo(int x, int y,String caminho) {
		this.x = x;
		this.y = y;
		
		imagemObj = new ImageIcon(getClass().getClassLoader().getResource(caminho));
		this.largura = imagemObj.getIconWidth();
		this.altura = imagemObj.getIconHeight();
		this.rectangle = new Rectangle(x, y, largura, altura);
		
		
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	public ImageIcon getImagemObj() {
		return imagemObj;
	}
	
	
	
	
	
	
	
	
}
