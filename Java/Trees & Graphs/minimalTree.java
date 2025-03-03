import java.util.*;
public class minimalTree {

    public static void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.val+" ");
        inorder(root.left);
        inorder(root.right);
    }
    public static TreeNode minimalTree(int arr[], int start, int end)
    {
        int mid = (start+end)/2;
        if(start > mid || end < mid)
        {
            return null;
        }
        TreeNode root = new TreeNode(arr[mid]);
        if(start>=end)
        {
            return root;
        }
        root.left = minimalTree(arr, start, mid - 1);
        root.right = minimalTree(arr, mid + 1, end);
        return root;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        TreeNode node = minimalTree(arr, 0, n-1);
        inorder(node);
    }
    
}
