package Utility;

import java.io.Serializable;
// import java.util.ArrayList;

public class Tweet implements Serializable{
    private int likesCount;
    private int reTweetsCount;
    private int commentsCount;
    private String tweetDate;
    private String hashTag;
    private String message;
    // private ArrayList<String> imagesLocation;
    private int id;

    public Tweet(int id, String message, String hashTag, int likesCount, int reTweetsCount, int commentsCount) {
        this.id=id;
        this.message=message;
        this.tweetDate = Time.getCurrentTime();
        this.hashTag = hashTag;
        this.likesCount = likesCount;
        this.reTweetsCount = reTweetsCount;
        this.commentsCount = commentsCount;
        // TODO: Add support for images
    }

    public void addLike() {
        this.likesCount++;
    }

    public void removeLike() {
        this.likesCount--;
    }

    public void addReTweet() {
        this.reTweetsCount++;
    }

    public void removeReTweet() {
        this.reTweetsCount--;
    }

    public void addComment() {
        this.commentsCount++;
    }

    public void removeComment() {
        this.commentsCount--;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public int getReTweetsCount() {
        return reTweetsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public String getTweetDate() {
        return tweetDate;
    }

    public String getHashTag() {
        return hashTag;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }
}