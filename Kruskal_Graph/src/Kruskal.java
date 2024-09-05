import java.util.*;
import java.util.Collections;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Kruskal {

    /*
     *  Private inner class to store edges. Implements Comparable
     *  because we need to sort by weight.
     */
    private static class Edge implements Comparable<Edge> {
        int x, y; /* Endpoints */
        double w; /* Weight    */

        private Edge (int x, int y, double w) {
            this.x = x;  this.y = y;  this.w = w;
        }

        @Override
        public  int compareTo (Edge other) {

            return Double.compare(this.getW(),other.getW());
        }
        public double getW(){return w;}
    }


    public static Graph minimumSpanningTree (Graph g) {
        List<Edge> L = new ArrayList<>();
        MatrixGraph mst= new MatrixGraph(g.numVertices(),Graph.UNDIRECTED_GRAPH);
        for (int i = 0; i < g.numVertices(); i++) {
            for (int j : g.neighbours(i)) {
                L.add(new Edge(i, j, g.weight(i, j)));
            }
        }
        Collections.sort(L);

        List<Integer>[] arrayOfLists = (List<Integer>[])new List[g.numVertices()];
        for (int i = 0; i < g.numVertices(); i++){
            arrayOfLists[i] = new ArrayList<Integer>();
            arrayOfLists[i].add(i);}

        for (Edge edge: L){
            int componentOfx = componentOf(arrayOfLists,edge.x);
            int componentOfy = componentOf(arrayOfLists,edge.y);
            if(componentOfx!=componentOfy){
                mst.addEdge(edge.x, edge.y, edge.getW());
                mergeComponents(arrayOfLists, componentOfx, componentOfy);
            }
        }

        return mst; // placeholder
    }

    public  static int componentOf(List<Integer>[] arrayOfLists, int v){
        for(int i=0;i<arrayOfLists.length;i++){
            if(arrayOfLists[i].contains(v)){
                return i;
            }
        }
        return -11;
    }

    public static void mergeComponents(List<Integer>[] arrayOfLists,int x,int y){
        arrayOfLists[x].addAll(arrayOfLists[y]);
        arrayOfLists[y]=arrayOfLists[x];
    }

}