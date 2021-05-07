package lab4;

import java.util.ArrayList;
import lab4.Sequences.SeqType;

public class DNAList {

	static int arraySize;
	static Sequences[] seqArray;

	public static void main(String[] args) {

		arraySize = Integer.parseInt(args[0]);
		seqArray = new Sequences[arraySize];
		for (int i = 0; i < arraySize; i++) {
			seqArray[i] = new Sequences();
		}

		String inputFileName = args[1];
		ArrayList<String> exprStrings = FileIO.readFile(inputFileName);

		String[][] instructions = new String[exprStrings.size()][];

		for (int i = 0; i < exprStrings.size(); i++) {
			String[] x = exprStrings.get(i).split(" ");
			instructions[i] = x;
		}

		for (int i = 0; i < exprStrings.size(); i++) {
			runInstructions(instructions[i]);
		}

	}

	public static void runInstructions(String[] instructions) {
		String instrType = instructions[0];

		int pos;
		String sequence;

		if (instrType.equals("insert")) {
			pos = Integer.parseInt(instructions[1]);
			SeqType seqType = SeqType.EMPTY;

			if (instructions[2].equals("DNA")) {
				seqType = SeqType.DNA;
			} else if (instructions[2].equals("RNA")) {
				seqType = SeqType.RNA;
			} else {
				System.out.println("Invalid insert command");
			}

			sequence = instructions[3];
			insert(pos, seqType, sequence);

		} else if (instrType.equals("remove")) {
			// collecting "pos" from remainder of input
			pos = Integer.parseInt(instructions[1]);
			remove(pos);

		} else if (instrType.equals("print")) {
			if (instructions.length == 1)
				print();
			else if (instructions.length == 2) {
				pos = Integer.parseInt(instructions[1]);
				print(pos);
			} else
				System.out.println("Invalid print command");

		} else if (instrType.equals("clip")) {
			pos = Integer.parseInt(instructions[1]);
			int start = Integer.parseInt(instructions[2]);
			int end = Integer.parseInt(instructions[3]);
			clip(pos, start, end);

		} else if (instrType.equals("copy")) {
			int origPos = Integer.parseInt(instructions[1]);
			int copyPos = Integer.parseInt(instructions[2]);

			copy(origPos, copyPos);

		} else if (instrType.equals("transcribe")) {
			pos = Integer.parseInt(instructions[1]);
			transcribe(pos);
		} else {
			System.out.println("Invalid instruction.");
		}

	}

	static void insert(int pos, SeqType type, String sequence) {

		if (pos < 0 || pos >= arraySize) {
			System.out.println("Error occurred while inserting");
			return;
		}

		if (Sequences.isValid(sequence, type)) {
			if (seqArray[pos].type != SeqType.EMPTY) {
				seqArray[pos].removeSequence();
			}
			// insertion with appropriate type
			seqArray[pos].type = type;
			seqArray[pos].insert(sequence);
		} else {
			System.out.println("Error occurred while inserting");
		}
	}

	static void remove(int pos) {
		if (pos < 0 || pos >= arraySize || seqArray[pos].type == SeqType.EMPTY) {
			System.out.println("No sequence to remove at specified position");
			return;
		}
		seqArray[pos].removeSequence();
	}

	static void print(int pos) {

		if (pos < 0 || pos >= arraySize || seqArray[pos].type == SeqType.EMPTY) {
			System.out.println("No sequence to print at specified position");
			return;
		}
		seqArray[pos].print();
	}

	static void print() {
		for (int i = 0; i < arraySize; ++i) {

			if (seqArray[i].type != SeqType.EMPTY) {
				System.out.print(i + "\t");
				seqArray[i].print();
			}
		}
	}

	static void copy(int origPos, int copyPos) {

		if (origPos < 0 || origPos >= arraySize || seqArray[origPos].type == SeqType.EMPTY) {
			System.out.println("No sequence to copy at specified position");
			return;
		}

		seqArray[copyPos].removeSequence();
		seqArray[copyPos].copy(seqArray[origPos]);
	}

	static void clip(int pos, int start, int end) {

		if (pos < 0 || pos >= arraySize || seqArray[pos].type == SeqType.EMPTY) {
			System.out.println("No sequence to clip at specified position");
			return;
		}

		if (start < 0) {
			System.out.println("Invalid start index");
			return;
		}
		if (start >= seqArray[pos].size()) {
			System.out.println("Start index is out of bounds");
			return;
		}
		if (end >= seqArray[pos].size()) {
			System.out.println("End index is out of bounds");
			return;
		}
		seqArray[pos].clip(start, end);
	}

	static void transcribe(int pos) {

		if (pos < 0 || pos >= arraySize || seqArray[pos].type == SeqType.EMPTY) {
			System.out.println("No sequence to transcribe at specified position");
			return;
		}

		if (seqArray[pos].type == SeqType.RNA) {
			System.out.println("Cannot transcribe RNA");
			return;
		}
		seqArray[pos].transcribe();
	}

}
