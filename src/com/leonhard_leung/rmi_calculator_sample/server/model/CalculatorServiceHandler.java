package com.leonhard_leung.rmi_calculator_sample.server.model;

import com.leonhard_leung.rmi_calculator_sample.shared.CalculatorService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServiceHandler extends UnicastRemoteObject implements CalculatorService {
    public CalculatorServiceHandler() throws RemoteException{}

    @Override
    public double add(double a, double b) throws RemoteException {
        return a + b;
    } // end of add

    @Override
    public double subtract(double a, double b) throws RemoteException {
        return a - b;
    } // end of subtract

    @Override
    public double multiply(double a, double b) throws RemoteException {
        return a * b;
    } // end of multiple

    @Override
    public double divide(double a, double b) throws RemoteException {
        if (b != 0) {
            return a / b;
        } else throw new IllegalArgumentException(); // throw exception if denominator is 0
    } // end of divide

    @Override
    public double exponent(double a, double b) throws RemoteException {
        return Math.pow(a, b);
    } // end of exponent

    @Override
    public double modulo(double a, double b) throws RemoteException {
        return 0;
    } // end of modulo
} // end of CalculatorServiceHandler
