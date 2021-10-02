package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

public class TileMap {
	
	private int mapaAltura;
	private int mapaLargura;
	private int tileAltura;
	private int tileLargura;
	private int camada[][];
	private int larguraTela;
	private int AlturaTela;
	private BufferedImage tileSet;
	private BufferedImage mapa;

	private Graphics2D dbg;
	private Rectangle objetivo;
	private List<Rectangle> tmp = new ArrayList<Rectangle>();
	
	
	public TileMap(int mapaLargura, int mapaAltura, int tileLargura, int tileAltura, String nomeTileSet, String nomeMapaMatriz) {
		
		this.mapaLargura = mapaLargura;
		this.mapaAltura = mapaAltura;
		this.tileLargura = tileLargura;
		this.tileAltura = tileAltura;
		
		larguraTela = mapaLargura * tileLargura;
		AlturaTela = mapaAltura * tileAltura;
		
		mapa = new BufferedImage(larguraTela, AlturaTela, BufferedImage.TYPE_4BYTE_ABGR);
		dbg = mapa.createGraphics();
		
		try {
			tileSet=ImageIO.read(getClass().getClassLoader().getResourceAsStream(nomeTileSet));
		} catch (IOException e) {
			System.out.println("Nao conseguiu ler o Tileset");
			e.printStackTrace();
		}
		
		camada = carregarMatriz(nomeMapaMatriz);
		montarMapa();
	
	}
	public void montarMapa() {

		int tile;
		int tileRow;
		int tileCol;
		int colunasTileSet=tileSet.getWidth()/tileLargura;
		
		for (int i = 0; i < mapaLargura; i++) {
			for (int j = 0; j < mapaAltura; j++) {
				tile = (camada[i][j] != 0) ? (camada[i][j] - 1) : 0;
				tileRow = (tile / colunasTileSet) | 0;
				tileCol = (tile % colunasTileSet) | 0;
				dbg.drawImage(tileSet, (j * tileAltura), (i * tileLargura), (j * tileAltura) + tileAltura,
						(i * tileLargura) + tileLargura, (tileCol * tileAltura), (tileRow * tileLargura),
						(tileCol * tileAltura) + tileAltura, (tileRow * tileLargura) + tileLargura, null);

				
			}
		}
		
	}

	
	public List<Rectangle> montarColisao() {
		for (int i = 0; i < mapaLargura; i++) {
			for (int j = 0; j < mapaAltura; j++) {
				if(camada[i][j] != 0) {
					tmp.add(new Rectangle( (j * tileAltura), (i * tileLargura), tileLargura, tileAltura));
				}		
			}
		}
//		objetivo = new Rectangle(512,0,1,512);
//		tmp.add(objetivo);
//		tmp.add(new Rectangle(0, 0, 1, 512));
		return tmp;
		
	}
//	public void remover(){
//		tmp.remove(objetivo);
//	}
	
	public int[][] carregarMatriz(String nomeMapa) {
		int[][] matz = new int[mapaLargura][mapaAltura];

		InputStream is = getClass().getClassLoader().getResourceAsStream(nomeMapa);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		ArrayList<String> linhas = new ArrayList<String>();
		String linha = "";

		try {
			while ((linha = br.readLine()) != null)
				linhas.add(linha);

			int j = 0;
			for (int i = 0; i < linhas.size(); i++) {
				StringTokenizer token = new StringTokenizer(linhas.get(i), ",");

				while (token.hasMoreElements()) {
					matz[i][j] = Integer.parseInt(token.nextToken());
					j++;
				}
				j = 0;
			}

		} catch (IOException e) {
			System.out.println("Não carregou a Matriz");
			e.printStackTrace();
		}

		return matz;
	}

	
	public BufferedImage getMapa() {
		return mapa;
	}
	public int getLarguraTela() {
		return larguraTela;
	}
	public int getAlturaTela() {
		return AlturaTela;
	}
	
}

