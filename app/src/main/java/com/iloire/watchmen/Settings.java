package com.iloire.watchmen;

public class Settings {

    // TODO: move to resources
    private static final String API_BASE_URL = "http://ec2-54-204-149-175.compute-1.amazonaws.com:3334";

    public static String getServiceBaseUrl () {
        return API_BASE_URL;
    }
}
