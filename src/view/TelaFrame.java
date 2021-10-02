package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaFrame extends JFrame {

	public static final int LARGURA = 512, ALTURA = 512;

	private Jogo jogo;
	private PainelInicial painelInicial;
	private CardLayout cardlayout;
	private Inventario inventario;
	public PainelAjuda ajuda;
	public PainelSobre sobre;
	public PainelGanhou ganhou;
	public PainelPerdeu perdeu;

	public PainelGanhou getGanhou() {
		return ganhou;
	}

	public TelaFrame() {
		cardlayout = new CardLayout();

		setSize(LARGURA,ALTURA);
		setLayout(cardlayout);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);

		painelInicial = new PainelInicial();
		jogo = new Jogo();
		inventario = new Inventario();
		ajuda = new PainelAjuda();
		sobre = new PainelSobre();
		ganhou = new PainelGanhou();
		perdeu = new PainelPerdeu();

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, LARGURA + 150,ALTURA);

		panel.add(jogo).setBounds(0, 0, LARGURA, ALTURA);
		panel.add(inventario).setBounds(LARGURA, 0, 150, ALTURA);

		add(painelInicial,"PI");
		add(panel,"g");
		add(ajuda, "Pajuda");
		add(sobre, "Psobre");
		add(ganhou, "Pganhou");
		add(perdeu,"Pperdeu");

		cardlayout.show(getContentPane(), "PI");

		setVisible(true);

	}

	public Jogo getJogo() {
		return jogo;
	}

	public PainelAjuda getAjuda() {
		return ajuda;
	}

	public PainelSobre getSobre() {
		return sobre;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void show(String indice) {
		if(indice.equals("g"))
			setSize(LARGURA+150, ALTURA);
		else 
			setSize(LARGURA, ALTURA);
		setLocationRelativeTo(null);

		cardlayout.show(getContentPane(), indice);
	}

	public PainelInicial getPainelInicial() {
		return painelInicial;
	}

	public Jogo getGame() {
		return jogo;
	}




}
