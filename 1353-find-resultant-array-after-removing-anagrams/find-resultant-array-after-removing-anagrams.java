class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> l = new ArrayList<>();
        l.add(words[0]);
        for(int i = 1 ; i < words.length; i++){
                if(!check(l.get(l.size()-1),words[i])){
                    l.add(words[i]);
                }
        }
        return l;
    }
    boolean check(String s,String t){
        char a[] = s.toCharArray();
        char b[] = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        String s1 = new String(a);
        String s2 = new String(b);

        return s1.equals(s2);
    }
}