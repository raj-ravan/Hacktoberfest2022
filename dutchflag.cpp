#include<bits/stdc++.h>
using namespace std;
int main()
{
  int n,i;
  cout<<"Enter the number of elements : \n";
  cin>>n;
  int arr[n];
  cout<<"Enter the elements : \n";
  for(i=0;i<n;i++)
  {
    cin>>arr[i];
  }
  int left=0,mid=0,right=n-1;
  while(mid<=right)
  {
    if(arr[mid]==0)
    {
      swap(arr[left],arr[mid]);
      left++;mid++;
    }
    else if(arr[mid]==1)
    {
      mid++;
    }
    else if(arr[mid]==2){
      swap(arr[mid],arr[right]);
      right--;
    }
  }
  cout<<"Segregated elements are : \n";
  for(i=0;i<n;i++)
  cout<<arr[i]<<" ";
}
