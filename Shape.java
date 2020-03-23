import java.util.Arrays;
import java.util.Random;

public class Shape {
	int values [];
	int coord[][];
	int boardY;
	int boardX;
	private boolean end=true;


	public Shape(int[][] coord,int boardX,int boardY,int[] values){
		this.coord=coord;
		this.boardX=boardX;
		this.boardY=boardY;
		this.values=values;

	}

	boolean move(int [][]board){

		if (isSuit(board)){
			for (int i = 0; i < coord.length; i++) {
				coord[i][1]+=1;

			}
			return false;
		}
		else{
			done(board);
			return true;
		}
	}
	boolean isSuit(int [][] board){
		for(int i = 0; i < coord.length;i++){
			if(coord[i][0]<0|| coord[i][1]<0){
				continue;
			}
			if( coord[i][1]+1>board.length-1)
				return false;

			if(board[coord[i][1]+1][coord[i][0]]!=0)
				return false ;
		}
		return true;
	}
	void done(int [][]board){
		if(!lose()) {
			for (int i = 0; i < coord.length; i++) {
				board[coord[i][1]][coord[i][0]] = values[i];
			}
		}
		else {

			end=false;
		}

	}

	void moveRight(int[][] board){
		

			if(!greaterThanX(board))
				for (int i = 0; i < coord.length; i++)
					
						coord[i][0]+=1;
	
	}
	void moveLeft(int[][]board){
		if(!lessThanX(board)){
			for (int i = 0; i < coord.length; i++) {
				coord[i][0]-=1;
			}
		}
	}

	boolean lessThanX(int[][] board){
		for(int i = 0; i < coord.length;i++){
			if(coord[i][0]-1<0){
				return true;
			}
			
			if(coord[i][1]-1<0){
				continue;
			}
			
			if(board[coord[i][1]][coord[i][0]-1]!=0){
				return true;
			}
		}
		return false;
	}

	boolean greaterThanX(int[][] board){
		for(int i = 0; i < coord.length;i++){
			if(coord[i][0]+1>boardX-1 ){
				return true;
			}

			if(coord[i][1]<0) {
				continue;
			}
			if(board[coord[i][1]][coord[i][0]+1]!=0 ){
				return true;
			}
		}
		return false;
	}

	boolean lose(){
		for (int i = 0; i < coord.length; i++) {
			if(coord[i][1]<0){
				return true;
			}
		}
		return false;
	}

	void rotateRight(){

	}
	void rotateLeft(){

	}

	boolean getEnd() {
		return end;
	}
	int [][] review(){
		int [][] arr = new int [4][2];
		int min = 0;
		int min2=20;
		for (int i = 0; i < coord.length; i++) {
			if(coord[i][1]<min){
				min=coord[i][1];
			}
		}
		for (int i = 0; i < coord.length; i++) {
			if(coord[i][0]<min2){
				min2=coord[i][0];
			}
		}
		min=min*-1;
		//System.out.println(min2);
		for (int i = 0; i < arr.length; i++) {
			arr[i][0]=coord[i][0]-min2;
			arr[i][1]=min+coord[i][1];
		}
		int [][] rew = new int [2][4];
		for (int i = 0; i <arr.length ; i++) {
			rew[arr[i][1]][arr[i][0]]=values[i];
		}
		return rew;
	}

	void printReview(){
		int [][] arr=review();
		for (int i = 0; i <arr.length ; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public int[][] getCoord() {
		return coord;
	}
}
