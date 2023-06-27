package Model;

import Utility.Tweet;
import Utility.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model{
    public static void main(String[] args){
        // TODO: Test tweet methods
        Model model=new Model();
    }

    public Connection getConnection(){
        try{
            String url="jdbc:mysql://localhost:3306/myDatabase";
            String userName="root";
            String passWord="1402AP";
            // TODO: Add config for connection details

            Connection conn=DriverManager.getConnection(url, userName, passWord);
            return conn;
        } catch(SQLException sqle){
            sqle.printStackTrace();
            return null;
        }
    }

    public User getUser(String userName){
        try(Connection conn=getConnection();){
            String sql="select * from users "
            + "where userName=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(!resultSet.next()){
                return null;
            }

            String[] data=new String[8];
            for(int i=1; i<=8; i++){
                data[i-1]=resultSet.getString(i);
            }
            User user=new User(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
            return user;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return null;
        }
        // TODO: Complete it for own view and others.
    }

    public void checkUpdate(){
        // TODO: check updated data
    }

    public String updateUser(User user){
        try(Connection conn=getConnection();){
            String sql="update users  "
            +"set passWord=?, bio=?, location=?, webSiteAddress=?, lastModified=?, AvatarLocation=?, HeaderLocation=? where userName=?";
            // TODO: Save images properly
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getPassWord());
            preparedStatement.setString(2, user.getBio());
            preparedStatement.setString(3, user.getLocation());
            preparedStatement.setString(4, user.getWebSiteAddress());
            preparedStatement.setString(5, user.getLastModified());
            preparedStatement.setString(6, user.getAvatarLocation());
            preparedStatement.setString(7, user.getHeaderLocation());
            preparedStatement.setString(8, user.getUserName());
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }

    public void checkAdd(){
        // TODO: Check add data
    }
    
    public String addUser(User user){
        String userName=user.getUserName();
        if(getUser(userName)!=null){
            return "user exists";
        }
        String[] data=user.getData();
        try(Connection conn=getConnection();){
            String sql="insert into users "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            for(int i=1; i<=13; i++){
                preparedStatement.setString (i, data[i-1]);
            }
            // TODO: Change these lines according to JavaFX
            preparedStatement.setString (14, user.getAvatarLocation());
            preparedStatement.setString (15, user.getHeaderLocation());
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }

    public String follow(String follower, String followed){
        try(Connection conn=getConnection();){
            String sql="insert into follows "
            + "values (?, ?)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, follower);
            preparedStatement.setString(2, followed);
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }

    public String unfollow(String follower, String followed){
        try(Connection conn=getConnection();){
            String sql="delete from follows "
            + "where follower=? and followed=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, follower);
            preparedStatement.setString(2, followed);
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }

    public String getFollowers(String userName){
        try(Connection conn=getConnection();){
            String sql="select * from follows "
            + "where followed=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet resultSet=preparedStatement.executeQuery();

            String result="";
            while(resultSet.next()){
                result+=resultSet.getString("follower")+"\n";
            }
            return result;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return null;
        }
    }

    public String getFollowing(String userName){
        try(Connection conn=getConnection();){
            String sql="select * from follows "
            + "where follower=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet resultSet=preparedStatement.executeQuery();

            String result="";
            while(resultSet.next()){
                result+=resultSet.getString("followed")+"\n";
            }
            return result;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return null;
        }
    }

    public String block(String blocker, String blocked){
        // TODO: It requires sth a bit more
        try(Connection conn=getConnection();){
            String sql="insert into blocks "
            + "values (?, ?)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, blocker);
            preparedStatement.setString(2, blocked);
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }

    public String unblock(String blocker, String blocked){
        try(Connection conn=getConnection();){
            String sql="delete from blocks "
            + "where blocker=? and blocked=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, blocker);
            preparedStatement.setString(2, blocked);
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }

    public String searchUser(String userName){
        try(Connection conn=getConnection();){
            String sql="select * from users "
            + "where userName=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet resultSet=preparedStatement.executeQuery();

            String result="";
            while(resultSet.next()){
                result+=resultSet.getString("userName")+"\n";
            }
            return result;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return null;
        }
    }

    public String addTweet(Tweet tweet){
        try(Connection conn=getConnection();){
            String sql="insert into tweets "
            + "values (0, ?, ?, ?, 0, 0, 0)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString (1, tweet.getMessage());
            preparedStatement.setString (2, tweet.getTweetDate());
            preparedStatement.setString (3, tweet.getHashTag());
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }

    public String addReTweet(Tweet reTweet, int mainTweetId){
        if(addTweet(reTweet).equals("failure")){
            return "failure";
        }
        try(Connection conn=getConnection();){
            String sql="insert into retweets "
            + "values (?, ?)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt (1, reTweet.getId());
            preparedStatement.setInt (2, mainTweetId);
            preparedStatement.executeUpdate();
            sql="update tweets "
            +"set reTweetsCount=reTweetsCount+1 where id=?";
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt(1, mainTweetId);
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }

    public String addQuote(Tweet quote, int mainTweetId){
        if(addTweet(quote).equals("failure")){
            return "failure";
        }
        try(Connection conn=getConnection();){
            String sql="insert into quotes "
            + "values (?, ?)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt (1, quote.getId());
            preparedStatement.setInt (2, mainTweetId);
            preparedStatement.executeUpdate();
            sql="update tweets "
            +"set reTweetsCount=reTweetsCount+1 where id=?";
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt(1, mainTweetId);
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }

    public String like(String userName, int tweetId){
        try(Connection conn=getConnection();){
            String sql="insert into likes "
            + "values (?, ?)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString (1, userName);
            preparedStatement.setInt (2, tweetId);
            preparedStatement.executeUpdate();
            sql="update tweets "
            +"set likesCount=likesCount+1 where id=?";
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt(1, tweetId);
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }

    public String unLike(String userName, int tweetId){
        try(Connection conn=getConnection();){
            String sql="delete from likes "
            + "where userName=? and id=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString (1, userName);
            preparedStatement.setInt (2, tweetId);
            preparedStatement.executeUpdate();
            sql="update tweets "
            +"set likesCount=likesCount-1 where id=?";
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt(1, tweetId);
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "failure";
        }
    }
}
/*  userName
    phoneNumber
    country
    email
    passWord
    firstName
    lastName
    birthDate
    bio
    location
    webSiteAddress
    signUpDate
    lastModified
    AvatarLocation
    HeaderLocation */

/*  id
    message
    tweetDate
    hashTag
    likesCount
    reTweetsCount
    commentsCount */