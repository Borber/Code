#include <iostream>
#include <bits/stdc++.h>
using namespace std;
class High_int{
    public:
    void Input();
    void Output();
    High_int operator+(High_int& Other){
    High_int SUM;
    SUM.Count = max(this->Count,Other.Count);
    for(int i = 0;i < SUM.Count;++i){
    SUM.Num[i] = this->Num[i] + Other.Num[i];
    SUM.Num[i+1]+=SUM.Num[i]/SUM.bsm;
    SUM.Num[i]%=SUM.bsm;
    }
    if(SUM.Num[SUM.Count]) SUM.Count++;
    return SUM;
    };
    private:
    string Num_Str;
    unsigned int Num[150]={},Count = 0;
    int Length = 0,bs = 9,bsm = 1e9;
};
void High_int::Input(){
    string Num_Str;
    cin >> Num_Str;
    unsigned int Length = Num_Str.length();
    for(int i = Length-1;i>=0;i-=bs){
        int temp = 0;
        for(int j = max(0,i-bs+1);j <= i;++j) temp = temp*10+Num_Str[j]-'0';
        Num[Count++] = temp;
        }
}
void High_int::Output(){
    for(int i = Count-1;i >= 0;--i) cout << Num[i];
    cout << endl;
}
int main(){
    High_int A,B,SUM;
    A.Input();
    B.Input();
    SUM=A+B;
    SUM.Output();
    return 0;
}