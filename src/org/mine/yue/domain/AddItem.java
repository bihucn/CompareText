package org.mine.yue.domain;

import java.util.List;

public class AddItem {
	private String itemDescriptor;
	private String id;
	
	private List<PropertyItem> propertyItems;
	private String comment;
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<PropertyItem> getPropertyItems() {
		return propertyItems;
	}
	public void setPropertyItems(List<PropertyItem> propertyItems) {
		this.propertyItems = propertyItems;
	}
	public String getItemDescriptor() {
		return itemDescriptor;
	}
	public void setItemDescriptor(String itemDescriptor) {
		this.itemDescriptor = itemDescriptor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
