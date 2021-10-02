package model;

public class Pergunta {
	private String pergunta;
	private boolean respostas;
	
	public Pergunta(String pergunta, boolean respostas) {
		super();
		this.pergunta = pergunta;
		this.respostas = respostas;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public boolean isRespostas() {
		return respostas;
	}

	public void setRespostas(boolean respostas) {
		this.respostas = respostas;
	}
	
	
	
}
