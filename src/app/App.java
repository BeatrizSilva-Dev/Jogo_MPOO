package app;

import java.util.ArrayList;
import java.util.List;

import controller.ControlePintura;
import controller.ControleTelas;
import controller.ControleTratamentoPersonagem;
import model.BasePerguntas;
import model.Lobo;
import model.Personagem;
import model.TileMap;
import view.Inventario;
import view.TelaFrame;
import view.TelaQuestao;

public class App {
	
	public static void main(String[] args) {
		
		BasePerguntas.gerarPerguntas();
		
		TelaFrame teste = new TelaFrame();
		TelaQuestao questao = new TelaQuestao();
		
		
		ControleTelas telas = new ControleTelas(teste, teste.getInventario());
//		ControleTratamentoPersonagem tratamento = new ControleTratamentoPersonagem(teste.getGame(), personagem,lobo);
		telas.control();
	}
	
	
	
}
