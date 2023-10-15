#include <stdio.h>
#include <string.h>


bool balanced;

int isMobile(){
    int wl, dl, wr, dr;

    scanf("%d %d %d %d", &wl, &dl, &wr, &dr);

    if(wl == 0) {
        wl = isMobile();
    }

    if(wr == 0) {
        wr = isMobile();
    }

    if(wl*dl != wr*dr) balanced = false;

    return wl + wr;

}


int main() {

    int tests;
    scanf("%d", &tests);
    while(tests--){

        balanced = true;
        isMobile();

        if (balanced) {
            printf("YES\n");
        } else {
            printf("NO\n");
        }
        if (tests > 0) {
            printf("\n"); // Print a blank line between consecutive test cases
        }
    }

    return 0;
}