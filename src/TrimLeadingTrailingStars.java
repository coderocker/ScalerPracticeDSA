public class TrimLeadingTrailingStars {
    public static void main(String[] args) {
        TrimLeadingTrailingStars tts = new TrimLeadingTrailingStars();
//        System.out.println(tts.solve("*"));
//
//        System.out.println(tts.lowerToUpper("test"));

        System.out.println(tts.isPalindrome("abba"));

    }

    public String solve(String A) {
        StringBuilder sb = new StringBuilder(A);

        while (sb.length() > 0 && (sb.charAt(0) == '*' || sb.charAt(sb.length()-1) == '*')) {
            if(sb.length() > 0 && sb.charAt(0) == '*') {
                sb.deleteCharAt(0);
            }
            if(sb.length() > 0 && sb.charAt(sb.length()-1) == '*') {
                sb.deleteCharAt(sb.length()-1);
            }
        }



        return sb.toString();
    }

    public int subString(String A, String B) {
        return A.indexOf(B);
    }

    private String lowerToUpper(String A) {
        int asciiChLowerA = 'a';
        int asciiChUpperA = 'A';
        int asciiChLowerZ = 'z';

        int asciiDiff = asciiChLowerA - asciiChUpperA;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<A.length(); i++) {
            char ch = A.charAt(i);
            if(ch >= asciiChLowerA && ch <= asciiChLowerZ) {
                ch = (char)(ch - asciiDiff);
            }
            sb.append(ch);
        }
        return sb.toString();
    }


    private int isPalindrome(String str) {
        int strLn = str.length();
        for(int i=0, j=strLn-1; i < (strLn/2); i++, j--) {
            if(str.charAt(i) != str.charAt(j)) {
                return 0;
            }
        }
        return 1;
    }


    private static void printVowelsAndConsonants(String str) {
        int countVowels = 0;
        for(int i=0,j=str.length()-1; i <=j ; i++, j--) {
            if(isVowel(str.charAt(i))) {
                countVowels++;
            }
            if(i<j) {
                if(isVowel(str.charAt(j))) {
                    countVowels++;
                }
            }
        }

        System.out.print(countVowels + ' ' + (str.length() - countVowels));
    }

    private static boolean isVowel(char ch) {
        String vowels = "aeiou";

        int index = vowels.indexOf(ch);

        if(index >= 0) {
            return  true;
        } else {
            return false;
        }
    }

}
