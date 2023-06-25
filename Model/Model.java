package Model;

import Utility.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model{
    public static void main(String[] args){
        // TODO: Test user methods
    }

    public Connection getConnection(){
        try{
            String url="jdbc:mysql://localhost:3306/myDatabase";
            String userName="root";
            String passWord="1402AP";
            // TODO: Add config for connection details

            Connection conn=DriverManager.getConnection(url, userName, passWord);
            System.out.println("Connected to database");
            return conn;
        } catch(SQLException sqle){
            sqle.printStackTrace();
            return null;
        }
    }

    public User getUser(String userName){
        try(Connection conn=getConnection();){
            String sql="select from users "
            + "where userName="+userName;
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.first()){
                return null;
            }

            String[] data=new String[8];
            for(int i=0; i<8; i++){
                data[i]=resultSet.getString(i);
            }
            User user=new User(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
            return user;
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return null;
        }
    }

    public void checkUpdate(){
        // TODO: check updated data
    }

    public String updateUser(User user){
        try(Connection conn=getConnection();){
            String sql="update users "
            +"set "
            +"passWord="+user.getPassWord()
            +"bio="+user.getBio()
            +"location="+user.getLocation()
            +"webSiteAddress="+user.getWebSiteAddress()
            +"lastModified="+user.getLastModified()
            // TODO: Save images properly
            +"AvatarLocation="+user.getAvatarLocation()
            +"HeaderLocation="+user.getHeaderLocation()
            +" where userName="+user.getUserName();
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.executeQuery();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "sql failure";
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
                preparedStatement.setString (i, data[i]);
            }
            // TODO: Change these lines according to JavaFX
            preparedStatement.setString (14, user.getAvatarLocation());
            preparedStatement.setString (15, user.getHeaderLocation());
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "sql failure";
        }
    }

    public String follow(String follower, String followed){
        try(Connection conn=getConnection();){
            String sql="insert into follow "
            + "values (?, ?)";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1, follower);
            preparedStatement.setString(2, followed);
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "sql failure";
        }
    }

    public String unfollow(String follower, String followed){
        try(Connection conn=getConnection();){
            String sql="delete from follow "
            + "where follower="+follower+" and followed="+followed;
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return "success";
        }
        catch(SQLException sqle){
            System.out.println(sqle.getMessage());
            return "sql failure";
        }
    }

    public String getFollowers(){

    }

    public String getFollowing(){

    }

    public void searchUser(){
        // maybe the same as getUser
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