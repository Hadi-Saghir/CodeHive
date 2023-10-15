#include <iostream>
#include <string>

using namespace std;

bool ImInYourArea(const string& s, const string& t) {
    int i = 0;  
    int j = 0;

    while (i < s.length() && j < t.length()) {
        if (s[i] == t[j]) {
            i++; 
        }
        j++;
    }

    return (i == s.length());
}

int main() {
    string s, t;

    while (cin >> s >> t) {
        cout << ImInYourArea(s, t) << endl;
    }

    return 0;
}
