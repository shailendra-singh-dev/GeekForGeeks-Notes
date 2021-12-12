package problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortTheColumnsOfCSVFile {

	
	public static void main(String[] args) {
		String input =  "Beth,Charles,Danielle,Adam,Eric\n" + 
				        "17945,10091,10088,3907,10132\n" + 
				        "2,12,13,48,11";
		String output = sortCsvColumns(input);
		System.out.println(output);
	}
	
	public static String sortCsvColumns(String csvFileContent) {

		Map<Integer, String> columns = new HashMap<Integer, String>();

		getColumnNames(csvFileContent, columns);

		int[] sortedColumns = sortMapByValue(columns);
		// System.out.print( "*** sortedColumn: " );
		// for ( int i = 0; i < sortedColumns.length; i++ ) {
		//
		// System.out.print( sortedColumns[i] + " " );
		// }

		return sortColumns(sortedColumns, csvFileContent);
	}

	private static void getColumnNames(String csvFileContent, Map<Integer, String> columns) {
		Pattern pattern = Pattern.compile("([^;\\n]+)([;\\n])");
		Matcher matcher = pattern.matcher(csvFileContent);

		int i = 0;
		while (matcher.find() && !matcher.group(2).equals("\n")) {
			columns.put(i, matcher.group(1));
			i++;
		}

		String[] values =  matcher.group(1).split(",");
		Arrays.sort(values);
		System.out.println(Arrays.toString(values));
//		columns.put(i, matcher.group(1));
		columns.put(i, Arrays.toString(values));
		System.out.println(columns);

//		pritOutMap( columns );
//		 System.out.println( "*** The column names input is ready" );

	}

	private static void pritOutMap( Map<Integer, String> map ) {
		for ( int i = 0; i < map.size(); i++ ) {
			System.out.println( map.get( i ) );
		}
	}

	private static int[] sortMapByValue(Map<Integer, String> unsortedMap) {
		LinkedList<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(
				(Collection<? extends Entry<Integer, String>>) unsortedMap.entrySet());

//		System.out.println(list);
//		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
//			public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
//				return o1.getValue().toLowerCase().compareTo(o2.getValue().toLowerCase());
//			}
//		});
		
//		Collections.sort(list,Comparator.naturalOrder());

		int[] sortedColumns = new int[unsortedMap.size()];
		int i = 0;
		for (Map.Entry<Integer, String> entry : list) {
			sortedColumns[i] = entry.getKey();
			i++;
		}
		return sortedColumns;
	}

	private static String sortColumns(int[] sortedColumns, String csvFileContent) {
		StringBuffer resultString = new StringBuffer();
		ArrayList<String> csvElements = new ArrayList<String>(Arrays.asList(csvFileContent.split("[;\\n]")));
		for (int i = 0; i < csvElements.size(); i++) {
//			System.out.println(csvElements.get(i));
		}
		for (int j = 0; j < csvElements.size() / sortedColumns.length; j++) {
			for (int i = 0; i < sortedColumns.length; i++) {
				int index = j * sortedColumns.length + sortedColumns[i];
//				System.out.println(index);
				resultString.append(csvElements.get(index));
				if (i < sortedColumns.length - 1) {
					resultString.append(";");
				}
			}
			if (j < csvElements.size() / sortedColumns.length - 1) {
				resultString.append("\n");
			}
		}
		return resultString.toString();
	}
}
