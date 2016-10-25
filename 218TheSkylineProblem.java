public class Solution {
    class Node implements Comparable{
        int x;
        int y;
        boolean start;
        public Node(int x, int y, boolean start) {
            this.x = x;
            this.y = y;
            this.start = start;
        }
        @Override
        public int compareTo(Node n) {
            if (y == n.y) {
                if (start == n.start)   return 0;
                if (start) return 1;
                return -1;
            }
            return n.y - y;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        List<Node> starts = new ArrayList<Node>();
        List<Node> ends = new ArrayList<Node>();
        for (int i = 0; i < buildings.length ; i ++) {
            starts.add(new Node (buildings[0], buildings[2], true));
            ends.add(new Node (buildings[1], buildings[2], false));
        }
        starts.addAll(ends);
        PriorityQueue<Node> q = PriorityQueue<Node>();
        q.offer(0);
        int pre = 0, cur = 0;
        for (int i = 0 ; i < list.size(); i++) {
            Node toAdd = starts.get(i);
            cur = q.peek();
            if (!toAdd.start) {
                Node toPop = q.pop();
                result.add(new int[2] {toPop.});
            }
            q.offer(n.y);
            cur = q.peek().y;
            if (pre != cur) {
                
            }
            
        }
        result.add();
    }
}