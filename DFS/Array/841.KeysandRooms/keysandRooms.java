class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return true;
        }
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, visited, 0);
        if (visited.size() == rooms.size()) {
            return true;
        }
        return false;
    }
    private void dfs(List<List<Integer>> rooms, Set<Integer> visited, int index) {
        visited.add(index);
        for (int key : rooms.get(index)) {
            if (!visited.contains(key)) {
                dfs(rooms, visited, key);
            }
        }
    }
}