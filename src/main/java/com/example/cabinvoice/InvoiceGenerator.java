package com.example.cabinvoice;

public class InvoiceGenerator {

    private static final double COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        return Math.max(totalFare, MINIMUM_FARE);
    }
    
    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
    
    public InvoiceSummary calculateInvoiceSummary(Ride[] rides) {
        double totalFare = calculateFare(rides);   // UC-2 method
        return new InvoiceSummary(rides.length, totalFare);
    }

}
