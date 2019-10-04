/*Problem statement: Given a fraction. Convert it into a decimal. So simple :P

eg.
10/2 = 5
3/5 = 0.6

(The Question Begins Now)  :D
If the decimals are repeating recursively, then enclose them inside  ().

eg.
8/3 = 2.(6)

as 8/3 = 2.66666666.......  infinitly.

Link to the problem: https://practice.geeksforgeeks.org/problems/a-simple-fraction/0
*/

#include <iostream>
#include <unordered_map>

using namesqpace std;

int main()
 {
	int t;
	cin >> t;
	while(t--) {
	    int n, d, r, index = 0, a;
	    unordered_map<int, int> ump;
	    string str;
	    cin >> n >> d;
	    a = n / d;
	    r = n % d;
	    if(!r) cout << (n / d) << endl;
	    else {
	        while(r != 0 && ump.find(r) == ump.end()) {
	            ump[r] = str.size();
	            r = r * 10;
	            str += to_string(r / d);
	            r = r % d;
	        }
	        cout << a << ".";
	        if(!r) cout << str << endl;
	        else
	        cout << str.substr(0, ump[r]) << "(" + str.substr(ump[r]) + ")" << endl;
	    }

	}
	return 0;
}
