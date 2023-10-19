package Round_2;

import java.util.*;

public class ThirdProgram {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("enter the n");
        int n= input.nextInt();
        int[][] arr = new int[n][n];

        System.out.println("enter the values..");
        for(int i = 0; i<n ; i++){
            for(int j = 0 ; j<n ; j++){

                arr[i][j] = input.nextInt();

            }
        }

        System.out.println("Input done");

        helper(arr);

        for(int i = 0; i<n ; i++){
            for(int j = 0 ; j<n ; j++){

                System.out.print(arr[i][j]+ " ");


            }
            System.out.println();
        }

    }

    public static void helper(int[][] arr) {

        int n = arr.length;

        for(int i=0 ; i<n ;i++ ){



                swap(i,n-i-1,arr);

        }




    }


    private static void swap(int p , int s , int[][] arr){

        int temp =arr[p][p];
        arr[p][p] = arr[p][s];
        arr[p][s] = temp;


    }


}
