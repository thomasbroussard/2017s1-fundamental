/**
 * 
 */
package fr.epita.iam.tests.services;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author tbrou
 *
 */
public class TestXML {
	
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		
		
		DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = newDocumentBuilder.parse(new File("identities.xml"));
		
		NodeList list = document.getElementsByTagName("identity");
		int length = list.getLength();
		System.out.println(length);
		for (int i=0 ; i < length ; i++){
			if (!(list.item(i) instanceof Element)){
				continue;
			}
			Element identityElement = (Element) list.item(i);
			NodeList properties = identityElement.getChildNodes();
			
			int propertiesLength = properties.getLength();
			for (int j=0 ; j < propertiesLength; j++){
				if (!(properties.item(j) instanceof Element)){
					continue;
				}
				Element propertyElement = (Element) properties.item(j);
				String propertyName = propertyElement.getAttribute("name");
				String propertyValue= propertyElement.getTextContent();
				System.out.println("propertyName = " + propertyName + ", propertyValue =" + propertyValue);
			}
			
		}
		
		
	}
	
}
