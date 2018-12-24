/// © Sayef Reyadh
/// Programming Made Simple
/// youtube.com/SayefReyadh

#include<bits/stdc++.h>
using namespace std;
#define MX 100


int parent[MX];
int rankParent[MX];


void initializeSet(int n)
{
    for(int i = 0 ; i < n ; i++)
    {
        parent[i] = i;
        rankParent[i] = 0;
    }
}

int findParent(int x)
{
    if(x != parent[x])
        return parent[x] = findParent(parent[x]);
    else
        return x;
}

void unionSet(int x, int y)
{
    int px = findParent(x);
    int py = findParent(y);
    if(px == py) return;

    ///cout << px << " " << py << endl;
    if(rankParent[px] < rankParent[py])
        parent[px] = py;
    else if(rankParent[px] > rankParent[py])
        parent[py] = px;
    else
    {
        parent[py] = px;
        rankParent[px]++;
    }


}

void printSet(int n)
{
    for(int i = 0 ; i < n ; i++)
    {
        cout << "Node is " << i << " Parent is " << parent[i] << " Rank is " << rankParent[i] << endl;
    }
    cout << endl;
}

int main()
{
    int n;
    cin >> n;
    initializeSet(n);

    unionSet(0,1);
    unionSet(4,2);
    unionSet(3,1);
    unionSet(0,3);

    unionSet(0,4);

    printSet(n);


}
