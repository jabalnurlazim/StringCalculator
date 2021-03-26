package main.java.calc;

import java.util.Scanner;

public class StringCalculator {

    public static String Calculator(String str) {
        // will get all numbers and store it to `numberStr`
        String numberStr[] = str.replaceAll("[+*/()-]+"," ").split(" ");
        // will get all operators and store it to `operatorStr`
        String operatorStr[] = str.replaceAll("[0-9()]+","").split("");

        int total = Integer.parseInt(numberStr[0]);

        for (int i=0; i<operatorStr.length; i++) {
            switch (operatorStr[i]) {
                case "+" :
                    total += Integer.parseInt(numberStr[i+1]);
                    break;
                case "-" :
                    total -= Integer.parseInt(numberStr[i+1]);
                    break;
                case "*" :
                    total *= Integer.parseInt(numberStr[i+1]);
                    break;
                case "/" :
                    total /= Integer.parseInt(numberStr[i+1]);
                    break;
            }

            if(i+2 >= operatorStr.length) continue; // if meets the last operands already
            numberStr[i+1] = String.valueOf(total);

        }
        return String.valueOf(total);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(Calculator(s.nextLine()));
    }
}
