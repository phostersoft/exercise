import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class TreeBFSDFS {

	public static void main(String[] args) {
		TreeBFSDFS main = new TreeBFSDFS();
		main.run();
	}

	public void run() {
		Node tree = constructTree();
		System.out.println("------------------");
		bfs(tree);
		System.out.println("------------------");
		dfs(tree);
		System.out.println("------------------");
		dfsRecursive(tree);
		System.out.println("------------------");
	}

	private void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty()) {
			Node toProcess = queue.poll();
			System.out.println("* BFS : " + toProcess.VALUE);
			for(Node child : toProcess.CHILDREN) {
				queue.offer(child);
			}
		}
	}

	private void dfs(Node node) {
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()) {
			Node toProcess = stack.pop();
			System.out.println("* DFS : " + toProcess.VALUE);
			for(Node child : toProcess.CHILDREN) {
				stack.push(child);
			}
		}
	}

	private void dfsRecursive(Node node) {
		System.out.println("* DFS RECURSIVE : " + node.VALUE);
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
		Node rootChild121 = new Node();
		rootChild121.VALUE = "1-1-2-1";
		rootChild12.CHILDREN.add(rootChild121);
		Node rootChild1211 = new Node();
		rootChild1211.VALUE = "1-1-2-1-1";
		rootChild121.CHILDREN.add(rootChild1211);
		Node rootChild31 = new Node();
		rootChild31.VALUE = "1-3-1";
		Node rootChild32 = new Node();
		rootChild32.VALUE = "1-3-2";
		rootChild3.CHILDREN.add(rootChild31);
		rootChild3.CHILDREN.add(rootChild32);
		return root;
	}

	class Node {
		public String VALUE;
		public List<Node> CHILDREN = new ArrayList<>();
	}
}
