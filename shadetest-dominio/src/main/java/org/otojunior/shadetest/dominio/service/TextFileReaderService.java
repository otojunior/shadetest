/**
 * 
 */
package org.otojunior.shadetest.dominio.service;

import org.otojunior.shadetest.infra.service.FileReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
public class TextFileReaderService {
	/***/
	private static final Logger LOG = LoggerFactory.getLogger(TextFileReaderService.class);
	
	private FileReaderService service;
	
	/**
	 * Construtuor padrão.
	 */
	public TextFileReaderService() {
		service = new FileReaderService();
	}
	
	/**
	 * 
	 * @return
	 */
	public String read() {
		StringBuilder buffer = new StringBuilder();
		for (int i = 1; i <= 2; i++) {
			String arquivo = String.format("recursos/tabelas/tabela%d.txt", i);
			String read = service.read(arquivo);

			if (LOG.isDebugEnabled()) {
				LOG.debug("Conjunto lido: " + read);
			}
			
			buffer.append(read);
		}
		return buffer.toString();
	}
}
