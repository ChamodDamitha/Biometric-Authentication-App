/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cdsbiometricapp;

import java.io.Serializable;

/**
 *
 * @author CHAMOD
 */
public class User implements Serializable{
    private String name;
    private float[] finger_lengths;
    private float[] finger_widths;
    private float[] finger_distances;

    public User(String name, float[] finger_lengths, float[] finger_widths, float[] finger_distances) {
        this.name = name;
        this.finger_lengths = finger_lengths;
        this.finger_widths = finger_widths;
        this.finger_distances = finger_distances;
    }

    public String getName() {
        return name;
    }

    public float[] getFinger_lengths() {
        return finger_lengths;
    }

    public float[] getFinger_widths() {
        return finger_widths;
    }

    public float[] getFinger_distances() {
        return finger_distances;
    }
            
}
