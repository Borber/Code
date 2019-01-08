#include<iostream>
#include<unistd.h>
#include<time.h>
#define Left  'h'
#define Down  'j'
#define Up    'k'
#define Right 'l'

using namespace std;
struct Snack_Data{
int  Long = 0;     //蛇的长度
int  Data[500][2]; //蛇的身体位置
char TO = Right;  //开始就往右走
}SNACK;        //蛇的本体

void Pause(int TIME)
{
    clock_t Start,End;
    Start = clock();
    while(1){End = clock();if((End-Start)/CLOCKS_PER_SEC>=TIME) break;}
return;
}

class Move{
public:
void left();
void down();
void up();
void right();
}Move_Snack;   //移动 但是还没判定 方向

class Plus{
public:
void left();
void down();
void up();
void right();
}Plus_Snack;    //加长 但是还没有 判定加长的时间 暂定是检测下一个移动的点是苹果 就加长 然后去掉苹果

class Snack{
public:
void Add_Apple(); //通过随机数 生成苹果
void Eat_Apple(); //通过判定蛇在吃到苹果之前的方向来 加长蛇 
void Die();       //通过判定 蛇里有没有两个相同的点来判定死亡
void PRINT();     //打印地图
int  GAME_OVER(){return GAMEOVER;}; // 结束游戏
private:
int GAMEOVER = 0;
int Apple[2];
};

void Move::left() {--SNACK.Data[SNACK.Long][1];}

void Move::down() {++SNACK.Data[SNACK.Long][0];}

void Move::up()   {--SNACK.Data[SNACK.Long][0];}

void Move::right(){++SNACK.Data[SNACK.Long][1];}

void Plus::left() {++SNACK.Long;SNACK.Data[SNACK.Long][0]=SNACK.Data[SNACK.Long-1][0];SNACK.Data[SNACK.Long][1]=SNACK.Data[SNACK.Long-1][1]-1;}

void Plus::down() {++SNACK.Long;SNACK.Data[SNACK.Long][0]=SNACK.Data[SNACK.Long-1][0]+1;SNACK.Data[SNACK.Long][1]=SNACK.Data[SNACK.Long-1][1];}

void Plus::up()   {++SNACK.Long;SNACK.Data[SNACK.Long][0]=SNACK.Data[SNACK.Long-1][0]-1;SNACK.Data[SNACK.Long][1]=SNACK.Data[SNACK.Long-1][1];}

void Plus::right(){++SNACK.Long;SNACK.Data[SNACK.Long][0]=SNACK.Data[SNACK.Long-1][0];SNACK.Data[SNACK.Long][1]=SNACK.Data[SNACK.Long-1][1]+1;}

void Snack::Add_Apple(){
int x,y;
int OK=1;
do{
    x=rand() % 20;
    y=rand() % 20;
    for(int i = 0;i <= SNACK.Long;++i) if(SNACK.Data[i][0]==x&&SNACK.Data[i][1]==y) OK=0;
}while(!OK);
Apple[0]=x;
Apple[1]=y;
}

void Snack::Eat_Apple(){
if(SNACK.TO == Left)   Plus_Snack.left();
if(SNACK.TO == Down)   Plus_Snack.down();
if(SNACK.TO == Up)     Plus_Snack.up();
if(SNACK.TO == Right)  Plus_Snack.right();
Add_Apple();                                // 吃完苹果就加一个
}

void Snack::Die(){
    for(int i = 0;i <= SNACK.Long; ++i)
    for(int j = i+1; j<= SNACK.Long;++j)
    if (SNACK.Data[i][0]==SNACK.Data[j][0]&&SNACK.Data[i][1]==SNACK.Data[j][1]) GAMEOVER = 1;
    }

void Snack::PRINT(){
int Map[20][20]{};
for(int i = 0; i <= SNACK.Long; ++i) Map[SNACK.Data[i][0]][SNACK.Data[i][1]] = 1;
Map[Apple[0]][Apple[1]] = 1;
for(int i = 0; i < 20;++i)
for(int j = 0; j < 20;++j)
if(Map[i][j]) cout << "*";
else cout << " ";
Pause(500);
}