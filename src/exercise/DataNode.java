package exercise;

import java.util.ArrayList;
import java.util.List;

public class DataNode {

	private String data = null;
	private List<DataNode> children = new ArrayList<>();
	private DataNode parent = null;
	private boolean collapse = false;
	private boolean selection = false;
	private List<DataNode> selected = new ArrayList<>();

	// constructor for DataNode
	public DataNode(String data) {
		this.data = data;
	}

	public DataNode addChild(DataNode child) {
		child.setParent(this);
		this.children.add(child);
		return child;
	}

	public void addChildren(List<DataNode> children) {
		children.forEach(each -> each.setParent(this));
		this.children.addAll(children);

	}

	public List<DataNode> getChildren() {
		return children;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private void setParent(DataNode parent) {
		this.parent = parent;
	}

	public DataNode getParent() {
		return parent;
	}

	public void ChangeExpand() {
		if (collapse == true) {
			collapse = false;
			getChildren().forEach(each -> ChangeExpand());
		} else {
			collapse = true;
			getChildren().forEach(each -> ChangeExpand());
		}
	}

	public boolean IsExpanded() {
		return collapse;
	}

	public void Selection() {
		if (selection == true) {
			selection = false;
			if (collapse == true) {
				getChildren().forEach(each -> Selection());
				this.children.removeAll(selected);
			}
		} else {
			selection = true;
			if (collapse == true) {
				getChildren().forEach(each -> Selection());
				for (DataNode dataNode : selected) {
					if (!data.equals(dataNode.getData())) {
						this.children.addAll(selected);
					}
				}
			}
		}
	}

	public boolean IsSelected() {
		return selection;
	}

}
