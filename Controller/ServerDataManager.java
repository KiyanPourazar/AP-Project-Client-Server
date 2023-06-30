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
        } else if(method.equals("sign-in")){
            // return signIn((String)object);
            return null;
        } else{
            return null;
        }
    }

    public static synchronized DataObject signUp(User user){
        String result=model.addUser(user);
        return new DataObject(result, null);
    }

    // public static synchronized DataObject signIn(String info){
    //     String[] inf=info.split(" | ");
    //     for(User user:userCol){
    //         if(user.getUserName().equals(inf[0])){
    //             if(user.getPassWord().equals(inf[2])){
    //                 return new DataObject("success", null);
    //             } else{
    //                 return new DataObject("wrong-pass", null);
    //             }
                
    //         }
    //     }
    //     return new DataObject("not-found", null);
    // }
}
