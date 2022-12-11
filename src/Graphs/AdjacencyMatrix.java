package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyMatrix {

    public ArrayList<GraphNode> nodelist = new ArrayList<GraphNode>();
    int [] [] adjacencyMatrix;

    public AdjacencyMatrix(ArrayList<GraphNode> nodelist) {

        this.nodelist = nodelist;
       adjacencyMatrix =  new int [nodelist.size()] [nodelist.size()];
    }
    public void addUndirectedEdge(int i, int j){
//        if we have a link we start at 1;
        adjacencyMatrix[i][j] = 1;
//        creating a link from i to j and j to i;
        adjacencyMatrix[j][i] = 1;

    }
    public ArrayList<GraphNode> getNeighbors(GraphNode node){
        /**
         * we're tasking the node index if any of the node columns equals = 1;
         * this is the node we're looking for.
         */
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = node.index;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
//            if column is equal to one we add it to the neighbors
            if(adjacencyMatrix[nodeIndex][i] == 1){
                neighbors.add(nodelist.get(i));
            }
        }
        return neighbors;
    }

    /**
     * Bfs visit
     * @return
     */
    public void bfsVisit(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for (GraphNode neighbor : neighbors) {
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }

            }
        }
    }

    /**
     * call the method one by one for each node.
     */
    public void bfs(){
        for (GraphNode node: nodelist) {
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }

//    prints out the matrix;
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < nodelist.size(); i++) {
            sb.append(nodelist.get(i).name  + " ");
        }
        sb.append("\n");
        for (int i = 0; i < nodelist.size(); i++) {
            sb.append(nodelist.get(i).name + " ");
            for (int j : adjacencyMatrix[i]) {
                sb.append((j) + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        Creating the graph;
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));

        AdjacencyMatrix am = new AdjacencyMatrix(nodeList);
        am.addUndirectedEdge(0,1);
        am.addUndirectedEdge(0,2);
        am.addUndirectedEdge(0,3);
        am.addUndirectedEdge(1,4);
        am.addUndirectedEdge(3,2);
        am.addUndirectedEdge(4,3);
        System.out.println(am.toString());

        am.bfs();
    }
}
