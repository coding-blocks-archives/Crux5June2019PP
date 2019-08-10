package L33_Aug9;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Aug-2019
 *
 */

public class Graph {

	private int numV;
	private int[][] matrix;

	public Graph(int v) {
		numV = v;
		matrix = new int[numV + 1][numV + 1];
	}

	public void addEdge(int u, int v, int cost) {

		matrix[u][v] = cost;
		matrix[v][u] = cost;
	}

	public int removeEdge(int u, int v) {

		int temp = matrix[u][v];

		matrix[u][v] = 0;
		matrix[v][u] = 0;

		return temp;
	}

	public int numEdge() {

		int count = 0;

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {

				if (matrix[i][j] != 0) {
					count++;
				}
			}
		}

		return count / 2;
	}

	public boolean containsEdge(int u, int v) {
		return matrix[u][v] != 0;
	}

	@Override
	public String toString() {

		String str = "";

		for (int i = 1; i < matrix.length; i++) {

			str += i + " -> ";
			for (int j = 1; j < matrix[0].length; j++) {

				if (matrix[i][j] != 0) {
					str += j + "[" + matrix[i][j] + "] , ";
				}
			}

			str += "\n";
		}

		return str;

	}

	public boolean hasPath(int src, int dst, HashMap<Integer, Boolean> visited) {

		// visited
		visited.put(src, true);

		// equal
		if (src == dst) {
			return true;
		}

		// nbrs
		for (int nbr = 1; nbr < matrix[0].length; nbr++) {

			if (matrix[src][nbr] != 0 && !visited.containsKey(nbr)) {

				boolean ans = hasPath(nbr, dst, visited);

				if (ans)
					return true;
			}
		}

		return false;

	}

	public void printAllPaths(int src, int dst, HashMap<Integer, Boolean> visited, String asf) {

		// equal
		if (src == dst) {
			System.out.println(asf + dst);
			return;
		}

		// visited
		visited.put(src, true);

		// nbrs
		for (int nbr = 1; nbr < matrix[0].length; nbr++) {

			if (matrix[src][nbr] != 0 && !visited.containsKey(nbr)) {

				printAllPaths(nbr, dst, visited, asf + src);

			}
		}

		visited.remove(src);

	}

	private class Pair {
		int vname;
		String psf;

		public Pair(int vname, String psf) {
			this.vname = vname;
			this.psf = psf;
		}
	}

	public boolean BFS(int src, int dst) {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		// put the src pair in queue
		Pair sp = new Pair(src, src + "");
		queue.addLast(sp);

		// work till queue is not empty
		while (!queue.isEmpty()) {

			// remove the pair
			Pair rp = queue.removeFirst();

			// ignore the second C
			if (visited.containsKey(rp.vname)) {
				continue;
			}

			// put in visited
			visited.put(rp.vname, true);

			// equal
			if (rp.vname == dst) {
				System.out.println(rp.psf);
				return true;
			}

			// nbrs
			for (int nbr = 1; nbr < matrix[0].length; nbr++) {

				if (matrix[rp.vname][nbr] != 0 && !visited.containsKey(nbr)) {

					// create a new pair for nbr
					Pair np = new Pair(nbr, rp.psf + nbr);
					queue.addLast(np);
				}
			}

		}

		return false;

	}

	public boolean DFS(int src, int dst) {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		// put the src pair in queue
		Pair sp = new Pair(src, src + "");
		stack.addFirst(sp);

		// work till queue is not empty
		while (!stack.isEmpty()) {

			// remove the pair
			Pair rp = stack.removeFirst();

			// ignore the second C
			if (visited.containsKey(rp.vname)) {
				continue;
			}

			// put in visited
			visited.put(rp.vname, true);

			// equal
			if (rp.vname == dst) {
				System.out.println(rp.psf);
				return true;
			}

			// nbrs
			for (int nbr = 1; nbr < matrix[0].length; nbr++) {

				if (matrix[rp.vname][nbr] != 0 && !visited.containsKey(nbr)) {

					// create a new pair for nbr
					Pair np = new Pair(nbr, rp.psf + nbr);
					stack.addFirst(np);
				}
			}

		}

		return false;

	}

	public void BFT() {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (int src = 1; src < matrix[0].length; src++) {

			if(visited.containsKey(src)) {
				continue ;
			}
			
			// put the src pair in queue
			Pair sp = new Pair(src, src + "");
			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the pair
				Pair rp = queue.removeFirst();

				// ignore the second C
				if (visited.containsKey(rp.vname)) {
					continue;
				}

				// put in visited
				visited.put(rp.vname, true);

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				for (int nbr = 1; nbr < matrix[0].length; nbr++) {

					if (matrix[rp.vname][nbr] != 0 && !visited.containsKey(nbr)) {

						// create a new pair for nbr
						Pair np = new Pair(nbr, rp.psf + nbr);
						queue.addLast(np);
					}
				}

			}

		}

	}
	
	public void DFT() {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		for (int src = 1; src < matrix[0].length; src++) {

			if(visited.containsKey(src)) {
				continue ;
			}
			
			// put the src pair in queue
			Pair sp = new Pair(src, src + "");
			stack.addFirst(sp);

			// work till queue is not empty
			while (!stack.isEmpty()) {

				// remove the pair
				Pair rp = stack.removeFirst();

				// ignore the second C
				if (visited.containsKey(rp.vname)) {
					continue;
				}

				// put in visited
				visited.put(rp.vname, true);

				// syso
				System.out.println(rp.vname + " via " + rp.psf);

				// nbrs
				for (int nbr = 1; nbr < matrix[0].length; nbr++) {

					if (matrix[rp.vname][nbr] != 0 && !visited.containsKey(nbr)) {

						// create a new pair for nbr
						Pair np = new Pair(nbr, rp.psf + nbr);
						stack.addFirst(np);
					}
				}

			}

		}

	}

}
