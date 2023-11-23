package com.homework;

// pyramid class, that corresponds to the information in the json file
public class Pyramid {

  protected Integer id;
  protected String name;
  protected String[] contributors;

  // constructor
  public Pyramid(
    Integer pyramidId,
    String pyramidName,
    String[] pyramidContributors
  ) {
    id = pyramidId;
    name = pyramidName;
    contributors = pyramidContributors;
  }

  public void print(){
    System.out.println("Pyramid ID: " + id);
    System.out.println("Name: " + name);
    System.out.println("Contributors: ");

    for (String contributor )
  }
}
