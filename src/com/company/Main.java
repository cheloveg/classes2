package com.company;

import java.util.Arrays;
import java.util.Scanner;

class Stack {
    int[] stck = new int[10];
    int tos;

    public Stack() {
        tos = -1;
    }

    void push(int item) {
        if (tos+1 >= stck.length*0.6 || tos+2 >= stck.length) {
            int[] old=stck.clone();
            stck = new int[(int) ((double)old.length*1.3)];
            System.arraycopy(old, 0, stck, 0, old.length);
        }
        try {
            stck[++tos] = item;
        }catch (ArrayIndexOutOfBoundsException e){
            int[] old=stck.clone();
            stck = new int[(int) ((int) 1+((double)old.length*1.3))];
            System.arraycopy(old, 0, stck, 0, old.length);
            stck[tos]=item;
        }
    }

    int pop() {
        if (tos < 0) {
            System.out.println("Стек пустой");
            return 0;
        }
        if(tos+1<stck.length*0.3 && (int) stck.length*0.3 != 0){
            int[] old=stck.clone();
            stck = null;
            stck = new int[(int) (old.length*0.3)];
            System.arraycopy(old, 0, stck, 0, stck.length);
        }
        int deletedNum=stck[tos--];
        stck[tos+1]=0;
        return deletedNum;
    }

    @Override
    public String toString() {
        return Arrays.toString(stck);
    }
}

public class Main {

    public static void menuOut() {
        System.out.println("1) добавить \n2) удалить \n3) выйти");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack stack1 = new Stack();

        menuOut();
        while (in.hasNextInt()) {
            int option=in.nextInt();
            if (option == 3)
                break;
            if (option == 1) {
                System.out.println("Введите значение: ");
                stack1.push(in.nextInt());
            }
            if(option == 2){
                System.out.println("Удалённое значение:" + stack1.pop());
            }
            System.out.println("Cостояние стека: " + stack1);

            menuOut();

        }
    }
}