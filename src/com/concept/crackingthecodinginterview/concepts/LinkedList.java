package com.concept.crackingthecodinginterview.concepts;

public class LinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);

/*		Node node=null;
		Node.printList(node);
*/

		System.out.println("List before deletion");
		Node.printList(head);
		Node.deleteNode(head, 5);
		System.out.println("List after deletion");
		Node.printList(head);

		System.out.println("List before adding element");
		Node.printList(head);
		System.out.println("List after adding element");
		head.add(4, 5);
		Node.printList(head);

		head.appendToTail(7);
		System.out.println("List after adding element at tail");
		Node.printList(head);


/*		System.out.println("List before deletion from index");
		Node.printList(head);
		System.out.println("List after deletion from index");
		Node.delete(head, 3);
		Node.printList(head);
*/

/*		System.out.println("List before deletion of duplicate element");
		Node.printList(head);
		head.delete(3);
		System.out.println("List after deletion of duplicate element");
		Node.printList(head);
*/

/*		System.out.println("List before deletion of all duplicate element");
		Node.printList(head);
		System.out.println("List after deletion of all duplicate element");
		head.deleteAllDuplicates(1);
		Node.printList(head);
*/
	}
}
