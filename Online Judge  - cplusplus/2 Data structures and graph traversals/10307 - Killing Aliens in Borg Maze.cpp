#include <iostream>
#include <string>
#include <queue>
#include <cstring>

using namespace std;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

struct Position {
    int x, y;
};

const int maxAliens = 100;
int x, y, alienCount, oo;
string maze[50];
int alienId[50][50], alienDist[50][50], link[maxAliens][maxAliens];

void bfs(Position start) {
    memset(alienDist, 127, sizeof(alienDist));
    alienDist[start.x][start.y] = 0;
    queue<Position> q;
    q.push(start);

    while (!q.empty()) {
        Position current = q.front(); // c++ doesn't return value on pop
        q.pop();

        //push adj to queue
        for (int k = 0; k < 4; k++) {
            Position next = {current.x + dx[k], current.y + dy[k]};
            if (next.x >= 0 && next.x < y && next.y >= 0 && next.y < x && maze[next.x][next.y] != '#' && alienDist[next.x][next.y] == oo) {
                alienDist[next.x][next.y] = alienDist[current.x][current.y] + 1;
                q.push(next);
            }
        }

        // If the current position is 'A' or 'S', update the link distances
        if (maze[current.x][current.y] == 'A' || maze[current.x][current.y] == 'S') {
            link[alienId[current.x][current.y]][alienId[start.x][start.y]] = alienDist[current.x][current.y];
            link[alienId[start.x][start.y]][alienId[current.x][current.y]] = alienDist[current.x][current.y];
        }
    }
}

int minimumSpanningTree() {
    // Initialize cost and solution
    int cost[maxAliens], result = 0;
    memset(cost, 127, sizeof(cost));
    bool visited[maxAliens];
    memset(visited, true, sizeof(visited));
    int next = 0;
    cost[next] = 0;

    // Find the minimum spanning tree
    for (int k = 1; k < alienCount; k++) {
        int current = next;
        visited[current] = false;
        next = -1;

        for (int i = 0; i < alienCount; i++) {
            if (visited[i]) {
                if (link[current][i] != oo && link[current][i] < cost[i])
                    cost[i] = link[current][i];
                if (next == -1 || cost[i] < cost[next])
                    next = i;
            }
        }

        result += cost[next];
    }

    return result;
}

int main() {

    int tests;
    cin >> tests;
    while(tests--) {
        alienCount = 0;
        string line;
        Position alienNodes[maxAliens];

        cin >> x >> y;
        getline(cin, line);

        for(int i = 0; i < y; i++) {
            getline(cin, maze[i]);

            for (int j = 0; j < x; j++) {
                if (maze[i][j] == 'S' || maze[i][j] == 'A') {
                    alienNodes[alienCount].x = i;
                    alienNodes[alienCount].y = j;
                    alienId[i][j] = alienCount;
                    alienCount++;
                }
            }
        }

        // BFS
        memset(link, 127, sizeof(link));
        oo = link[0][0];

        for (int i = 0; i < alienCount; i++)
            bfs(alienNodes[i]);

        // Minimum Spanning Tree
        cout << minimumSpanningTree() << endl;
    }

    return 0;
}
