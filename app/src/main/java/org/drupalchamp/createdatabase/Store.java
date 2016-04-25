package org.drupalchamp.createdatabase;

/**
 * Created by user
 * Date: 4/25/2016
 * CreateDatabase
 */
public class Store {
    private String name;
    private String description;
    private int imageResourceId;

    //drinks is an array of Foods
    public static final Store[] drinks = {
            new Store("ToothPaste", "Various companies toothpaste are available",
                    R.drawable.toothpaste),
            new Store("Biscuits", "All Flavours are available",
                    R.drawable.britannia_biscuits),
            new Store("EveryDayUse", "All things are available of everyday use.",
                    R.drawable.kirana_shops)
    };

    //Each Drink has a name, description, and an image resource
    private Store(String name, String description, int imageResourceId) {
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
