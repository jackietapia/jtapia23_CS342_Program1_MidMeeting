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


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Author Code Number: " + "1075T");
        System.out.println("Class: CS 342, Fall 2016");
        System.out.println("Program: #1, Mid Meeting\n\nAnswer:");

        File file = new File("CityNames.txt");

        ArrayList<City> cities = new ArrayList<>();

        int index = 0;
        try{

            Scanner sc  = new Scanner(file);
            String input = sc.nextLine();

            int size = Integer.parseInt(input);

            cities.ensureCapacity(size);


            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] newLine = line.split(", ");

                City c = new City(newLine[0], newLine[1], false, (index+1), size);

                index++;

                cities.add(c);

            }
            sc.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }


        File file2 = new File("CityDistances.txt");

        try {

            Scanner sc2 = new Scanner(file2);
            sc2.nextLine();

            while (sc2.hasNextLine()) {

                String line2 = sc2.nextLine();
                String[] newLine2 = line2.split(" ");
                int srcCity = (Integer.parseInt(newLine2[0]))-1;
                int destCity = (Integer.parseInt(newLine2[1]))-1;
                int distance = (Integer.parseInt(newLine2[2]));

                Connection connection1 = new Connection(cities.get(destCity), distance);
                Connection connection2 = new Connection(cities.get(srcCity), distance);

                cities.get(srcCity).getConnection().add(connection1);
                cities.get(destCity).getConnection().add(connection2);


            }

            sc2.close();

        }
        catch (FileNotFoundException e)
        {
                e.printStackTrace();
        }

        for(City city: cities)
        {
            city.setDistanceArray(dijkstra(cities, (city.getId())-1, cities.size()));
        }


        File file3 = new File("Participants.txt");

        int i = 0;

        try{
            Scanner sc3 = new Scanner(file3);

            int size = Integer.parseInt(sc3.nextLine());

            int[] cityIDs = new int[size];

            while(sc3.hasNextLine())
            {
                String line3 = sc3.nextLine();
                String[] newLine3 = line3.split(" ");

                int id = Integer.parseInt(newLine3[1]) - 1;
                cityIDs[i] = id;
                i++;
            }

            float[] averages = new float[cities.size()];
            int count = 0;

            for(City city: cities)
            {
                city.setAverage(getAverage(city, cityIDs));
                averages[count] = getAverage(city, cityIDs);
                count++;
            }

            getMinValue(cities, averages);

            sc3.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }


    public static float[] dijkstra(ArrayList<City> cities, int start, int numOfCities)
    {
        ArrayList<Connection> temp;
        boolean[] isVisited = new boolean[numOfCities];
        float[] distances = new float[numOfCities];
        int currentVertex;
        int adjacentVertex;
        int weight;
        float shortestNewDistance;


        /**
         * Initialize all cities as being unvisited
         */
        for(int x = 0; x < numOfCities; x++)
        {
            isVisited[x] = false;
            distances[x] = Integer.MAX_VALUE;
        }

        distances[start] = 0;
        currentVertex = start;

        /** main loop that is continued until all cities have been visited **/
        while(isVisited[currentVertex] == false)
        {
            isVisited[currentVertex] = true;

            temp = cities.get(currentVertex).getConnection();

            int j = 0;
            while(j < temp.size()){
                adjacentVertex = (temp.get(j).getDest().getId()) - 1;
                weight = temp.get(j).getDistance();


                if(distances[adjacentVertex] > (distances[currentVertex] + weight)){
                    distances[adjacentVertex] = distances[currentVertex] + weight;
                }
                j++;
            }


            currentVertex = 0;
            shortestNewDistance = Integer.MAX_VALUE;

            for(int z = 0; z < numOfCities; z++)
            {
                if(isVisited[z] == false && (shortestNewDistance > distances[z]))
                {
                    shortestNewDistance = distances[z];
                    currentVertex = z;
                }
            }

        }

        return distances;

    }

    public static float getAverage(City city, int[] IDs)
    {
        float sum = 0;
        float avg;

        for(int id: IDs)
        {
            sum += city.getDistanceArray()[id];
        }

        avg = sum/IDs.length;

        return avg;
    }

    public static void getMinValue(ArrayList<City> cities, float[] array) {
        float minValue = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                index = i;
            }
        }
        System.out.println("City: " + cities.get(index).getCity() + ", "  + cities.get(index).getState()+ ". Average Distance: " + minValue);
    }


}

