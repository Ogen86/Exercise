package exercise;

public class Main {

	private static DataNode createTree() {
		DataNode root = new DataNode("root");

		DataNode node1 = root.addChild(new DataNode("node 1"));

		DataNode node11 = node1.addChild(new DataNode("node 11"));
		DataNode node111 = node11.addChild(new DataNode("node 111"));
		DataNode node112 = node11.addChild(new DataNode("node 112"));

		DataNode node12 = node1.addChild(new DataNode("node 12"));

		DataNode node2 = root.addChild(new DataNode("node 2"));

		DataNode node21 = node2.addChild(new DataNode("node 21"));

		DataNode node3 = root.addChild(new DataNode("node 3"));

		return root;
	}

	private static void printTree(DataNode node, String appender) {
		System.out.println(appender + node.getData());
		node.getChildren().forEach(each -> printTree(each, appender + appender));
	}

	private static void printSelected(DataNode node, String appender) {
		System.out.println(appender + node.getData());
		node.getChildren().forEach(each -> printSelected(each, appender + appender));
	}
	
	private static void selection(DataNode node) {
		node.Selection();
	}
	
	private static void changeExpand(DataNode node) {
		node.ChangeExpand();
	}

	public static void main(String[] args) {
		DataNode root = createTree();
		System.out.println("full tree:");
		printTree(root, " ");
		
		
		selection(root);
		

		System.out.println("selected nodes:");
		printSelected(root, " ");
	}

}
