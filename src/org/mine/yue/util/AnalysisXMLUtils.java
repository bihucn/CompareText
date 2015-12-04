package org.mine.yue.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.mine.yue.domain.AddItem;
import org.mine.yue.domain.PropertyItem;

public class AnalysisXMLUtils {

	@SuppressWarnings({ "unchecked", "static-access" })
	public static List<AddItem> AnalysisXML(){
		List<AddItem> addItemList = new ArrayList<>();
		
		
		
		FileInputStream inputStream = null;
		Document doc = null;
		try {
			inputStream = new FileInputStream("F:/test.xml");
			doc = new SAXReader().read(inputStream);
			Element root = doc.getRootElement();
			
			
			Element importElement = root.element("import-items");
			
			List<Element> addList = importElement.elements("add-item");
			if(addList.size()==0){
				System.out.println("no items");
				return null;
			}
			
			
			for (int i = 0; i < addList.size(); i++) {
				
				List<String> addComments = new ArrayList<>();
				List<PropertyItem> proItemList = new ArrayList<>();
				
				Element addElem = addList.get(i);
				AddItem addItem = new AddItem();
				
				addItem.setId(addElem.attributeValue("id"));
				addItem.setItemDescriptor(addElem.attributeValue("item-descriptor"));
				
				for (Iterator<Node> nodeIterator =addElem.nodeIterator(); nodeIterator.hasNext();) {
					
					Node node = nodeIterator.next();
					if(node != null){
			            if(node.getNodeType()==node.COMMENT_NODE){
			                addComments.add("<!--"+node.getText()+" -->");
			            }
			        }
					
				}
				
				addItem.setComment(addComments);
				
				for(Iterator<Element> elemIterator = addElem.elementIterator();elemIterator.hasNext();){
					
					PropertyItem proItem = new PropertyItem();
					
					Element elem = elemIterator.next();
					if(elem != null){
						proItem.setName(elem.attributeValue("name"));
						proItem.setValue("<![CDATA["+elem.getText()+"]]>");
						proItemList.add(proItem);
					}
					  
				}
				addItem.setPropertyItems(proItemList);
				addItemList.add(addItem);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {

			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return addItemList;
		
	}
	
}
