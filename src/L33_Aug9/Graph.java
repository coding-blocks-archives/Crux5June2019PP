package L33_Aug9;

import java.security.IdentityScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import L28_July31.HeapGeneric;

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

		String color;

		public Pair(int vname, String psf) {
			this.vname = vname;
			this.psf = psf;
		}

		public Pair(int vname, String psf, String color) {
			this.vname = vname;
			this.psf = psf;
			this.color = color;
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

			if (visited.containsKey(src)) {
				continue;
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

					// make the pair only for unvisited nbrs
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

			if (visited.containsKey(src)) {
				continue;
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

	public boolean isCyclic() {

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (int src = 1; src < matrix[0].length; src++) {

			if (visited.containsKey(src)) {
				continue;
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
					return true;
				}

				// put in visited
				visited.put(rp.vname, true);

				// nbrs
				for (int nbr = 1; nbr < matrix[0].length; nbr++) {

					// make the pair only for unvisited nbrs
					if (matrix[rp.vname][nbr] != 0 && !visited.containsKey(nbr)) {

						// create a new pair for nbr
						Pair np = new Pair(nbr, rp.psf + nbr);
						queue.addLast(np);
					}
				}

			}

		}

		return false;
	}

	public boolean isConnected() {

		int count = 0;

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (int src = 1; src < matrix[0].length; src++) {

			if (visited.containsKey(src)) {
				continue;
			}

			count++;

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

				// nbrs
				for (int nbr = 1; nbr < matrix[0].length; nbr++) {

					// make the pair only for unvisited nbrs
					if (matrix[rp.vname][nbr] != 0 && !visited.containsKey(nbr)) {

						// create a new pair for nbr
						Pair np = new Pair(nbr, rp.psf + nbr);
						queue.addLast(np);
					}
				}

			}

		}

		return count == 1;
	}

	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

	public ArrayList<ArrayList<Integer>> getCC() {

		ArrayList<ArrayList<Integer>> tres = new ArrayList<>();

		HashMap<Integer, Boolean> visited = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (int src = 1; src < matrix[0].length; src++) {

			if (visited.containsKey(src)) {
				continue;
			}

			ArrayList<Integer> comp = new ArrayList<>();

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

				// add in component array list
				comp.add(rp.vname);

				// nbrs
				for (int nbr = 1; nbr < matrix[0].length; nbr++) {

					// make the pair only for unvisited nbrs
					if (matrix[rp.vname][nbr] != 0 && !visited.containsKey(nbr)) {

						// create a new pair for nbr
						Pair np = new Pair(nbr, rp.psf + nbr);
						queue.addLast(np);
					}
				}

			}

			tres.add(comp);

		} // for src

		return tres;
	}

	public boolean isBipartite() {

		HashMap<Integer, String> visited = new HashMap<>();

		LinkedList<Pair> queue = new LinkedList<>();

		for (int src = 1; src < matrix[0].length; src++) {

			if (visited.containsKey(src)) {
				continue;
			}

			// put the src pair in queue
			Pair sp = new Pair(src, src + "", "R");
			queue.addLast(sp);

			// work till queue is not empty
			while (!queue.isEmpty()) {

				// remove the pair
				Pair rp = queue.removeFirst();

				// ignore the second C
				if (visited.containsKey(rp.vname)) {

					String oc = visited.get(rp.vname);
					String nc = rp.color;

					if (!oc.equals(nc)) {
						return false;
					}

					continue;
				}

				// put in visited
				visited.put(rp.vname, rp.color);

				// nbrs
				for (int nbr = 1; nbr < matrix[0].length; nbr++) {

					// make the pair only for unvisited nbrs
					if (matrix[rp.vname][nbr] != 0 && !visited.containsKey(nbr)) {

						// create a new pair for nbr
						String nc = rp.color.equals("R") ? "G" : "R";

						Pair np = new Pair(nbr, rp.psf + nbr, nc);
						queue.addLast(np);
					}
				}

			}

		}

		return true;

	}

	private class PrimsPair implements Comparable<PrimsPair> {
		int vname;
		int acqvname;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			return o.cost - this.cost;
		}
	}

	public Graph Prims() {

		Graph mst = new Graph(matrix.length - 1);

		HashMap<Integer, PrimsPair> map = new HashMap<>();

		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();

		// make a pair and put in heap and hash map
		for (int i = 1; i < matrix.length; i++) {
			PrimsPair np = new PrimsPair();
			np.vname = i;
			np.acqvname = 0;
			np.cost = Integer.MAX_VALUE;

			heap.add(np);
			map.put(i, np);
		}

		// work till heap is not empty
		while (!heap.isEmpty()) {

			// remove the pair from heap
			PrimsPair rp = heap.remove();
			map.remove(rp.vname);

			// mst add
			if (rp.acqvname != 0) {
				mst.addEdge(rp.vname, rp.acqvname, rp.cost);
			}

			// nbrs
			for (int nbr = 1; nbr < matrix[0].length; nbr++) {
				if (matrix[rp.vname][nbr] != 0) {

					// update the pairs which are present in heap
					if (map.containsKey(nbr)) {

						PrimsPair nbrpair = map.get(nbr);

						int oc = nbrpair.cost;
						int nc = matrix[rp.vname][nbr];

						// if new cost < old cost then update the pair
						if (nc < oc) {
							nbrpair.cost = nc;
							nbrpair.acqvname = rp.vname;

							heap.updatePriority(nbrpair);
						}

					}
				}
			}

		}

		return mst;

	}

	private class DijkstraPair implements Comparable<DijkstraPair> {
		int vname;
		String psf;
		int cost;

		@Override
		public int compareTo(DijkstraPair o) {
			return o.cost - this.cost;
		}
	}

	public void Dijkstra(int src) {

		HashMap<Integer, DijkstraPair> map = new HashMap<>();

		HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();

		// make a pair and put in heap and hash map
		for (int i = 1; i < matrix.length; i++) {
			DijkstraPair np = new DijkstraPair();
			np.vname = i;
			np.psf = "";
			np.cost = Integer.MAX_VALUE;

			if (i == src) {
				np.psf = i + "";
				np.cost = 0;
			}

			heap.add(np);
			map.put(i, np);
		}

		// work till heap is not empty
		while (!heap.isEmpty()) {

			// remove the pair from heap
			DijkstraPair rp = heap.remove();
			map.remove(rp.vname);

			// syso
			System.out.println(rp.vname + " via " + rp.psf + " @cost: " + rp.cost);

			// nbrs
			for (int nbr = 1; nbr < matrix[0].length; nbr++) {
				if (matrix[rp.vname][nbr] != 0) {

					// update the pairs which are present in heap
					if (map.containsKey(nbr)) {

						DijkstraPair nbrpair = map.get(nbr);

						int oc = nbrpair.cost;
						int nc = rp.cost + matrix[rp.vname][nbr];

						// if new cost < old cost then update the pair
						if (nc < oc) {
							nbrpair.cost = nc;
							nbrpair.psf = rp.psf + nbr;

							heap.updatePriority(nbrpair);
						}

					}
				}
			}

		}

	}

}





