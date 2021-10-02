package controller;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.JOptionPane;

import model.BasePerguntas;
import model.Lobo;
import model.Pergunta;
import model.Personagem;
import model.TileMap;
import model.Vilao;
import view.Jogo;
import view.TelaFrame;
import view.TelaMensagem;
import view.TelaQuestao;

public class ControlePintura implements Runnable {

	private Thread thread;
	private Jogo jogo;
	private List<TileMap> maps;
	public static List<Rectangle> colisao;
	private Personagem personagem;
	private Lobo lobo;
	private TelaQuestao questao;
	private TelaMensagem mensagem;
	private boolean loop =true;
	Pergunta question;
	private List<Vilao> vilao;
	private TelaFrame telaframe;
	
	public ControlePintura(Jogo jogo, List<TileMap> maps, Personagem personagem, Lobo lobo, TelaQuestao questao,List<Vilao> vilao) {
		super();
		this.jogo = jogo;
		this.maps = maps;
		this.personagem = personagem;
		this.lobo = lobo;
		this.questao = questao;
		this.vilao = vilao;

		colisao = maps.get(1).montarColisao();

		thread = new Thread(this);
		thread.start();
	}

	public void atualizar() {
		if (personagem.getBounds().intersects(lobo.getRectangle())) {
			questao.setVisible(true);
			question = BasePerguntas.getPergunta().get(0);
			questao.setPergunta(question.getPergunta());
			
			jogo.setVisible(false);
			loop = false;

		}
		questao.repaint();
		for (TileMap tileMap2 : maps) {
			tileMap2.montarMapa();
		}
		for (Vilao v : vilao) {
			if (personagem.getBounds().intersects(v.getBounds())) {
				JOptionPane.showMessageDialog(mensagem, "Você perdeu!!");
				System.exit(0);

			}
		}
	}

	public Pergunta getQuestion() {
		return question;
	}

	public void desenhar() {

		for (TileMap tileMap : maps) {
			jogo.getGraphicsFundo().drawImage(tileMap.getMapa(), 0, 0, null);
				jogo.getGraphicsFundo().drawImage(lobo.getImagemObj().getImage(), lobo.getX()+2, lobo.getY()+2, null);
				personagem.draw(jogo.getGraphicsFundo());

		for (Vilao v : vilao) {
			v.draw(jogo.getGraphicsFundo());
		}
		}

	}

	@Override
	public void run() {

		while (true) {

			if (loop) {
				atualizar();
				desenhar();
				jogo.requestFocus();
				jogo.repaint();
				try {
					thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
