package combekaapprest.utils;


public class LoginRequest {

    private String username;
    private String password;
    private String email;

    public String getUserName(){
        return username;
    }
    public void setUserName(String username){
        this.username = username;
    } 
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    } 
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    } 

   

}
