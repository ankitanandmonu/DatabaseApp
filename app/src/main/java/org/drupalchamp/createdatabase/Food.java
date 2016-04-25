package org.drupalchamp.createdatabase;

/**
 * Created by user
 * Date: 4/25/2016
 * CreateDatabase
 */
public class Food {
    private String name;
    private String description;
    private int imageResourceId;

    //drinks is an array of Foods
    public static final Food[] drinks = {
            new Food("Burger", "Burger with spicy & crispy chicken",
                    R.drawable.burger),
            new Food("Salad", "Mix of Various vegetables & fruits",
                    R.drawable.salad),
            new Food("Samose", "Spicy and pappery",
                    R.drawable.samose)
    };

    //Each Drink has a name, description, and an image resource
    private Food(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return this.name;
    }
}
