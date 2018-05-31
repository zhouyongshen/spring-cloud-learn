package com.zys.spring.command.fail;


public class ErrorHelloCommandMain {
    public static void main(String[] args) throws Exception {
        ErrorHelloCommand command = new ErrorHelloCommand();
        String result = command.execute();
        System.out.println(result);
    }
}
