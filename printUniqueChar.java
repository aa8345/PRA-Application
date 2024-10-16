import java.util.*;

public class printUniqueChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result="";
        String str = sc.nextLine();
        sc.close();

        Set<Character> mySet = new HashSet<>();

        for(char ch : str.toCharArray()){
            if(!mySet.contains(ch)){
                result+=ch;
                mySet.add(ch);
            }
        }
        System.out.println(result);
    }
}
