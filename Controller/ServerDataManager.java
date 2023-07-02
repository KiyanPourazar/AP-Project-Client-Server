import Model.Model;
import Utility.DataObject;
import Utility.User;

public class ServerDataManager {
    private static Model model=new Model();

    public static DataObject runMethod(DataObject dataObject){
        String method=dataObject.getMethod();
        Object object=dataObject.getObject();
        if(method.equals("sign-up")){
            return signUp((User)object);
        } else if(method.equals("login")){
            return logIn((String)object);
        } else if(method.equals("get-profile")){
            return getProfile((String)object);
        } else if(method.equals("update-profile")){
            return updateProfile((User)object);
        } else if(method.equals("show-followers")){
            return showFollowers((String)object);
        } else if(method.equals("show-blocks")){
            return showBlocks((String)object);
        } else if(method.equals("show-following")){
            return showFollowing((String)object);
        } else{
            return null;
        }
    }

    public static synchronized DataObject signUp(User user){
        String result=model.addUser(user);
        return new DataObject(result, null);
    }

    public static synchronized DataObject logIn(String info){
        String[] inf=info.split(" | ");
        String result=model.login(inf[0], inf[2]);
        return new DataObject(result, null);
    }

    public static synchronized DataObject getProfile(String userName){
        User user=model.getUser(userName);
        String result="failure";
        if(user!=null){
            result="success";
        }
        return new DataObject(result, user);
    }

    public static synchronized DataObject updateProfile(User user){
        String result=model.updateUser(user);
        return new DataObject(result, null);
    }

    public static synchronized DataObject showFollowers(String userName){
        String result=model.getFollowers(userName);
        return new DataObject("success", result);
    }

    public static synchronized DataObject showBlocks(String userName){
        String result=model.getBlocks(userName);
        return new DataObject("success", result);
    }

    public static synchronized DataObject showFollowing(String userName){
        String result=model.getFollowing(userName);
        return new DataObject("success", result);
    }
}
