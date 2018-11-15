package edu.dcccd.trans.utils;

import org.springframework.security.core.userdetails.User;

import java.util.Arrays;

public class WebUtils {
 
    public static String toString(User user) {
        return "UserName: " + Arrays.toString(user.getAuthorities().toArray());
    }
}