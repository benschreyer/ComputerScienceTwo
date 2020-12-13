import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Town implements Comparable<Town>
{
	private String name;
    //Store the shortest path from a start node to this node
    private LinkedList<Town> shortestPath;
    private LinkedList<Road> shortestPathRoad;
    //Nodes that have directed edges from this node to them, each node also has an associated edge weight
    private Map<Town, Integer> adjacencyMap;
    //Store the shortest known distance from a start node to this node
    private int distance;
    
    /**
     * Construct a Town with a name
     * @param Name of Town
     */
    Town(String name)
    {
    	this.name = name;
    	shortestPath = new LinkedList<Town>();
       	shortestPathRoad = new LinkedList<Road>();
    	adjacencyMap = new HashMap<Town,Integer>();
    	distance = -1;
    }
    
	/**
	 * Get the name of a Town
	 * @return Name of this Town
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Set the name of a Town
	 * @param Name of this Town
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/**
	 * Compare Town to other
	 * @param Other Town
	 * @return Comparison result
	 */
	@Override
	public int compareTo(Town o) 
	{
		return o.getName().compareTo(name);
	}
	
	/**
	 * Check equality of Towns
	 * @param Other Town
	 * @return True if the objects are equal
	 */
	public boolean equals(Town o)
	{
		return o.compareTo(this) == 0;
	}
	
	/**
	 * Set the shortest known distance from this node to a source
	 * @param Distance
	 */
	public void setDistance(int x)
    {
        distance = x;
    }
	
	/**
	 * Get the shortest known distance from this node to a source
	 * @return Distance
	 */
    public int getDistance()
    {
        return distance;
    }
    
    /**
     * Get the string representation of Town
     * @return String representation of Town
     */
    public String toString()
    {
        return name;
    }

    /**
     * Add an adjacent Town to this Town
     * @param Adjacent Town
     * @param Distance to Town
     */
    public void addAdjacency(Town add,int weight)
    {
        if(add == this)
        {
            adjacencyMap.put(add,0);
        }
        else
        {
            adjacencyMap.put(add, weight);
        }
    }
    /**
     * Remove adjacency from Town
     * @param Town to remove adjacency to
     */
    public void removeAdjacency(Town r)
    {
    	adjacencyMap.remove(r);
    }
    

    /**
     * Get list of Towns from source to this node
     * @return LinkedList representing shortest path from source to this Town
     */
    public LinkedList<Town> getShortestPath()
    {
        return shortestPath;
    }
    
    /**
     * Get list of Roads from source to this node
     * @return LinkedList representing shortest path from source to this Town
     */
    public LinkedList<Road> getShortestPathRoad()
    {
        return shortestPathRoad;
    }

    /**
     * Get Towns adjacent to this Town 
     * @return Set of adjacent nodes
     */
    public Set<Town> getAdjacentNodes()
    {
        return adjacencyMap.keySet();
    }

    /**
     * Get the distance from this Town to another
     * @param Other Town
     * @return Distance to other Town
     */
    public int getWeightTo(Town node)
    {
        return adjacencyMap.get(node);
    }

}
