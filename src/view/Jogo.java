package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Jogo extends JPanel {

	private BufferedImage fundo;
	private Graphics graphicsFundo;
	
	public Jogo() {
		
		fundo = new BufferedImage(512,512, BufferedImage.TYPE_4BYTE_ABGR);
		graphicsFundo = fundo.getGraphics();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		g.drawImage(fundo, 0, 0, null);
		
	}
	
	public Graphics getGraphicsFundo() {
		return graphicsFundo;
	}
}