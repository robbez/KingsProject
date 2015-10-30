public class BST <AnyType extends Comparable<AnyType>>
{
   private Node<AnyType> root;

   private class Node<AnyType>
   {
      private AnyType data;
      private Node<AnyType> left, right;

      public Node(AnyType data)
      {
         left = right = null;
         this.data = data;
      }
   }
 

}