/*
* TOP 'N' WORDS
*/

import java.util.*;

public class Solution {
	private Scanner scanner;
	private int size,k;
	private HashMap<String, Integer> map;
	
	
	public Solution() {
		scanner = new Scanner(System.in);
		map = new HashMap<String, Integer>();
		
	}
	
	private int getKeyCount(String input) {
		if(input == null || input.length() == 0) {
			throw new RuntimeException("Invalid String input");
		}
		else {
			if(map.containsKey(input)) {
				return map.get(input);
			}
			else {
				return 0;
			}
		}
	}
	
	public void run() {
		size = Integer.parseInt(scanner.nextLine());
		fillMap();
		
		if(scanner.hasNextLine()) {
			k = Integer.parseInt(scanner.nextLine());
			findTopK_Elements();
		}
		else {
			throw new RuntimeException("K-value undefined");
		}
	}
	
	private void fillMap() {
		for(int i=0; i<size; i++) {
			String input = scanner.nextLine();
			input.trim();
			int value = getKeyCount(input)+1;
			map.put(input,value);
		}
	}
	
	private void findTopK_Elements() {
		if(map == null || map.size() == 0) {
			throw new RuntimeException("Invalid Hashmap size ");
		}
		
		class Element {
			String key;
			int count;
			
			public Element(String key, int count) {
				this.key = key;
				this.count = count;
			}
		}
		
		PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(size, new Comparator<Element>() {
			public int compare(Element e1, Element e2) {
				if(e2.count>e1.count) return 1;
				else if(e2.count<e1.count) return -1;
				else return (e1.key.compareTo(e2.key));
			}
		});
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			String key = new String(entry.getKey());
			int value = entry.getValue();
			Element e = new Element(key, value);
			maxHeap.add(e);
		}
		for(int i=0; i<k; i++) {
			Element tmp = maxHeap.poll();
			System.out.println(tmp.key);
		}
	}
	
 /**
	
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution q = new Solution();
		q.run();
	}

}

