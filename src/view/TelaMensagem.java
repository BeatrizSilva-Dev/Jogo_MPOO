package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControlePintura;

public class TelaMensagem extends JFrame{
	//	private ImageIcon imagemV, imagemF;
	//	private String mensagem = "Parabéns você acertou!";
	ControlePintura controlePintura;
	private boolean resposta;
	private ImageIcon imagem;
	private String endereco;

	public TelaMensagem(){
		setSize(TelaFrame.LARGURA, TelaFrame.ALTURA);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		try {
			imagem = new ImageIcon(getClass().getResource(endereco));
		} catch (Exception e) {
			// TODO: handle exception
		}


	}
	protected void paintComponent(Graphics g){
		try {
			g.drawImage(imagem.getImage(),0,0,null);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


}

