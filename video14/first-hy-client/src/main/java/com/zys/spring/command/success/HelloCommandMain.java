package com.zys.spring.command.success;

public class HelloCommandMain {
    public static void main(String[] args) throws Exception {
        HelloCommand command = new HelloCommand();
        String result = command.execute();
        System.out.println(result);
    }
}
