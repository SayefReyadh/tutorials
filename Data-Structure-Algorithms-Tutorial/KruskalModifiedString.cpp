#include<bits/stdc++.h>
using namespace std;
#define MX 100


struct edgeStructure
{
    int u;
    int v;
    int w;
};

vector <string> vertexNames;
map <string , int> vertexNumbers;

bool operator < (edgeStructure lhs, edgeStructure rhs)
{
    return lhs.w < rhs.w;
}

bool cmp(const edgeStructure &lhs, const edgeStructure &rhs)
{
    if(lhs.u != rhs.u)
        return lhs.u < rhs.u;
    else
        return lhs.w < rhs.w;
}


int parent[MX];
int rankParent[MX];


vector<edgeStructure> edgeVector;

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


int kruskal(int n)
{
    initializeSet(n);

    sort(edgeVector.begin(), edgeVector.end());

    int sz = edgeVector.size();

    int ans = 0;
    for(int i = 0 ; i < sz ; i++)
    {
        if(findParent(edgeVector[i].u) != findParent(edgeVector[i].v))
        {
            //union
            unionSet(parent[edgeVector[i].u] , parent[edgeVector[i].v]);
            //cout << edgeVector[i].u << " " << edgeVector[i].v << endl;
            ans+=edgeVector[i].w;
        }
    }
    //cout << endl;
    return ans;
}


int main()
{
    freopen("kruskalModifiedString.txt", "r", stdin);
    int vertex, edge;
    cin >> vertex >> edge;

    for(int i = 0 ; i < vertex ; i++)
    {
        string str;
        cin >> str;
        vertexNames.push_back(str);
        vertexNumbers[str] = i;
        //cout << str << endl;

    }
    //cout << endl;


    for(int i = 0 ; i < edge ; i++)
    {
        string str1 , str2;
        cin >> str1 >> str2;
        //cout << str1 << endl;
        //cout << str2 << endl;

        edgeStructure e;
        e.u = vertexNumbers[str1];
        e.v = vertexNumbers[str2];
        cin >> e.w;
        //cin >> e.u >> e.v >> e.w;
        edgeVector.push_back(e);
    }
    //cout << "MST" << endl;
    cout << "MST Cost " << kruskal(vertex) << endl;
}


