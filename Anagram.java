/** Functions for checking if a given string is an anagram. */
public class Anagram {

    public static void main(String args[]) {

        System.out.println(isAnagram("silent","listen"));  
        System.out.println(isAnagram("William Shakespeare","I am a weakish speller"));
        System.out.println(isAnagram("Madam Curie","Radium came"));
        System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort"));

        System.out.println(preProcess("What? No way!!!"));

        System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

        String str = "1234567";
        Boolean pass = true;

        for (int i = 0; i < 10; i++) {
            String randomAnagram = randomAnagram(str);
            System.out.println(randomAnagram);
            pass = pass && isAnagram(str, randomAnagram);
            if (!pass) break;
        }

        System.out.println(pass ? "test passed" : "test Failed");
    }

    public static boolean isAnagram(String str1, String str2) {

        String s1 = preProcess(str1);
        String s2 = preProcess(str2);

        if (s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int index = s2.indexOf(c);

            if (index == -1) return false;

            s2 = s2.substring(0, index) + "*" + s2.substring(index + 1);
        }

        return true;
    }

    public static String preProcess(String str) {
        String cleaned = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isLetter(c)) {
                cleaned += Character.toLowerCase(c);
            }
        }

        return cleaned;
    }

    public static String randomAnagram(String str) {
        String temp = preProcess(str);
        String result = "";

        while (temp.length() > 0) {
            int i = (int)(Math.random() * temp.length());
            char c = temp.charAt(i);

            result += c;

            temp = temp.substring(0, i) + temp.substring(i + 1);
        }

        return result;
    }
}

