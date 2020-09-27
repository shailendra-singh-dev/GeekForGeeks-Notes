package data_structures;

public class BSTNode {

	public int binaryData;
	public int data;
	public int row;
	public BSTNode left;
	public BSTNode right;

	public BSTNode(int binaryData) {
		this.binaryData = binaryData;
		data = binaryToDecimal(binaryData);
	}

	public int getBinary() {
		return binaryData;
	}

	private int decimalToBinary(int n) {
		int[] binary = new int[1000];
		int i = 0;
		while (n > 0) {
			binary[i] = n % 2;
			n = n / 2;
			i++;
		}
		StringBuffer stringhBuffer = new StringBuffer();
		for (int j = i - 1; j >= 0; j--) {
			stringhBuffer.append(binary[j]);
		}
		return Integer.parseInt(stringhBuffer.toString());
	}

	private int binaryToDecimal(int n) {
		int temp = n;
		int base = 1;
		int dec_value = 0;
		while (temp > 0) {
			int last_digit = temp % 10;
			temp = temp / 10;
			dec_value += base * last_digit;
			base = base * 2;
		}
		return dec_value;
	}

	@Override
	public boolean equals(Object obj) {
		BSTNode bstNode = (BSTNode) obj;
		return data == bstNode.data;
	}

	@Override
	public String toString() {
		return "[" + data + "]";
	}
}
