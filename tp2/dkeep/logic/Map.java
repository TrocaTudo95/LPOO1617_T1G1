package dkeep.logic;

public class Map {
	private char[][] map;

	public static void main(String[] args) {
		
	}

	public Map(int level){
		if(level == 0){
			char[][] temp = {{'X','X','X','X','X','X','X','X','X','X'} ,
							 {'X',' ',' ',' ','I',' ','X',' ',' ','X'} ,
							 {'X','X','X',' ','X','X','X',' ',' ','X'} ,
							 {'X',' ','I',' ','I',' ','X',' ',' ','X'} ,
							 {'X','X','X',' ','X','X','X',' ',' ','X'} ,
							 {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
							 {'I',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
							 {'X','X','X',' ','X','X','X','X',' ','X'} ,
							 {'X',' ','I',' ','I',' ','X','K',' ','X'} ,
							 {'X','X','X','X','X','X','X','X','X','X'} };
			for ( int i = 0 ; i < 9; i++) 
				System.arraycopy(temp[i],0,this.map[i],0,9);
		}
		else if (level == 1){
			char[][] temp = {{'X','X','X','X','X','X','X','X','X','X'} ,
					    	 {'I',' ',' ',' ',' ',' ',' ',' ','K','X'} ,
					    	 {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
					    	 {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
					    	 {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
					    	 {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
					    	 {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
					    	 {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
					    	 {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'} ,
					    	 {'X','X','X','X','X','X','X','X','X','X'} };
			for ( int i = 0 ; i < 9; i++) 
				System.arraycopy(temp[i],0,this.map[i],0,9);
		}
	}

	public char[][] getMap(){
		return this.map;
	}
}