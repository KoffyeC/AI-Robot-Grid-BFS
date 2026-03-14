public class Runner
{
	public static void main(String[] args) {
		Runner program = new Runner();
		Grid g = new Grid();
		Node n = new Node(0, 0);
        BFS bfs = new BFS(3, 3);
        
        g.displayGrid(bfs);
        
        System.out.println();
        bfs.addQueue(g, n);
        bfs.breadth_first_search(g);
        bfs.printQueue(n);
    }
}
