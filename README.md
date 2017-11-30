# Dynamic Xml Class Loader Android

Android Dynamic class generator from XML descriptor

# Fetch your object xml descriptor

Allocated in raw, fetch the descriptor with the objects to be propagated to its defined classes.

<?xml version="1.0" encoding="utf-8"?>
<cards>
    <card>
        <id>1</id>
        <name>Name value</name>
        <title>Title value</title>
        <category>Category value</category>
        <description>Description value</description>
        <resource>Resource value</resource>
    </card>
</cards>


# Define your Model Class to unmarshall

Allocated in models package, define the equivalen attributes and setter/getters.

import java.util.concurrent.atomic.AtomicInteger;

public class CardModel {

    private static final AtomicInteger count = new AtomicInteger(0);

    private int mId;
    private String mName;
    private String mTitle;
    private String mCategory;
    private String mDescription;
       
    public CardModel(String name, String title, CARD_CATEGORIES category, String description) {

        mId = count.incrementAndGet();
        mName = name;
        mTitle = title;
        mCategory = category;
        mDescription = description;
        
    }

    //(Set:Get)*
    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    
    ...
    
    
    public void setId(int id) {
        this.mId = id;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }


    ...
    
    
