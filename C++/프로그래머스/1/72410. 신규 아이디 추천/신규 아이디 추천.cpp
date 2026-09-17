#include <bits/stdc++.h>

using namespace std;

string solution(string new_id) {
    int prevPoint = -1;
    
    // 1 phase
    for (int i = 0; i < new_id.length(); i++) {
        new_id[i] = tolower(new_id[i]);        
    }
    
    // 2 phase
    for (int i = 0; i < new_id.length(); ) {
        bool valid = (new_id[i] >= 'a' && new_id[i] <= 'z')
              || (new_id[i] >= '0' && new_id[i] <= '9')
              || new_id[i] == '-' || new_id[i] == '_' || new_id[i] == '.';
        if (!valid) {
            new_id.erase(i, 1);   // i를 증가시키지 않음
        } else {
            i++;
        }
    }
    
    // 3 phase
    for (int i = 0; i < new_id.length() - 1; ) {
        if (new_id[i] == '.' && new_id[i + 1] == '.') {
            new_id.erase(i, 1);
        }
        else {
            i++;
        }
    }
    
    // 4 phase
    if (new_id[0] == '.') {
        new_id.erase(0, 1);
    }
    
    if (new_id[new_id.length() - 1] == '.') {
        new_id.erase(new_id.length() - 1, 1);
    }
    
    // 5 phase
    if (new_id == "") {
        new_id += "a";
    }
    
    // 6 phase
    if (new_id.length() >= 16) {
        new_id = new_id.substr(0, 15);
        
        if (new_id[14] == '.') {
            new_id.erase(14, 1);
        }
    } 
    
    // 7 phase
    if (new_id.length() <= 2) {
        while (new_id.length() < 3) {
            new_id += new_id[new_id.length() - 1];
        }
    }  
    
    return new_id;
}