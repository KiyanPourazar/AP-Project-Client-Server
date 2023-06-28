package Utility;

import java.io.Serializable;
// import java.util.ArrayList;
import java.util.Objects;

public class Tweet implements Serializable{
    private int likesCount;
    private int reTweetsCount;
    private int commentsCount;
    private String tweetDate;
    private String hashTag;
    private String message;
    private String userName;
    // private ArrayList<String> imagesLocation;
    private int id;
    private boolean isFavstar;

    public Tweet(String userName, String message, String hashTag) {
        this.userName=userName;
        this.message=message;
        this.tweetDate = Time.getCurrentTime();
        this.hashTag = hashTag;
        this.likesCount = 0;
        this.reTweetsCount = 0;
        this.commentsCount = 0;
        setId(hashCode());
        isFavstar=false;
        // TODO: Add support for images
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, likesCount, reTweetsCount, commentsCount, tweetDate, hashTag, message);
    }

    public void setTweetDate(String date){
        tweetDate=date;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setFavstar(boolean state){
        isFavstar=state;
    }

    public boolean getFavstar(){
        return isFavstar;
    }

    public int getId() {
        return id;
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

    public void setLikesCount(int count){
        likesCount=count;
    }

    public int getReTweetsCount() {
        return reTweetsCount;
    }

    public void setReTweetsCount(int count) {
        reTweetsCount=count;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int count){
        commentsCount=count;
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

    public String getUserName(){
        return userName;
    }
}