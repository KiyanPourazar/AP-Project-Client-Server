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
        Model model=new Model();
        // TODO: add all the extra conditions to avoid duplication
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
            + "where follower=? and followed=?";
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

    public String getFollowers(String userName){
        try(Connection conn=getConnection();){
            String sql="select * from follow "
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
            String sql="select * from follow "
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

    public String block(){

    }

    public String unblock(){

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