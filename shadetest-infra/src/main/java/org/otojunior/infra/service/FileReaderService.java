/**
 * 
 */
package org.otojunior.infra.service;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class FileReaderService {
	/***/
	private static final Logger LOG = LoggerFactory.getLogger(FileReaderService.class);
	
	/**
	 * 
	 * @param arquivo
	 * @return
	 */
	public String read(String arquivo) {
		StringBuilder buffer = new StringBuilder();
		try {
			RandomAccessFile r = new RandomAccessFile(arquivo, "r");
			String linha = r.readLine();
			while (linha != null) {
				LOG.debug("linha lida: " + linha);
				buffer.
					append(linha).
					append(SystemUtils.LINE_SEPARATOR);
				linha = r.readLine();
			}
			r.close();
		} catch (IOException e) {
			LOG.error("Erro de I/O", e);
		}
		return buffer.toString();
	}

}
