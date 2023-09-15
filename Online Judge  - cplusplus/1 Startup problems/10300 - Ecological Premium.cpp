
#include <iostream>

using std::cin;

int main() {
    int n;
    cin >> n; //number of test cases, e.g. farms
    
    while (n--) { 
        int f;
        cin >> f; // Number of farmers in the farm
        
        int totalPremium = 0; // premium per farm
        
        for (int i = 0; i < f; i++) { 
            int size, animals, environment;
            cin >> size >> animals >> environment; //size, number of animals, and degree of farmers environment-friendliness
            
            int farmerPremium = size * environment; 
            
            totalPremium += farmerPremium; 
        }
        
        std::cout << totalPremium << std::endl; // Output the total premium for this test case
    }
    
    return 0;
};