public abstract class EnigmaSuper {
    public abstract char encode(char ch);
    public abstract char decode(char ch);
    public int check_for_self_mapping(Character[] alphaperm) {
        for (int i = 0; i < alphaperm.length; i++) {
            if (alphaperm[i] == i + 'a') {
                return i;
            }
        }
        return -1;
    }
}
