#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

class Graph {
public:
    unordered_map<int, bool> visited;
    unordered_map<int, vector<int>> adj;

    void addEdge(int v, int w);
    int BFS(int v);
};

void Graph::addEdge(int v, int w) {
    adj[v].push_back(w);
    adj[w].push_back(v); // Since friends are mutual, add both directions
}

int Graph::BFS(int v) {
    visited[v] = true;
    int componentSize = 0;

    queue<int> q;
    q.push(v);

    while (!q.empty()) {
        int u = q.front();
        q.pop();
        componentSize++;

        for (int neighbor : adj[u]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                q.push(neighbor);
            }
        }
    }

    return componentSize;
}

int main() {
    int tests;
    cin >> tests;
    while (tests--) {
        int citizens, friendships, v, e, largestComponentSize = 0;

        cin >> citizens >> friendships;
        Graph network;

        for (int i = 0; i < friendships; i++) {
            cin >> v >> e;
            network.addEdge(v, e);
        }

        for (int i = 1; i <= citizens; i++) {
            if (!network.visited[i]) {
                int componentSize = network.BFS(i);
                largestComponentSize = max(largestComponentSize, componentSize);
            }
        }

        cout << largestComponentSize << endl;
    }

    return 0;
}
