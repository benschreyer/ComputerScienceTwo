import java.util.HashSet;

public class Road implements Comparable<Road>
{
	private String name;
	private HashSet<Town> connections;
	private int distance;
	
	/**
	 * Construct a road between two Towns
	 * @param Town
	 * @param Town
	 * @param Distance
	 * @param Road name
	 */
	public Road(Town town, Town town2, int distance, String name) 
	{
		this.name = name;
		connections = new HashSet<Town>();
		connections.add(town);
		connections.add(town2);
		this.distance = distance;
	}

	/**
	 * Compare Road to other Road
	 * @param Road to compare to
	 */
	@Override
	public int compareTo(Road other) 
	{
		if(other.getConnections().equals(this.getConnections()))
		{
			return 0;
		}
		return -1;
	}

	/**
	 * Check for equality of Road with another Road
	 * @param Other Road
	 * @return True if the Roads are the same
	 */
	public boolean equals(Road other)
	{
		return this.compareTo(other) == 0;
	}
	
	/**
	 * Get the name of a town
	 * @return The name of town
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get a string representation of a town
	 * @return String representation of town
	 */
	public String toString()
	{
		return getName();
	}
	
	/**
	 * Get the Towns that this road connects
	 * @return Towns that this road connects
	 */
	public HashSet<Town> getConnections()
	{
		return connections;
		
	}
	/**
	 * Get the length of the road
	 * @return weight of the road
	 */
	public int getWeight()
	{
		return distance;
	}
}
