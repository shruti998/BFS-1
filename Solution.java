//# BFS-1
//# Problem 1
//Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> result= new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            List<Integer> temp= new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                TreeNode cur=q.poll();
                temp.add(cur.val);
                if(cur.left!=null)
                {
                    q.add(cur.left);
                }
                if(cur.right!=null)
                {
                    q.add(cur.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}

//# Problem 2
//Course Schedule (https://leetcode.com/problems/course-schedule/)


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // we need indegree array to see how many dependency are there
        int indegree[]=new int[numCourses];
        // we need map to check if a course is done how many indegree decresses
        Map<Integer,List<Integer>> map= new HashMap<>();
        // we need a queue to see what courses is done
        Queue<Integer> q=new LinkedList<>();
        //we need count variable to tarack how many courses are done
        int count=0;
        // initiallizing the value in the array and map
        for(int[] pre:prerequisites)
        {
            int to=pre[0];
            int from=pre[1];
            indegree[to]++;
            if(!map.containsKey(from))
            {
                map.put(from, new ArrayList<>());

            }
            map.get(from).add(to);
        }
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty())
        {
            int cur=q.poll();
            // check if map cointains the course or not 
            if(map.containsKey(cur))
            {
            List<Integer> temp=map.get(cur);
            for(int j=0;j<temp.size();j++)
            {
                indegree[temp.get(j)]--;
                if(indegree[temp.get(j)]==0)
                {
                    q.add(temp.get(j));
                    count++;
                }
            }
            }
        }
return count==numCourses;
        
    }
}


