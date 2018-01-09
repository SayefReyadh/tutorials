/// © Sayef Reyadh
/// Programming Made Simple
/// youtube.com/SayefReyadh

#include<bits/stdc++.h>
using namespace std;
#define MX 100
///#include <algorithm>
///#include <vector>

int num[MX];
vector <int> v;



struct bInfo
{
    int id;
    string name;
    int meritPosition;

    bool operator < (const bInfo &var) const
    {
        return id < var.id;
    }

};

bool cmp(bInfo lhs, bInfo rhs)
{
    if(lhs.id < rhs.id)
        return lhs.id < rhs.id;
    else if(lhs.meritPosition < rhs.meritPosition)
        return lhs.meritPosition < rhs.meritPosition;
    else
        return false;
}



bool operator < (bInfo lhs, bInfo rhs)
{
    return lhs.id < rhs.id;
}

bool cmp2(const bInfo &lhs, const bInfo &rhs)
{
    return lhs.id < rhs.id;
}



int n;
bInfo info[10];


void inputFile()
{
    for(int i = 0 ; i < n ; i++)
    {
        cin >> info[i].id >> info[i].name >> info[i].meritPosition;
    }
}

void outputFile()
{
    for(int i = 0 ; i < n ; i++)
    {
        cout << info[i].id << " " << info[i].name << " " << info[i].meritPosition << endl;
    }
}

void randomNumberGenerator(int n)
{
    for(int i = 0 ; i < n ; i++)
    {
        num[i] = rand()%200;
        v.push_back(num[i]);
    }

}

void showNumbers(int n)
{
    for(int i = 0 ; i < n ; i++)
    {
        ///cout << num[i] << " ";
        cout << v[i] << " ";
    }
    cout << endl;
}


int main()
{

//    int n = 10;
//    randomNumberGenerator(n);
//    showNumbers(n);
//    sort(v.begin(), v.end());
//    showNumbers(n);

    freopen("i.txt", "r", stdin);
    cin >> n;
    inputFile();
    sort(info, info+n, cmp);
    outputFile();
}

/*
i.txt
5
5 Sayef 305
3 Reyadh 207
4 Khan 102
2 Asif 105
1 Shaafi 190
*/

