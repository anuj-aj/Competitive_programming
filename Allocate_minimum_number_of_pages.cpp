/* 

You are given N number of books. Every ith book has Pi number of pages. 

You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations, and print this minimum value. 
Each book will be allocated to exactly one student. Each student has to be allocated atleast one book.

Link to the problem: https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages/0

*/

#include <iostream>
#include <climits>

#define ll long long 

using namespace std;

int countStudents(int a[], int N, ll mid) {
    ll count = 1, sum = 0;
    for(int i = 0; i < N; i++) {
        sum += a[i];
        if(sum > mid) {
            count++;
            sum = a[i];
        }
    }
    return count;
}

int partition(int a[], int N, int M) {
    ll ans = INT_MAX, x, mid, lo, hi;
    lo = a[0];
    hi = a[0];
    for(int i = 1; i < N; i++) {
        lo = max((int)lo, a[i]);
        hi += a[i];
    }
    while(lo <= hi) {
        mid = (lo + hi) / 2;
        x = countStudents(a, N, mid);
        if(x <= M) {
            ans = min(ans, mid);
            hi = mid - 1;
        }
        else {
            lo = mid + 1;
        }
    }
    return ans;
}
int main()
 {
	int t;
	cin >> t;
	while(t--) {
	   int N, M;
	   cin >> N;
	   int arr[N];
	   for(int i = 0; i < N; i++) {
	       cin >> arr[i];
	   }
	   cin >> M;
	   cout << (N >= M ? partition(arr, N, M) : -1) << endl;
	}
	return 0;
}