/**
 *
 * Binary Tree to Represent Morse Code and Decode Morse Code
 *
 * @author  Ben Schreyer
 * @version 1.0
 * @since   2020-11-13
 */
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface
{
    private TreeNode<String> head;
    private TreeNode<String> navigator;
    /**
     * default constructor
     */
    MorseCodeTree()
    {


    }

    /**
     * Get the root of the tree
     * @return root of the tree
     */
    @Override
    public TreeNode getRoot() {
        return head;
    }
    /**
     * Set the root of the tree
     * @param New root
     */
    @Override
    public void setRoot(TreeNode newNode) {
        head = newNode;
    }
    /**
     * Add a symbol code association to the tree
     * @param Code to associate symbol with
     * @param Symbol
     * @return  The tree that the symbol was added to
     */
    @Override
    public LinkedConverterTreeInterface insert(Object code, Object result)
    {
        addNode(head, code, result);
        return this;
    }

    /**
     * Add a symbol to the tree according to its code
     * @param Root of tree
     * @param Code
     * @param Letter

     */
    @Override
    public void addNode(TreeNode root, Object code, Object letter) {
        String codeT = (String) code;
        if(codeT.length() > 1)
        {
            if(codeT.charAt(0) == '.')
            {
                addNode(root.getLeft(), codeT.substring(1),letter);
            }
            else
            {
                addNode(root.getRight(), codeT.substring(1),letter);
            }
        }
        else
        {
            if(codeT.charAt(0) == '.')
                root.setLeft(new TreeNode<String>((String)letter));
            else
                root.setRight(new TreeNode<String>((String)letter));
        }
    }
    /**
     * Get the symbol associated with a code
     * @param Code
     * @return Symbol for code
     */
    @Override
    public Object fetch(String code) throws InvalidMorseCodeException {
        return fetchNode(head, code);
    }

    @Override
    public Object fetchNode(TreeNode root, Object code) throws InvalidMorseCodeException {
        String codeT = (String) code;
        if(codeT.length() > 0)
        {
            if(codeT.charAt(0) == '.')
            {
                if(root.getLeft() == null)
                {
                    throw new InvalidMorseCodeException();
                }

               return fetchNode(root.getLeft(), codeT.substring(1));
            }
            else
            {
                if(root.getRight() == null)
                {
                    throw new InvalidMorseCodeException();
                }
               return fetchNode(root.getRight(), codeT.substring(1));
            }
        }
        else
        {
            return root.getData();
        }
    }
    /**
     * Not supported
     */
    @Override
    public LinkedConverterTreeInterface delete(Object data) throws UnsupportedOperationException
    {
        return null;
    }
    /**
     * Not supported
     */
    @Override
    public LinkedConverterTreeInterface update() throws UnsupportedOperationException
    {
        return null;
    }
    /**
     * Construct the tree
     */
    @Override
    public void buildTree()
    {
        head = new TreeNode<String>("");
        navigator = head;
        head.setLeft(new TreeNode<String>("e"));
        head.setRight(new TreeNode<String>("t"));


        head.getLeft().setLeft(new TreeNode<String>("i"));
        head.getLeft().setRight(new TreeNode<String>("a"));
        head.getRight().setLeft(new TreeNode<String>("n"));
        head.getRight().setRight(new TreeNode<String>("m"));

        head.getLeft().getLeft().setLeft(new TreeNode<String>("s"));
        head.getLeft().getLeft().setRight(new TreeNode<String>("u"));
        head.getLeft().getRight().setLeft(new TreeNode<String>("r"));
        head.getLeft().getRight().setRight(new TreeNode<String>("w"));

        head.getRight().getLeft().setLeft(new TreeNode<String>("d"));
        head.getRight().getLeft().setRight(new TreeNode<String>("k"));
        head.getRight().getRight().setLeft(new TreeNode<String>("g"));
        head.getRight().getRight().setRight(new TreeNode<String>("o"));


        head.getLeft().getLeft().getLeft().setLeft(new TreeNode<String>("h"));
        head.getLeft().getLeft().getLeft().setRight(new TreeNode<String>("v"));

        head.getLeft().getLeft().getRight().setLeft(new TreeNode<String>("f"));
        head.getLeft().getRight().getLeft().setLeft(new TreeNode<String>("l"));
        head.getLeft().getRight().getRight().setLeft(new TreeNode<String>("p"));
        head.getLeft().getRight().getRight().setRight(new TreeNode<String>("j"));
        head.getRight().getLeft().getLeft().setLeft(new TreeNode<String>("b"));
        head.getRight().getLeft().getLeft().setRight(new TreeNode<String>("x"));
        head.getRight().getLeft().getRight().setLeft(new TreeNode<String>("c"));
        head.getRight().getLeft().getRight().setRight(new TreeNode<String>("y"));

        head.getRight().getRight().getLeft().setLeft(new TreeNode<String>("z"));
        head.getRight().getRight().getLeft().setRight(new TreeNode<String>("q"));
    }
    /**
     * Get an ArrayList of data in the tree
     * @return ArrayList containing data in tree Inorder traversal
     */
    @Override
    public ArrayList toArrayList() {
        ArrayList<String> ret = new ArrayList<String>();
        LNRoutputTraversal(head,ret);
        return ret;
    }
    /**
     * Fill an arraylist with the Inorder traversal of the code tree
     * @param Root of tree
     * @param ArrayList to fill
     */
    @Override
    public void LNRoutputTraversal(TreeNode root, ArrayList list)
    {
        if(root.getLeft()!=null)
            LNRoutputTraversal(root.getLeft(),list);
        list.add(root.getData());
        if(root.getRight()!=null)
            LNRoutputTraversal(root.getRight(),list);
    }
}
