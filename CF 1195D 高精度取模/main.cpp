#include "bits/stdc++.h"
using namespace std;


int mod(string a,long long  b)//高精度a除以单精度b
{
    long long d=0;
    for(int i=0;i<a.size();i++)  d=(d*10+(a[i]-'0'))%b;  //求出余数
    return d;
}

string a[100001];

int main(){
    int n;
    cin >> n;
    for(int i=0;i<n;i++) cin >> a[i];

    int len = a[0].length();

    string sum = "";
    long long  yu = 0;
    for(int pos= len-1;pos>=0;pos--)
    {
        long long  temp_sum = 0;
        for(int i=0;i<n;i++)
        {
            temp_sum+=(a[i][pos]-'0');
        }
        temp_sum*=n;
        temp_sum+= (temp_sum*10);
        temp_sum+=yu;

        yu = temp_sum/100;

        string jia = "00";
        int ss = (temp_sum%100);
        jia[0] = '0'+ss/10;
        jia[1] = '0'+ss%10;
        sum = jia+sum;
    }



    stringstream ss;
    ss<<yu;
    string   qian=ss.str();

    sum = qian+sum;
    int ans = mod(sum,998244353);
    cout << ans << endl;
    return 0;
}
