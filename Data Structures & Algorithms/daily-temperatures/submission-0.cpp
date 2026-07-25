class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& t) {
        stack<int>s;
        vector<int>result(t.size());
        for(int i=t.size()-1;i>=0;i--){
            int res = 0;
            while(!s.empty() && t[s.top()]<=t[i]){
                // res = s.top();
                s.pop();
            }
            if(!s.empty())res = s.top()-i;
            s.push(i);
            result[i] = res;


        }
        return result;
    }
};
