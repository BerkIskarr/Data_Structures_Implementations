// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Graph mst = Kruskal.minimumSpanningTree(GraphOfEssex.getGraph());
        int n = mst.numVertices();
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
                if (mst.isEdge(i,j))
                    System.out.println (GraphOfEssex.TOWN[i] + "--" + GraphOfEssex.TOWN[j]);
    }
}

