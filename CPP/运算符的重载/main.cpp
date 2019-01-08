#include <iostream>
using namespace std;
class Point{
public:
Point(){ }
Point(int x,int y);
~Point(){ }
Point& operator++();
Point operator++(int);
Point& operator--();
Point operator--(int);
friend ostream& operator<<(ostream& out, const Point& a);
friend void operator>>(istream&in, Point& a);
public:
int x;
int y;
};

Point::Point(int x,int y){
this->x=x;
this->y=y;
}

Point& Point::operator++(){
this->x++;
this->y++;
return *this;
}

Point Point::operator++(int){
Point tmp(this->x,this->y);
this->x++;
this->y++;
return tmp;
}

Point& Point::operator--(){
this->x--;
this->y--;
return *this;
}

Point Point::operator--(int){
Point tmp(this->x,this->y);
this->x--;
this->y--;
return tmp;
}

ostream& operator<<(ostream& out, const Point& a){
out<<"a点为：("<<a.x<<","<<a.y<<")"<<endl;
return out;
}

void operator>>(istream&in, Point& a){
int px,py;
cout<<"输入x:"; cin>>px;
cout<<"输入y:"; cin>>py;
a.x=px;
a.y=py;
}

int main()
{
Point a;
cin>>a;
cout<<a;
cout<<"++a:"<<++a;
cout<<"--a:"<<--a;
cout<<"a++:"<<a++;
cout<<"a--:"<<a--;
cout<<"a:"<<a;
return 0;
}