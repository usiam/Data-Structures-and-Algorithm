package lab4;

public class LinkedList<T> {
	public Node<T> first;

	public LinkedList() {
		first = null;
	}

	public LinkedList(LinkedList<T> list) { // copy constructor is called to copy the existing list
		if (list.first == null) {
			return;
		} else {
			Node<T> iterNode = list.first;
			while (iterNode != null) {
				addLast(iterNode.data);
				iterNode = iterNode.next;
			}
		}
	}

	public void reverse() {
		Node<T> prev = null;
		Node<T> current = first;
		Node<T> next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		first = prev;

	}

	public void addFirst(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		if (first == null) {
			first = node;
			first.next = null;
		} else {
			node.next = first;
			first = node;
		}
	}

	public void addLast(T data) {

		Node<T> node = new Node<T>();
		node.data = data;

		if (first == null) {
			first = node;
			first.next = null;
		} else {
			Node<T> tempNode = first;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			node.next = null;
			tempNode.next = node;
		}

	}

	public int size() {
		Node<T> node = new Node<T>();
		node = first;
		int i = 0;
		while (node != null) {
			node = node.next;
			i++;
		}
		return i;
	}

	public boolean search(T data) {
		Node<T> node = new Node<T>();
		node = first;
		while (node != null) {
			if (node.data == data) {
				return true;
			}
			node = node.next;
		}
		return false;
	}

	public void remove(T data) {
		Node<T> node = new Node<T>();
		Node<T> prevNode = new Node<T>();
		node = first;
		prevNode = first;
		while (node != null) {
			if (node == data) {
				prevNode.next = node.next;
			} else {
				prevNode = node;
				node = node.next;
			}
		}
	}

	public T removeFirst() {

		T tempData = first.data;

		first = first.next;

		return tempData;
	}

	public T removeLast() {
		if (first == null) {
			return null;
		}

		Node<T> tempNode = first;
		Node<T> prevNode = null;

		while (tempNode.next != null) {
			prevNode = tempNode;
			tempNode = tempNode.next;
		}

		T data = tempNode.data;
		if (size() == 1) {
			first = null;
		} else {
			prevNode.next = null;
		}
		return data;

	}

	public T getFirst() {
		return first.data;
	}

	public T getLast() {

		if (first == null) {
			return null;
		}
		Node<T> tempNode = first;
		while (tempNode.next != null) {
			tempNode = tempNode.next;
		}
		return tempNode.data;
	}

	public void printList() {
		Node<T> node = first;
		while (node != null) {
			System.out.print(node.data.toString() + "");
			node = node.next;
		}
	}
}
