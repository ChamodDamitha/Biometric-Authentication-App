/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cdsbiometricapp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHAMOD
 */
public class FileHandler {
    final static String file_location = "user_profiles.ser";
    
    public static ArrayList<User> getAllUsers(){
        String line;
        ArrayList<User> users=new ArrayList<>();
        try{
            InputStream file = new FileInputStream(file_location);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            try{
                users= (ArrayList<User>)input.readObject();
            }
            finally{
                input.close();
            }    
        }
        
        catch(FileNotFoundException e){}    
        catch(IOException e){}
        catch(ClassNotFoundException e){}
        return users;
    }
    
    public static void saveUser(User u){
        ArrayList<User> users=getAllUsers();
        try {
            OutputStream file = new FileOutputStream(file_location);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try{
                users.add(u);
                output.writeObject(users);
            }
            finally{
                output.close();
            }
        }
        catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
