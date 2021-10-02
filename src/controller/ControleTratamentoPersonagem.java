package controller;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.BasePerguntas;
import model.Lobo;
import model.Personagem;
import view.Jogo;
import view.TelaQuestao;

public class ControleTratamentoPersonagem extends KeyAdapter{
	
	private Jogo tela;
	private Personagem personagem;
	private Lobo lobo;
	
	public ControleTratamentoPersonagem(Jogo tela, Personagem personagem,Lobo lobo) {
		super();
		this.tela = tela;
		this.personagem = personagem;
		this.lobo = lobo;
	
		control();
	}

	public void control() {
		tela.addKeyListener(this);
		tela.requestFocus();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int codigo = e.getKeyCode();
		
		switch (codigo) {
		case KeyEvent.VK_UP:
			personagem.mover("cima");
			personagem.animar("cima");
			break;
		case KeyEvent.VK_DOWN:
			personagem.mover("baixo");
			personagem.animar("baixo");
			break;
		case KeyEvent.VK_RIGHT:
			personagem.mover("direita");
			personagem.animar("direita");
			break;
		case KeyEvent.VK_LEFT:
			personagem.mover("esquerda");
			personagem.animar("esquerda");
			break;
			
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}