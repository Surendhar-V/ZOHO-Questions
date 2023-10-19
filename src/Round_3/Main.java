package Round_3;

import java.util.*;

public class Main {

    public static ArrayList<Map<String, Integer>> database;
    public static Integer currentNode = 0;
    public static ArrayList<Integer> limitlist = new ArrayList<>();

    public static void main(String[] args) {

        limitlist.add(0);
        database = new ArrayList<>();
        database.add(new HashMap<>());

        Scanner input = new Scanner(System.in);

        while (true) {

            String command = input.next();

            String variable = "";

            if (!(command.equals("ROLLBACK")) && !(command.equals("BEGIN")) && (!command.equals("EXIT")) && (!command.equals("PRINT"))) {

                variable = input.next();
                variable.toUpperCase();
            }

            if (command.equals("BEGIN")) {

                begin();

            } else if (command.equals("SET")) {

                int value = input.nextInt();
                setVariable(variable, value);

            } else if (command.equals("GET")) {
                getVariable(variable);
            } else if (command.equals("COUNT")) {
                int num = Integer.parseInt(variable);
                countValues(num);
            } else if (command.equals("EXIT")) {
                break;
            } else if (command.equals("PRINT")) {

                for (Map<String, Integer> map : database) {

                    System.out.println(map);

                }

            } else if (command.equals("UNSET")) {
                unSetVariable(variable);
            } else if (command.equals("UPDATE")) {
                int value = input.nextInt();
                updateVariable(variable, value);
            } else if (command.equals("ROLLBACK")) {
                rollBack();
            } else if (command.equals("COMMIT")) {
                commit();
            }

        }


    }

    public static void begin() {

        currentNode++;
        database.add(new HashMap<String, Integer>());
        limitlist.add(currentNode);

    }

    public static void countValues(int num) {

        int tempnode = 0;
        int count = 0;

        for (Map<String, Integer> tempMap : database) {

            for (String a : tempMap.keySet()) {

                if (tempMap.get(a) == num) {
                    count++;
                }

            }

        }
        if (count != 0) System.out.println(count);
        else System.out.println("null");
    }

    public static void getVariable(String variable) {


        System.out.println(database.get(currentNode).get(variable) != null);

    }

    public static void setVariable(String variable, int value) {


        HashMap<String, Integer> tempMap = (HashMap<String, Integer>) database.get(currentNode);
        tempMap.put(variable, value);
        database.set(currentNode, tempMap);

    }

    public static void unSetVariable(String variable) {

        HashMap<String, Integer> tempMap = (HashMap<String, Integer>) database.get(currentNode);
        tempMap.put(variable, null);
        database.set(currentNode, tempMap);

    }

    public static void updateVariable(String variable, Integer value) {

        HashMap<String, Integer> tempMap = (HashMap<String, Integer>) database.get(currentNode);
        if (tempMap.keySet().contains(variable)) {
            tempMap.put(variable, value);
        } else {
            System.out.println("Variable not found");
        }
        database.set(currentNode, tempMap);


    }

    public static void rollBack() {
        currentNode--;
    }

    public static void commit() {

        database.remove(currentNode);
        currentNode--;
    }

}
