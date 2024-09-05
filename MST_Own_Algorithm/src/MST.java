import java.util.Arrays;

public class MST {
    // Finding the total weight of a graph
    public static double totalEdgeWeight(Graph g){
        double total_weight = 0;
        int numOfVertices = g.numVertices();
        // Loop to go through the edges
        for(int i=0;i<numOfVertices;i++){
            for(int j=0;j<i;j++){
                if(g.isEdge(i,j)){
                    total_weight+=g.weight(i,j);}}}
        return total_weight;
    }

    // Creates random graph with n vertices with p percent
    public static Graph getRandomGraph(int n, double p){

        Graph rand_graph = new MatrixGraph(n,Graph.UNDIRECTED_GRAPH);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                // Create edge with random weight between 0 and 1, 1 being excluded
                if(!rand_graph.isEdge(i,j) && Math.random()<p){
                    rand_graph.addEdge(i,j,Math.random());}
            }}
        return rand_graph;
    }

    // A basic Disjoint-set data structure, used as it is more efficient
    static class ComponentTracker{
        int[] repArray;
        int numberOfVertices;
        // Sets up the array for the initial situation
        ComponentTracker(int numberOfVertices){
            this.numberOfVertices=numberOfVertices;
            repArray = new int[numberOfVertices];
            for(int i =0;i<numberOfVertices;i++){
                repArray[i]=i;
            }
        }
        // Returns the representative of x, reading through the data to find the rep
        int representativeOf(int x){
            // Used temp to avoid changes
            int temp= x;
            while (repArray[temp] != temp) {
                temp = repArray[temp];
            }
            return temp;}

        // Checks if x and y are in the same component
        boolean inSameComponent(int x, int y){
            return representativeOf(x) == representativeOf(y);
        }

        // Merges x and y by making one the parent of the other
        void mergeComponents(int x, int y){
            // First find the representatives
            int repx = representativeOf(x);
            int repy = representativeOf(y);
            // Check if x and y are already in the same component -if already merged
            if(repx==repy){
                return;
            }
            // The representatives repx and repy will be connected, indicating that the two components are now part of the same larger component
            /* The other nodes within the same component are not explicitly updated during the merge operation,
            the merge operation does indirectly affect the other nodes in the same component through subsequent representativeOf operations,
            when you later call representativeOf(y) for any node y in the same component as x, it will return the updated representative that reflects the merge */
            repArray[repx]=repy;
        }
    }
    // Returns the MST of a graph
    public static Graph spanningTree(Graph g) {
        int numberOfVertices = g.numVertices();
        MatrixGraph T = new MatrixGraph(numberOfVertices, Graph.UNDIRECTED_GRAPH);

        /* Stores the vertex connected to the index vertex in MST,
            Used because it is more efficient to directly access the connected vertex through array
           while inserting into the MST */
        /* All 3 arrays are used mainly because of efficiency */
        int[] TreeNbr = new int[numberOfVertices];
        // Stores the bool indicating the existence of the vertex in MST
        boolean[] inTree = new boolean[numberOfVertices];
        // Stores the min weight connected to the index vertex
        double[] minWeightArr = new double[numberOfVertices];
        Arrays.fill(minWeightArr, Double.POSITIVE_INFINITY);
        ComponentTracker componentracker = new ComponentTracker(numberOfVertices);

        minWeightArr[0] = 0;
        // Nested loops to check every edge
        for (int i = 0; i < numberOfVertices; i++) {
            int minVertex = -1;
            double minWeight = Double.POSITIVE_INFINITY;

            for (int j = 0; j < numberOfVertices; j++) {
                /* Update the min weight and vertex,
                minWeight is placeholder for the minimum weight during execution to facilitate the min edge */
                if (!inTree[j] && minWeightArr[j] < minWeight) {
                    minVertex = j;
                    minWeight = minWeightArr[j];
                }
            }

            // Update inTree to mark minVertex as part of the MST if not already in the same component as the current vertex i
            inTree[minVertex] = !componentracker.inSameComponent(i,minVertex);

            // Update the arrays with min edge
            for (int j = 0; j < numberOfVertices; j++) {
                if (!inTree[j] && g.isEdge(minVertex, j) && g.weight(minVertex, j) < minWeightArr[j]) {
                    minWeightArr[j] = g.weight(minVertex, j);
                    TreeNbr[j] = minVertex;
                }
            }
        }
        // Create the MST by adding the representative of min weighted edges and merging after every addition
        for (int i = 1; i < numberOfVertices; i++) {
            if(!componentracker.inSameComponent(i,TreeNbr[i])){
                T.addEdge(componentracker.representativeOf(i), TreeNbr[componentracker.representativeOf(i)], minWeightArr[componentracker.representativeOf(i)]);
                componentracker.mergeComponents(componentracker.representativeOf(i), TreeNbr[componentracker.representativeOf(i)]);
            }}

        return T;
    }

    public static void main(String[] args) {
        try{
            Graph GOE =GraphOfEssex.getGraph();
            System.out.println("Total edge weight of the Graph of Essex: "+MST.totalEdgeWeight(GOE));
            System.out.println("Total edge weight of the MST of Graph of Essex: "+MST.totalEdgeWeight(MST.spanningTree(GOE)));
            Graph randG = MST.getRandomGraph(100,0.4);
            System.out.println("Total edge weight of random graph: "+MST.totalEdgeWeight(randG));
            // Count the average Edge Weight of 100 rand graphs
            double total = 0;
            for(int i=0;i<100;i++) {
                Graph randGr = MST.getRandomGraph(100, 0.4);
                Graph mst = MST.spanningTree(randGr);
                total+=MST.totalEdgeWeight(mst);
            }
            System.out.println("Average edge weight of 100 random graphs: "+total/100);
            // A small error handling
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}