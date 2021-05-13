package com.mavenprojectWords;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchWords {
public static void main(String[] args) throws IOException {
Scanner scanner = new Scanner(System.in);
System.out.println("Pelease enter the pool of words");
String letters = scanner.nextLine();
Map<Character,Integer>letterscountmap = getCharacterCountMap(letters);
BufferedReader reader = new BufferedReader(new FileReader("/Users/sree/eclipse-workspace/Dictionary/DictionaryFile.txt"));
System.out.println("All possible words you can make with those letters");
for(String currentword = reader.readLine(); currentword !=null;currentword = reader.readLine()) {
Map<Character,Integer> currentwordmap = getCharacterCountMap(currentword);
boolean canMakeCurrentWord = true;	
for(Character character : currentwordmap.keySet()) {
int currentWordCharCount = currentwordmap.get(character);
int letterscharcount = letterscountmap.containsKey(character)?
letterscountmap.get(character):0;
if(currentWordCharCount > letterscharcount) {
	canMakeCurrentWord = false;
	break;
}
}
if(canMakeCurrentWord) {
	System.out.println(currentword);
}
}
	scanner.close();
	reader.close();
}

private static Map<Character,Integer> getCharacterCountMap(String letters) {
	Map<Character,Integer>letterscountmap = new HashMap<>();
	for(int i=0; i< letters.length();i++) {
		char currentchar = letters.charAt(i);
		int count = letterscountmap.containsKey(currentchar) ?
				letterscountmap.get(currentchar) :0;
		letterscountmap.put(currentchar, count+1);
		
	}
	return letterscountmap;
}
}
