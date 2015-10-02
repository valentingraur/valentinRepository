/*
 * 08.09.2015 isBalanced() fixed
 * 23.02.2015 Constructors modified
 * 03.03.2014 isFull2()
 * 25.09.2011 Error fixed
 * 19.09.2011 Original version
 */
 
package jss2;


public class MyLinkedBinaryTree<T>
	extends LinkedBinaryTree<T>
{
	public MyLinkedBinaryTree()
	{
		super();
	}
	
	
	public MyLinkedBinaryTree( T element )
	{
		super( element );
	}
	
	
	public MyLinkedBinaryTree( T element, MyLinkedBinaryTree<T> leftSubTree, MyLinkedBinaryTree<T> rightSubTree )
	{
		super( element );
 
		if( leftSubTree != null ) {
			count += leftSubTree.size();
			root.left = leftSubTree.root;
		}
 
		if( rightSubTree != null ) {
			count += rightSubTree.size();
			root.right = rightSubTree.root;
		}
	}
	

	public int height()
	{
		return height( root );
	}
	

	private int height( BinaryTreeNode<T> node )
	{
		if( node == null )
			return -1;
		else
			return 1 + Math.max( height( node.left ), height( node.right ) );
	}
	
	
	public boolean isFull()
	{
		return isFull( root );
	}
	
	
	private boolean isFull( BinaryTreeNode<T> node )
	{
		if( node == null )
			return true;
		else
			return isFull( node.left ) && isFull( node.right ) &&
			       height( node.left ) == height( node.right );
	}
	
	
	public boolean isFull2()
	{
		int expectedNoNodes = ( 1 << ( height() + 1 ) ) - 1;
		
		return expectedNoNodes == size();
	}
	
	
	public boolean isBalanced()
	{
		return isBalanced( root );
	}
	
	
	public boolean isBalanced( BinaryTreeNode<T> node )
	{
		if( node == null || node.left == null || node.right == null) {
			return true;
		}
		else{
			return node.getHits() >= node.left.getHits() && node.getHits() >= node.right.getHits() && isBalanced( node.left ) && isBalanced( node.right );

		}
		}
}