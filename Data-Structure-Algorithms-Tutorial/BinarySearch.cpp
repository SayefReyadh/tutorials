#include<bits/stdc++.h>
#include<stdlib.h>
using namespace std;

int num[100];

int binarySearch (int l, int r, int key);

int main()
{
    ///Basic Input Phase
    int n;
    cout <<"Enter N: ";
    cin >> n;

    for(int i = 0 ; i < n ; i++)
    {
        num[i] = rand()%1000;
    }

    cout << "Unsorted Numbers: ";
    for(int i = 0 ; i < n ; i++)
    {
        cout << num[i] << " ";
    }
    cout << endl;

    ///C++ STL - Sort
    ///https://www.youtube.com/watch?v=kDQiS5F3kZk
    sort(num , num + n);

    cout << "Sorted Numbers: ";
    for(int i = 0 ; i < n ; i++)
    {
        cout << num[i] << " ";
    }
    cout << endl;

    /// Binary Search Starts
    int key;
    cout << "Enter Key to Search: ";
    cin >> key;

    int index = binarySearch(0, n - 1, key);

    if(index != -1)
        cout << "Value Key: " << key << " is found at " << index << endl;
    else
        cout << "Key is not found" << endl;
}

int binarySearch (int l, int r, int key)
{
    if (r >= l) {
        int mid = l + (r - l) / 2;

        // If the element is present at the middle itself
        if (num[mid] == key)
            return mid;

        // If element is smaller than mid, then it can only be present in left subarray
        if (num[mid] > key)
            return binarySearch(l, mid - 1, key);

        // Else the element can only be present in right subarray
        return binarySearch(mid + 1, r, key);
    }

    // We reach here when element is not present in array
    return -1;
}

