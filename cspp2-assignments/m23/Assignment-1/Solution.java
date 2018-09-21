import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.Math;
class Text {
	private String text1;
	private String text2;
	public Text(String t1, String t2) {
		this.text1 = t1;
		this.text2 = t2;
	}
	public static String TextToString(File text) {
		String str = "";
		try {
			Scanner scan = new Scanner(new FileReader(text));
			StringBuilder sbuilder = new StringBuilder();
			while (scan.hasNext()) {
				sbuilder.append(scan.next());
				sbuilder.append(" ");
			}
			scan.close();
			str= sbuilder.toString();
		} catch(FileNotFoundException e) {
			System.out.println("no file");
		}
		return str;
	}
	public static Map removableWords(String text) {
		text = text.toLowerCase();
		String[] tokens = text.replaceAll("[^A-Za-z ]","").split(" ");
		Map <String, Integer> map = new HashMap<>();
		for (int i = 0; i<tokens.length; i++) {
			if(!map.containsKey(tokens[i])) {
				map.put(tokens[i], 1);
			} else {
				map.put(tokens[i], map.get(tokens[i])+1);
			}
		}
		return map;
	}
	public static int compareWords(String s1, String s2) {
		float numerator = 0;
		double denominator = 0;
		float firstSum = 0;
		float secondSum = 0;
		Map <String, Integer> list1 = new HashMap<>();
		Map <String, Integer> list2= new HashMap<>();
		for (String element : list1.keySet()) {
			for (String item :list2.keySet()) {
				if (element.equals(item)) {
					numerator += list1.get(element) * list2.get(item);
				}
			}
		}
		for (String inList1 : list1.keySet()) {
			firstSum += Math.pow(list1.get(inList1),2);
		}
		for (String inList2 : list2.keySet()) {
			secondSum += Math.pow(list2.get(inList2),2);
		}
		denominator = Math.sqrt(firstSum) * Math.sqrt(secondSum);
		double result = (numerator / denominator) * 100;
		return (int) (((result) * 100D)/100D);
	}
}

class Solution {
	public Solution() {

	}
	public static void main(String[] args) {
		// File folder = new File("");
		// File[] listOfFiles = folder.listFiles();
		// for (int i = 0; i < listOfFiles.length; i++) {
		// 	File file = listOfFiles[i];
		// 	if (file.isFile() && file.getName().endsWith(".txt")) {
		// 		String content = FileUtils.readFileToString(file);
		// 	}
		// }
		try {
		Scanner s = new Scanner(System.in);
		String readFile;
		readFile = s.nextLine();
		File folder = new File(readFile);
		File[] listOfFiles = folder.listFiles();
		for (File f : listOfFiles) {

		}
		int length = listOfFiles.length;
		int[][] matrix = new int[length][length];
		for (int i = 0; i<length; i++) {
			for (int j = 0; j<length; j++) {
				matrix[i][j] = Text.compareWords(Text.TextToString(listOfFiles[i]),Text.TextToString(listOfFiles[j]));
			}
		}
		for (int i = 0; i<length;i++) {
			for(int j = 0;j<length;j++) {
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	} catch (NoSuchElementException e) {
		System.out.println("empty dictectoty");
	}

	}
}