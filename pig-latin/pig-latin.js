//
// This is only a SKELETON file for the 'Pig Latin' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

/*
 * Author : Haripriya Baskaran
 * Created Date and Time : 25-07-2020 20:00 IST
 * Purpose : Exercism Practice Problem Solutions
 */

export class translator {
  static translate(sentence) {
  	  var vowels = ["a","e","i","o","u"];
	  var sent = sentence.trim().split(/\s+/);
	  var i;
	  for(i=0;i<sent.length;i++){
		var word = sent[i];
		if(vowels.includes(word[0])){
			word+="ay";
			sent[i]=word;
			continue;
		}
		else if((word[0]=="x" && word[1]=="r") ||
					(word[0]=="y" && word[1]=="t")){
			word+="ay";
			sent[i]=word;
			continue;
		}
		else{
			var isQUPresent = /[a-z&&[^aeiou]]*qu.*/;
			var isYpresentAsVowel = /[a-z&&[^aeiou]]*y[a-z&&[^aeiou]]*/;
			if(isQUPresent.test(word)){
				//Condition - Starts With Consonant and contains "qu" after it
				var newword = "";
				var index = -1;
				var j;
				for(j=0;j<word.length-1;j++){
						if(word[j]=="q" && word[j+1]=="u"){
							index = j+2;
							break;
						}
					}
				newword = word.substring(index,word.length);
				newword += word.substring(0, index);
				newword+="ay";
				word = newword;
				sent[i] = word;
				continue;
			}
			else if(isYpresentAsVowel.test(word)){
				//Condition - Starts with Consonant and contains "y" as a vowel
				var newword = "";
				var index=-1;
				var j;
				for(j=0;j<word.length;j++){
					if(word[j]=='y'){
						index = j;
						break;
					}
				}
				newword = word.substring(index,word.length);
				newword += word.substring(0, index);
				newword+="ay";
				word = newword;
				sent[i] = word;
				continue;
			}
			else{
				//Condition- Starts with Consonant and no "qu" and "y" in between 
				var newword = "";
				var index=0;
				var j;
				for(j=0;j<word.length;j++){
					if(vowels.includes(word[j])){
						index = j;
						break;
					}
				}
				newword = word.substring(index,word.length);
				newword += word.substring(0, index);
				newword+="ay";
				word = newword;
				sent[i] = word;
				continue;
			}
			
		}
	  }
	  var result;
	  for(i=0;i<sent.length;i++){
		//document.write(sent[i]+"</br>");
		result += sent[i]+" ";
	  }
    return result;
  }
}
