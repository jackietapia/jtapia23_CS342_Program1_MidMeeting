/**
 * Program 1: Mid-Meeting
 *
 * Class: CS 342, Fall 2016
 * System: OS X, IntelliJ IDE
 * Author Code Number: 1075T
 *
 *
 * To Do: Find the city with the smallest average distance of travel for all participants
 *
 */

public class Connection {

    private City destination;
    private int distance;


    public Connection() {
        this.destination = null;
        this.distance = -9999;
    }

    public Connection(City destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public City getDest() {
        return this.destination;
    }

    public int getDistance() {
        return this.distance;
    }

}
