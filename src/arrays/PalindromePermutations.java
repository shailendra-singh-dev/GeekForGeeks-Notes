package arrays;

public class PalindromePermutations {

	private static void charIntValue(){
		String str = "aba";
		for(char ch:str.toCharArray()){
			int charIntValue= ch-'0';
			System.out.print(charIntValue);
		}		 
	}
	
	public static void test(){
		charIntValue();
	}
}
