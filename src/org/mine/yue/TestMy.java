package org.mine.yue;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.mine.yue.domain.AddItem;
import org.mine.yue.domain.PropertyItem;


public class TestMy {
	
	
	public static void main(String[] args) throws DocumentException {
		
		List<AddItem> addItemList = new ArrayList<>();
		
		
		File f = new java.io.File("test.xml");
		Document doc = new SAXReader().read(f);
		Element root = doc.getRootElement();
		
		
		Element importElement = root.element("import-items");
		
		List<Element> addList = importElement.elements("add-item");
		
		for (Element addNode : addList) {
			
			AddItem addItem = new AddItem();
			addItem.setId(addNode.attributeValue("id"));
			addItem.setItemDescriptor(addNode.attributeValue("item-descriptor"));
			
			System.out.println("< item-descriptor="+addItem.getItemDescriptor()+"  id="+addItem.getId()+" >");
			
			for (Iterator<Node> nodeIterator =addNode.nodeIterator(); nodeIterator.hasNext();) {
				 Node node = nodeIterator.next();
				 if(node!=null){
					 if(node.getNodeType() == node.COMMENT_NODE){
						 String text = node.getText();
						 System.out.println(text);
					 }
					 if(node.getNodeType() == node.ELEMENT_NODE){
						 String nodeName = node.getName();
						 System.out.println("nodeName = "+nodeName);
						 PropertyItem item = new PropertyItem();
						 
					 }
					 
				 }
				
			}
			
			addItemList.add(addItem);
			
			
		}
		
		
		
	}

}
