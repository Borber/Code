#include<iostream>
using namespace std;
typedef struct Node{int data;struct Node *next;}Node;
class List{
public:
    Node* Create(int Data,Node *Last);
    Node* Delete(Node *The_Delete);
};
Node* List::Create(int Data,Node *Last){
    Node *p;
    p = (Node *)malloc(sizeof(Node));
    p->data=Data;
    Last->next = p;
    p->next = NULL;
    return p;
}
Node* List::Delete(Node *The_Delete){
    Node *Temp;
    Temp = (The_Delete->next);
    The_Delete->next = Temp->next;
    if(The_Delete == The_Delete->next) {free(Temp);return NULL;}
    free(Temp);
    return The_Delete->next;
}

int main(){
    Node Head;
    Node *pcur,*per;
    pcur = &Head;
    List List_First;
    int n,m;
    Head.data = 1;
    cin >> n >> m;
    for(int i = 2;i <= n;++i) {cout << i;pcur = List_First.Create(i,pcur);}
    pcur->next = &Head;
    pcur = &Head;
    for(int i = 1;i <= n;++i){
        for(int j = 1;j < m-1;++j) {per = pcur ; pcur = per->next;}
        pcur = List_First.Delete(pcur);
    }
    return EXIT_SUCCESS;
}