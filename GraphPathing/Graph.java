//Ben Schreyer 11/13/2020
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph
{
    private Set<Node> graph;

    Graph()
    {
        graph = new HashSet<Node>();
    }

    public void addNode(Node node)
    {
        graph.add(node);
    }
    public Iterator<Node> getIterator()
    {
        return graph.iterator();
    }
}
