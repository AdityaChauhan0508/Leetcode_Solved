class Solution {

    List<Integer> [] graph;
    int[] parent, depth, heavy, head, pos, size;
    int[] segTree;
    int[] base;
    int curPos;
    int n;
    StringBuilder str;
    
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

        this.n = n;
        this.str = new StringBuilder(s);

        graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        size = new int[n];
        Arrays.fill(heavy,-1);

        dfs(0,-1);

        head = new int[n];
        pos = new int[n];
        base = new int[n];
        curPos = 0;

        decompose(0,0);

        segTree = new int[4 * n];
        build(1,0,n-1);

        List<Boolean> result = new ArrayList<>();

        for(String q : queries) {
            String[] parts = q.split(" ");

            if(parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                updateNode(u, c);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = queryPath(u, v);

                result.add((mask & (mask - 1)) == 0);
            }
        }
        return result;
    }

    private int dfs(int v , int p) {
        parent[v] = p;
        size[v] = 1;

        int maxSize = 0;

        for(int u : graph[v]) {
            if(u == p) continue;
            depth[u] = depth[v] + 1;
            int subtree = dfs(u,v);
            size[v] += subtree;

            if(subtree > maxSize) {
                maxSize = subtree;
                heavy[v] = u;
            }
        }
        return size[v];
    }
    private void decompose(int v, int h) {
        head[v] = h;
        pos[v] = curPos;
        base[curPos] = 1 << (str.charAt(v) - 'a');
        curPos++;

        if(heavy[v] != -1) decompose(heavy[v], h);

        for(int u : graph[v]) {
            if(u != parent[v] && u != heavy[v])
                decompose(u, u);
        }
    }

    private void build(int node, int l, int r) {
        if(l == r) {
            segTree[node] = base[l];
        } else {
            int mid = (l + r) / 2;
            build(node * 2, l, mid);
            build(node * 2 + 1, mid + 1, r);
            segTree[node] = segTree[node * 2] ^ segTree[node * 2 +1];
        }
    }

    private void update(int node, int l, int r, int idx, int val) {
        if(l == r) {
            segTree[node] = val;
        } else {
            int mid = (l + r) / 2;
            if(idx <= mid)
                update(node * 2, l, mid, idx, val);
            else
                update(node * 2 + 1, mid + 1, r, idx, val);

            segTree[node] = segTree[node * 2] ^ segTree[node * 2 + 1];
        }
    }

    private void updateNode(int u, char c) {
        str.setCharAt(u, c);
        int mask = 1 << (c - 'a');
        update(1,0,n-1,pos[u],mask);
    }

    private int query(int node, int l, int r, int ql, int qr) {
        if(qr < l  || r < ql) return 0;
        if(ql <= l && r <= qr) return segTree[node];

        int mid = (l+r) / 2;
        return query(node * 2, l, mid, ql, qr) ^ query(node * 2 + 1, mid + 1,r,ql,qr);
    }

    private int queryPath(int a, int b) {
        int res = 0;

        while(head[a] != head[b]) {
            if(depth[head[a]] < depth[head[b]]) {
                int temp = a;
                a = b;
                b = temp;
            }
            res ^= query(1,0,n-1,pos[head[a]], pos[a]);
            a = parent[head[a]];
        }
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        res ^= query(1,0,n-1,pos[a],pos[b]);
        return res;
    }
}










