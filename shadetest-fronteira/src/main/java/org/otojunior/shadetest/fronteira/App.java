package org.otojunior.shadetest.fronteira;

import org.otojunior.shadetest.fronteira.ui.JanelaPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author Oto Junior
 */
public class App {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		LOG.info("shadetest Application.");
		new JanelaPrincipal().setVisible(true);
	}
}
