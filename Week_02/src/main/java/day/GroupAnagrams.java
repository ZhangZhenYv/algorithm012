package api;

/*字母异位词分组*/
public class GroupAnagrams {
  /* 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
   示例:
   输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
   输出:
           [
           ["ate","eat","tea"],
           ["nat","tan"],
           ["bat"]
           ]
   说明：
   所有输入均为小写字母。
   不考虑答案输出的顺序。
*/
 /*时间复杂度：O(NK \log K)O(NKlogK)，其中 NN 是 strs 的长度，
   而 KK 是 strs 中字符串的最大长度。当我们遍历每个字符串时，
   外部循环具有的复杂度为 O(N)O(N)。然后，我们在 O(K \log K)O(KlogK) 的时间内对每个字符串排序。

   空间复杂度：O(NK)O(NK)，排序存储在 ans 中的全部信息内容。*/

   public List<List<String>> groupAnagrams(String[] strs) {
      if (strs.length == 0) return new ArrayList();
      Map<String, List> ans = new HashMap<String, List>();
      for (String s : strs) {
         char[] ca = s.toCharArray();
         Arrays.sort(ca);
         String key = String.valueOf(ca);
         if (!ans.containsKey(key)) ans.put(key, new ArrayList());
         ans.get(key).add(s);
      }
      return new ArrayList(ans.values());
   }
   /**
    * 时间复杂度是O(nklog^k)，其中n是字符串数组的长度，k是其中最长的一个字符串的长度。
    * 1、首先声明一个map，key为排序后的词，因为anagram排序后都一样，所以可以借此分出不同的组。
    * 2、value设为string类型的list，它每遇到自己key下的字符串时，就把它拉进list中
    * 3、最后再遍历一遍list，输出给结果就可以了。
    *
    * 个人觉得第二步比较重要，也很难想到。键值对选择还是很重要:)
    *字母异位词分组
    */
   public List<List<String>> groupAnagrams2(String[] strs) {

      List<List<String>> res = new LinkedList<>();
      Map<String, List<String>> map = new HashMap<>();
      //O(n), n = the length of strs
      for(int i = 0; i < strs.length; i ++){

         String s = strs[i];
         char[] c = s.toCharArray();
         //O(k*log^k), k = the longest string in strs
         Arrays.sort(c);
         s = new String(c);
         if(map.containsKey(s)){
            List<String> list = map.get(s);
            list.add(strs[i]);
            map.put(s, list);
         }
         else {
            List<String> list = new LinkedList<>();
            list.add(strs[i]);
            map.put(s, list);
         }
      }
      //O(m), m = the number of anagram group
      for(List list : map.values())
         res.add(list);

      return res;
   }



}
