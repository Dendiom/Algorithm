package TestOne.fifty_to_hundred;


public class FiftyEight {

    public static int lengthOfLastWord(String s) {   // normal way
        if (s == null || s.length() == 0)
            return 0;
        String[] words = s.trim().split(" ");
        return words[words.length - 1].length();
    }

    public static int lengthOfLastWordOneLine(String s) {         // nothing but short
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("sdfd"));
        System.out.println(lengthOfLastWord("sd fd"));
        System.out.println(lengthOfLastWordOneLine("sd fd fff f "));
    }
}

