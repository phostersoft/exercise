import java.util.ArrayList;
import java.util.List;


public class TreeBFSDFS {

	public static void main(String[] args) {
		TreeBFSDFS main = new TreeBFSDFS();
		main.run();
	}

	public void run() {
		Node tree = constructTree();
		bfs(tree);
		dfs(tree);
	}

	private void bfs(Node node) {
	}

	private void dfs(Node node) {
		System.out.println("* DFS : " + node.VALUE);
		for(Node child : node.CHILDREN) {
			dfs(child);
		}
	}

	private Node constructTree() {
		Node root = new Node();
		root.VALUE = "1";
		Node rootChild1 = new Node();
		rootChild1.VALUE = "1-1";
		Node rootChild2 = new Node();
		rootChild2.VALUE = "1-2";
		Node rootChild3 = new Node();
		rootChild3.VALUE = "1-3";
		root.CHILDREN.add(rootChild1);
		root.CHILDREN.add(rootChild2);
		root.CHILDREN.add(rootChild3);
		Node rootChild11 = new Node();
		rootChild11.VALUE = "1-1-1";
		Node rootChild12 = new Node();
		rootChild12.VALUE = "1-1-2";
		rootChild1.CHILDREN.add(rootChild11);
		rootChild1.CHILDREN.add(rootChild12);
		Node rootChild31 = new Node();
		rootChild31.VALUE = "1-3-1";
		Node rootChild32 = new Node();
		rootChild32.VALUE = "1-3-2";
		rootChild3.CHILDREN.add(rootChild31);
		rootChild3.CHILDREN.add(rootChild32);
		root.CHILDREN.add(rootChild1);
		root.CHILDREN.add(rootChild2);
		root.CHILDREN.add(rootChild3);
		return root;
	}

	class Node {
		public String VALUE;
		public List<Node> CHILDREN = new ArrayList<>();
	}
}
