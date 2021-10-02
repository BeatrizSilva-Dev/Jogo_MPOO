package view;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaQuestao extends JFrame{
	
	private ImageIcon imagem,imagemV,imagemSair,imagemF;
	private JButton verdadeirobutton, falsobutton;
	private String pergunta = "pergunta";
	
	public TelaQuestao() {
		setSize(300, 250);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		imagem = new ImageIcon(getClass().getResource("/tela1.png"));
		imagemV = new ImageIcon(getClass().getResource("/v.png"));
		imagemF = new ImageIcon(getClass().getResource("/f.png"));
		
		verdadeirobutton = new JButton(imagemV);
		
		verdadeirobutton.setBorderPainted(false);
		verdadeirobutton.setFocusPainted(false);
		verdadeirobutton.setContentAreaFilled(false);
		
		falsobutton = new JButton(imagemF);
		
		falsobutton.setBorderPainted(false);
		falsobutton.setFocusPainted(false);
		falsobutton.setContentAreaFilled(false);
		
		
		verdadeirobutton.setBounds(50,150, 100, 60);
		falsobutton.setBounds(150, 150, 100, 60);
		
		
		add(verdadeirobutton);
		add(falsobutton);
		
//		setVisible(false);
		
		JPanel p = new JPanel(){
			
			protected void paintComponent(Graphics g){
				g.drawImage(imagem.getImage(),0,0,null);
				g.setColor(Color.WHITE);
				g.drawString(pergunta, 100, 100);
			}
		};
		p.setBounds(0, 0, 300, 250);
		add(verdadeirobutton);
		add(falsobutton);
		add(p);
		

	}

	public JButton getVerdadeirobutton() {
		return verdadeirobutton;
	}

	public JButton getFalsobutton() {
		return falsobutton;
	}
	public void setPergunta(String pergunta){
		this.pergunta = pergunta;
	}
}
