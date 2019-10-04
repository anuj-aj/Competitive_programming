/*

We define f (X, Y) as number of different corresponding bits in binary representation of X and Y. For example, f (2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f (2, 7) = 2.

You are given an array of N integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 10^9+7.

Link to the problem: https://practice.geeksforgeeks.org/problems/find-sum-of-different-corresponding-bits-for-all-pairs/0

*/

#include <iostream>
#include <vector>

#define MOD 1000000007

using namespace std;

int main()
 {
	int t;
	cin >> t;
	while(t--) {
	    int n, x, j;
	    long long ans = 0;
	    vector<int> zeroes(35), ones(35);
	    cin >> n;
	    for(int i = 0; i < n; i++) {
	        j = 0;
	        cin >> x;
	        while(j < 33) {
	            if(x & 1) ones[j]++;
	            else zeroes[j]++;
	            x >>= 1;
	            j++;
	        }
	    }
	    for(int i = 0; i < 33; i++) {
	        ans = (ans + (zeroes[i] * ones[i]) % MOD)% MOD;
	    }
	    cout << (2 * ans) % MOD << endl;
	}
	return 0;
}