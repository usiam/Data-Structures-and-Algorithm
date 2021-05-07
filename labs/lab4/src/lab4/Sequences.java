package lab4;

public class Sequences {

	enum SeqType {
		DNA, RNA, EMPTY
	}

	SeqType type;

	LinkedList<Character> seqList;

	public Sequences() {
		type = SeqType.EMPTY;
		seqList = new LinkedList<Character>();
	}

	public void insert(String seqStr) {
		for (int i = 0; i < seqStr.length(); i++) {
			char c = seqStr.charAt(i);
			seqList.addLast(c);
		}
	}

	public void removeSequence() {
		type = SeqType.EMPTY;
		while (!isEmpty()) {
			seqList.removeLast();
		}
	}

	public int size() {
		return seqList.size();
	}

	public boolean isEmpty() {
		return seqList.size() == 0;
	}

	public void print() {
		System.out.print(type + "\t"); // prints the type and then a tab
		seqList.printList(); // then prints the whole sequence
		System.out.println();
	}

	LinkedList<Character> cloneSequence(LinkedList<Character> cloneList) {
		LinkedList<Character> clonedSequence = new LinkedList<Character>(cloneList);
		return clonedSequence;
	}

	public void copy(Sequences copySeq) {

		if (copySeq.type == SeqType.EMPTY) {
			type = SeqType.EMPTY;
		} else if (copySeq.type == SeqType.DNA) {
			type = SeqType.DNA;
		} else if (copySeq.type == SeqType.RNA) {
			type = SeqType.RNA;
		}

		seqList = cloneSequence(copySeq.seqList);

	}

	public void clip(int start, int end) {
		if (end < start) {
			SeqType preservedType = type;
			removeSequence();
			type = preservedType;
		} else {
			for (int i = 0; i < start; i++) {
				seqList.removeFirst();
			}
			for (int j = seqList.size() - 1; j > end; j--) {
				seqList.removeLast();
			}
		}
	}

	public void transcribe() {
		type = SeqType.RNA;
		seqList.reverse();
		Node<Character> currNode = seqList.first;
		while (currNode != null) {
			if (currNode.data == 'A') {
				currNode.data = 'U';
				currNode = currNode.next;
			} else if (currNode.data == 'T') {
				// since all the T gets converted to U and then we know U gets converted to A
				// we can say T gets converted to A directly
				currNode.data = 'A';
				currNode = currNode.next;
			} else if (currNode.data == 'C') {
				currNode.data = 'G';
				currNode = currNode.next;
			} else if (currNode.data == 'G') {
				currNode.data = 'C';
				currNode = currNode.next;
			} else {
				System.out.println("Cannot transcribe this DNA sequence.");
			}
		}
	}

	static boolean isValid(String sequence, SeqType type) {
		for (int i = 0; i < sequence.length(); i++) {
			char c = sequence.charAt(i);
			if (type == SeqType.DNA) {
				if (c != 'A' && c != 'T' && c != 'G' && c != 'C') {
					return false;
				}
			} else if (type == SeqType.RNA) {
				if (c != 'A' && c != 'U' && c != 'G' && c != 'C') {
					return false;
				}
			}
		}
		return true;
	}
}
