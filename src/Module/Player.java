/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

/**
 *
 * @author AM STORE
 */
public class Player {
    
    private int id, score;
    private String userName, password, confirmPass;
    private int mode;
    
    public Player(String userName, int score, int mode){
        this.userName = userName;
        this.score = score;
        this.mode = mode;
    }
    
    public Player(String userName, String password, String confirmPass){
        this.userName = userName;
        this.password = password;
        this.confirmPass = confirmPass;
    }
    
    public Player(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    
    
    public Player(){}
    
    public void setId(int id){ this.id = id;}
    public void setUserName(String userName){ this.userName = userName;}
    public void setPassword(String password){ this.password = password;}
    public void setConfirmPassword(String confirmPass){ this.confirmPass = confirmPass;}
    public void setMode(int mode){ this.mode = mode;}
    public void setScore(int score){ this.score = score;}
    
    public int getId(){return id;}
    public String getUserName(){return userName;}
    public String getPassword(){return password;}
    public String getConfirmPassword(){return confirmPass;}
    public int getMode(){return mode;}
    public int getScore(){return score;}
}
