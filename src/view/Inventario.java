package view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Inventario extends JPanel{
	private JButton voltarButton;
	private ImageIcon imagem,imagemVoltar;
	
	public Inventario(){
		setSize(100, 560);
		setLayout(null);
		
		imagem = new ImageIcon(getClass().getResource("/fundoInventario.png"));
		
		imagemVoltar = new ImageIcon(getClass().getResource("/voltar.png"));
		
		voltarButton = new JButton(imagemVoltar);
		
//		voltarButton.setBorderPainted(false);
		voltarButton.setFocusPainted(false);
		voltarButton.setContentAreaFilled(false);
		
		voltarButton.setBounds(10, 470, 130, 40);
		
		add(voltarButton);
		
		
		
		
	}
	
	protected void paintComponent(Graphics g){
		g.drawImage(imagem.getImage(),0,0,null);
	}
	public JButton getVoltarButton() {
		return voltarButton;
	}
}
