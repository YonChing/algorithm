#include <stdio.h>

void fibonacci() {
	int f1 = 0;
	int f2 = 1;
	int f3 = 0;
	int max = 0;

	scanf("%d", &max);
	printf("%d\n%d\n", f1, f2);
	while ( 1 ) {
		f3 = f1 + f2;
		if (f3 > max)
			break;
		f1 = f2;
		f2 = f3;
		printf("%d\n", f3);
	}
}
