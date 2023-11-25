package com.homework;

public class Pharaoh {
    protected Integer id;
    protected String name;
    protected String begin;
    protected String end;
    protected Integer contribution;
    String hieroglyphic; 

    public Pharaoh( 
        Integer pharaohId,
        String pharaohName,
        String pharaohBegin,
        String pharaohEnd,
        Integer pharaohContribution,
        String pharaohHieroglyphic
    ) {
        id = pharaohId;
        name = pharaohName;
        begin = pharaohBegin;
        end = pharaohEnd;
        contribution = pharaohContribution;
        hieroglyphic = pharaohHieroglyphic;
    }

    public void print(){
        System.out.println("Pharaoh ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Reign Period: " + begin + " - " + end);
        System.out.println("Contribution: " + contribution);
        System.out.println("Hieroglyphic: " + hieroglyphic);
    }
}

