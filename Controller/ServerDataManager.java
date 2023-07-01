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
}
