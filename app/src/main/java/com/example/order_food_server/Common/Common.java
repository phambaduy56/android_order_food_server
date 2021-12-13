package com.example.order_food_server.Common;

import com.example.order_food_server.Model.Request;
import com.example.order_food_server.Model.User;

public class Common {
    public static User currentUser;
    public static Request currentRequest;


    public static String UPDATE = "Update";
    public static String DELETE = "Delete";

    public static String DATETIME = "Date";


    public static final int PICK_IMAGE_REQUEST = 71;

    public static String convertCodeToStatus(String code) {
        if(code.equals("0")){
            return "Placed";
        } else if (code.equals("1")) {
            return "On my way";
        } else {
            return "Shipped";
        }
    }
}
