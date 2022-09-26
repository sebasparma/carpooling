package com.pragma.carpooling.factory;

import com.pragma.carpooling.dto.UserDTO;
import com.pragma.carpooling.entity.User;

public class UserDataFactory {

    public static User getUserFull(){
        return new User("User Name","User lastName", "320024234","User address", "user@email.com","AAaa12-a");
    }

    public static UserDTO getUserDTOFull(){
        return new UserDTO("User Name","User lastName", "320024234","User address", "user@email.com","AAaa12-a");
    }

    public static User getUserEmpty(){
        return new User();
    }

    public static UserDTO getUserDTOEmpty(){
        return new UserDTO();
    }

    public static String getUserJson(){
        return "{\n" +
                "    \"name\": \"Nombre Correcto\",\n" +
                "    \"lastName\": \"Parra\",\n" +
                "    \"phoneNumber\": \"3107623066\",\n" +
                "    \"address\": \"CARRERA 77 G No\",\n" +
                "    \"email\": \"user@email.com\",\n" +
                "    \"password\": \"AAaa12-a\"\n" +
                "}";
    }

    public static String getUserJsonEmpty(){
        return "{\n" +
                "    \"name\": \"\",\n" +
                "    \"lastName\": \"\",\n" +
                "    \"phoneNumber\": \"\",\n" +
                "    \"address\": \"\",\n" +
                "    \"email\": \"\",\n" +
                "    \"password\": \"\"\n" +
                "}";
    }

    public static String getUserJsonInvalidPassword(){
        return "{\n" +
                "    \"name\": \"Nombre Correcto\",\n" +
                "    \"lastName\": \"Parra\",\n" +
                "    \"phoneNumber\": \"3107623066\",\n" +
                "    \"address\": \"CARRERA 77 G No\",\n" +
                "    \"email\": \"user@email.com\",\n" +
                "    \"password\": \"AAaa\"\n" +
                "}";
    }

    public static String getUserJsonInvalidEmail(){
        return "{\n" +
                "    \"name\": \"Nombre Correcto\",\n" +
                "    \"lastName\": \"Parra\",\n" +
                "    \"phoneNumber\": \"3107623066\",\n" +
                "    \"address\": \"CARRERA 77 G No\",\n" +
                "    \"email\": \"useremail.com\",\n" +
                "    \"password\": \"AAaa12-a\"\n" +
                "}";
    }

}
