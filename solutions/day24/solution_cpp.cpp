#include <iostream>
#include <vector>
#include <algorithm>  // for reverse
using namespace std;

/*
You are given a large integer represented as an integer array digits,
where each digits[i] is the ith digit of the integer. The digits are ordered
from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.

-> Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
*/

int main() {
    vector<int> arr = {9, 1, 5, 9};  // or {9, 9, 9}
    int size = arr.size();

    // Convert the array to a number
    int number = 0;
    for (int i = 0; i < size; i++) {
        number = number * 10 + arr[i];
    }

    // Add 1 to the number
    number += 1;

    // Convert the number back to an array
    vector<int> num(size);
    for (int i = size - 1; i >= 0; i--) {
        num[i] = number % 10;
        number /= 10;
    }

    // Print the result
    cout << "[";
    for (int i = 0; i < size; i++) {
        cout << num[i];
        if (i < size - 1) cout << ", ";
    }
    cout << "]" << endl;

    return 0;
}
