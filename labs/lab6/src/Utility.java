/*CSC 172 Lab
 * 
Uzair Tahamid Siam
email: usiam@u.rochester.edu
URID: 31434546 / NETID: usiam
Partner: Abrar Rahman Protyasha
Lab session - M/W 6:15 - 7:30

*/

public class Utility {

	public static void totalChange(int[] counts, int[] denominations, int[] returnArray) {
		int j = 0;
		
		for (int i = 0; i < denominations.length; i++) {
			for (int k = j; k < j + counts[i]; k++) {
				returnArray[k] = denominations[i];
			}
			j += counts[i];
		}
	}
}

