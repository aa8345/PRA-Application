import java.util.*;

public class removeDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        sc.close();
        String result = "";

        Set<Character> myset = new HashSet<>();

        for(char ch : str.toCharArray()){
            if(!myset.contains(ch)){
                result += ch;
                myset.add(ch);
            }
        }

        System.out.println(result);
    }
}
