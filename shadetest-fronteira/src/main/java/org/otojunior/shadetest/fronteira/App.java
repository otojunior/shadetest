package org.otojunior.shadetest.fronteira;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

import org.otojunior.shadetest.fronteira.ui.JanelaPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 *
 * @author Oto Junior
 * @version $Id: $Id
 */
public class App {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	/**
	 * Application main method.
	 *
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		LOG.info("shadetest Application.");
		
		/*
		 * Proteção contra múltiplas instâncias em execução. 
		 */
		if (isProgramaExecutando()) {
			LOG.info("Uma instância da aplicação ShadeTest, já se encontra em execução");
			System.exit(1);
		}
		
		new JanelaPrincipal().setVisible(true);
	}
	
	/**
     * Verifica se a aplicação está rodando. 
     * Este método é útil quando há várias versões instaladas
     * e somente uma deve executar por vez. 
     * @return true se o programa estiver executando.
     */
    private static boolean isProgramaExecutando() {
        FileLock lock = null;
        File file = new File(System.getProperty("user.home"), ".shadetestlock");
        RandomAccessFile randomAccessFile = null;
        try {
        	randomAccessFile = new RandomAccessFile(file, "rw");
            lock = randomAccessFile.getChannel().tryLock();
        } catch (IOException e) {
        	LOG.error(e.getMessage());
        }
        return (lock == null);
    }
}
