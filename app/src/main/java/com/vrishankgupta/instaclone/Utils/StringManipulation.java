package com.vrishankgupta.instaclone.Utils;

/**
 * Created by vrishankgupta on 08/02/18.
 */

public class StringManipulation {

    public static String expandUsername(String username){
        return username.replace(".", " ");
    }

    public static String condenseUsername(String username){
        return username.replace(" " , ".");
    }
}

