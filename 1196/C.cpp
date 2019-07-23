#include"bits/stdc++.h"
using namespace std;

int a[300001];
int cha[300001];

int main()
{
    int n,k;
    cin >> n >> k;
    for(int time=0;time<n;time++)
    {
        cin >> a[time];
        if(time >=1)
        {
            cha[time-1]= a[time]-a[time-1];
        }
    }
    sort(cha,cha+n-1);
    long long ans = 0;
    for(int i=0;i<n-1-(k-1);i++)
    {
        ans+=cha[i];
    }
    cout <<  ans << endl;
    return 0;
}
