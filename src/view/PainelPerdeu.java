package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelPerdeu extends JPanel{
	private ImageIcon imagemfundo, imagemXIcon;
	private JButton imagemXButton;
	
	public PainelPerdeu() {
		setSize(512, 512);
		setLayout(null);
		
		imagemfundo = new ImageIcon(getClass().getResource("/perdeu.png"));
		imagemXIcon = new ImageIcon(getClass().getResource("/x.png"));
		imagemXButton = new JButton(imagemXIcon);

		
		imagemXButton.setBounds(467, 0, 45, 45);
		
		add(imagemXButton);
		
		
	}
	public JButton getImagemXButton() {
		return imagemXButton;
	}
	protected void paintComponent(Graphics g) {
		g.drawImage(imagemfundo.getImage(), 0, 0, null);

	}
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
