import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;



public class Graph implements GraphInterface<Town, Road> 
{
	private ArrayList<Road> roads;
	private ArrayList<Town> towns;
	
	/**
	 * Construct a new Graph representing a map of towns and roads
	 * @return New Graph
	 */
	public Graph()
	{
		roads = new ArrayList<Road>();
		towns = new ArrayList<Town>();
	}
	
	/**
	 * @param Town one
	 * @param Town two
	 * @return Road found between Towns, otherwise null
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) 
	{
		Iterator<Road> iter = roads.iterator();
		while(iter.hasNext())
		{
			Road temp = iter.next();
			int c = 0;
			for(Town t : temp.getConnections())
			{
				if(t.equals(sourceVertex) || t.equals(destinationVertex))
				{
					c++;
				}
			}
			if(c == 2)
			{
				return temp;
			}
		}
		return null;
	}

	/**
	 * Add a road between two Towns
	 * @param First Town
	 * @param Second Town
	 * @param Distance between Towns
	 * @param Road name
	 * @return New Road
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
	{
		Road test = getEdge(sourceVertex, destinationVertex);
		if(test != null)
		{
			return test;
		}
		//System.out.println("yes");
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(newRoad);
		
		sourceVertex.addAdjacency(destinationVertex, weight);
		destinationVertex.addAdjacency(sourceVertex, weight);
		return newRoad;
	}

	/**
	 * Add a Town to the map
	 * @param Town to add
	 * @return true if the Town was added, false if the Town was already on the map
	 */
	@Override
	public boolean addVertex(Town v) 
	{
		if(containsVertex(v))
		{
			return false;
		}
		towns.add(v);
		return true;
	}
	
	/**
	 * Check whether a Road exists between two Towns
	 * @param Town
	 * @param Other Town
	 * @return true if there is a road between the two towns
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) 
	{
		return getEdge(sourceVertex, destinationVertex) != null;
	}

	/**
	 * Check if a Town is on the map
	 * @param Town
	 * @return true if the Town is contained in the map
	 */
	@Override
	public boolean containsVertex(Town v) 
	{
		if(towns.contains(v))
		{
			return true;
		}
		
		Iterator<Town> iter = towns.iterator();
		while(iter.hasNext())
		{
			if(v.equals(iter.next()))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * Get the set of Roads associated with the map
	 * @return Set of roads
	 */
	@Override
	public Set<Road> edgeSet() 
	{
		HashSet<Road> ret = new HashSet<Road>();
		for(Road t: roads)
		{
			ret.add(t);
		}
		return ret;
	}

	/**
	 * Get Set of roads that connect to a Town
	 * @return Set of Roads that connect to a Town
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) 
	{
		HashSet<Road> rds = new HashSet<Road>();
		Iterator<Road> iter = roads.iterator();
		while(iter.hasNext())
		{
			Road rd = iter.next();
			if(rd.getConnections().contains(vertex))
			{
				rds.add(rd);
			}
		}
		return rds;
	}

	/**
	 * Remove a Road from the map
	 * @param First Town
	 * @param Second Town
	 * @param Distance between Towns along Road
	 * @param Description or Name of Road
	 * @return Null if the Road does not exist, otherwise the Road is returned
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) 
	{
		Road testRoad = getEdge(sourceVertex, destinationVertex);
		if(testRoad.getName().equals(description) && testRoad.getWeight() == weight)
		{
			sourceVertex.removeAdjacency(destinationVertex);
			destinationVertex.removeAdjacency(sourceVertex);
			roads.remove(testRoad);
			return testRoad;
		}
		return null;
	}



	
	/**
	 * Get a Town
	 * @param Name of Town to get
	 * @return Town object or null if none
	 */
	public Town getVertex(String n)
	{
		for(Town t: towns)
		{
			if(t.getName().equals(n))
			{
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Remove a Town  and any connected Roads from the map
	 * @return True if the Town existed and was removed
	 */
	@Override
	public boolean removeVertex(Town v) 
	{
		Town temp = v;
		
		Iterator<Town> townIterator = towns.iterator();
		
		while(townIterator.hasNext())
		{
			Town nxt = townIterator.next();
			if(temp.equals(nxt))
			{
				temp = nxt;
				break;
			}
		}
		
		Iterator<Road> iter = roads.iterator();
		while(iter.hasNext())
		{
			Road current = iter.next();
			if(current.getConnections().contains(temp))
			{
				iter.remove();
			}
		}
		
		Iterator<Town> adjacentsIterator = temp.getAdjacentNodes().iterator();
		while(adjacentsIterator.hasNext())
		{
			adjacentsIterator.next().removeAdjacency(temp);
		}
		return towns.remove(temp);

	}

	/**
	 * Get the Set of Towns for this map
	 * @return Set of Towns
	 */
	@Override
	public Set<Town> vertexSet() 
	{
		HashSet<Town> ret = new HashSet<Town>();
		for(Town t: towns)
		{
			ret.add(t);
		}
		return ret;
	}

	/**
	 * Get a list of Road names to take between the start and end Town
	 * @param Start Town
	 * @param End Town
	 * @return List of Road names in order
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) 
	{
		System.out.println(sourceVertex.getName());
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> ret = new ArrayList<String>();
		System.out.println(destinationVertex.getShortestPath());
		LinkedList<Town> townList = destinationVertex.getShortestPath();
		LinkedList<Road> roadList = destinationVertex.getShortestPathRoad();
		townList.add(destinationVertex);
		ListIterator<Town> townIterator = townList.listIterator();
		
		for(Road r: roadList)
		{
			ret.add(townIterator.next() + " via " + r.getName() + " to " + townIterator.next() +" " +r.getWeight()+" mi");
			townIterator.previous();
			
		}

		return ret;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) 
	{
		 Set<Town> visited = new HashSet<Town>();
	     Set<Town> unvisited = new HashSet<Town>();
	     
	     unvisited.add(sourceVertex);
	     
	     Town current = sourceVertex;
	     
	     Iterator<Town> resetDistanceIterator = towns.iterator();
	     
	     while(resetDistanceIterator.hasNext())
	     {
	    	 Town temp = resetDistanceIterator.next();
	    	 temp.setDistance(-1);
	    	 temp.getShortestPathRoad().clear();
	    	 temp.getShortestPath().clear();
	     }
	     current.setDistance(0);
	     
        //while some nodes have not been visited
        while(unvisited.size() > 0)
        {
        	System.out.println(current);
            //check if adjacent nodes could have a shorter path to start through the current node
            for(Town n: current.getAdjacentNodes() )
            {
            	System.out.println("\t" + n);
            	//System.out.println(n.getName());
                if(n.getDistance()==-1|| n.getDistance() > current.getDistance() + current.getWeightTo(n))
                {
                    n.setDistance(current.getDistance() + current.getWeightTo(n));
                    n.getShortestPath().clear();
                    n.getShortestPathRoad().clear();
                    n.getShortestPath().addAll(current.getShortestPath());
                    n.getShortestPath().add(current);
                    n.getShortestPathRoad().addAll(current.getShortestPathRoad());
                    n.getShortestPathRoad().add(getEdge(current,n));
                    
                    visited.remove(n);
                }

                if(!visited.contains(n))
                {
                    unvisited.add(n);
                }
            }
            unvisited.remove(current);
            visited.add(current);
            //current.getShortestPath().add(current);
            if(unvisited.size() < 1)
            {
            	return;
            }
            Town min = unvisited.iterator().next();
            int minDist = min.getDistance();
            
            //find minimum distance unvisited node to use for next iteration
            for(Town n: unvisited)
            {
                if((n.getDistance() < minDist) || minDist == -1 && !visited.contains(n));
                {
                    min = n;
                    minDist = n.getDistance();
                }
            }
         
            current = min;
        }

        //sourceVertex.setDistance(0);
		
	}
	
	/**
	 * Get a list of Town names for the map
	 * @return List of Town names
	 */
	public ArrayList<String> vertexList() 
	{
		ArrayList<String> ret = new ArrayList<String>();
		for(Town t: towns)
		{
			ret.add(t.getName());
		}
		return ret;
	}
	
	/**
	 * Get a list of Road names for the map
	 * @return List of Road names
	 */
	public ArrayList<String> edgeList() 
	{
		ArrayList<String> ret = new ArrayList<String>();
		for(Road t: roads)
		{
			ret.add(t.getName());
		}
		return ret;
	}

}
