package problems.string;

public class MakingAnagrams {

	public static int getNumberOfDeletedCharacters(String a, String b) {
		int count = 0;
		int[] aNumberedArray = new int[26];
		int[] bNumberedArray = new int[26];
		for (int i = 0; i < a.length(); i++) {
			aNumberedArray[a.charAt(i) - 'a']++;
		}
		for (int i = 0; i < b.length(); i++) {
			bNumberedArray[b.charAt(i) - 'a']++;
		}
		for (int i = 0; i < bNumberedArray.length; i++)
			count += Math.abs(aNumberedArray[i] - bNumberedArray[i]);
		return count;
	}
	
	public static void test() {
		int num = getNumberOfDeletedCharacters("abc", "dcf");
		System.out.println("getNumberOfDeletedCharacters():"+ num);
	}
}
