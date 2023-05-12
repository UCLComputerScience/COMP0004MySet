package uk.ac.ucl;

import java.util.List;
import java.util.ArrayList;

/**
 * This class implements methods common to all concrete set implementations but does not
 * represent a complete set implementation.<br />
 *
 * New set objects are created using a MySetFactory.
 */

public abstract class AbstractMySet<T extends Comparable<T>> implements MySet<T> {
  @Override
  public boolean equals(MySet<T> aSet)
  {
    // TODO write a working method body.
    return false;
  }

  @Override
  public int hashCode()
  {
    return toList().hashCode();
  }

  public List<T> toList()
  {
    // TODO write the code to return a List of the set contents.
    // Ok

    return new ArrayList<>();
  }

  public MySet<T> union(MySet<T> mySet) throws MySetException
  {
    MySet<T> result = MySetFactory.getInstance().getMySet();
    /*
    this.forEach(x -> {
      try {
        result.add(x);
      } catch (MySetException e) {
        throw new RuntimeException(e);
      }
    });
    */
    for (T x : this){
      result.add(x);
    }
    for (T x : mySet){
      result.add(x);
    }

    //TODO write the statements needed to find the union

    return result;
  }

  public MySet<T> intersection(MySet<T> mySet) throws MySetException
  {
    MySet<T> result = MySetFactory.getInstance().getMySet();

    for (T x : this){
      if(mySet.contains(x)){
        result.add(x);
      }
    }

    // TODO write the statements needed to find the intersection.

    return result;
  }

  public MySet<T> difference(MySet<T> mySet) throws MySetException
  {
    MySet<T> result = MySetFactory.getInstance().getMySet();
    for (T x : this){
      if (!mySet.contains(x)){
        result.add(x);
      }
    }
    // TODO write the statements needed to find the difference.
    return result;
  }

  @Override
  public String toString(){
    StringBuilder output = new StringBuilder("{");
    boolean first = true;
    for (T value : this) {
      if (!first) { output.append(", "); }
      first = false;
      output.append(value);
    }
    output.append("}");
    return output.toString();
  };

  protected void checkSize(int maximumSize)
    throws MySetException
  {
     // TODO throw an exception if the set exceeds its maximum size.
  }

  // A helper method that might be useful.
  private void addAll(MySet<T> source, MySet<T> destination)
    throws MySetException
  {
    for (T value : source)
    {
      destination.add(value);
    }
  }
}
