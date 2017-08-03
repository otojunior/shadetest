/**
 * 
 */
package org.otojunior.shadetest.checainstancia;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

import javax.swing.JOptionPane;

import com.izforge.izpack.panels.process.AbstractUIProcessHandler;

/**
 * @author 01456231650
 *
 */
public class ChecaInstanciaAoInstalar {
	/**
	 * 
	 * @param handler
	 * @param args
	 */
	@SuppressWarnings("resource")
	public void run(AbstractUIProcessHandler handler, String[] args) {
		FileLock lock = null;
        File file = new File(System.getProperty("user.home"), ".shadetestlock");
        RandomAccessFile randomAccessFile = null;
        try {
        	randomAccessFile = new RandomAccessFile(file, "rw");
            lock = randomAccessFile.getChannel().tryLock();
            if (lock == null) {
            	JOptionPane.showMessageDialog(null, "Uma instância está em execução");
            	System.exit(1);
            	//throw new RuntimeException("Uma instância da aplicação está executando");
            }
        } catch (IOException e) {
        	throw new RuntimeException(e);
        }
	}
}
