#include"bits/stdc++.h"
using namespace std;

int main()
{
    int T,temp;
    cin >> T;
    for(int time=0;time<T;time++)
    {
        int max1= 0;
        int max2 = 0;
        int num,a;
        cin >> num;
        for(int i=0;i<num;i++)
        {
            cin >> a;
            if( a > max2)
            {
                max2 =a;
            }
            if(max2 > max1)
            {
                temp = max1;
                max1 = max2;
                max2 = temp;
            }
        }
        int ans =  min(max2-1, num-2);
        cout << ans << endl;
    }
    return 0;
}
