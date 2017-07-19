/**
 * 
 */
package org.otojunior.shadetest.infra.util;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author 01456231650
 *
 */
@Ignore
public class ManifestUtilTest {

	/**
	 * Test method for {@link org.otojunior.shadetest.infra.util.ManifestUtil#getAttribute(java.lang.String)}.
	 */
	@Test
	public final void testGetAttributeString() {
		String attribute = ManifestUtil.getAttribute(ManifestUtil.BUILD_JDK);
		assertEquals("1.8.0_111", attribute);
	}

	/**
	 * Test method for {@link org.otojunior.shadetest.infra.util.ManifestUtil#getAttribute(java.lang.String, boolean)}.
	 */
	@Test
	public final void testGetAttributeStringBoolean() {
		String attribute = ManifestUtil.getAttribute(ManifestUtil.BUILD_JDK, true);
		assertEquals("1.8.0_111", attribute);
	}
}
