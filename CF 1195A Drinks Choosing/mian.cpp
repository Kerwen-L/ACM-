#include"bits/stdc++.h"
using namespace std;
int Num[1001];

int main(){
    int n,k;
    cin >> n >> k;
    for( int i =0;i<=1000;i++) Num[i]=0;
    int temp;
    for(int i=0;i<n;i++)
    {
        cin >>temp;
        Num[temp]++;
    }
    int ans = 0;
    int numbers = 0;
    for(int i=1;i<=k;i++)
    {
        ans+=2*(Num[i]/2);
        if(Num[i]%2 == 1) numbers+=1;
    }
    if(numbers %2 == 0)
    {
        ans+=(numbers/2);
    }
    else{
        ans+=(numbers/2+1);
    }
    cout << ans << endl;
    return 0;
}
