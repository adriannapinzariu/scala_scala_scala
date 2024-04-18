#include <stdio.h>

void modifyValue(int x) {
    x = 100; 
    printf("Inside modifyValue: %d\n", x);
}

int main() {
    int a = 20;
    modifyValue(a);
    printf("In main: %d\n", a);
    return 0;
}

//Inside modifyValue: 100
//In main: 20