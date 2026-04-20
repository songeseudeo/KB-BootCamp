package sub.etc;

public class StringMethodExample {
    public static void main(String[] args) {
        
        String str = "  Hello Java World  ";
        
        System.out.println("원본 문자열: [" + str + "]");
        System.out.println("1. length()          : " + str.length());
        System.out.println("2. charAt(7)         : " + str.charAt(7));
        System.out.println("3. substring(7, 11)  : " + str.substring(7, 11));
        System.out.println("4. equals(\"hello\")   : " + str.equals("hello"));
        System.out.println("5. equalsIgnoreCase  : " + str.trim().equalsIgnoreCase("hello java world"));
        System.out.println("6. indexOf(\"Java\")    : " + str.indexOf("Java"));
        System.out.println("7. contains(\"World\") : " + str.contains("World"));
        System.out.println("8. replace(\"Java\", \"Python\") : " + str.replace("Java", "Python"));
        System.out.println("9. trim()            : [" + str.trim() + "]");
        
        String[] arr = str.trim().split(" ");
        System.out.print("10. split(\" \")       : ");
        for (String s : arr) {
            System.out.print("[" + s + "] ");
        }
        System.out.println();


    }
}