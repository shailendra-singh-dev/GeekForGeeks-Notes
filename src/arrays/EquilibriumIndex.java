package arrays;

public class EquilibriumIndex {

    public static int getEquilibriumIndex(int[] array) {
	int sumLeft = 0;
	int sumRight = 0;

	for (int i = 0; i < array.length; i++) {
	    sumLeft = 0;
	    sumRight = 0;
	    for (int j = 0; j < i; j++) {
		sumLeft += array[j];
	    }

	    for (int j = i+1; j < array.length; j++) {
		sumRight += array[j];
	    }

	    if (sumLeft == sumRight) {
		return i;
	    }
	}
	return -1;
    }
    
    
}
