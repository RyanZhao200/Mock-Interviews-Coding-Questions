class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        if(products == null || products.length == 0 || searchWord == null || searchWord.length() == 0){
            return ans;
        }
        Arrays.sort(products);
        
        for(int i = 0;i<searchWord.length();i++){
            List<String> curr = helper(products,searchWord,i);
            ans.add(curr);
        }
        return ans;
           
    }
    
    public List<String> helper(String[] products, String searchWord, int j){
        List<String> ans = new ArrayList<>();
        int count = 0;
        for(int i = 0;i<products.length;i++){
           
            if(products[i].indexOf(searchWord.substring(0,j+1)) == 0){
                ans.add(products[i]);
                count++;
            }
             if(count>=3){
                return ans;
            }
        }
        return ans;
    }
    
    
}
