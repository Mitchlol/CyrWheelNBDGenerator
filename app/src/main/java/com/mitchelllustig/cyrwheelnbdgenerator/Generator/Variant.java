package com.mitchelllustig.cyrwheelnbdgenerator.Generator;

/**
 * Created by lolcat on lolcat.
 */

public class Variant {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
