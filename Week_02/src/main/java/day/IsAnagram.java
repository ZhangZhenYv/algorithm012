package api;

/**
 * 通过将 ss 的字母重新排列成 tt 来生成变位词。
 * 因此，如果 TT 是 SS 的变位词，
 * 对两个字符串进行排序将产生两个相同的字符串。
 * 此外，如果 ss 和 tt 的长度不同，
 * tt 不能是 ss 的变位词，我们可以提前返回。
 *
 * @author bingjie.chen
 * @date 有效的字母异位词
 */
public class IsAnagram {
   /*时间复杂度：O(n \log n)O(nlogn)，假设 nn 是 ss 的长度，
   排序成本 O(n\log n)O(nlogn) 和比较两个字符串的成本 O(n)O(n)。
   排序时间占主导地位，总体时间复杂度为 O(n \log n)O(nlogn)。
   空间复杂度：O(1)O(1)，空间取决于排序实现，如果使用 heapsort，
   通常需要 O(1)O(1) 辅助空间。注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，
   所以它花费 O(n)O(n) 额外的空间，但是我们忽略了这一复杂性分析，因为：
   这依赖于语言的细节。
   这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。
   */
   public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
         return false;
      }
      char[] str1 = s.toCharArray();
      char[] str2 = t.toCharArray();
      Arrays.sort(str1);
      Arrays.sort(str2);
      return Arrays.equals(str1, str2);
   }
   /*时间复杂度：O(n)O(n)。时间复杂度为 O(n)O(n) 因为访问计数器表是一个固定的时间操作。
   空间复杂度：O(1)O(1)。尽管我们使用了额外的空间，但是空间的复杂性是 O(1)O(1)，
   因为无论 NN 有多大，表的大小都保持不变。*/


   public boolean isAnagram2(String s, String t) {
      if (s.length() != t.length()) {
         return false;
      }
      int[] counter = new int[26];
      for (int i = 0; i < s.length(); i++) {
         counter[s.charAt(i) - 'a']++;
         counter[t.charAt(i) - 'a']--;
      }
      for (int count : counter) {
         if (count != 0) {
            return false;
         }
      }
      return true;
   }

   public boolean isAnagram3(String s, String t) {
      if (s.length() != t.length()) {
         return false;
      }
      int[] table = new int[26];
      for (int i = 0; i < s.length(); i++) {
         table[s.charAt(i) - 'a']++;
      }
      for (int i = 0; i < t.length(); i++) {
         table[t.charAt(i) - 'a']--;
         if (table[t.charAt(i) - 'a'] < 0) {
            return false;
         }
      }
      return true;
   }




}
