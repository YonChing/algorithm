#include <stdio.h>
#include "declared.h"

int main() {
	int a = 0; 
	int b = 0;
	scanf("%d %d", &a, &b);
	swap(&a, &b);
	printf("%d %d\n", a, b);
	printf("%d\n", gcd(a, b));
	return 0;
}
