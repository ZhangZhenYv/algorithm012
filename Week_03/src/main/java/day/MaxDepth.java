package api;

/**
 *
 二叉树的最大深度
 *
 *
 */
public class MaxDepth {
    /* Definition for a binary tree node. */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int left_height = maxDepth(root.left);
                int right_height = maxDepth(root.right);
                return java.lang.Math.max(left_height, right_height) + 1;
            }
        }
    /*时间复杂度：我们每个结点只访问一次，因此时间复杂度为 O(N)O(N)，
    其中 NN 是结点的数量。
    空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用 NN 次（树的高度），因此保持调用栈的存储将是 O(N)O(N)。但在最好的情况下（树是完全平衡的），树的高度将是 \log(N)log(N)。因此，在这种情况下的空间复杂度将是 O(\log(N))O(log(N))。
*/

  /*  二叉树的最小深度*/

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if ((root.left == null) && (root.right == null)) {
                return 1;
            }

            int min_depth = Integer.MAX_VALUE;
            if (root.left != null) {
                min_depth = Math.min(minDepth(root.left), min_depth);
            }
            if (root.right != null) {
                min_depth = Math.min(minDepth(root.right), min_depth);
            }

            return min_depth + 1;
        }
    /*二叉树的序列化与反序列化*/
    public class Codec {
        public String rserialize(TreeNode root, String str) {
            if (root == null) {
                str += "None,";
            } else {
                str += str.valueOf(root.val) + ",";
                str = rserialize(root.left, str);
                str = rserialize(root.right, str);
            }
            return str;
        }

        public String serialize(TreeNode root) {
            return rserialize(root, "");
        }

        public TreeNode rdeserialize(List<String> l) {
            if (l.get(0).equals("None")) {
                l.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
            l.remove(0);
            root.left = rdeserialize(l);
            root.right = rdeserialize(l);

            return root;
        }

        public TreeNode deserialize(String data) {
            String[] data_array = data.split(",");
            List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
            return rdeserialize(data_list);
        }
    }




}
