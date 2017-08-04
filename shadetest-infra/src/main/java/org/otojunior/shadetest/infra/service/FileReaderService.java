/**
 * 
 */
package org.otojunior.shadetest.infra.service;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>FileReaderService class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
public class FileReaderService {
	/***/
	private static final Logger LOG = LoggerFactory.getLogger(FileReaderService.class);
	
	/**
	 * <p>read.</p>
	 *
	 * @param arquivo a {@link java.lang.String} object.
	 * @return a {@link java.lang.String} object.
	 */
	public String read(String arquivo) {
		StringBuilder buffer = new StringBuilder();
		try (RandomAccessFile r = new RandomAccessFile(arquivo, "r")) {
			String linha = r.readLine();
			while (linha != null) {
				if (LOG.isDebugEnabled()) {
					LOG.debug("linha lida: " + linha);
				}
				
				buffer.
					append(linha).
					append(SystemUtils.LINE_SEPARATOR);
				linha = r.readLine();
			}
		} catch (IOException e) {
			LOG.error("Erro de I/O", e);
		}
		return buffer.toString();
	}
}
