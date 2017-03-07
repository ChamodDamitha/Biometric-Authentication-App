/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cdsbiometricapp;

import java.util.ArrayList;

/**
 *
 * @author CHAMOD
 */
public class Biometric {
    private final float threshold = 0.95f;
    
    public User login(User request_user){
        float max_match_value=0,match_value;
        User max_match_user=null;
        
        ArrayList<User> users=FileHandler.getAllUsers();
        
        for(User u:users){
            match_value=getMatchValue(u, request_user);
            if(max_match_value<match_value){
                max_match_value=match_value;
                max_match_user=u;
            }
        }    
        
        if(max_match_value>threshold && max_match_value>0){
            return max_match_user;
        }
        else{
            return null;
        }
    }

    public boolean signup(User user){
        ArrayList<User> users=FileHandler.getAllUsers();
        for(User u:users){
            if(u.getName().equals(user.getName())){
                return false;
            }
        }
        FileHandler.saveUser(user);
        return true;
    }

    
    public float getMatchValue(User u1,User u2){
        float avg_ratio=0;
        float ratio;
        
        for(int i=0;i<5;i++){
            ratio=u1.getFinger_lengths()[i]/u2.getFinger_lengths()[i];
            avg_ratio+=(ratio<=1 ? ratio : (1/ratio));
            
            ratio=u1.getFinger_widths()[i]/u2.getFinger_widths()[i];
            avg_ratio+=(ratio<=1 ? ratio : (1/ratio));
            
            ratio=u1.getFinger_distances()[i]/u2.getFinger_distances()[i];
            avg_ratio+=(ratio<=1 ? ratio : (1/ratio));
        }
         
        return (avg_ratio/15);
    }
    
}
