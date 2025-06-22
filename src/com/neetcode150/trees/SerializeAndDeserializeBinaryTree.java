package com.neetcode150.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * Reference : https://www.youtube.com/watch?v=vqbpTOU-LS4
 */
public class SerializeAndDeserializeBinaryTree {


    public static void main(String[] args) {

    }
    // Encodes a tree to a single string.
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public String serialize(TreeNode root) {
        return recursiveSerialize(root, "");
    }
    public String recursiveSerialize(TreeNode root, String str){

        if(root == null){
            str = str +  "null,";
            return str;
        }

        str = str + root.val +",";
        str = recursiveSerialize(root.left, str);
        str = recursiveSerialize(root.right, str);

        return str;
    }

    // Decodes your encoded data to tree.
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public TreeNode deserialize(String data) {
        String[] strArray = data.split(",");
        List<String> strList = new LinkedList<String>(Arrays.asList(strArray));
        return recursiveDeserialize(strList);
    }
    // Decodes your encoded data to tree.
    public TreeNode recursiveDeserialize(List<String> strs){
        if(strs.get(0).equals("null")){
            strs.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(strs.get(0)));
        strs.remove(0);
        root.left= recursiveDeserialize(strs);
        root.right = recursiveDeserialize(strs);

        return root;
    }
}
