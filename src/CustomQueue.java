
public class CustomQueue<Item> {
	private class Node{
		Item item;
		Node nextNode;
	}
	
	private Node first;
	private Node second;
	private int N;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
}
