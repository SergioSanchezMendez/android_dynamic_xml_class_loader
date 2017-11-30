package safon.tarot4all.models;

import java.util.concurrent.atomic.AtomicInteger;

public class CardModel {

    private static final AtomicInteger count = new AtomicInteger(0);

    private int mId;
    private java.lang.String mName;
    private java.lang.String mTitle;
    private String mCategory;
    private java.lang.String mDescription;
    private java.lang.String mInvertedDescription;

    public CardModel() {
        mId = count.incrementAndGet();
        mName = null;
        mTitle = null;
        mCategory = null;
        mDescription = null;
        mInvertedDescription = null;
    }

    public CardModel(java.lang.String name, java.lang.String title, String category, java.lang.String description,
                     java.lang.String descriptionInverted) {

        mId = count.incrementAndGet();
        mName = name;
        mTitle = title;
        mCategory = category;
        mDescription = description;
        mInvertedDescription = descriptionInverted;
    }

    //(Set:Get)*
    public int getId() {
        return mId;
    }

    public java.lang.String getName() {
        return mName;
    }

    public java.lang.String getTitle() {
        return mTitle;
    }

    public String getCategory() {
        return mCategory;
    }

    public java.lang.String getDescription() {
        return mDescription;
    }

    public java.lang.String getInvertedDescription() {
        return mInvertedDescription;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public void setName(java.lang.String name) {
        this.mName = name;
    }

    public void setTitle(java.lang.String title) {
        this.mTitle = title;
    }

    public void setCategory(String category) {
        this.mCategory = category;
    }

    public void setDescription(java.lang.String description) {
        this.mDescription = description;
    }

    public void setInvertedDescription(java.lang.String invertedDescription) {
        this.mInvertedDescription = invertedDescription;
    }

}
