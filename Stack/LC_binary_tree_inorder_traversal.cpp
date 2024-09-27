// LEETCODE


// RECURSIVE SOLUTION
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right; 
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> output;
        output = inorder(root, output);  // returns final output
        return output;
    }

    vector<int> inorder(TreeNode* root, vector<int> output) { // receives output every time to add nodes
        if (root == nullptr) { // if the root is null return the algorithm
            cout << "null";
            return output;
        }
        // visit entire left-subtree of cur-root-node, run the lRr on the left-node of cur-root
        output = inorder(root->left, output); 

        // after visiting entire left-subtree, running lRr algo on each root-node on the left-subtree
        // then returning after visiting entire left-subtree
        output.push_back(root->val);  

        // visit entire right-subtree of the current originla root node, run lRe on teh right-node of cur-root
        output = inorder(root->right, output); 

        // we are passing in left, adding root, passing in right, because inorder is lRr. 
        // returns output so it can be set
        return output;
    }
};

// NOTE: draw algorithm on paper to visualize
// when traversing left/right-subtree run the lRr algo on it. 