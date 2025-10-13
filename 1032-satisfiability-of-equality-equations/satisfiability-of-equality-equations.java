class Solution {
    public boolean equationsPossible(String[] e) {
        ufds u = new ufds();
        for(var i : e){
            char ch1 = i.charAt(0) , ch2 = i.charAt(1) , ch3 = i.charAt(3);
            if(ch2 == '='){
                u.merge(ch1-'a' , ch3-'a');
            }
        }
        for(var i : e){
            char ch1 = i.charAt(0) , ch2 = i.charAt(1) , ch3 = i.charAt(3);
            if(ch2 == '!'){
                if(u.find(ch1-'a') == u.find(ch3-'a')) return false;
            }
        }
        return true;
    }
}
class ufds{
    int parent[];
    int size[];
    ufds(){
        this.parent = new int[26];
        this.size = new int[26];
        for(int i = 0;i<26;i++)parent[i]=i;
        for(int i = 0;i<26;i++)size[i] = 1;
    }
    int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    void merge(int x,int y){
        int u_x = find(x);
        int u_y = find(y);
        if(u_x == u_y) return ;
        if(size[u_x] > size[u_y]){
            parent[u_y] = u_x;
            size[u_x] += size[u_y];
        }
        else{
            parent[u_x] = u_y;
            size[u_y] += size[u_x];
        }
    }
}