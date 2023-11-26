package com.homework;

import java.util.Map;

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

    public Integer getId() {
        return id;
    }

    public String[] getContributors() {
        return contributors;
    }

    public String getName() {
        return name;
    }

    // Modified print method to display names of pharaohs
    public void print(Map<String, String> hieroglyphicMap) {
        System.out.println("Pyramid ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Contributors: ");

        for (String contributor : contributors) {
            // Retrieve the pharaoh's name using the contributor hieroglyphic
            String pharaohName = hieroglyphicMap.get(contributor);
            if (pharaohName != null) {
                System.out.println(pharaohName);
            } else {
                System.out.println("Unknown contributor: " + contributor);
            }
        }
    }
}

