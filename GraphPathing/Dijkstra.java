//Ben Schreyer 11/13/2020
import java.util.*;


public class Dijkstra
{
    //A main class to test the implementation
    public static void main(String[] args)
    {
        Graph g = new Graph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");

        nodeA.addAdjacency(nodeB, 5);
        nodeA.addAdjacency(nodeC, 4);
        nodeA.addAdjacency(nodeD, 9);
        nodeB.addAdjacency(nodeC, 2);
        nodeB.addAdjacency(nodeF, 11);
        nodeC.addAdjacency(nodeI, 22);
        nodeC.addAdjacency(nodeD, 2);
        nodeD.addAdjacency(nodeG, 3);
        nodeE.addAdjacency(nodeC, 3);
        nodeE.addAdjacency(nodeI, 15);
        nodeF.addAdjacency(nodeE, 1);
        nodeG.addAdjacency(nodeH, 3);
        nodeG.addAdjacency(nodeC, 1);
        nodeH.addAdjacency(nodeI, 9);

        g.addNode(nodeA);
        g.addNode(nodeB);
        g.addNode(nodeC);
        g.addNode(nodeD);
        g.addNode(nodeE);
        g.addNode(nodeF);
        g.addNode(nodeG);
        g.addNode(nodeH);
        g.addNode(nodeI);

        DijkstraFromNode(nodeA, g);
        System.out.println("Minimum distance to I: "+nodeI.getDistance());
        System.out.println("Path to take:");
        for(Node n: nodeI.getShortestPath())
        {
            System.out.println(n);
        }
    }

    public static void DijkstraFromNode(Node start, Graph graph)
    {
        Set<Node> visited = new HashSet<Node>();
        Set<Node> unvisited = new HashSet<Node>();

        unvisited.add(start);

        Node current = start;
        current.setDistance(0);
        //while some nodes have not been visited
        while(unvisited.size() > 0)
        {
            //check if adjacent nodes could have a shorter path to start through the current node
            for(Node n: current.getAdjacentNodes() )
            {
                if(n.getDistance()==-1|| n.getDistance() > current.getDistance() + current.getWeightTo(n))
                {
                    n.setDistance(current.getDistance() + current.getWeightTo(n));
                    n.getShortestPath().clear();
                    n.getShortestPath().addAll(current.getShortestPath());
                    n.getShortestPath().add(current);
                }


                if(!visited.contains(n))
                {
                    unvisited.add(n);
                }
            }

            unvisited.remove(current);
            visited.add(current);

            Node min = null;
            int minDist = -1;
            //find minimum distance unvisited node to use for next iteration
            for(Node n: unvisited)
            {
                if((n.getDistance() < minDist || minDist == -1) && !visited.contains(n));
                {
                    min = n;
                    minDist = n.getDistance();
                }
            }

            current = min;
        }

        start.setDistance(0);


    }
}
