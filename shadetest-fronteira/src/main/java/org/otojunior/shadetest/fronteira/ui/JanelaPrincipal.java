/**
 * 
 */
package org.otojunior.shadetest.fronteira.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.otojunior.shadetest.dominio.service.TextFileReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Janela Principal
 * @author Oto Junior
 */
public class JanelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(JanelaPrincipal.class);
	
	/**
	 * Construtor padrão.
	 */
	public JanelaPrincipal() {
		this.setSize(200, 100);
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
		
		this.add(painelBotoes, BorderLayout.SOUTH);
		this.add(new JLabel("Teste Shade"), BorderLayout.CENTER);
	}
}
