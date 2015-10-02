/*
 * 03.03.2014 isFull2()
 * 03.03.2014 Spelling fixed in package name
 * 19.09.2011 Original version
 */
 
package dk.viauc.jpe.mylinkedbinarytree;


import jss2.*;


public class TestMyLinkedBinaryTree
{
	public static void main( String[] args )
	{
		new TestMyLinkedBinaryTree().run();
	}
	
	
	private void run()
	{
		MyLinkedBinaryTree<String> tree = buildTree();
		
		System.out.println( "full:     " + tree.isFull() );
		System.out.println( "full2:    " + tree.isFull2() );
		System.out.println( "height:   " + tree.height() );
		System.out.println( "balanced: " + tree.isBalanced() );
		
		tree = buildTree2();
		
		System.out.println( "full:     " + tree.isFull() );
		System.out.println( "full2:    " + tree.isFull2() );
		System.out.println( "height:   " + tree.height() );
		System.out.println( "balanced: " + tree.isBalanced() );
	}
	
	
	private MyLinkedBinaryTree<String> buildTree()
	{
		MyLinkedBinaryTree<String> lTree = new MyLinkedBinaryTree<String>( "L" );
		MyLinkedBinaryTree<String> mTree = new MyLinkedBinaryTree<String>( "M" );
		MyLinkedBinaryTree<String> nTree = new MyLinkedBinaryTree<String>( "N" );
		MyLinkedBinaryTree<String> oTree = new MyLinkedBinaryTree<String>( "O" );
		MyLinkedBinaryTree<String> pTree = new MyLinkedBinaryTree<String>( "P" );
		
		MyLinkedBinaryTree<String> gTree = new MyLinkedBinaryTree<String>( "G" );
		MyLinkedBinaryTree<String> hTree = new MyLinkedBinaryTree<String>( "H", lTree, mTree );
		MyLinkedBinaryTree<String> iTree = new MyLinkedBinaryTree<String>( "I" );
		MyLinkedBinaryTree<String> jTree = new MyLinkedBinaryTree<String>( "J", nTree, null );
		MyLinkedBinaryTree<String> kTree = new MyLinkedBinaryTree<String>( "K", oTree, pTree );
		
		MyLinkedBinaryTree<String> dTree = new MyLinkedBinaryTree<String>( "D", gTree, hTree );
		MyLinkedBinaryTree<String> eTree = new MyLinkedBinaryTree<String>( "E", iTree, null );
		MyLinkedBinaryTree<String> fTree = new MyLinkedBinaryTree<String>( "F", jTree, kTree );

		MyLinkedBinaryTree<String> bTree = new MyLinkedBinaryTree<String>( "B", dTree, eTree );
		MyLinkedBinaryTree<String> cTree = new MyLinkedBinaryTree<String>( "C", null, fTree );
		
		MyLinkedBinaryTree<String> aTree = new MyLinkedBinaryTree<String>( "A", bTree, cTree );
		
		return aTree;
	}
	
	
	private MyLinkedBinaryTree<String> buildTree2()
	{
		MyLinkedBinaryTree<String> dTree = new MyLinkedBinaryTree<String>( "D" );
		MyLinkedBinaryTree<String> eTree = new MyLinkedBinaryTree<String>( "E" );
		MyLinkedBinaryTree<String> fTree = new MyLinkedBinaryTree<String>( "F" );
		MyLinkedBinaryTree<String> gTree = new MyLinkedBinaryTree<String>( "G" );

		MyLinkedBinaryTree<String> bTree = new MyLinkedBinaryTree<String>( "B", dTree, eTree );
		MyLinkedBinaryTree<String> cTree = new MyLinkedBinaryTree<String>( "C", fTree, gTree );
		
		MyLinkedBinaryTree<String> aTree = new MyLinkedBinaryTree<String>( "A", bTree, cTree );
		
		return aTree;
	}
}