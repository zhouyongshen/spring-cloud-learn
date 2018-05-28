package com.zys.spring.command.fail;

import com.zys.spring.command.success.HelloCommand;

public class ErrorHelloCommandMain {
    public static void main(String[] args) throws Exception {
        ErrorHelloCommand command = new ErrorHelloCommand();
        String result = command.execute();
        System.out.println(result);
    }
}
