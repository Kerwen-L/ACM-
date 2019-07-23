#include"bits/stdc++.h"
using namespace std;

int a[2000000];

int main()
{
    int T,temp;
    cin >> T;
    for(int time=0;time<T;time++)
    {
        cin >> a[time];
    }
    int numbs = 0;
    for(int i=2;i<T;i++)
    {
        if((a[i]-a[i-1])*(a[i-1]-a[i-2]) <0)
            numbs+=1;
        if((a[i]-a[i-1])>0 && (a[i-1]-a[i-2])<0)
        {
            cout << "NO" << endl;
            return 0;
        }
    }
    if(numbs ==1 || numbs==0)
        cout << "YES" << endl;
    else
        cout << "NO" << endl;
    return 0;
}
