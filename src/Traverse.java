import java.util.*;

public class Traverse {
  public static void main(String[] args) {
    // See below site for visualization of this graph
    // https://auberonedu.github.io/graph-explore/graph_site/viz.html
    Vertex<Integer> v3 = new Vertex<>(3);
    Vertex<Integer> v7 = new Vertex<>(7);
    Vertex<Integer> v12 = new Vertex<>(12);
    Vertex<Integer> v34 = new Vertex<>(34);
    Vertex<Integer> v56 = new Vertex<>(56);
    Vertex<Integer> v78 = new Vertex<>(78);
    Vertex<Integer> v91 = new Vertex<>(91);
    Vertex<Integer> v45 = new Vertex<>(45);
    Vertex<Integer> v23 = new Vertex<>(23);
    Vertex<Integer> v67 = new Vertex<>(67);

    v3.neighbors.addAll(List.of(v7, v34));
    v7.neighbors.addAll(List.of(v12, v45, v34, v56));
    v12.neighbors.addAll(List.of(v7, v56, v78));
    v34.neighbors.addAll(List.of(v34, v91));
    v56.neighbors.addAll(List.of(v78));
    v78.neighbors.addAll(List.of(v91));
    v91.neighbors.addAll(List.of(v56));
    v45.neighbors.addAll(List.of(v23));
    v23.neighbors.addAll(List.of());
    v67.neighbors.addAll(List.of(v91));

    //don't need this instantiation due to method overloading
    // Set<Vertex<Integer>> visited = new HashSet<>();
    dfs(v7);
  }

  //method overloading
  public static <T> void dfs(Vertex<T> vertex) {
    //make tracker to avoid cycling
    //call method overload buddy with two parameters
    dfs(vertex, new HashSet<Vertex<T>>());

  }

  //if changed to private static method then can't bring in
  //outside visited List! Can only be used inside this class
  public static <T> void dfs(Vertex<T> vertex, Set<Vertex<T>> visited) {
    //return if vertex null OR if visited already contains 
    //current vertex
    if (vertex == null || visited.contains(vertex)) return;

    System.out.println(vertex.data);
    //update visited with current vertex
    visited.add(vertex);

    if (vertex.neighbors == null) return;

    for (Vertex<T> neighbor : vertex.neighbors) {
      dfs(neighbor, visited);
    }
  }
}
