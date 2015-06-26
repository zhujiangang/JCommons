package org.jcommons.common;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jcommons.file.FileUtils;

public class Test {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		Document doc = DocumentHelper.parseText(FileUtils.readFile(new File(
				"D:/xml.xml")));
		Element root = doc.getRootElement();
		System.out.println(root.element("soapBody"));
		List<Element> eles = root.elements();
		Element ele1 = (Element) eles.get(0).elements().get(0);
		Element ele2 = (Element) ele1.elements().get(0);
		System.out.println(ele2.getData());
	}

}
