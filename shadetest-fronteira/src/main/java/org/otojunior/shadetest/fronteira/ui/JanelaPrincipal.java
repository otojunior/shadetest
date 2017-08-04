/**
 * 
 */
package org.otojunior.shadetest.fronteira.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.otojunior.shadetest.dominio.service.TextFileReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Janela Principal
 *
 * @author Oto Junior
 * @version $Id: $Id
 */
public class JanelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(JanelaPrincipal.class);
	
	/**
	 * Construtor padrão.
	 */
	public JanelaPrincipal() {
		this.setSize(500, 200);
		this.setLocation(500,  500);
		this.setResizable(false);
		this.setTitle("Janela Principal - Teste Shade");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(e -> {
			TextFileReaderService service = new TextFileReaderService();
			String result = service.read();
			JOptionPane.showMessageDialog(
				JanelaPrincipal.this, 
				result);
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> {
			JanelaPrincipal.this.setVisible(false);
			JanelaPrincipal.this.dispose();
			System.exit(0);
		});
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.add(btnOk);
		painelBotoes.add(btnCancelar);
		
		String str = 
				"java.version: " + System.getProperty("java.version") + "\n" +
				"java.home: " + System.getProperty("java.home") + "\n" +
				"java.vm.name: " + System.getProperty("java.vm.name") + "\n" +
				"java.class.version: " + System.getProperty("java.class.version") + "\n" +
				"user.dir: " + System.getProperty("user.dir");
			
		JTextArea textArea = new JTextArea(str);
		textArea.setEditable(false);
		textArea.setAutoscrolls(false);
		
		this.add(painelBotoes, BorderLayout.SOUTH);
		this.add(textArea, BorderLayout.CENTER);
	}
}
