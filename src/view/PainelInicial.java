package view;

import java.awt.Graphics;
//
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//
public class PainelInicial extends JPanel{

	private ImageIcon imagemFundoIcon, imagemJogarIcon, imagemSairIcon, imagemAjudaIcon, imagemSobreIcon;
	private JButton jogarButton, sairButton, ajudaButton, sobreButton;
	public PainelInicial() {
		setSize(512, 512);
		setLayout(null);

		imagemFundoIcon = new ImageIcon(getClass().getResource("/resposta.png"));
		imagemJogarIcon = new ImageIcon(getClass().getResource("/JOGAR.png"));
		imagemSairIcon = new ImageIcon(getClass().getResource("/sair.png"));
		imagemAjudaIcon = new ImageIcon(getClass().getResource("/ajuda.png"));
		imagemSobreIcon = new ImageIcon(getClass().getResource("/sobre.png"));

		jogarButton = new JButton(imagemJogarIcon);

		jogarButton.setBorderPainted(false);
		jogarButton.setFocusPainted(false);
		jogarButton.setContentAreaFilled(false);

		sairButton = new JButton(imagemSairIcon);

		sairButton.setBorderPainted(false);
		sairButton.setFocusPainted(false);
		sairButton.setContentAreaFilled(false);


		ajudaButton = new JButton(imagemAjudaIcon);

		ajudaButton.setBorderPainted(false);
		ajudaButton.setFocusPainted(false);
		ajudaButton.setContentAreaFilled(false);
		
		sobreButton = new JButton(imagemSobreIcon);
		
		sobreButton.setBorderPainted(false);
		sobreButton.setFocusPainted(false);
		sobreButton.setContentAreaFilled(false);
		
		jogarButton.setBounds(30,450, 100, 50);
		sairButton.setBounds(400, 450, 100, 50);
		ajudaButton.setBounds(150, 450, 100, 50);
		sobreButton.setBounds(280, 450, 100, 50);

		add(jogarButton);
		add(ajudaButton);
		add(sairButton);
		add(sobreButton);
		

	}

	public JButton getSobreButton() {
		return sobreButton;
	}

	public JButton getAjudaButton() {
		return ajudaButton;
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(imagemFundoIcon.getImage(), 0, 0, null);

	}

	public JButton getJogarbutton() {
		return jogarButton;
	}


	public JButton getSairbutton() {
		return sairButton;
	}
}
