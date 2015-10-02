/**
 * BinaryTreeNode represents a node in a binary tree with a left and 
 * right child.
 * 
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 8/19/08
 */

package jss2;

public class BinaryTreeNode<T>
{
   protected T element;
   protected BinaryTreeNode<T> left, right;
   private int hits;

   /**
    * Creates a new tree node with the specified data.
    *
    * @param obj  the element that will become a part of the new tree node
   */
   BinaryTreeNode (T obj) 
   {
      element = obj;
      left = null;
      right = null;
      hits = 0;
   }

   /**
    * Returns the number of hits of this node.
    *
    * @return  the integer number of hits of this node
    */
   protected int getHits() {
      return hits;
   }

   /**
    * Every time the node is found with the find(), contains() etc. methods
    * its hit count is incremented by one.
    */
   protected void incrHits() {
      hits++;
   }

   /**
    * Returns the number of non-null children of this node.
    * This method may be able to be written more efficiently.
    *
    * @return  the integer number of non-null children of this node 
    */
   public int numChildren() 
   {
      int children = 0;

      if (left != null)
         children = 1 + left.numChildren();

      if (right != null)
         children = children + 1 + right.numChildren();

      return children;
   }
}

