package linkedlist;

public class LinkedList {

	Node head;

	public void insert(int data) {
		//System.out.println(data);
		Node node = new Node();
		node.setData(data);

		if(head==null) {
			head = node;
		}else {
			Node n = head;
			while(n.getNext()!=null) {
				n=n.getNext();
			}
			n.setNext(node);
		}
	}
	public void insertAt(int pos, int data) {

		if(pos ==0) {
			insertAtStart(data);
		}


		Node n = new Node();
		n.setData(data);


		int size = size();
		if(pos>size) {
			System.out.println("The position value is invalid.");
			return;
		}
		Node node = head;
		int nodePos = 1;
		while(node!=null) {
			nodePos++;
			if(nodePos==pos) {
				//insert here
				n.setNext(node.getNext());
				node.setNext(n);
				break;
			}
			node = node.getNext();
		}

	}
	public void insertAtStart(int data) {
		Node n = new Node();
		n.setData(data);
		n.setNext(head);
		head = n;
	}

	public void deleteAt(int index) {
		if(index==1) {
			head = head.getNext();
		}else {
			int c=1;
			Node n = head;
			while(n!=null) {
				c++;
				if(c==index) {
					n.setNext(n.getNext().getNext());
					break;
				}

				n=n.getNext();
			}
		}
	}
	public void show() {
		Node n = head;
		while(n!=null) {
			System.out.print(n.getData() + "  ");
			n = n.getNext();
		}
		System.out.println();
	}
	public int size() {
		Node n = head;
		int c = 0;
		while(n!=null) {
			c++;
			n=n.getNext();
		}
		System.out.println("Length of the linked list is " + c);
		return c;
	}

	/*
	 * find the kth member from the end in SLL
	 */

	public void findKFromEnd(int index) {

		Node p1 = head; 
		Node p2 = new Node();
		int c=1;
		while(p1!=null) {
			if(c==index) {
				p2 = head;
			}else if(p2!=null){
				p2 = p2.getNext();
			}
			p1 = p1.getNext();
			c++;
		}
		System.out.println(p2.getData());
	}

	public void findLoop(LinkedList linkedList) {
		Node slow  = head;
		Node fast = head;

		while(slow.getNext()!=null && fast.getNext()!=null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow==fast) {
				System.out.println("Loop Exists");
				return;
			}
		}
		System.out.println("Loop Not exists.");		
	}

	public LinkedList createLoopLL(LinkedList ll) {
		System.out.println("Executing create loop");

		int pos = 3;
		Node n = new Node(90);

		int c =0;
		Node currentNode = head;
		while(currentNode.getNext()!=null) {
			if(c==pos) {
				n.setNext(currentNode);
			}
			c++;
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(n);
		showLoopyList(ll);
		System.out.println();
		return ll;
	}

	public void showLoopyList(LinkedList ll) {
		Node n1 = ll.head;
		int len = 0;
		while(len<10 && n1!=null) {
			len++;
			System.out.print(n1.getData() + "  ");
			n1 = n1.getNext();
		}
	}

	//You are given the heads of two sorted linked lists list1 and list2.

	//Merge the two lists into one sorted list. 
	//The list should be made by splicing together the nodes of the first two lists


	public void mergerLists() {

		System.out.println();
		LinkedList linkedList1 = new LinkedList();
		LinkedList linkedList2 = new LinkedList();

		linkedList1.insert(5);
		linkedList1.insert(10);
		linkedList1.insert(15);
		linkedList1.insert(20);

		linkedList2.insert(6);
		linkedList2.insert(9);
		linkedList2.insert(11);
		linkedList2.insert(23);



		Node head1 = linkedList1.head;
		Node head2 = linkedList2.head;

		Node cursor = null;

		Node dummy=new Node(0);
		
		while(head1!=null && head2!=null) {

			//System.out.println(head1.getData() + "   " + head2.getData());

			if(head1.getData() <= head2.getData()) { //System.out.println("in");
				if(cursor==null) { 
					Node n = new Node(head1.getData()); 
					cursor = n; 
					dummy.setNext(cursor);
				}else {
					Node n = new Node(head1.getData());
					cursor.setNext(n); 
					cursor = cursor.getNext(); 
				} head1 = head1.getNext(); 
			}else { 
				Node n = new Node(head2.getData()); 
				cursor.setNext(n); 
				cursor = cursor.getNext(); 
				head2 = head2.getNext();
			} 
			System.out.println("cursor : " + cursor.getData()); 
		}
		while(dummy.getNext()!=null) {
			dummy=dummy.getNext();
			System.out.println("dummy node : " + dummy.getData());
			
		}
	}

}
