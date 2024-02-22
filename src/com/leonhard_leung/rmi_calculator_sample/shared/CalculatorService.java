package com.leonhard_leung.rmi_calculator_sample.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorService extends Remote {
    double add(double a, double b) throws RemoteException;
    double subtract(double a, double b) throws RemoteException;
    double multiply(double a, double b) throws RemoteException;
    double divide(double a, double b) throws RemoteException;
    double exponent(double a, double b) throws RemoteException;
    double modulo(double a, double b) throws RemoteException;
} // end of calculateExpression
