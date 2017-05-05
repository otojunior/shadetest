/*
 * Copyright [2015] [Oto Soares Coelho Junior]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.otojunior.shadetest.infra.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manifest reader utilitary class.
 * 
 * @author Oto Junior
 */
public class ManifestUtil {
	/* Logger */
	private static final Logger LOG = LoggerFactory.getLogger(ManifestUtil.class);
	/* Manifest Path */
	private static final String MANIFEST_PATH = "META-INF/MANIFEST.MF";
	
	/* Public constants presents in manifest attributes. */
	public static final String CREATED_BY 					= "Created-By";
	public static final String BUILD_JDK 					= "Build-Jdk";
	public static final String BUILT_BY 					= "Built-By";
	public static final String IMPLEMENTATION_BRANCH 		= "Implementation-Branch";
	public static final String IMPLEMENTATION_BUILD 		= "Implementation-Build";
	public static final String IMPLEMENTATION_DATE 			= "Implementation-Date";
	public static final String IMPLEMENTATION_TITLE 		= "Implementation-Title";
	public static final String IMPLEMENTATION_VENDOR 		= "Implementation-Vendor";
	public static final String IMPLEMENTATION_VENDOR_ID 	= "Implementation-Vendor-Id";
	public static final String IMPLEMENTATION_VERSION 		= "Implementation-Version";
	public static final String SPECIFICATION_TITLE 			= "Specification-Title";
	public static final String SPECIFICATION_VENDOR 		= "Specification-Vendor";
	public static final String SPECIFICATION_VERSION 		= "Specification-Version";

	/**
	 * Manifest Attributes.
	 */
	private static Attributes attributes;
	
	/*
	 * Initialization block.
	 * Reads the manifest.
	 */
	static {
		loadManifest();
	}
	
	/**
	 * Construtor privado vazio.
	 */
	private ManifestUtil() { }
	
	/**
	 * Get the manifest attribute value.
	 * @param name the attribute name specified.
	 * @return The value of attribute.
	 */
	public static String getAttribute(String name) {
		String value = null;
		if (attributes != null) {
			value = attributes.getValue(name);
		}
		return value;
	}
	
	/**
	 * Get the manifest attribute value.
	 * @param name the attribute name specified.
	 * @param reload Reloads manifest before get the attribute value.
	 * @return The value of attribute.
	 */
	public static String getAttribute(String name, boolean reload) {
		if (reload) {
			loadManifest();
		}
		return getAttribute(name);
	}
	
	/**
	 * Loads the manifest.
	 */
	private static void loadManifest() {
		try {
			InputStream is = ManifestUtil.class.
				getClassLoader().
				getResourceAsStream(MANIFEST_PATH);
			if (is != null) {
				Manifest manifest = new Manifest(is);
				attributes = manifest.getMainAttributes();
			}
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
