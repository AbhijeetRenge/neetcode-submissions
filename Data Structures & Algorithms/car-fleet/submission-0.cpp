class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<pair<int,int>>PandS(speed.size());
        for(int i=0;i<speed.size();i++){
            PandS[i] = {position[i], speed[i]};
        }
        sort(PandS.begin(),PandS.end());
        stack<double>s;
        for(int i = PandS.size()-1; i>=0;i--){
            double time = (double)(target-PandS[i].first)/PandS[i].second;
            if(s.empty() || time > s.top()){
                s.push(time);
            }
        }
        return s.size();
    }
};
