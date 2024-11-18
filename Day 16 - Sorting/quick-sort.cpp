#include <bits/stdc++.h>
using namespace std;

int parition(vector<int> &arr, int s, int e)
{
  int pivot = arr[e];
  int i = s - 1;

  for (int j = s; j < e; j++)
  {
    if (arr[j] < pivot)
    {
      i++;
      swap(arr[i], arr[j]);
    }
  }
  swap(arr[i + 1], arr[e]);
  return i + 1;
}

void quick_sort(vector<int> &arr, int s, int e)
{
  // base case
  if (s >= e)
  {
    return;
  }

  // rec case
  int mid = parition(arr, s, e);
  quick_sort(arr, mid + 1, e);
  quick_sort(arr, s, mid - 1);
}

int main()
{

  int n;
  cin >> n;
  vector<int> arr(n);
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }
  int s = 0, e = n - 1;
  quick_sort(arr, s, e);
  for (int x : arr)
    cout << x << ' ';
  return 0;
}