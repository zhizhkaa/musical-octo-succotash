import java.util.*;

/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }
    
    /** Check if location equals **/
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) return false;
        Location l = (Location) o;
        return xCoord == l.xCoord && yCoord == l.yCoord;
    }
    
    /** Get Object hash code **/
    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }
}