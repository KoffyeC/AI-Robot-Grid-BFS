public class Node
{
    int row; //Row of the node
    int column; //Column of the node
    
    //This stores the variables into the constructor for the location we are at on the grid.
    Node(int row, int column){
        this.row = row;
        this.column = column;
    }
    
    //This display's the current character in the grid that the node is on.
    public void displayNode(Grid g)
    {
        System.out.println(g.grid[this.row][this.column]);
    }
    
    public int getRow()
    {
        return this.row;
    }
    
    public int getColumn()
    {
        return this.column;
    }
    
    public void setRow(int setRow)
    {
        row = setRow;
    }
    
    public void setColumn(int setCol)
    {
        column = setCol;
    }
    
    //Help from ChatGPT
    @Override //We are adding a overidden toString() method to define for node how it should print as a toString by overriding the original toString method.
    public String toString()
    {
        return "(Row: " + row + ", Column:" + column + ")";
    }
    
}