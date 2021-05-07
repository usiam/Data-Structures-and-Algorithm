/*CSC 172 Lab
 * 
Uzair Tahamid Siam
email: usiam@u.rochester.edu
URID: 31434546 / NETID: usiam
Partner: Abrar Rahman Protyasha
Lab session - M/W 6:15 - 7:30

*/


public class MakeChangeDynamicProgramming {
	public static long call = 0;
	public static int[][] table;

	public static int[] makeChange(int amount, int[] denominations) {
		table = new int[amount + 1][];
		int[] counts = new int[denominations.length + 1];
		recMakeChange(amount, denominations, counts);

		int[] returnArray = new int[counts[counts.length - 1]];
		Utility.totalChange(counts, denominations, returnArray);

		return returnArray;
	}

	public static boolean recMakeChange(int amount, int[] denominations, int[] counts) {
		call++;

		boolean solutionFound = false;
		if (amount == 0) {
			solutionFound = true;
			return solutionFound;
		} else if (amount < 0) {
			return solutionFound;
		} else { // amount > 0
					// check if solution already computed
			if (table[amount] != null) {
				for (int k = 0; k < table[amount].length; ++k) {
					counts[k] = table[amount][k];
				}
				solutionFound = true;
				return solutionFound;
			}

			int[] temp = new int[counts.length];
			int[] best = new int[counts.length];
			best[best.length - 1] = amount + 1;

			for (int i = 0; i < denominations.length; i++) {
				if (recMakeChange(amount - denominations[i], denominations, temp)) {
					if (temp[temp.length - 1] < best[best.length - 1]) {
						temp[i]++;
						temp[temp.length - 1]++;
						for (int z = 0; z < best.length; ++z) {
							best[z] = temp[z];
						}
					}
					solutionFound = true;
				}
			}

			if (solutionFound) {
				// copy best into counts
				table[amount] = new int[counts.length];
				for (int z = 0; z < counts.length; z++) {
					table[amount][z] = counts[z] = best[z];
				}
				return solutionFound;
			} else {
				return solutionFound;
			}
		}
	}

}
