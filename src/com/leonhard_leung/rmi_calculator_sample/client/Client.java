package com.leonhard_leung.rmi_calculator_sample.client;

import com.leonhard_leung.rmi_calculator_sample.shared.CalculatorService;
import com.leonhard_leung.rmi_calculator_sample.shared.PalindromeService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Client {
    private static final int PORT = 2000; // for easy port configuration
    private static final String HOST_ADDRESS = "localhost"; // for easy server address configuration

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            Registry registry = LocateRegistry.getRegistry(HOST_ADDRESS, PORT);

            int choice;
            do {
                choice = menu(in);

                switch (choice) {
                    case 1 -> startCalculatorService(in, registry);
                    case 2 -> startPalindromeService(in, registry);
                }
            } while (choice != 3);

        } catch (RemoteException | NotBoundException exception) {
            exception.printStackTrace();
        }
    } // end of main

    public static void startCalculatorService(Scanner in, Registry registry) throws RemoteException, NotBoundException {
        CalculatorService calculatorService = (CalculatorService) registry.lookup("Calculator Service");

        double operand1;
        char operator;
        double operand2;

        try {
            System.out.println("\n<────────────────┤ Calculator ├────────────────>");
            System.out.println("\nPlease separate your expression by spaces (ex. 15 / 2)");
            System.out.println("\taccepted operators: +, -, *, /, ^, %");
            System.out.print("\nEnter Expression: ");
            String expression = in.nextLine().trim();
            String[] data = expression.split(" ");
            operand1 = Double.parseDouble(data[0]);
            operator = data[1].charAt(0);
            operand2 = Double.parseDouble(data[2]);
        } catch (NumberFormatException | IndexOutOfBoundsException exception) {
            System.out.println("  * invalid expression");
            return;
        }

        double result = 0;
        switch (operator) {
            case '+' -> result = calculatorService.add(operand1, operand2);
            case '-' -> result = calculatorService.subtract(operand1, operand2);
            case '*' -> result = calculatorService.multiply(operand1, operand2);
            case '/' -> {
                try {
                    result = calculatorService.divide(operand1, operand2);
                } catch (IllegalArgumentException exception) {
                    System.out.println("  * cannot divide by zero *");
                    return;
                }
            }
            case '^' -> result = calculatorService.exponent(operand1, operand2);
            case '%' -> result = calculatorService.modulo(operand1, operand2);
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        System.out.println(operand1 + " " + operator + " " + operand2 + " = " + decimalFormat.format(result));
    } // end of startCalculatorService

    public static void startPalindromeService(Scanner in, Registry registry) throws RemoteException, NotBoundException{
        PalindromeService palindromeService = (PalindromeService) registry.lookup("Palindrome Service");

        System.out.println("\n<────────────┤ Palindrome Checker ├────────────>");
        System.out.print("\nEnter a word: ");
        String word = in.nextLine().trim();

        boolean isPalindrome = palindromeService.isPalindrome(word);
        System.out.println(word + " is " + (isPalindrome ? "a palindrome" : "not a palindrome"));
    } // end of startPalindromeService

    public static int menu(Scanner in) {
        int choice;
        do {
            try {
                System.out.println("\n╔═══════════════════════════╗");
                System.out.println("║        Simple Menu        ║");
                System.out.println("║   ─────────────────────   ║");
                System.out.println("║   1. Calculator           ║");
                System.out.println("║   2. Palindrome Checker   ║");
                System.out.println("║   3. Exit Program         ║");
                System.out.println("╚═══════════════════════════╝");
                System.out.print("   Select: ");
                choice = in.nextInt();
                in.nextLine();
                if (choice < 1 || choice > 3) {
                    System.out.println("  * enter a number from the menu only *");
                }
            } catch(NumberFormatException exception) {
                System.out.println("  * invalid input *");
                choice = 0;
            }
        } while (choice < 1 || choice > 3) ;
        return choice;
    } // end of menu
} // end of Client
