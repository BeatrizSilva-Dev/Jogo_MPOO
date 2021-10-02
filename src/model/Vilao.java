package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

import controller.ControlePintura;

public class Vilao extends Sprite{
	private int VELOCIDADE = 4;

	public static ArrayList<String> direcoes = new ArrayList<>();

	static{
		Collections.addAll(direcoes, "cima","baixo","direita","esquerda");
	}
	public Vilao(int aparencia, int largura, int altura, int colunas, int linhas, int x, int y, String endereco) {
		super(aparencia, largura, altura, colunas, linhas, x, y, endereco);

	}

	@Override
	public void animar(String direcao) {
		if(!direcao.equals(""))
			setAparencia(getAparencia() + 1);

		if(direcao == "cima")
		{
			if(getAparencia() > 15 || getAparencia() < 12)
				setAparencia(12);

		}
		if(direcao == "baixo")
		{
			if(getAparencia() > 3)
				setAparencia(0);
		}
		if(direcao == "direita")
		{
			if(getAparencia() > 11 || getAparencia() < 8)
				setAparencia(8);
		}
		if(direcao == "esquerda")
		{
			if(getAparencia() > 7 || getAparencia() < 4)
				setAparencia(4);
		}


	}
	

	@Override
	public void draw(Graphics g) {
		g.drawImage(getSprites()[getAparencia()], getX(), getY(), getLarguraPersonagem(), getAlturaPersonagem(), null);

	}

	@Override
	public void mover(String direcao) {
		if(direcao == "cima")
		{
			setY((getY() - VELOCIDADE));
		}
		if(direcao == "baixo")
		{
			setY((getY() + VELOCIDADE));
		}
		if(direcao == "direita")
		{
			setX((getX() + VELOCIDADE));
		}
		if(direcao == "esquerda")
		{
			setX((getX() - VELOCIDADE));
		}	
		animar(direcao);
	}

	public boolean collision(List<Rectangle> tmp, int x,int y) {


		Rectangle vilao = new Rectangle(getX()+x, getY()+y, 
				getLarguraPersonagem(), getAlturaPersonagem());
		for(Rectangle rectangle : tmp) {
			if(rectangle.intersects(vilao)){

				return true;
			}
		}
		return false;
	}

	@Override
	public void setX(int x) {
		if(!collision(ControlePintura.colisao, x-getX(), 0)) {
			super.setX(x);
		}
	}

	@Override
	public void setY(int y) {
		if(!collision(ControlePintura.colisao, 0, y-getY())) {
			super.setY(y);
		}
	}
	private String direcao;
	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	private int quantidadePassos;
	public static void setDirecoes(ArrayList<String> direcoes) {
		Vilao.direcoes = direcoes;
	}

	public int getQuantidadePassos() {
		return quantidadePassos;
	}

	public void setQuantidadePassos(int quantidadePassos) {
		this.quantidadePassos = quantidadePassos;
	}
}
