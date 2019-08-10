package L33_Aug9;

import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Aug-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		Graph g = new Graph(7);
		g.addEdge(1, 2, 2);
		g.addEdge(1, 4, 10);
		g.addEdge(2, 3, 3);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 5, 8);
		g.addEdge(5, 6, 5);
		g.addEdge(6, 7, 4);
		g.addEdge(5, 7, 6);

		System.out.println(g);

		// g.removeEdge(4, 5);
		// g.removeEdge(6, 7);

		// System.out.println(g.hasPath(1, 6, new HashMap<>()));
		// g.printAllPaths(1, 6, new HashMap<>(), "");

		// System.out.println(g);

		// System.out.println(g.numEdge());

		// System.out.println(g.containsEdge(1, 2));

		// System.out.println(g.BFS(1, 6));
		// System.out.println(g.DFS(1, 6));

		// g.DFT();

		// System.out.println(g.isCyclic());
		// System.out.println(g.isConnected());
		// System.out.println(g.isTree());
		// System.out.println(g.getCC());
		// System.out.println(g.isBipartite());

		// System.out.println(g.Prims());
		g.Dijkstra(2);

	}
}
