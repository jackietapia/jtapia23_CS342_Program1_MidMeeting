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

import java.util.ArrayList;

public class City {

    private String city;
    private String state;
    private int id;

    private boolean visited;


    private ArrayList<Connection> connections;
    private float[] distances;

    private float average;

    public City()
    {
        city = null;
        state = null;
        id = -9999;
    }

    public City(String city, String state, Boolean visited, int id, int size)
    {
        this.city = city;
        this.state = state;
        this.id =id;
        this.connections = new ArrayList<Connection>();
        this.distances = new float[size];
        this.average = 0;
    }

    public ArrayList<Connection> getConnection()
    {
        return this.connections;
    }

    public float[] getDistanceArray() { return this.distances; }

    public String getCity()
    {
        return this.city;
    }

    public String getState()
    {
        return this.state;
    }

    public int getId()
    {
        return this.id;
    }

    public void setDistanceArray(float[] array)
    {
        this.distances = array;
    }

    public void setAverage(float avg)
    {
        this.average = avg;
    }
}
