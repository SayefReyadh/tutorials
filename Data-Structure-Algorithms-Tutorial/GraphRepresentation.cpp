/// © Sayef Reyadh
/// Programming Made Simple
/// youtube.com/SayefReyadh

#include<bits/stdc++.h>
using namespace std;
#define MX 100

typedef pair<int, int> PII;  /// dest & cost
vector<PII> v[MX];

vector <string> vertexNames; /// to store the vertex names
map <string, int> vertexNumbers; /// representing the vertex names with a numeric value

int vertex, edge; /// number of vertex & edge


void createGraph()
{
    cin >> vertex >> edge;

    for(int i = 0 ; i < edge ; i++)
    {
        int source;// , dest , cost;
        PII p;
        cin >> source >> p.first >> p.second; /// source - dest - cost
        v[source].push_back(p);
        int source2 = p.first;
        p.first = source;
        v[source2].push_back(p); /// for undirected graph
    }
}

void createStringGraph()
{
    cin >> vertex >> edge;

    for(int i = 0 ; i < vertex ; i++)
    {
        string vertexNameString;
        cin >> vertexNameString;
        vertexNames.push_back(vertexNameString);
        vertexNumbers[vertexNameString] = i;

    }

    for(int i = 0 ; i < edge ; i++)
    {
        string sourceString, destString;
        cin >> sourceString >> destString;
        int source;
        PII p;
        source = vertexNumbers[sourceString]; /// source
        p.first = vertexNumbers[destString]; /// dest
        cin >> p.second; /// cost

        v[source].push_back(p);
        int source2 = p.first;
        p.first = source;
        v[source2].push_back(p);
    }
}

void printGraph()
{
    for(int i = 0 ; i < vertex ; i++)
    {
        cout << i << " -- ";
        for(int j = 0 ; j < v[i].size() ; j++)
        {
            cout << v[i][j].first << "-" << v[i][j].second << "  ";
        }
        cout <<endl;
    }
    cout <<endl;

}

void printStringGraph()
{
    for(int i = 0 ; i < vertex ; i++)
    {
        cout << vertexNames[i] << " -- ";
        for(int j = 0 ; j < v[i].size() ; j++)
        {
            cout << vertexNames[v[i][j].first] << "-" << v[i][j].second << "  ";
        }
        cout <<endl;
    }
    cout <<endl;

}

int main()
{
    freopen("kruskal.txt", "r", stdin);
    createGraph();
    printGraph();

    freopen("kruskalModifiedString.txt", "r", stdin);
    createStringGraph();
    printStringGraph();

}


/*
kruskal.txt
8 9
0 3 3
0 4 6
1 5 5
1 6 1
2 4 6
3 5 8
5 6 3
5 7 2
6 7 6

kruskalModifiedString.txt
8 9
Rayerbag
Niketon
Mirpur
Dhanmondi
Jatrabari
Rampura
Badda
Gulshan
Rayerbag Dhanmondi 3
Rayerbag Jatrabari 6
Niketon Rampura 5
Niketon Badda 1
Mirpur Jatrabari 6
Dhanmondi Rampura 8
Rampura Badda 3
Rampura Gulshan 2
Badda Gulshan 6
*/
