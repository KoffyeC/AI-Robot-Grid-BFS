import java.util.LinkedList;
import java.util.Queue;

public class BFS 
{
    int numRow;
    int numColumn;
    
   /*
    * This is the visited array.
    * It tells us the specific coordinates on the graph that we have visited already.
    * The reason why we use boolean is because it stores either true or false to whether its coordinates have ben visited.
    * The [3][3] here gives us the size of our grid.
    * Help from ChatGPT
    */
    boolean[][] visited; 
    
    BFS(int r, int c)
    {
        this.numRow = r;
        this.numColumn = c;
        //Help from ChatGPT - This allows me to set the size of the grid from the runner class.
        visited = new boolean [numRow][numColumn]; 
    }
    
       /*
        * This is a linked list: It will hold our values that are queued up to be searched.
        * Inside the "<>", this is called a generic type parameter. 
        *   o It tells the Queue (which is the type) that impliments LinkedList, which kind of objects to expect and should hold.
        */
        Queue<Node> queue = new LinkedList<>();
        
        
 
         
        
        //The "<Node>" in Queue<Node> queue adds type safety.
        public void addQueue(Grid g, Node d)
        {
            
            //This will prevent the same node from being added to the queue when the addQueue is called multiple times.
            if (!(visited[d.getRow()][d.getColumn()] == true)) {
                //This is help from ChatGPT Auto.
                //This sets the first position we start at to visited.
                visited[d.getRow()][d.getColumn()] = true;
                queue.add(new Node(d.getRow(), d.getColumn()));
            }
            
            System.out.println("The queue is ready:");
        }
        
        
        //We are adding a overidden toString() method to define for node how it should print as a toString by overriding the original toString method.
        public String toString(Node d)
        {
            return "Row: " + d.getRow() + " and Column:" + d.getColumn();
        }
    
    
        //Help from ChatGPT - This prints the queued items 
        public void printQueue(Node d)
        {
            for (Node n : queue)
            {
               System.out.println(n.toString()); 
            }
        }
        
    
    public void breadth_first_search(Grid g) //int row and int column is the position of the node we want to start searching at.
    {
        // We will be removing nodes from the queue, so we want to make sure its size is above zero.
        while (queue.size() > 0)
        {
            /*
             * We are assigning our current node location to whatever is the first value in the queue.
             *      o We use "poll()" to return the first node from the queue and setting it equal to current, while simultanously removing it from the queue.
             *
             * "Node current" will hold our current node (its current location).
             *  We don't have a node object, "Node current = new Node()" because that would require us to have a no argument constructor in the node class.
             *      o Instead, queue returns a Node object that already contains "row" and "column" inside of it.
                    o Therefore, when we added "Node current" we are pointing the reference that node object returned from "queue.poll()" to the other Node object, current.
                    o Afterward, we can then access row and column from current.
             */
            
            Node current = queue.poll();
            
            // Right - Check to see if the row right of the current Node is less than the length of the grid.
            if (current.getRow() + 1 < g.grid.length) { // This adds boundaries when we check and see if any values are up, down, left, right, so we don't go out of bounds.
                if (g.grid[current.getRow() + 1][current.getColumn()] != 'X')
                {
                    //We add "new Node" because our LinkedList is designed to hold Node objects
                    //We also have the rows and columns seperated by commas because the node object only expects two integers sperated by commas, not a value in a grid.
                    if (!(visited[current.getRow() + 1][current.getColumn()] == true))
                    {
                        visited[current.getRow() + 1][current.getColumn()] = true; //If I have not visited that location, set it to visited and add it to the Node.
                        queue.add(new Node(current.getRow() + 1, current.getColumn()));
                    }
                }
            }
            
            // Left - Check to see if the row left of the current Node is greater than 0.
            if (current.getRow() - 1 >= 0){ 
                if (g.grid[current.getRow() - 1][current.getColumn()] != 'X')
                {
                    if (!(visited[current.getRow() - 1][current.getColumn()] == true))
                    {
                        visited[current.getRow() - 1][current.getColumn()] = true; //If I have not visited that location, set it to visited and add it to the Node.
                        queue.add(new Node(current.getRow() - 1, current.getColumn()));
                    }
                }
            }
            
            
            /* Up - Check to see if the column above of the current Node is less than the length of the grid and not above the grid.
             * We use "g.grid[0].length" because without it, I'm targeting the row (which isn't what we want).
             *      o So, we add "[0]" because it tells us to look at the first row and give us the number of columns in that row (which is 3).
             */
            if (current.getColumn() + 1 < g.grid[0].length){ 
                if (g.grid[current.getRow()][current.getColumn() + 1] != 'X')
                {
                    if (!(visited[current.getRow()][current.getColumn() + 1] == true))
                    {
                        visited[current.getRow()][current.getColumn() + 1] = true; //If I have not visited that location, set it to visited and add it to the Node.
                        queue.add(new Node(current.getRow(), current.getColumn() + 1));
                    }
                }
            }
            
            
            // Down - Check to see if the column below the current Node is greater than or equal to 0 and not below the grid.
            if (current.getColumn() - 1 >= 0){ 
                if (g.grid[current.getRow()][current.getColumn() - 1] != 'X')
                {
                    if (!(visited[current.getRow()][current.getColumn() - 1] == true))
                    {
                        visited[current.getRow()][current.getColumn() - 1] = true; //If I have not visited that location, set it to visited and add it to the Node.
                        queue.add(new Node(current.getRow(), current.getColumn() - 1));
                    }
                }
            }
        
            System.out.println(g.grid[current.getRow()][current.getColumn()] + " = Visited"); //This shows you the visited nodes
            
            if (g.grid[current.getRow()][current.getColumn()] == 'G')
            {
                System.out.println("\n" + "The goal has been reached!"); //Tells you the goal has been reached
                return; //Help from ChatGPT - This ends the function and prevents the search from continuing to look for neighbors.
            }
        }
    }
}