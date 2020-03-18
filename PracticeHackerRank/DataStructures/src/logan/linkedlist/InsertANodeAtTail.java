import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertANodeAtTail {
static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {

		public SinglyLinkedListNode head;

		public SinglyLinkedList() {
			this.head = null;
		}

	}

	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
		if (head == null) {
			head = new SinglyLinkedListNode(data);
			return head;
		}
		SinglyLinkedListNode currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = new SinglyLinkedListNode(data);
		return head;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

		SinglyLinkedList llist = new SinglyLinkedList();

		int llistCount = Integer.parseInt(inp.readLine());

		for (int i = 0; i < llistCount; i++) {
			int llistItem = Integer.parseInt(inp.readLine());

			SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

			llist.head = llist_head;
		}
		
		System.out.println("");
	}
}
//input data
//5
//141
//302
//164
//530
//474
