package Round_2;

import java.util.*;

public class FirstProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input : Enter the characters in sequence...   ");
        String s = input.nextLine();

        Character[] arr = new Character[s.length()];

        for(int i = 0 ; i<s.length() ;i++){

            arr[i] = s.charAt(i);

        }

          MoveVowels1(arr);

    }


    private static void MoveVowels1(Character[] arr) {
        int i= 0;
        int count = 0;

        while(i<arr.length){

            if(isVowel(arr[i])){
                count++;
                i++;
            }else{
                swap(i-count , i , arr);
                i++;
            }

        }


        System.out.println(Arrays.toString(arr));

    }

    private static boolean isVowel(Character ch){

        if(ch =='a' || ch=='A' || ch=='e' || ch=='E' || ch=='i' || ch =='I' || ch == 'o' || ch =='O' || ch == 'u' || ch=='U'){
            return true;
        }

        return false;
    }
    private static void swap(int i , int j , Character[] arr){

        Character temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;

    }


    private static void MoveVowels2(Character[] arr){

        //Counting vowels
        int countVowels = 0;

        for(int i = 0; i<arr.length ; i++){
            if(isVowel(arr[i])){
                countVowels++;
            }
        }

        System.out.println(countVowels);

        int j = arr.length-countVowels;

        int i =0;
        while(i<arr.length && j<arr.length){


            if(isVowel(arr[i]) && j<arr.length){

                while(isVowel(arr[i])){
                    swap(i ,j , arr);
                    j++;
                }
                i++;

            }else {
                i++;
            }


        }
        System.out.println(Arrays.toString(arr));;

    }
}