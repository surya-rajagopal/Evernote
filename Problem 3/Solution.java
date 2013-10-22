/*
* MULTIPLY EXCEPT SELF
*/


import java.util.*;

public class Solution {

	private long[] input;
	private int size;
	private Scanner scanner; 
	
	public Solution() {
		scanner = new Scanner(System.in);	
	}
	
	public void run() {
		this.size = Integer.parseInt(scanner.nextLine());
		this.input = new long[this.size];

		if(this.size>1 ) {
			for(int i=0; i<this.size; i++) {
				this.input[i] = scanner.nextLong();			
			}
			multiplySelf();
		}
		else {
			throw new RuntimeException("Size incorrectly defined");
		}
	}
	
	private void multiplySelf() {
		long[] result = new long[this.size];
		if(this.size>1) {
			long product = 1;
			for(int i=0; i<this.size; i++) {
				result[i] = product;
				product *= this.input[i];
			}
			
			product = 1;
			for(int i=this.size-1; i>=0; i--) {
				result[i] *= product;
				product *= this.input[i];				
			}
			
			System.out.println();
			for(int i=0; i<this.size; i++) {
				System.out.println(result[i]);			
			}
		}	
		else {
			throw new RuntimeException("Size incorrectly defined");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution test = new Solution();
		test.run();
	}

}

