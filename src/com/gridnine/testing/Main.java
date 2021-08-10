package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Список всех рейсов");
        printFlights(flights);
        space();
        Filters flightFilter = new FlightFilters();
        System.out.println("Список всех рейсов за исключением уже вылетевших");
        printFlights(flightFilter.alreadyInFlight(flights));
        space();
        System.out.println("Список всех рейсов за исключением прибывающие раньше вылета");
        printFlights(flightFilter.arBefDep(flights));
        space();
        System.out.println("Список всех рейсов за исключением тех, что проведут на земле более двух чаосв");
        printFlights(flightFilter.grTime(flights));
        }

    public static void space(){
        System.out.println("___");
    }

    public static void printFlights(List<Flight> flights){
        for (Flight flight: flights) {
            System.out.println(flight.getSegments());
        }
    }

}