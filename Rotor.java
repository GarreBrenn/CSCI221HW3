import java.util.*;
public class Rotor {
    Map <Character, Character> emap = new HashMap<Character, Character>();
    Map <Character, Character> dmap = new HashMap<Character, Character>();
	//char[] emap, dmap;  // encode map and decode map instance variables
    int pos;            // current position of the rotor

    // The parameter alphaperm below is a permutation of ['a','z']
    // startpos is the starting position of the rotor
    public Rotor(Character[] alphaperm, char startpos) {
	if (alphaperm.length != 26) {
	    System.out.println("Must have 26 letter permutation for Rotor");
	    System.exit(1);
	}

	//emap = new char[alphaperm.length];   // encode map instance variable
	//dmap = new char[alphaperm.length];   // decode map instance variable

	pos = startpos - 'a';  // startpos is a letter, 'a'-'z'

	for (int i = 0; i < alphaperm.length; i++) {  // build encode map
	    emap.put((char) (i +'a') ,alphaperm[i]);   // automatically converts to char
	}

	for (int i = 0; i < 26; i++) {  // build decode (reverse) map
		char p1 = emap.get((char)(i + 'a'));
		dmap.put(p1, (char)(i+'a'));
	}

	// for debugging below
	/*
	System.out.print("Rotor encryption map: ");
	for (int i = 0; i < emap.length; i++) {
	    System.out.print(emap[i]);
	}
	System.out.println();

	System.out.print("Rotor decryption map: ");
	for (int i = 0; i < emap.length; i++) {
	    System.out.print(dmap[i]);
	}
	System.out.println();
	*/
    }

    // encode one character, ch, according to the rotor "wiring"
    public char encode(char ch) {
	// formula below first converts 'a'-'z' to a (contact) position 0-25
	// then adds the rotor orientation position, pos
	// then mods with 26 to handle "wrap around"
	int input_contact_pos = (ch - 'a' + pos) % 26;
	return emap.get((char) (input_contact_pos + 'a'));
    }

    // decode one character, ch, according to the rotor "wiring"
    // (reverse dir). Decoding is a bit tricky.  First we need to
    // reverse map the incoming character.  Then, we need to "rotate"
    // (in the reverse direction) the decoded character by the
    // position, pos.  To do this, we can't just subtract pos (might
    // become negative), so we add 26, then subtract.

    public char decode(char ch) {
	// formula in brackets converts 'a'-'z' to a position 0-25
	char dec_ch = dmap.get(ch);   // decode at contact position ch - 'a'
	int output_contact_position = (dec_ch - 'a' + 26 - pos) % 26;
	return (char) (output_contact_position + 'a');
    }

    /*
       advance the roter one position.  Think about what instance
       variable(s) you need to keep track of this.  This method
       returns true of the rotor has made a complete turn; otherwise
       false
    */
    public boolean advance() {
	return ++pos % 26 == 0;
    }

    // reset the starting position for the rotor
    public void reset(char startpos) {
	pos = startpos - 'a';
    }
}
