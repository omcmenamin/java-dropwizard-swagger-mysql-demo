package org.kainos.ea.client;

public class FailedToCreateOrderException extends Throwable{
    @Override
    public String getMessage(){
        return "Failed to create orders in the database";
    }
}
