package com.leonhard_leung.rmi_calculator_sample.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PalindromeService extends Remote {
    boolean isPalindrome(String text) throws RemoteException;
} // end of PalindromeService interface
