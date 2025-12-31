class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,j=0,maxlen=0;
        while(j<n){
            if(map.containsKey(fruits[j])){
                map.put(fruits[j],map.get(fruits[j])+1);
            }else{
                map.put(fruits[j],1);
            }
            while(map.size()>2){
                int freq=map.get(fruits[i]);
                if(freq==1)map.remove(fruits[i]);
                else map.put(fruits[i],freq-1);
                i++;
            }
            int len=j-i+1;
            maxlen=Math.max(maxlen,len);
            j++;
        }
        return maxlen;
    }
}