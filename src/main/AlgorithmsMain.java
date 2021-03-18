package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import problems.arrays.Duplicates;

public class AlgorithmsMain {

	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int T = Integer.parseInt(br.readLine());
//		for (int i = 0; i < T; i++) {
//			String S1 = br.readLine();
//			String S2 = br.readLine();		
//			Set<String> permutationS1 = permutationFinder(S1);
//			Set<String> permutationS2 = permutationFinder(S2);
//			for(String str:permutationS1) {
//				if(permutationS2.contains(str)) {
//					System.out.println("YES");	
//				}else {
//					System.out.println("NO");
//				}
//			}
//		}
		
		int[] a = new int[] { -1, -1, 3, 2, 2 };
		System.out.println(Arrays.toString(new Duplicates().getDuplicatesArray(a)));
	}

	public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }
	
	 public static String charInsert(String str, char c, int j) {
	        String begin = str.substring(0, j);
	        String end = str.substring(j);
	        return begin + c + end;
	 }

	private static int[] getModifiedArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (i == a.length - 1) {
				a[i] = 0;
				break;
			}
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[i]) {
					a[i] = 0;
					break;
				} else if (a[j] < a[i]) {
					a[i] = 1;
					break;
				}
			}
		}
		return a;
	}
}
