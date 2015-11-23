/**
 * 
 */
package org.otojunior.shadetest.dominio.service;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class FileTextReaderService {
	private static final Logger LOG = LoggerFactory.getLogger(FileTextReaderService.class);
	
	/**
	 * 
	 * @return
	 */
	public String read() {
		StringBuilder buffer = new StringBuilder();
		try {
			for (int i = 1; i <= 2; i++) {
				String arquivo = String.format("recursos/tabelas/tabela%d.txt", i);
				RandomAccessFile r = new RandomAccessFile(arquivo, "r");
				String linha = r.readLine();
				while (linha != null) {
					buffer.
						append(linha).
						append(SystemUtils.LINE_SEPARATOR);
					linha = r.readLine();
				}
				r.close();
			}
		} catch (IOException ioe) {
			LOG.error("Erro de I/O", ioe);
		}
		return buffer.toString();
	}
}
