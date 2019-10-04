/*

Given an array, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.

Link to the problem: https://practice.geeksforgeeks.org/problems/minimum-sum-partition/0

*/

#include <iostream>
#include <vector>

using namespace std;

int dp[51][2501];
int sumPart(vector<int> vec, int n, int sum) {
    if(n < 0) return abs(sum);
    if(dp[n][abs(sum)] == -1)
        dp[n][abs(sum)] = min(sumPart(vec, n - 1, sum + vec[n]), sumPart(vec, n - 1, sum - vec[n]));
    return dp[n][abs(sum)];
}

int main()
 {
	int t;
	cin >> t;
	while(t--) {
	    int n;
	    vector<int> vec;
	    cin >> n;
	    vec.resize(n);
	    for(int i = 0; i < n; i++) cin >> vec[i];
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j <= 50 * n; j++) {
	            dp[i][j] = -1;
	        }
	    }
	    cout << sumPart(vec, n - 1, 0) << endl;
	}
	return 0;
}