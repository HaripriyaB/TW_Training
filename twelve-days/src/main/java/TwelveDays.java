import java.io.*;
import java.util.*;

class TwelveDays {
    String verse(int verseNumber) {
		String s="";
        switch(verseNumber){
			case 1: 
					s="a Partridge in a Pear Tree.";
					break;
			case 2: 
					s="two Turtle Doves,";
					break;
			case 3: 
					s="three French Hens,";
					break;
			case 4: 
					s="four Calling Birds,";
					break;
			case 5: 
					s="five Gold Rings,";
					break;
			case 6: 
					s="six Geese-a-Laying,";
					break;
			case 7: 
					s="seven Swans-a-Swimming,";
					break;
			case 8: 
					s="eight Maids-a-Milking,";
					break;
			case 9: 
					s="nine Ladies Dancing,";
					break;
			case 10: 
					s="ten Lords-a-Leaping,";
					break;
			case 11: 
					s="eleven Pipers Piping,";
					break;
			case 12: 
					s="twelve Drummers Drumming,";
					break;
			default:
					s="Wrong number";
		}
		return s;
    }

    String verses(int startVerse, int endVerse) {
       if(startVerse == endVerse){
		return verse(startVerse);
	   }
	   String s="";
	   for(int i=endVerse;i>startVerse;i--){
			s+=verse(i)+" ";
	   }
	   s += "and "+verse(startVerse);
	   return s;
		   
    }
    
    String sing() {
		int start=1;
		Map<Integer, String> map=new HashMap<>();
		map.put(1,"first");
		map.put(2,"second");
		map.put(3,"third");
		map.put(4,"fourth");
		map.put(5,"fifth");
		map.put(6,"sixth");
		map.put(7,"seventh");
		map.put(8,"eighth");
		map.put(9,"nineth");
		map.put(10,"tenth");
		map.put(11,"eleventh");
		map.put(12,"twelfth");
		String final_song="";
        for(int i=1;i<=12;i++){
			String song = "On the "+map.get(i)+" of Christmas my true love gave to me: ";
			song +=verses(start, i);
			final_song+=song+"\n\n";
		}
		return final_song;
		
    }
	
	public static void main(String args[]){
		TwelveDays td=new TwelveDays();
		String song = td.sing();
		System.out.println(song);
		}
	
}
