#include <iostream>
#include <vector>

using std::cin;
using std::vector;

int main() {
    int n;
    int currSet = 0;
    
    while (cin >> n) { 

        if(n == 0){break;}

        currSet++;

        vector<int> stacks(n);

        int totalBricks = 0;
        for (int i = 0; i < n; i++) {
            cin >> stacks[i] ;
            totalBricks += stacks[i];
        }

        int desiredHeight = totalBricks / n;
        
        int k = 0;
        for (auto stackHeight : stacks)  { 
            int temp = stackHeight - desiredHeight;

            if (temp > 0) {
                k += temp;
            }
        }
        
        std::cout << "Set #" << currSet << std::endl;
        std::cout << "The minimum number of moves is " << k << "." << std::endl;
    }
    
    return 0;
};


//C
#include <stdio.h>

int main() {
    int n;
    int currSet = 0;
    
    while (scanf("%d", &n) != EOF) { 

        if(n == 0){break;}

        currSet++;
        int stacks[50];

        int numberOfBricks;
        int totalBricks = 0;
        for (int i = 0; i < n; i++) {
            scanf("%d", &numberOfBricks);
            stacks[i] = numberOfBricks;
            totalBricks += numberOfBricks;
        }

        int desiredHeight = totalBricks / n;
        
        int k = 0;
        for (int i = 0; i < n; i++)  { 
           int temp = desiredHeight - stacks[i];

           if (temp < 0) {
                k += -temp;
            }
        }

        printf("Set #%d\n", currSet);
        printf("The minimum number of moves is %d.\n\n", k);
    }
    
    return 0;
}
