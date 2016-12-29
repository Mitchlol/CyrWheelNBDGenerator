package com.mitchelllustig.cyrwheelnbdgenerator.Generator;

import java.util.Random;

/**
 * Created by lolcat on lolcat.
 */

public class Generator {
    private Random random;
    private DataSet dataSet;

    public Generator(DataSet dataSet) {
        random = new Random();

        this.dataSet = dataSet;
    }

    public String generate() {
        StringBuilder combo = new StringBuilder();
        do {
            Category category = dataSet.getCategories().get(getRandomFrom0toN(dataSet.getCategories().size()));
            Variant variant = category.getVariants().get(getRandomFrom0toN(category.getVariants().size()));
            combo.append(variant.getName() + " ");
        } while (getRandomFrom0toN(3) > 0);

        return combo.toString();
    }

    private int getRandomFrom0toN(int n) {

        return random.nextInt(n);
    }
}
