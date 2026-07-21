class Solution {
public:

    string encode(vector<string>& strs) {
        string res = "";
        for(int i=0;i<strs.size();i++){
            res+= to_string(strs[i].size())+"#"+strs[i];
        }
        return res;
    }

    vector<string> decode(string s) {
        int i=0;
        vector<string>res;
        string curr = "";
        while(i<s.size()){
            if(s[i]!='#'){
                curr += s[i];
                i++;
            }else{
                int length = stoi(curr);
                res.push_back(s.substr(i+1, length));
                i+= length+1;
                curr = "";
            }
        }
        return res;
    }
};
