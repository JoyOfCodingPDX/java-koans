package com.sandwich.koan.path.xmltransformation;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XmlToPathTransformerImplTest {

	@Test
	public void extractKoansReadsRequireAssertionAttribute() throws Exception {
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new ByteArrayInputStream((
					"<suite class=\"AboutKoans\">"
					+ "<koan name=\"findAboutKoansFile\" displayIncompleteKoanException=\"false\" requireAssertion=\"false\" />"
					+ "</suite>").getBytes("UTF-8")));
		NodeList nodes = document.getDocumentElement().getChildNodes();
		KoanElementAttributes koan = new XmlToPathTransformerImpl()
				.extractKoansAndRawLessons("beginner.AboutKoans", nodes)
				.get("findAboutKoansFile");

		assertEquals("false", koan.displayIncompleteKoanException);
		assertEquals("false", koan.requireAssertion);
	}
}
