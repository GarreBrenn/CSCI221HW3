public class Plugboard {
    char[] emap, dmap;  // encode map and decode map instance variables
    
    // decide on your instance variables to represent the plugboard
    // NOTE:  you need to be able to map and reverse-map
    //        (remember the direction of flow when discussed in class)
    
    // swaps is a string with upto 10 pairs of characters to swap (eg. "ajqzbw")
    public Plugboard(Character[] swaps) {
	if (swaps.length > 20) {
	    System.out.println("Plugboard must have 10 or fewer letter pairs");
	    System.exit(1);
	}
	if (swaps.length % 2 != 0) {
	    System.out.println("Plugboard must have even number of letters");
	    System.exit(1);
	}
	emap = new char[26];   // encode map instance variable
	dmap = new char[26];   // decode map instance variable

	for (int i = 0; i < emap.length; i++) {  // encode map, straight through
            emap[i] = (char) (i + 'a');
	}

	for (int i = 0; i < swaps.length / 2; i++) {  // build encode map
	    int p1 = swaps[2*i] - 'a';
	    int p2 = swaps[2*i+1] - 'a';

	    // swap
	    char temp = emap[p1];
	    emap[p1] = emap[p2];
	    emap[p2] = temp;
	}

	for (int i = 0; i < emap.length; i++) {  // build decode (reverse) map
            dmap[emap[i]-'a'] = (char) (i + 'a');
	}
    }

    // encode one character through the plugboard
    // (you may assume that ch is a valid character in range ['a', 'z']
    public char encode(char ch) {
	return emap[ch - 'a'];
    }

    // decode one character through the plugboard
    // (you may assume that ch is a valid character in range ['a', 'z']
    public char decode(char ch) {
	return dmap[ch - 'a'];
    }
}
