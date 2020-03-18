/**
 * 
 */
package logan.linkedlist;

/**
 * @author longphan
 *
 */
public class PrintTheElementsOfALinkedList {

	/**
	 * @param args
	 */
	 /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
   	static void printLinkedList(SinglyLinkedListNode head) {
	    System.out.println(head.data);
	    if(head.next != null){
                printLinkedList(head.next);
      	    }
    }
}
