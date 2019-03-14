import java.util.*;
public class Plugboard extends EnigmaSuper{
    //char[] emap1, dmap1;  // encode map and decode map instance variables
	private Map<Character, Character> emap,dmap;

    
    // decide on your instance variables to represent the plugboard
    // NOTE:  you need to be able to map and reverse-map
    //        (remember the direction of flow when discussed in class)
    
    // swaps is a string with upto 10 pairs of characters to swap (eg. "ajqzbw")
    public Plugboard(Character[] swaps) {
    try {
		if (swaps.length > 20) {
			throw new Exception ("Plugboard must have 10 or fewer letter pairs");
		}
		if (swaps.length % 2 != 0) {
			throw new Exception ("Plugboard must have even number of letters");
		}
	}
    catch (Exception e) {
    	System.out.println(e.getMessage());
    	System.exit(1);
	}

	emap = new HashMap<>();
	dmap = new HashMap<>();
	//emap1 = new char[26];   // encode map instance variable
	//dmap1 = new char[26];   // decode map instance variable

	for (int i = 0; i < 26; i++) {  // encode map, straight through
		emap.put((char) (i + 'a'), (char) (i + 'a'));
	}

	for (int i = 0; i < swaps.length / 2; i++) {  // build encode map
	    char p1 = swaps[2*i];
	    char p2 = swaps[2*i+1];

	    // swap
		emap.put(p1, p2);
		emap.put(p2, p1);
	}

	for (int i = 0; i < 26; i++) {  // build decode (reverse) map
        char p1 = emap.get((char)(i + 'a'));
		dmap.put(p1, (char)(i+'a'));
	}
    }

    // encode one character through the plugboard
    // (you may assume that ch is a valid character in range ['a', 'z']
    public char encode(char ch) {
		return emap.get(ch);
    }

    // decode one character through the plugboard
    // (you may assume that ch is a valid character in range ['a', 'z']
    public char decode(char ch) {
    	return dmap.get(ch);
    }
}
