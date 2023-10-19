package Round_2;

import java.util.*;

public class FourthProgram {

    public static HashMap<Integer ,Character[]> map = new HashMap<>();
    public static int[] arr = new int[27];
    public static void declareMap(){

        map.put(2 ,new Character[]{'A' ,'B' ,'C'});
        map.put(3,new Character[]{'D' ,'E' ,'F'});
        map.put(4,new Character[]{'G' ,'H' ,'I'});
        map.put(5,new Character[]{'J' ,'K' ,'L'});
        map.put(6,new Character[]{'M' ,'N' ,'O'});
        map.put(7,new Character[]{'P' ,'Q' ,'R' , 'S'});
        map.put(8,new Character[]{'T' ,'U' ,'V'});
        map.put(9,new Character[]{'W' ,'X' ,'Y','Z'});
        map.put(1,new Character[]{' '});


    }

    public static void main(String[] args) {

        declareMap();
        String alpha = "";

        for(int i = 0; i<26 ;i++){

            alpha+=(char)('A'+i);

        }


        Scanner input = new Scanner(System.in);
        String s= input.nextLine();
        s = touppercase(s);
        declareMap();

        String res = "";

        for(int i= 0; i<s.length() ; i++){

            if(s.charAt(i) ==' '){
            res+=Integer.toString(1);
            res+='(';
            res+=arr[arr.length-1];
            res+=')';
            }else {

                if(s.charAt(i) >='A' && s.charAt(i) <='O'){
                    int num = s.charAt(i)-'A'+1;
                    int p = num/3;

                    res+=Integer.toString(p);
                    res+='(';

                    int integer = 0;

                    for(int j = 0; j<map.get(p).length ; j++){
                        if(map.get(p)[j] == s.charAt(i)){
                            res+=j+1;
                            break;
                        }
                    }

                    res+= integer;
                    res+=')';
                }
                else if(s.charAt(i) >='P' && s.charAt(i)<='S'){

                    int num = 7;
                    res+=Integer.toString(num);
                    res+='(';

                    for(int k = 0 ; k<map.get(num).length ; k++){
                        if(map.get(num)[k] == s.charAt(i)){
                            res+=k+1;
                            break;
                        }
                    }

                    res+=num;
                    res+=')';


                }else if(s.charAt(i) >='T' && s.charAt(i) <='S'){

                    int num = 8;
                    res+=Integer.toString(num);
                    res+='(';

                    for(int k = 0 ; k<map.get(num).length ; k++){
                        if(map.get(num)[k] == s.charAt(i)){
                            res+=k+1;
                            break;
                        }
                    }

                    res+=num;
                    res+=')';

                }else if(s.charAt(i) >='W' && s.charAt(i) <='Z'){

                    int num = 9;
                    res+=Integer.toString(num);
                    res+='(';

                    for(int k = 0 ; k<map.get(num).length ; k++){
                        if(map.get(num)[k] == s.charAt(i)){
                            res+=k+1;
                            break;
                        }
                    }

                    res+=num;
                    res+=')';

                }else{

                    res+='0';
                    res+='(';
                    res+='1';
                    res+=')';

                }

            }
        }
        System.out.println(res);


    }


    private static String touppercase(String s){

        String res = "";

        for(int i = 0 ; i<s.length() ; i++){

            if(s.charAt(i) >='a' && s.charAt(i) <='z'){
                res+=(char)(s.charAt(i)-32);
            }else{
                res+=s.charAt(i);
            }

        }


        return res;
    }

}