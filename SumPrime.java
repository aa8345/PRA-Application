import java.util.*;
public class SumPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        int sum = 0;
        for(char ch : input.toCharArray()){
            if(isPrime(Character.getNumericValue(ch))){
                sum += Integer.parseInt(String.valueOf(ch));
            }
        }
        System.out.println(sum);
    }

    public static boolean isPrime(int n){
        if(n<2) return false;

        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
