import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface 
{
	private Graph graph;
	/**
	 * Construct a new TownGraphManager
	 */
	TownGraphManager()
	{
		graph = new Graph();
	}

	/**
	 * Add a road to the map between two Towns with a name and weight
	 * @param Name of first Town
	 * @param Name of second Town
	 * @param Length of the Road
	 * @param Name of the road to be added
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) 
	{
		
		if(graph.containsEdge(new Town(town1), new Town(town2)))
		{
			return false;	
		}
		
		//System.out.println(town1 + " " + town2);
		graph.addEdge(graph.getVertex(town1), graph.getVertex(town2), weight, roadName);
		
		return true;
	}

	/**
	 * Get the name of a Road between two Towns
	 * @param First Town
	 * @param Second Town
	 * @return Name of Road between the Towns
	 */
	@Override
	public String getRoad(String town1, String town2) 
	{
		return graph.getEdge(new Town(town1), new Town(town2)).getName();
	}

	/**
	 * Add a Town by name to the map
	 * @param Name of the town
	 * @return True if the Town did not already exist and was added
	 */
	@Override
	public boolean addTown(String v) 
	{
		return graph.addVertex(new Town(v));
	}

	/**
	 *  Get a Town object from the map by name
	 *  @param Name of Town
	 *  @return Town object found, null if not found
	 */
	@Override
	public Town getTown(String name) 
	{
		return graph.getVertex(name);
	}

	/**
	 * Determines whether a Town is on the map
	 * @param Name of Town
	 * @return True if the Town is on the map
	 */
	@Override
	public boolean containsTown(String v) 
	{
		return getTown(v) != null;
	}

	/**
	 * Determines whether a Road exists between two Towns
	 * @param Name of first Town
	 * @param Name of second Town
	 * @return True if a Road exists between the two Towns
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2)
	{
		return null != graph.getEdge(new Town(town1), new Town(town2));
	}

	/**
	 * Get a list of all Road names
	 * @return List of all Road names
	 */
	@Override
	public ArrayList<String> allRoads() 
	{
		ArrayList<String> ret = graph.edgeList();
		Collections.sort(ret);
		return ret;
	}

	/**
	 * Delete a Road between two Towns
	 * @param Name of first Town
	 * @param Name of second Town
	 * @param Name of road between Towns
	 * @return True if the road was deleted
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) 
	{
		if(!containsRoadConnection(town1,town2))
		{
			return false;
		}
		graph.removeEdge(new Town(town1), new Town(town2), graph.getEdge(new Town(town1), new Town(town2)).getWeight(), road);
		return true;
	}

	/**
	 * Remove a Town from the map
	 * @param String name of the town
	 * @return True if the Town existed and was deleted
	 */
	@Override
	public boolean deleteTown(String v) 
	{
		return graph.removeVertex(new Town(v));
	}

	/**
	 * Get a list of all Town names
	 * @return List of Town names
	 */
	@Override
	public ArrayList<String> allTowns() 
	{
		ArrayList<String> ret = graph.vertexList();
		Collections.sort(ret);
		return ret;
	}

	/**
	 * Get the shortest path between two Towns
	 * @param Town where the path starts
	 * @param Town where the path ends
	 * @return List of strings giving directions between the Towns
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) 
	{
		Town src = getTown(town1);
		Town stp = getTown(town2);
	

		if(src == null || stp == null)
		{
			return null;
		}
		ArrayList<String> ret = graph.shortestPath(src, stp);

		return ret;
		
	}
	/**
	 * Load a map stored in a text file
	 * @param File to read in
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void populateTownGraph(File selectedFile) throws IOException, FileNotFoundException
	{

		    Scanner scanner = new Scanner(selectedFile);
		    
		    while (scanner.hasNextLine()) 
		    {
		    	
		        String[] line = scanner.nextLine().split(";");
		        if(line.length != 3)
		        {
		        	throw new FileNotFoundException();
		        }
		        addTown(line[1]);
		        addTown(line[2]);
		        addRoad(line[1],line[2],Integer.parseInt(line[0].split(",")[1]),line[0].split(",")[0]);
		    }
		    scanner.close();
		
	}

}
