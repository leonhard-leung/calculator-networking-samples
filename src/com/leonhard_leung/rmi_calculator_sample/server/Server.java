package com.leonhard_leung.rmi_calculator_sample.server;

import com.leonhard_leung.rmi_calculator_sample.server.model.CalculatorServiceHandler;
import com.leonhard_leung.rmi_calculator_sample.server.model.PalindromeServiceHandler;
import com.leonhard_leung.rmi_calculator_sample.shared.CalculatorService;
import com.leonhard_leung.rmi_calculator_sample.shared.PalindromeService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    private static final int PORT = 2000; // for easy port configuration

    public static void main(String[] args) {
        try {
            // create instances of service handlers
            CalculatorService calculatorService = new CalculatorServiceHandler();
            PalindromeService palindromeService = new PalindromeServiceHandler();

            // create RMI registry on port 2000
            Registry registry = LocateRegistry.createRegistry(PORT);

            // bind service objects to names in the registry
            registry.rebind("Calculator Service", calculatorService);
            registry.rebind("Palindrome Service", palindromeService);

            System.out.println("Services bound"); // status message
        } catch (RemoteException exception) {
            exception.printStackTrace();
        }
    } // end of main
} // end of Server
