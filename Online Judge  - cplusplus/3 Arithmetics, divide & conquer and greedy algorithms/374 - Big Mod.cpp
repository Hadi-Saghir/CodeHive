#include <iostream>


int BigMod(const int* b, const int* p,const int* m){
    long long result = 1;
    long long base = *b % *m;
    int power = *p;
    const int mod = *m;
    
    while (power > 0) {
        if (power % 2 == 1) {
            result = (result * base) % mod;
        }
        base = (base * base) % mod;
        power /= 2;
    }
    
    return static_cast<int>(result);

}

int main()
{
    int b,p,m;
    while (std::cin >> b >> p >> m)
    {
        int result = BigMod(&b, &p, &m);

        std::cout << result << std::endl;
            
    }

    return 0;
}
