package lab2;

public class lab2 {

	public static void main(String[] args) {
		Integer [] intArray = {1, 2, 3, 4, 5 };
		Double [] doubArray = {1.1, 2.2, 3.3, 4.4};
		Character [] charArray = {'H','E','L', 'L', 'O' };
		String [] strArray = {"once", "upon", "a", "time" };
		
		System.out.println("printArrayNonGen\n------");
		printArrayNonGen(intArray);
		printArrayNonGen(doubArray);
		printArrayNonGen(charArray);
		printArrayNonGen(strArray);
		
		
		System.out.println("\nprintArray\n------");
		printArray(intArray);
		printArray(doubArray);
		printArray(charArray);
		printArray(strArray);
		
	
		System.out.println("\nprintArrayGen\n------");
		printArrayGen(intArray);
		printArrayGen(doubArray);
		printArrayGen(charArray);
		printArrayGen(strArray);
		
		System.out.println("\ngetMax\n------");
		System.out.println(getMax(intArray));
		System.out.println(getMax(doubArray));
		System.out.println(getMax(charArray));
		System.out.println(getMax(strArray));
		
		System.out.println("\ngetMaxGen\n------");
		System.out.println(getMaxGen(intArray));
		System.out.println(getMaxGen(doubArray));
		System.out.println(getMaxGen(charArray));
		System.out.println(getMaxGen(strArray));
		
		
	}		
	
	//Q1
	public static void printArrayNonGen(Object[] obj) {
		
		for(int i = 0; i < obj.length; i++) {
			if(i == 0) {
				System.out.print("{");
			}
			System.out.print(obj[i]);
			if(i == obj.length - 1) {
				System.out.print("}");
			} else {
				System.out.print(", ");
			}
			
		}
		
		System.out.println();
	}
	
	//Q2
	public static void printArray(Integer[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				System.out.print("{");
			}
			System.out.print(arr[i]);
			if(i == arr.length - 1) {
				System.out.print("}");
			} else {
				System.out.print(", ");
			}
			
		}
		
		System.out.println();
	}
	public static void printArray(Double[] arr) {
	
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				System.out.print("{");
			}
			System.out.print(arr[i]);
			if(i == arr.length - 1) {
				System.out.print("}");
			} else {
				System.out.print(", ");
			}
			
		}
	
	System.out.println();
	}
	
	public static void printArray(Character[] arr) {
	
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				System.out.print("{");
			}
			System.out.print(arr[i]);
			if(i == arr.length - 1) {
				System.out.print("}");
			} else {
				System.out.print(", ");
			}
			
		}
	
	System.out.println();
	}
	
	public static void printArray(String[] arr) {
	
		for(int i = 0; i < arr.length; i++) {
			if(i == 0) {
				System.out.print("{");
			}
			System.out.print(arr[i]);
			if(i == arr.length - 1) {
				System.out.print("}");
			} else {
				System.out.print(", ");
			}
			
		}
	
	System.out.println();
	}
	
	//Q3
	public static <T> void printArrayGen(T[] gen) {
		for(int i = 0; i < gen.length; i++) {
			if(i == 0) {
				System.out.print("{");
			}
			System.out.print(gen[i]);
			if(i == gen.length - 1) {
				System.out.print("}");
			} else {
				System.out.print(", ");
			}
			
		}
		
		System.out.println();
	}
	
	
	//Q4
	public static Comparable getMax(Comparable [] anArray) {
	
		Comparable max = anArray[0];
		
		for(int i = 1; i < anArray.length; i++) {
			if(max.compareTo(anArray[i]) < 0) {
				max = anArray[i];
			}
		}
		
		return max;
		
	}
	
	//T inherits all the methods and attributes from the interface Comparable but Comparable is just an interface so it must work on a type which is
	//specified by Comparable<? super T> ? is a wildcard and can be any superclass of the type T that we are using with this method.
	
	//Q5
	public static <T extends Comparable<? super T>> T getMaxGen(T[] anArray) {
		T max = anArray[0];
		
		for(T t : anArray) {
			if(max.compareTo(t) < 0) {
				max = t;
			}
		}
		
		return max;
	}
}


		