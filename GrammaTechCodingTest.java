/*
The problem:
------------

INPUT is a text file.
 * The file consists of a number of lines, separated by line breaks.

 * Each line contains "words" made up of lower case alphabetical
 characters separated by white space.

 * You can assume that the file is small enough to fit in working memory.

OUTPUT is a text file containing an index to the input:
 * For each word w in the input, there is an entry of the form
 w num1 num2 ... <carriage_return>
 such that num1, num2,... are the line numbers in the input on which
 w occurs. If w occurs more than once on a given line, the line
 number should only occur once.

 * The entries appear in alphabetical order.
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrammaTechCodingTest {

	static Map<String,HashSet<Integer>> wordOccurance = new HashMap<String,HashSet<Integer>>();

	public static void main(String[] args){
		String in = "input.txt";
		String out = "output.txt";
		readWords(in);
		createAlphabeticalOrder(wordOccurance,out);		
	}

	/*
	 * input param : filename - Contains the name of the file containing lines in the given format
	 * This function separates words from the input file and stores the occurance in a hashmpa by using the word as key and distinct line numbers as value
	 */
	public static void readWords(String fileName){
		int count = 0;
		String line = "";
		try {			
			BufferedReader brRating = new BufferedReader(new FileReader(fileName));
			while ((line = brRating.readLine()) != null) {				
				count++;							// This counter gives line numbers
				String[] words = line.split("\\s+");		// Reading white space spearated words
				for(int i = 0; i < words.length ; i++){
					HashSet<Integer> lineNumber = new HashSet<Integer>();  // Adding line numbers into hashset in order to remove duplicates					
					if(wordOccurance.containsKey(words[i])){
						lineNumber = wordOccurance.get(words[i]);						
					}
					lineNumber.add(count);
					wordOccurance.put(words[i], lineNumber);	// Adding index and line numbers into a map	
				}
			}	
			brRating.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * input param : map - Contains the map containing information of word and line number in alphabetically unsorted order.
	 * 			   : outputFile - where output is generated
	 * This function takes the keys in an arraylist and sorts alphabetically. Then the hashmap is accessd using sorted key.
	 */
	static void createAlphabeticalOrder(Map<String,HashSet<Integer>> map,String outputFile){
		try {
			PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
			Set<String> indexes = map.keySet();
			ArrayList<String> arlist=new ArrayList<String>(indexes);			
			Collections.sort(arlist);	// sorting the ArrayList in lexicographical manner 
			for(String key : arlist){				
				writer.print(key);		//sorted key
				for(int l : map.get(key)){
					writer.print(" "+l);	//The line number
				}		
				writer.println();
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}	
}

