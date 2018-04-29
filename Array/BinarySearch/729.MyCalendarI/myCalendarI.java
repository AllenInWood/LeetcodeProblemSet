class MyCalendar {
    List<int[]> event;
    
    public MyCalendar() {
        event = new ArrayList<>();
        event.add(new int[]{-1, 0});
        event.add(new int[]{1000000000, 1000000000});
    }
    
    public boolean book(int start, int end) {
        int l = 0, r = event.size() - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (event.get(mid)[0] == start) {
                return false;
            } else if (event.get(mid)[0] > start) {
                r = mid;
            } else {
                l  = mid;
            }
        }
        if(event.get(l)[1] <= start && event.get(l + 1)[0] >= end){
            event.add(l + 1, new int[] {start, end});
            return true;
        }
        if(event.get(r - 1)[1] <= start && event.get(r)[0] >= end){
            event.add(r, new int[] {start, end});
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */