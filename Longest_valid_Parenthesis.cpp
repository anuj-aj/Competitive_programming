/*

Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

Link to the problem: https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0

*/

#include <iostream>
#include <string>
#include <stack>


using namespace std;

int main()
 {
	int t;
	cin >> t;
	while(t--) {
	    int MAX = 0;
	    string str;
	    stack<int> st;
	    cin >> str;
	    st.push(-1);
	    for(int i = 0; i < str.size(); i++) {
	        if(str[i] == '(') {
	            st.push(i);
	        }
	        else {
	            st.pop();
	            if(st.empty()) st.push(i);
	            else
	                MAX = max(MAX, i - st.top());
	        }
	    }
	    cout << MAX << endl;
	}
	return 0;
}