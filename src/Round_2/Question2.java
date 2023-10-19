package Round_2;

import java.util.*;

//Time Complexity - O(n)
//Auxillay Compexity - O(n)

public class Question2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String s1 = input.next();
        char[] str = s1.toCharArray();
        String s2 = input.next();

        int[] occurence = Kmp(s1 , s2);


        for(int i=0 ; i<occurence.length ; i++){

            if(occurence[i] == s2.length()){

                clean(i-s2.length()+1 , i , str);

            }


        }

        String res = new String();

        for(int i= 0; i<occurence.length ; i++){

            if(str[i] == '*'){
                res+='X';
                i+=s2.length();
                i--;
            }else{
                res+=str[i];
            }
        }


        String newString = "";


        for(int i = 0 ; i<res.length();i++){

            if(res.charAt(i) =='X'){
                while(i<res.length() && res.charAt(i)=='X'){
                    i++;
                }
                newString+='X';
                if(i<res.length()) newString+=res.charAt(i);

            }else{
                    newString+=res.charAt(i);

            }

        }

        System.out.println(newString);
    }

    private static void clean(int i, int i1, char[] str) {

        for(;i<=i1;i++){
            str[i] = '*';
        }
    }

    private static int[] Kmp(String s1 , String s2){

        int[] lps = lps(s2);
        int[] brr = new int[s1.length()];


        int i =0;
        int j =0;
        int count = 0;

        while(i<s1.length()){

            if(s1.charAt(i) ==s2.charAt(j)){

                brr[i] = ++count;
                i++;
                j++;

                if(j>=s2.length()){

                    j=0;
                    count=0;

                }

            }else{
                count=0;
                if(j==0){
                    i++;
                }else{

                    j = lps[j-1];

                }


            }


        }

        return brr;


    }

    private static int[] lps(String s ){

        int[] lps = new int[s.length()];

        int i =0;
        int j =1;

        while(j<s.length()){

            if(s.charAt(i) ==s.charAt(j)){

                lps[j] = i+1;
                i++;
                j++;

            }else{

                if(i==0){
                    j++;
                }else{

                    i = lps[i-1];

                }


            }


        }

        return lps;

    }
}
