package ninjase.model;

public class Level {
	int numRows;
	int numCols;
        int level;
        
	public Level(int numRows, int numCols, int level) {
		this.numRows = numRows;
		this.numCols = numCols;
                this.level = level;
        }
        
        public int[] values(){
            int[] levelData = {this.numRows, this.numCols, this.level};
            return levelData;
        }
        
        public void setLevel(int rows, int cols, int level){
            this.numCols = cols;
            this.numRows = rows;
            this.level = level;
        }
        
}
