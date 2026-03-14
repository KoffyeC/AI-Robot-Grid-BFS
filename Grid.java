public class Grid {
    
    //Creating the grid for the robot to traverse
    char[][] grid = 
    {
        {'R', '.', '.'},
        {'.', '.', 'X'},
        {'X', '.', 'G'}
    };
    
    public void displayGrid(BFS b)
    {
        System.out.println("The Grid is a (" + b.numRow + " x " + b.numColumn + "):");
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                System.out.print(grid[i][j] + " ");    
            }   
            
            System.out.println();    
        }
    }
    
    
}