#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<pair<string, string>> order;
    unordered_map<string, string> list;
    vector<string> ans;
    
    for (string str : record) {
        vector<string> subarr;
        int cur = 0, pos = 0;
        
        while ((pos = str.find(" ", cur)) != string::npos) {
            int len = pos - cur;
            
            subarr.push_back(str.substr(cur, len));
            cur = pos + 1;
        }
        subarr.push_back(str.substr(cur));
        
        order.push_back({subarr[0], subarr[1]});
        
        if (subarr[0] == "Enter") {
            list[subarr[1]] = subarr[2];
        }
        else if (subarr[0] == "Change") { // change
            list[subarr[1]] = subarr[2];
        }
    }   
    
    for (int i = 0; i < order.size(); i++) {
        if (order[i].first == "Enter") {
            ans.push_back(list[order[i].second] + "님이 들어왔습니다.");
        }
        else if (order[i].first == "Leave") {
            ans.push_back(list[order[i].second] + "님이 나갔습니다.");
        }
    }
    
    return ans;
}