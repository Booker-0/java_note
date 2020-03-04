package cn.ideal.domain;

public class UserDao {
    public User login(User loginUser) {
        String trueUsername = "admin";
        String truePassword = "admin";
        if(loginUser.getUsername().equals(trueUsername)&&loginUser.getPassword().equals(truePassword))
        {
            return loginUser;
        }
        else{
            return null;
        }
    }
}
