import collections


class Solution:
    def restoreArray(self, adjacentPairs):

        def dfs(u):
            output.append(u) # add cur-node to visited and otuput
            visited.add(u)
            # for every neighbor in cur-node, if its not visited recurse
            for v in g[u]:
                if v not in visited:
                    dfs(v)

        g = collections.defaultdict(list)  # {node-val: [neighbors]}
        for u, v in adjacentPairs: # for every pair of adjacent nodes
            g[u].append(v) # add v as a neightbor of u
            g[v].append(u) # add u as a neighbor of v
        # iterate nodes and find an endpoint either first/last where there
        # neighbors are 1
        for key, value in g.items():
            if len(value) == 1:
                start = key

        output = []
        visited = set() # store unqiue visited nodes

        dfs(start) # depth first search
        return output

# adjacentPairs = [[2,1],[3,4],[3,2]]
# {1:[2], 2:[1,3]}
# 1743. Restore the Array From Adjacent Pairs