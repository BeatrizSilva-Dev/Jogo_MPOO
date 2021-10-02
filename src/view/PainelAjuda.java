package view;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelAjuda extends JPanel{
	
	
	private JLabel imagemfundolbl;
	private ImageIcon imagemfundo,imagemvoltar;
	private JButton voltarJButton;
	public PainelAjuda() {
		setSize(512, 512);
		setLayout(null);
		
		imagemfundo = new ImageIcon(getClass().getResource("/ajudaInstrucao.png"));
		imagemvoltar = new ImageIcon(getClass().getResource("/voltarBotao.png"));
		
		imagemfundolbl = new JLabel(imagemfundo);
		voltarJButton = new JButton(imagemvoltar);
		
		imagemfundolbl.setBounds(0, 0, TelaFrame.LARGURA, TelaFrame.ALTURA);
		
		
		voltarJButton.setBounds(450, 20, 45, 45);
		
		add(voltarJButton);
		add(imagemfundolbl);

		


	}
	public JButton getVoltarJButton() {
		return voltarJButton;
	}
	
}