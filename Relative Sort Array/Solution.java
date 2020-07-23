class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i  : arr1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i = 0; i<arr2.length;i++){
            if(map.containsKey(arr2[i])){
                while(map.get(arr2[i])!=0){
                    ans.add(arr2[i]);
                    map.put(arr2[i],map.get(arr2[i])-1);
                }
            }
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            while(e.getValue()!=0){
                ans.add(e.getKey());
                map.put(e.getKey(),e.getValue()-1);
            }
        }
       
        int[] res = new int[ans.size()];
        for(int i = 0;i <ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
        
    }
}
