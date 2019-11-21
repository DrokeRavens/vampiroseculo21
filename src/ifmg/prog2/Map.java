package ifmg.prog2;

import java.util.ArrayList;

/**
 * @author  Grupo IFMG-Sabará
 * @version v3
 */
public class Map
{
    private ArrayList<Room> lastRooms;
    Map()
    {
        lastRooms = new ArrayList<>();
    }

    public void drawMap(Room currentLocation)
    {
        String mapString = "";
        for(Room lastDiscoveredRooms : lastRooms)
        {
            //if(lastDiscoveredRooms.getExit(""))
        }
    }

    public void addDiscoveredRoom(Room discoveredRoom)
    {
        if(!lastRooms.contains(discoveredRoom))
        {
            lastRooms.add(discoveredRoom);
        }
    }
}