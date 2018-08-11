class Solution {
    // use array
    // public int[] smallestRange(List<List<Integer>> nums) {
    //     PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
    //         @Override
    //         public int compare(int[] o1, int[] o2) {
    //             return o1[0] - o2[0];
    //         }
    //     });
    //     int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;
    //     for (int i = 0; i < nums.size(); i++) {
    //         max = Math.max(max, nums.get(i).get(0));
    //         queue.offer(new int[] {nums.get(i).get(0), i, 0});
    //     }
    //     int range = Integer.MAX_VALUE;
    //     while (queue.size() == nums.size()) {
    //         int[] cur = queue.poll();
    //         if (max - cur[0] < range) {
    //             range = max - cur[0];
    //             start = cur[0];
    //             end = max;
    //         }
    //         if (cur[2] + 1 < nums.get(cur[1]).size()) {
    //             cur[2] += 1;
    //             cur[0] = nums.get(cur[1]).get(cur[2]);
    //             queue.offer(cur);
    //             if (cur[0] > max) {
    //                 max = cur[0];
    //             }
    //         }
    //     }
    //     return new int[]{start, end};
    // }
    
    
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> queue = new PriorityQueue<>(new Comparator<Element>(){
            @Override
            public int compare(Element o1, Element o2) {
                return o1.val - o2.val;
            }
        });
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            queue.offer(new Element(nums.get(i).get(0), i, 0));
            max = Math.max(max, nums.get(i).get(0));
        }
        int start = -1, end = -1;
        int range = Integer.MAX_VALUE;
        while (queue.size() == nums.size()) {
            Element cur = queue.poll();
            if (max - cur.val < range) {
                range = max - cur.val;
                start = cur.val;
                end = max;
            }
            if (cur.index + 1 < nums.get(cur.num).size()) {
                cur.index += 1;
                cur.val = nums.get(cur.num).get(cur.index);
                queue.offer(cur);
                if (cur.val > max) {
                    max = cur.val;
                }
            }
        }
        return new int[]{start, end};
    }
    
    class Element {
        int val;
        int num;
        int index;
        public Element(int val, int num, int index) {
            this.val = val;
            this.num = num;
            this.index = index;
        }
    }
}