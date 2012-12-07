#include <stdio.h>

int gcd(int a, int b) {
	while (b != 0) {
		if (a < b) {
			swap(&a, &b);
		}
		int t = b;
		b = a % b;
		a = t;
	}
	return a;
}
