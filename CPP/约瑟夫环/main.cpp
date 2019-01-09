#include<iostream>
using namespace std;
typedef struct Node{int data;struct Node *next;}Node;
class List{
    public:
    List(int n,int m):n(n),m(m){};
    void Create(Node *Last);
    void Delete();
    Node* Return(){return head;};
    private:
    int i = 1,n,m,Print_Num=0;
    Node *per,*pcur,*head = (Node *)malloc(sizeof(Node));
};
void List::Create(Node *Last){
    if (i == n) {Last->data = i;Last->next = head;return;}
    Node *Temp;
    Temp = (Node *)malloc(sizeof(Node));
    Last->data = i++;
    Last->next = Temp;
    Create(Temp);
    return;
}
void List::Delete(){
    pcur = head;
    for(int x = 1;x <= n;++x){
        for(int j = 1;j < m-1;++j){
            per = pcur;
            pcur = per->next;
        }
        per = pcur->next;
        cout << per->data << " ";
        pcur->next = per->next;
        free(per);
        per = pcur;
        pcur = per->next;
    }
}
int main(){
    int n,m;
    cin >> n >> m;
    List List_First(n,m);
    List_First.Create(List_First.Return());
    List_First.Delete();
    cout << endl;
    return EXIT_FAILURE;
}