package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BasePerguntas {
	private static ArrayList<Pergunta> pergunta = new ArrayList<>();
	private static Random random;
	
	public static void gerarPerguntas(){
		pergunta.add(new Pergunta("70+80=150?", true));
		pergunta.add(new Pergunta("9*80=730?", false));
		pergunta.add(new Pergunta("150/30=5?", true));
		pergunta.add(new Pergunta("1600-900=800?", false));
		pergunta.add(new Pergunta("90*90=8100?", true));
		pergunta.add(new Pergunta("8650/5=1730?", true));
		
		Collections.shuffle(pergunta);
		
	}
	public static ArrayList<Pergunta> getPergunta(){
		return pergunta;
		
	}
	
	public static Pergunta getPerguntaAleatoria(){
		return pergunta.get(random.nextInt(pergunta.size()-1));
		
	}
			
}
