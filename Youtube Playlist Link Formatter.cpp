/*
https://developers.google.com/apis-explorer/#p/youtube/v3/youtube.playlistItems.list
part : snippet
maxResults : 100
playlistId : id
fields : items(snippet(resourceId/videoId,title))
Generate the JSON Data and paste it in input.txt
*/

#include<bits/stdc++.h>
using namespace std;
#define MX 100

int main()
{
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);

    string str;
    while(getline(cin, str))
    {
        int l;
        if(str.find("title") != std::string::npos)
        {
            l = str.rfind(",");
            l -= 2;
            //cout << l << endl;
            cout << "* " << str.substr(14,l-13) << endl;
        }
        if(str.find("videoId") != std::string::npos)
        {
            l = str.rfind("\"");
            l -= 1;
            cout << "[Youtube Video](https://youtu.be/" << str.substr(17,l-16) << ")\n"<< endl;
        }
    }
}
