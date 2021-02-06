package org.btm.App;


class Item 
{
  String name;
  int cost;

  public Item(String name, int cost) 
  {
    this.name = name;
    this.cost = cost;
  }

  public String toString() 
  { 
      return this.name + ": " + this.cost;
  }
}
