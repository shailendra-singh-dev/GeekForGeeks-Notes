package problems.string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortColumnsCSV {
    
	private static String NEW_LINE = "\n";
	private static String COMMA = ",";
  
    private static String[] getFilledArray(String[] array,int size ) {
        String[] newArray = new String[size];      
        int i=0; 
		for(;i<array.length;i++) {
           newArray[i] = array[i];              
		}
        for(;i<size;i++) {
           newArray[i] = "";
		} 
		return newArray;
	}

	public static String sortCsvColumns(String csvFileContent) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<Integer, String[]> mapOfRowsToColumnValues = new HashMap<Integer, String[]>();
		Map<String, List<String>> mapOfHeaderColumnToValuesList = new HashMap<String, List<String>>();

		List<String> listOfRows = Arrays.asList(csvFileContent.split("\\n"));
		for (int i = 0; i < listOfRows.size(); i++) {
			map.put(i, listOfRows.get(i));
		}
		for (Entry<Integer, String> entry : map.entrySet()) {
			String value = entry.getValue();
			mapOfRowsToColumnValues.put(entry.getKey(), value.split(COMMA));
		}
		int rowToCover = listOfRows.size();
        int firstRowSize = mapOfRowsToColumnValues.get(0).length;
		for (int i = 0; i < firstRowSize; i++) {
			List<String> valuesToPut = new ArrayList<String>();
			int j = 1;
			while (j < rowToCover) {
				String[] array = mapOfRowsToColumnValues.get(j);				
                array = getFilledArray(array,firstRowSize);
				valuesToPut.add(array[i]);
				j++;
			}
			mapOfHeaderColumnToValuesList.put(mapOfRowsToColumnValues.get(0)[i], valuesToPut);
		}
		/**
		 * sort the map using keys map key=header column of csv, and value of map is
		 * list of rows of that column
		 **/
		TreeMap<String, List<String>> sorted = new TreeMap<>();
		sorted.putAll(mapOfHeaderColumnToValuesList);

		StringBuilder sb = formStringFromSortedData(map, sorted);
		return sb.toString();

	}

	private static StringBuilder formStringFromSortedData(Map<Integer, String> map,
			TreeMap<String, List<String>> sorted) {
		StringBuilder resultingString = new StringBuilder();
		int i = 0;
		List<String> keyList = new ArrayList<String>();
		// form the first line of resulting string using sorted map
		// keys of the map forms the first row of csv
		for (Entry<String, List<String>> entry : sorted.entrySet()) {
			String key = entry.getKey();
			resultingString.append(key);
			keyList.add(key);
			if (i < sorted.size() - 1)
				resultingString.append(COMMA);
			i++;
		}
		resultingString.append(NEW_LINE);
		int csvRowsWithoutHeader = 0;
		int headerColumnKeys = 0;
		while (csvRowsWithoutHeader < map.size() - 1 && headerColumnKeys < keyList.size()) {
			String key = sorted.get(keyList.get(headerColumnKeys)).get(csvRowsWithoutHeader);
			resultingString.append(key);
			// seperate the string with comma
			if (headerColumnKeys < sorted.size() - 1)
				resultingString.append(COMMA);
			headerColumnKeys++;
			if (headerColumnKeys == sorted.size()) {
				csvRowsWithoutHeader++;
				headerColumnKeys = 0;
				// don't append newline to last line of csv
				if (csvRowsWithoutHeader < map.size() - 1)
					resultingString.append(NEW_LINE);
			}
		}
		return resultingString;
	}

  
}