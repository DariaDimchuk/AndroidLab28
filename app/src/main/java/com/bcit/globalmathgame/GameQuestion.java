package com.bcit.globalmathgame;

import java.util.Random;

public class GameQuestion {
    public static final int MAX_RANDOM_EXCLUSIVE = 101;
    public static final int MAX_OPERATION_CHOICE = 4;

    public String question;
    public int number1;
    public int number2;
    public OPERATION operation;
    public String operationSymbol;


    public int correctAns;


    public GameQuestion(Random random){
        this.number1 = random.nextInt(MAX_RANDOM_EXCLUSIVE);
        this.number2 = random.nextInt(MAX_RANDOM_EXCLUSIVE);

        int operationNum = random.nextInt(MAX_OPERATION_CHOICE);

        switch (operationNum){
            case 0 :
                this.operation = OPERATION.ADDITION;
                this.operationSymbol = "+";
                this.correctAns = number1 + number2;
                break;
            case 1 :
                this.operation = OPERATION.SUBTRACTION;
                this.operationSymbol = "-";
                this.correctAns = number1 - number2;
                break;
            case 2 :
                this.operation = OPERATION.MULTIPLICATION;
                this.operationSymbol = "x";
                this.correctAns = number1 * number2;
                break;
            case 3 :
                this.operation = OPERATION.DIVISION;
                this.operationSymbol = "/";

                this.correctAns = performDivisionOnThis(random);
                break;
        }

        this.question = number1 + " " + operationSymbol + " " + number2;
    }



    public int getBadAns(Random random){
        int operationNum = random.nextInt(MAX_OPERATION_CHOICE);

        int val = 0;
        switch (operationNum){
            case 0 :
                val = correctAns + random.nextInt(50);
                break;
            case 1 :
                val = correctAns - random.nextInt(50);
                break;
            case 2 :
                val = correctAns * random.nextInt(30);
                break;
            case 3 :
                int num = random.nextInt(30);

                val = performDivision(correctAns, num, random);
        }

        if(val == correctAns){
            val = getBadAns(random);
        }


        return val;
    }


    private int performDivisionOnThis(Random random){
        //in case divisor is 0
        while(number2 == 0){
            number2 = random.nextInt(MAX_RANDOM_EXCLUSIVE);
        }

        //try to get a whole number
        while(number1 % number2 != 0){
            number1 = random.nextInt(MAX_RANDOM_EXCLUSIVE);
            return performDivisionOnThis(random);
        }

        return number1 / number2;
    }


    private int performDivision(int left, int right, Random random){
        //in case divisor is 0
        while(right == 0){
            right = random.nextInt(MAX_RANDOM_EXCLUSIVE);
        }

        //try to get a whole number
        while(left % right != 0){
            left = random.nextInt(MAX_RANDOM_EXCLUSIVE);
            return performDivision(left, right, random);
        }

        return left / right;
    }


    public enum OPERATION{
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }

}
