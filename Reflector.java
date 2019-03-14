import java.util.*;
public class Reflector {
    // NOTE:  you need to be able to map and reverse-map
    //        (remember the direction of flow when discussed in class)
    
    // encryption map array and decryption map array
    //char[] emap, dmap;
	private Map<Character, Character> emap = new HashMap<>();
	private Map<Character, Character> dmap = new HashMap<>();

    // alphaperm is a permutation (rearrangement) of ['a','z']
    // NOTE: NO self mappings AND pairwise mapped.

    // helper function that checks for self mapping
    // return -1 if NO self map; otherwise return position of self map
    private int check_for_self_mapping(Character[] alphaperm)
    {
	for (int i = 0; i < alphaperm.length; i++) {
            if (alphaperm[i] == i + 'a') {
		return i;
	    }
	}
	return -1;
    }

    public Reflector(Character[] alphaperm) {
	if (alphaperm.length != 26) {
	    System.out.println("Must have 26 letter permutation for Reflector");
	    System.exit(1);
	}

	//emap = new char[alphaperm.length];
	//dmap = new char[alphaperm.length];

	// check for self-mapping
	int self_map_pos = check_for_self_mapping(alphaperm);
	if (self_map_pos >= 0) {
	    // self mapping, so print the mapping array and position of self map
	    for (int j = 0; j < alphaperm.length; j++) {
		System.out.print(alphaperm[j]);
	    }
	    System.err.println();
	    System.err.println("Reflector self mapping at position "
			       + self_map_pos);
	    System.exit(1);
	}
	    
	for (int i = 0; i < alphaperm.length; i++) {  // build encrypt map
	    emap.put(((char) (i + 'a')), alphaperm[i]);
		//emap[i] = alphaperm[i];   // automatically converts to char
	}

	for (int i = 0; i < 26; i++) {
		dmap.put(emap.get((char)(i + 'a')), (char)(i + 'a'));
	}

	// for debugging below
	/*
	System.out.print("Reflector encryption map: ");
	for (int i = 0; i < emap.length; i++) {
	    System.out.print(emap[i]);
	}
	System.out.println();

	System.out.print("Reflector decryption map: ");
	for (int i = 0; i < dmap.length; i++) {
	    System.out.print(dmap[i]);
	}
	System.out.println();
	*/
    }

    // encode one character through the reflector
    public char encode(char ch) {
		return emap.get(ch);
    }

    // decode one character through the reflector
    public char decode(char ch) {
	return dmap.get(ch);
    }
}
