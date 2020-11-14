//Ben Schreyer 11/13/2020
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


public class Node
{

    private String name;
    //Store the shortest path from a start node to this node
    private LinkedList<Node> shortestPath;
    //Nodes that have directed edges from this node to them, each node also has an associated edge weight
    private Map<Node, Integer> adjacencyMap;
    //Store the shortest known distance from a start node to this node
    int distance;

    Node(String na)
    {
        name = na;
        distance = -1;
        shortestPath = new LinkedList<Node>();
        adjacencyMap = new HashMap<Node, Integer>();
    }

    public void addAdjacency(Node add,int weight)
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

    public LinkedList<Node> getShortestPath()
    {
        return shortestPath;
    }

    public Set<Node> getAdjacentNodes()
    {
        return adjacencyMap.keySet();
    }

    public int getWeightTo(Node node)
    {
        return adjacencyMap.get(node);
    }

    public void setDistance(int x)
    {
        distance = x;
    }
    public int getDistance()
    {
        return distance;
    }

    public String toString()
    {
        return name;
    }
}
