package controller;

import java.util.List;
import java.util.Random;

import model.Vilao;

public class ControleTratamentoVilao extends Thread{
	List<Vilao> vilao;
	private Random random;
	private boolean loop = true;

	ControleTratamentoVilao(List<Vilao> vilao) {
		this.vilao = vilao;
		random = new Random();
		
		start();
	}

	@Override
	public void run() {
		while(loop) {
			for (Vilao v : vilao) {
				v.setDirecao(Vilao.direcoes.get(random.nextInt(Vilao.direcoes.size())));
			
				while (v.getQuantidadePassos() > 0) {
					v.mover(v.getDirecao());
					v.setQuantidadePassos(v.getQuantidadePassos() - 1);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						System.out.println("Erro");
						e.printStackTrace();
					}
				}
				v.setQuantidadePassos(random.nextInt(100) + 100);
			}
		}
		
	}
	
}
