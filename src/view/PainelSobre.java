package view;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelSobre extends JPanel{
	
	
	private JLabel imagemfundolbl;
	private ImageIcon imagemfundo,imagemvoltar;
	private JButton voltarbutton;
	public PainelSobre() {
		setSize(TelaFrame.LARGURA, TelaFrame.ALTURA);
		setLayout(null);
		
		imagemfundo = new ImageIcon(getClass().getResource("/sobreJogo.png"));
		imagemvoltar = new ImageIcon(getClass().getResource("/voltarBotao.png"));
		
		imagemfundolbl = new JLabel(imagemfundo);
		voltarbutton = new JButton(imagemvoltar);
		
		imagemfundolbl.setBounds(0, 0, TelaFrame.LARGURA, TelaFrame.ALTURA);
		voltarbutton.setBounds(440, 20, 45, 45);
		
		
		add(voltarbutton);
		add(imagemfundolbl);
		
		

	}
	public JButton getVoltarbutton() {
		return voltarbutton;
	}
}
