#include <stdio.h>
#include <string.h>

int main() {
    char str[64];

    while (fgets(str, sizeof(str), stdin)) {
        unsigned int bit = 128;
        int i = 0;
        int sum = 0;

        if (str[i] != '|') {
            continue;
        }

        for (; str[i]; ++i) {
            if (str[i] == ' ') {
                bit >>= 1;
            } else if (str[i] == 'o') {
                sum += bit;
                bit >>= 1;
            }
        }

        putchar(static_cast<char>(sum));
    }

    return 0;
}






