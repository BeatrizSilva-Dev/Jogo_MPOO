package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import app.App;
import model.Lobo;
import model.Personagem;
import model.TileMap;
import model.Vilao;
import view.Inventario;
import view.PainelAjuda;
import view.PainelGanhou;
import view.PainelInicial;
import view.PainelPerdeu;
import view.PainelSobre;
import view.TelaFrame;
import view.TelaMensagem;
import view.TelaQuestao;

public class ControleTelas implements ActionListener{
	private TelaFrame telaframe;
	private PainelInicial painelInicial;
	private TelaQuestao questao;
	private Lobo lobo;
	private Inventario inventario;
	private boolean resposta;
	Personagem personagem;
	ControlePintura controlePintura;
	ControleTratamentoPersonagem controleTratamentoPersonagem;
	private List<TileMap> maps;
	private TelaMensagem mensagem;
	private List<Vilao> vilao;
	PainelAjuda ajuda;
	PainelSobre sobre;
	PainelGanhou ganhou;
	PainelPerdeu perdeu;
	ControleTratamentoVilao controleTratamentoVilao;
	
	public ControleTelas(TelaFrame telaframe, Inventario inventario) {
		super();
		this.telaframe = telaframe;
		this.painelInicial = telaframe.getPainelInicial();
		this.questao = new TelaQuestao();
		this.inventario = inventario;
		mensagem = new TelaMensagem();
		
		try {
			maps = new ArrayList<TileMap>();
			maps.add(new TileMap(16, 16, 32, 32,"tiled_1.png", "camada_1.txt"));
			maps.add(new TileMap(16, 16, 32, 32, "tiled_1.png", "camada_2.txt"));
			personagem = new Personagem(0, 128, 192, 4, 4, 30, 425, "personagem.png");
			lobo = new Lobo(425, 30, "lobo.png");
			vilao = new ArrayList<Vilao>();
			vilao.add(new Vilao(0, 192, 256, 4, 4, 200, 250, "vilao.png"));
			vilao.add(new Vilao(0, 128, 192, 4, 4, 100, 60, "death.png"));
		} catch (Exception e2) {
			System.out.println("erro no sprite");
		}

	}

	public void control() {
		painelInicial.getJogarbutton().addActionListener(this);
		painelInicial.getAjudaButton().addActionListener(this);
		painelInicial.getSobreButton().addActionListener(this);
		painelInicial.getSairbutton().addActionListener(this);
		inventario.getVoltarButton().addActionListener(this);
		telaframe.ajuda.getVoltarJButton().addActionListener(this);
		telaframe.sobre.getVoltarbutton().addActionListener(this);
		questao.getVerdadeirobutton().addActionListener(this);
		questao.getFalsobutton().addActionListener(this);
		telaframe.ganhou.getImagemXButton().addActionListener(this);
		telaframe.perdeu.getImagemXButton().addActionListener(this);
		
	}
	

	public void verificarResposta() {
		if (controlePintura.question.isRespostas() == resposta) {
			telaframe.show("Pganhou");
			questao.setVisible(false);
		} else {
			telaframe.show("Pperdeu");
			questao.setVisible(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == painelInicial.getJogarbutton()) {
			telaframe.show("g");

			controlePintura = new ControlePintura(telaframe.getGame(), maps, personagem, lobo, questao, vilao);

			controleTratamentoPersonagem = new ControleTratamentoPersonagem(telaframe.getGame(), personagem, lobo);
			
			controleTratamentoVilao = new ControleTratamentoVilao(vilao);
			
		}
		if (e.getSource() == painelInicial.getAjudaButton()) {
			telaframe.show("Pajuda");
		}
		if (e.getSource() == painelInicial.getSobreButton()) {
			telaframe.show("Psobre");
		}
		if (e.getSource() == painelInicial.getSairbutton()) {
			System.exit(0);
		}
		if (e.getSource() == inventario.getVoltarButton()) {
			telaframe.show("PI");
		}
		if ((e.getSource() == telaframe.ajuda.getVoltarJButton() )) {
			telaframe.show("PI");
		}
		if ((e.getSource() == telaframe.sobre.getVoltarbutton())) {
			telaframe.show("PI");
		}
		if (e.getSource() == questao.getVerdadeirobutton()) {
			 resposta = true;
			 verificarResposta();
		}
		if (e.getSource() == questao.getFalsobutton()) {
			resposta = false;
			 verificarResposta();
		}
		if (e.getSource() == telaframe.ganhou.getImagemXButton()) {
			String[] opcoes = { "Sim", "Não" };
			int respostas = JOptionPane.showOptionDialog(null, "Deseja encerrar o jogo?", "",
					JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			if (respostas == JOptionPane.YES_OPTION) {
				System.exit(0);
			}else {
			reiniciarJogo();
			}
		}
		if (e.getSource() == telaframe.perdeu.getImagemXButton()) {
			String[] opcoes = { "Sim", "Não" };
			int respostas = JOptionPane.showOptionDialog(null, "Deseja encerrar o jogo?", "",
					JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			if (respostas == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			reiniciarJogo();
		}
	}
	private void reiniciarJogo() {
		telaframe.dispose();
		telaframe.show("PI");
		TelaFrame frame = new TelaFrame();
		TelaQuestao questao = new TelaQuestao();
		ControleTelas telas = new ControleTelas(frame, frame.getInventario());
		telas.control();

	}
	
}
