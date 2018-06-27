package com.xyz.xiao20180619;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public abstract class CommandManager {

    public void process() {
        MyCommand command = createCommand();
        command.setState(1);

        MyCommand command1 = createCommand();
        command1.setState(2);

        System.out.println(command.getState());
        System.out.println(command1.getState());
    }

    @Lookup
    abstract MyCommand createCommand();

}
