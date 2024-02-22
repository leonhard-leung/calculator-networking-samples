package com.leonhard_leung.rmi_calculator_sample.server.model;

import com.leonhard_leung.rmi_calculator_sample.shared.PalindromeService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PalindromeServiceHandler extends UnicastRemoteObject implements PalindromeService {
    public PalindromeServiceHandler() throws RemoteException{}

    @Override
    public boolean isPalindrome(String text) throws RemoteException {
        String textInLowercase = text.toLowerCase();
        int textLength = textInLowercase.length();
        int halfLength = textLength % 2 == 0 ? (textLength / 2) : (textLength / 2) + 1; // round up if text length is odd

        // iterate up to the text's half-length, use (textLength - i - 1) to get the end position
        for (int i = 0; i < halfLength; i++) {
            if (textInLowercase.charAt(i) != textInLowercase.charAt(textLength - i - 1)) {
                return false;
            }
        }
        return true;
    } // end of isPalindrome
} // end of PalindromeServiceHandler
