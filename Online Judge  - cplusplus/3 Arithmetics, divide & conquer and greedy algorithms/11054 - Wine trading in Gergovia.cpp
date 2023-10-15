#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long long Lazy(vector<int>& demands) {
    long long work = 0;
    long long sum = 0;

    for (int i = 0; i < demands.size(); i++) {
        sum += demands[i];
        work += abs(sum);
    }

    return work;
}

int main() {
    int n;

    while (cin >> n && n != 0) {
        vector<int> demands(n);

        for (int i = 0; i < n; i++) {
            cin >> demands[i];
        }

        cout << Lazy(demands) << endl;
    }

    return 0;
}
