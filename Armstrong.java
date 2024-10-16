// Armstrong Number : sum of digits raised to the power of n (no. of digits) 
//is equal to the number itself 

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.close();

       if(isArmstrong(num)){
        System.out.println("ARM");
       }
       else{
        System.out.println("NO");
       }
    }

    public static boolean isArmstrong(int num){
        String temp = Integer.toString(num);
        int n = temp.length();

        int sum = 0;

        for(char ch : temp.toCharArray()){
            sum+= Math.pow((int) ch, n); // to convert from char to int use:
        }                               // (int) ch .. Character.getNumericValue .. ch-'0'

        if(num==sum)return true;
        return false;
    }
}
