package at.ac.tuwien.infosys.wadl2java.xml;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Node;

import at.ac.tuwien.infosys.java2wadl.WadlException;
import at.ac.tuwien.infosys.java2wadl.util.UriUtil;
import at.ac.tuwien.infosys.java2wadl.util.XPathUtil;
import at.ac.tuwien.infosys.java2wadl.util.XmlUtil;
import at.ac.tuwien.infosys.java2wadl.wadl.IFaultReference;
import at.ac.tuwien.infosys.wadl2java.Wadl2JavaBaseTest;

public class FaultReferenceParserTest extends Wadl2JavaBaseTest {

	public static void assertEqualsFaultReferenceFixture(IFaultReference faultReference) throws WadlException {
		assertEquals(UriUtil.createUri("href"), faultReference.getHref());
	}

	@Test
	public void testParseRepresentationReference() throws FileNotFoundException, WadlException {
		String xml = loadResource("at.ac.tuwien.infosys.wadl2java.xml.FaultReferenceTestCase.txt");
		List<Node> resultNodes = XmlUtil.toList(XPathUtil.query(xml, "//*[1]"));

		assertEquals(1, resultNodes.size());
		for (Node node : resultNodes) {
			assertEqualsFaultReferenceFixture(new FaultReferenceParser().parse(node));
		}
	}
}
