#include <iostream>
#include <bits/stdc++.h>
#include <vector>
using namespace std;
#define L(i,k,mx,my) (i == mx+1||i == mx-1)&&(k == my+2||k == my-2)
int m,n,mx,my;
long long Map[30][30]={1};
bool Pick(int i,int k){
    if((i == mx&&k == my) || (i == 0&&k == 0)) return 1;
    if((L(i,k,mx,my) )||(L(k,i,my,mx))) return 1;
    return 0;
}
int main()
{
    cin >> m >> n >> mx >> my;
    for(int i=0;i <= m;++i)
    for(int k=0;k <= n;++k)
    if(!Pick(i,k)) Map[i][k] = Map[i][k==0?k:k-1] + Map[i==0?i:i-1][k];
    cout << Map[m][n];
    return 0;
}