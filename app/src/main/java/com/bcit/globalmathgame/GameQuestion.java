package com.bcit.globalmathgame;

import java.util.Random;

public class GameQuestion {
    public String question;
    public int number1;
    public int number2;
    public OPERATION operation;
    public String operationSymbol;


    public int correctAns;


    public GameQuestion(Random random){
        this.number1 = random.nextInt(101);
        this.number2 = random.nextInt(101);

        int operationNum = random.nextInt(4);

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

                //in case divisor is 0
                while(number2 == 0){
                    number2 = random.nextInt(101);
                }

                this.correctAns = number1 / number2;
                break;
        }

        this.question = number1 + " " + operationSymbol + " " + number2;
    }



    public int getBadAns(Random random){
        int range = random.nextInt(50);

        int operationNum = random.nextInt(4);

        int val = 0;
        switch (operationNum){
            case 0 :
                val = correctAns + random.nextInt(range);
                break;
            case 1 :
                val = correctAns - random.nextInt(range);
                break;
            case 2 :
                val = correctAns * random.nextInt(range);
                break;
            case 3 :
                int num = random.nextInt(range);

                //in case divisor is 0
                while(num == 0){
                    num = random.nextInt(100);
                }

                val = correctAns / num;
        }

        return val;
    }


    public enum OPERATION{
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }

}
