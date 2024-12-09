package controller;

import exception.OnCallException;

import java.io.IOException;
import java.util.function.Supplier;

public abstract class ExceptionLoopController {

    protected <T> T repeatUntilValid(Supplier<T> function) {
        while(true) {
            try{
                return function.get();
            } catch (OnCallException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
