/**
 *
 * Generic Node For a Binary Tree
 *
 * @author  Ben Schreyer
 * @version 1.0
 * @since   2020-11-13
 */
public class TreeNode<T>
{
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T data;

    /**
     * Construct with data
     * @param Object to hold
     */
    TreeNode(T d)
    {
        data = d;
        left = null;
        right = null;
    }
    /**
     * Construct with all fields
     * @param Object to hold
     * @param Left node
     * @param Right node
     */
    TreeNode(T d, TreeNode<T> left, TreeNode<T> right)
    {
        data = d;
        left = left;
        right = right;
    }
    /**
     * Construct copy
     * @param Object to copy
     */
    TreeNode(TreeNode<T> c)
    {
        this(c.getData(),c.getLeft(),c.getRight());
    }

    /**
     * Retreive node data
     * @return Data
     */
    public T getData()
    {
        return data;
    }

    /**
     * Set data held by node
     * @param Data
     */
    public void setData(T d)
    {
        data = d;
    }

    /**
     * Get left node
     * @return left node
     */
    public TreeNode<T> getLeft()
    {
        return left;
    }

    /**
     * Set left node
     * @param Node to set as left
     */
    public void setLeft(TreeNode<T> n)
    {
        left = n;
    }

    /**
     * Get node right of current
     * @return Right node
     */
    public TreeNode<T> getRight()
    {
        return right;
    }

    /**
     * Set right node of current
     * @param Node
     */
    public void setRight(TreeNode<T> n)
    {
        right = n;
    }

}
