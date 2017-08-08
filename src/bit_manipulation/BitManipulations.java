package bit_manipulation;

public class BitManipulations {
	int bitwise_and() {
		int n1 = 10; // 1010
		int n2 = 15;// 1111
		// If both are 1 ,result is 1 else 0
		int n3 = n1 & n2;// 1010
		printf("bitwise_and():%d", n3);
		return n3;
	}

	private void printf(String string, int n3) {
		System.out.print(string + n3);

	}

	int bitwise_or() {
		int n1 = 10; // 1010
		int n2 = 15; // 1111
		// If one of them is 1 ,result is 1 else 0
		int n3 = n1 | n2; // 1111
		printf("bitwise_or():%d", n3);
		return n3;
	}

	int bitwise_xor() {
		int n1 = 10; // 1010
		int n2 = 15; // 1111
		// If both are different ,result is 1 else 0
		int n3 = n1 ^ n2; // 0101
		printf("bitwise_xor():%d", n3);
		return n3;
	}

	int bitwise_not() {
		int n1 = 10; // 0......1010
		// a. make it negative 1......0101
		// b. 2's complement 1......1010 (last sign bit is same)
		// c. add 1 
		// d. Result 1......1011 i.e -11
		int n3 = ~n1; //
		printf("bitwise_not():%d", n3);
		return n3;
	}

	int bitwise_left_shift() {
		int n1 = 10;
		int n2 = n1 << 2;
		printf("bitwise_left_shift():%d", n2);
		return n2;
	}

	int bitwise_right_shift() {
		int n1 = 10;
		int n2 = n1 >> 2;
		printf("bitwise_right_shift():%d", n2);
		return n2;
	}
}
