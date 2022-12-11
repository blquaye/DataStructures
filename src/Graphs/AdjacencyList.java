package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyList {
    public ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

//    creating graph
    public AdjacencyList(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }
//printing graph
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            sb.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                if(j == nodeList.get(i).neighbors.size()-1){
                    sb.append(nodeList.get(i).neighbors.get(j).name);
                }else{
                    sb.append(nodeList.get(i).neighbors.get(j).name + "-->");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public void addUndirectedEdge(int i, int j){
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    /**
     * helper method
     * @param
     */
    public void bfsVisit(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            //this will dequue
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for (GraphNode neighbor: currentNode.neighbors) {
                if(!neighbor.isVisited){
                   queue.add(neighbor);
                   neighbor.isVisited = true;
                }
            }
        }
    }
    public void bfs(){
        for (GraphNode node : nodeList) {
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A",0));
        nodeList.add(new GraphNode("B",1));
        nodeList.add(new GraphNode("C",2));
        nodeList.add(new GraphNode("D",3));
        nodeList.add(new GraphNode("E",4));

        AdjacencyList al = new AdjacencyList(nodeList);
        al.addUndirectedEdge(0,1);
        al.addUndirectedEdge(0,2);
        al.addUndirectedEdge(0,3);
        al.addUndirectedEdge(1,4);
        al.addUndirectedEdge(3,2);
        al.addUndirectedEdge(4,3);
        System.out.println(al.toString());

        al.bfs();
    }
    
}
