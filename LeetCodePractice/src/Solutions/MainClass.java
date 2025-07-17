package Solutions;

import java.util.ArrayList;

import SolutionsArrays.QuickSort;
import graph.Edge;
import graph.Graph;
import graph.Vertex;
import hashmapLeetcode.TopKFreq;

public class MainClass {

	public static void main(String[] args) {
		/*Graph busNetwork = new Graph(false, true);
		Vertex cliftonStation = busNetwork.addVertex("Clifton");
		Vertex capeStation = busNetwork.addVertex("Cape May");
		Vertex ricaStation = busNetwork.addVertex("Costa Rica");
		Vertex nyStation = busNetwork.addVertex("New York");
		Vertex laStation = busNetwork.addVertex("Las Angeles");
		Vertex ramonStation = busNetwork.addVertex("San Ramon");
		Vertex houstonStation = busNetwork.addVertex("Houston");
		
		
		busNetwork.addEdge(cliftonStation, capeStation, 0);
		busNetwork.addEdge(capeStation, ricaStation, 0);
		//busNetwork.addEdge(ricaStation, laStation, 0);
		busNetwork.addEdge(laStation, ricaStation, 0);
		busNetwork.addEdge(ricaStation, capeStation, 0);
		busNetwork.addEdge(capeStation, cliftonStation, 0);
		busNetwork.addEdge(ramonStation, houstonStation, 0);	
		busNetwork.addEdge(laStation, ramonStation, 0);
		
		busNetwork.print();
		
		System.out.println(new MainClass().isReachable(busNetwork, laStation, cliftonStation));

		//System.out.println(repeatedString("aba",10));
		
		new TopKFreq().topKFrequent();
		
	}
	
	public static long repeatedString(String s, long n) {
	    // Write your code here
	        long occurancesInOneStr = s.chars().filter(ch->ch=='a').count();
	        long quo = n/s.length();
	        occurancesInOneStr *= quo;
	        System.out.println("occurancesInOneStr: " + occurancesInOneStr);
	        long rem = n%s.length();
	        System.out.println(rem);
	        String remStr = s.substring(0, (int)rem);
	        System.out.println(remStr);
	        
	        occurancesInOneStr += remStr.chars().filter(ch->ch=='a').count();
	        System.out.println("occurancesInOneStr: " + occurancesInOneStr);
	        return occurancesInOneStr;
	        
	    }

	
	public boolean isReachable(Graph busNetwork, Vertex start, Vertex dest) {
		for(Edge e: start.getEdges()) {
			if(e.getEndV()==dest){
				return true;
			}else {
				return isReachable(busNetwork, e.getEndV(), dest);
			}
		}
		return false;
	}
	*/
		
		QuickSort q = new QuickSort();
		int[] arr = {4,6,2,5,1,8,3};
		
		System.out.println("Before Quick Sort : ");
		for(int n:arr) System.out.print( n  + "  ");
		
		q.quickSort(arr, 0, arr.length-1);
		System.out.println();
		
		System.out.println("After Quick Sort : ");
		for(int n:arr) System.out.print( n  + "  ");
	}
}
