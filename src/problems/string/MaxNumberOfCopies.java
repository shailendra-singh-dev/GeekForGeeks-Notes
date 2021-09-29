package problems.string;

public class MaxNumberOfCopies {

	public void test() {
		//T1
		String[] L1 = { "BILL", "BOB" };
		String S1 = "BILLOBILLOLLOBBI";
		//T2
		String[] L2 = { "ILOVEMYDOG", "CATS" };
		String S2 = "CAT";
		//T3
		String[] L3 = { "ABCD", "XYZ" };
		String S3 = "ABCDXYZ";
		System.out.println(getCount(S3, L3));
	}

	public int getCount(String S, String[] L) {
		int max = 0;
		for (String str : L) {
			int count = 0, size = str.length();
			for (int i = 0; i < S.length(); i++) {
				for (char ch : str.toCharArray()) {
					int index = S.indexOf(ch);
					if (index >= 0) {
						S = S.substring(0, index) + S.substring(index + 1, S.length());
						count++;
						System.out.println("S:" + S + ",count:" + count + ",size:" + size);
						if (count == size) {
							max++;
							count = 0;
						}
					}
				}
			}
		}
		return max;
	}
}
