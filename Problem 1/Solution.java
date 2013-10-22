/*
* CIRCULAR BUFFER	
*/
import java.util.*;

public class Solution {
	private int size;
	private Deque<String> buffer;
	private Scanner scanner;
	
	public Solution() {
		scanner = new Scanner(System.in);
	}
	
	public void run() {
		size = Integer.parseInt(scanner.nextLine());
		buffer = new LinkedList<String>();
		operateBuffer();
	}
	
	private void operateBuffer() {
		while(scanner.hasNextLine()) {
			String input = scanner.nextLine();
			if(input.equals('Q')) {
				System.out.println("Q processed");
				break; 
			}
			else {
				processCommand(input);
			}
		}
	}
	
	private void processCommand(String input) {
		if(input == null || input.length() == 0) 
			throw new RuntimeException("Invalid input length");
		else {
			String[] split = input.split("\\s+");
			int n=0;
			if(split.length == 2) {
				n = Integer.parseInt(split[1]);
			}
			int i;
			
			switch(split[0].charAt(0)) {
				case 'A':
					int currSize = buffer.size();
					for(i=0;i<n;i++) {
                                            if(currSize == size) {
						buffer.removeFirst();
						currSize--;
                                            }
						buffer.addLast(scanner.nextLine());
						currSize++;
					}
					
					break;
				case 'R':
					for(i=0;i<n;i++) {
						buffer.removeFirst();
					}
					break;
				case 'L':
					for(String s: buffer) {
						System.out.println(s);
					}
					break;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution q1 = new Solution();
		q1.run();
	}

}

