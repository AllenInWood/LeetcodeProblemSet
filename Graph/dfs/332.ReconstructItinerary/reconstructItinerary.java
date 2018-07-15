class Solution {
//     Map<String, Queue<String>> flights;
//     LinkedList<String> path;
    
//     public List<String> findItinerary(String[][] tickets) {
//         flights = new HashMap<>();
//         path = new LinkedList<>();
//         for (String[] ticket : tickets) {
//             if (!flights.containsKey(ticket[0])) {
//                 flights.put(ticket[0], new PriorityQueue<>());
//             }
//             flights.get(ticket[0]).offer(ticket[1]);
//         }
//         dfs("JFK");
//         return path;
//     }
//     private void dfs(String departure) {
//         Queue<String> arrivals = flights.get(departure);
//         while (arrivals != null && !arrivals.isEmpty()) {
//             dfs(arrivals.poll());
//         }
//         path.addFirst(departure);
//     }
    
    
    Map<String, Queue<String>> flights;
    LinkedList<String> path;
    
    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            if (!flights.containsKey(ticket[0])) {
                flights.put(ticket[0], new PriorityQueue<>());
            }
            flights.get(ticket[0]).offer(ticket[1]);
        }
        
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (flights.containsKey(stack.peek()) && !flights.get(stack.peek()).isEmpty()) {
                stack.push(flights.get(stack.peek()).poll());
            }
            path.addFirst(stack.pop());
        }
        return path;
    }
}