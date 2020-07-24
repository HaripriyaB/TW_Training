/*
 * Author : Haripriya Baskaran
 * Created Date and Time : 24-07-2020 21:00 IST
 * Purpose : Exercism Practice Problem Solutions
 */

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class PigLatin {

	public static void main(String[] args) throws Exception {
		ArrayList<Character> vowels = new ArrayList();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		String Rule3 = "[a-z&&[^aeiou]]*qu.*";
		String Rule4 = "[a-z&&[^aeiou]]*y[a-z&&[^aeiou]]*";
		String sent="";
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a sentence/phrase to translate:");
		sent = br.readLine();
		sent = sent.toLowerCase();
		String[] words = sent.trim().split("\\s+");
		for(int i=0;i<words.length;i++){
			String word=words[i];
			if(vowels.contains(word.charAt(0))){
				word+="ay";
				words[i] = word;
				continue;
			}
			else if((word.charAt(0)=='x' && word.charAt(1)=='r') ||
					(word.charAt(0)=='y' && word.charAt(1)=='t')){
				word+="ay";
				words[i] = word;
				continue;
			}
			else{
				Pattern p = Pattern.compile(Rule3);
				Pattern r = Pattern.compile(Rule4);
				
				if(p.matcher(word).matches()){
					String newword = "";
					int index=-1;
					for(int j=0;j<word.length()-1;j++){
						if(word.charAt(j)=='q' && word.charAt(j+1)=='u'){
							index = j+2;
							break;
						}
					}
					newword = word.substring(index);
					newword += word.substring(0, index);
					newword+="ay";
					word = newword;
					words[i] = word;
//					System.out.println("Inside rule 3");
					continue;
				}
				else if(r.matcher(word).matches()){
					String newword = "";
					int index=-1;
					for(int j=0;j<word.length();j++){
						if(word.charAt(j)=='y'){
							index = j;
							break;
						}
					}
					newword = word.substring(index);
					newword += word.substring(0, index);
					newword+="ay";
					word = newword;
					words[i] = word;
//					System.out.println("Inside rule 4");
					continue;
				}
				else{
					String newword = "";
					int index=0;
					for(int j=0;j<word.length();j++){
						if(vowels.contains(word.charAt(j))){
							index = j;
							break;
						}
					}
					newword = word.substring(index);
					newword += word.substring(0, index);
					newword+="ay";
					word = newword;
					words[i] = word;
//					System.out.println("Inside rule else");
					continue;
				}
			}
		}
		for(int i=0;i<words.length;i++){
			System.out.print(words[i]+" ");
		}
		

	}

}
