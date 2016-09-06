/**
 * Created by jackietapia on 8/31/16.
 */

public class AdjacencyList {

    // instance variables
    private String cityName;
    private int stateID;
    private String abb;


    // constructor
    public AdjacencyList(String cityName, int stateID, String abb)
    {
        this.cityName = cityName;
        this.stateID = stateID;
        this.abb = abb;
    }


    public String getCityName()
    {
        return this.cityName;
    }

    public int getStateID()
    {
        return this.stateID;
    }

    public String getAbb()
    {
        return this.abb;
    }



}
