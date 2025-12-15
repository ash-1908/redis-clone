package com.redisclone;

import java.util.Scanner;

import com.redisclone.store.MemoryStore;

/**
 * Hello world!
 *
 */
public class App 
{
    private static MemoryStore store = new MemoryStore();
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Redis." );
        Scanner sc = new Scanner(System.in);
        String[] inputArgs = new String[1];
        while(inputArgs[0] == null || !inputArgs[0].toLowerCase().equals("exit")) {
            String inputString = sc.nextLine();
            inputArgs = inputString.trim().split(" ");
            Object out = null;
            if(inputArgs[0].toLowerCase().equals("set")) {
                out = store.set(inputArgs[1], inputArgs[2]);
            } else if(inputArgs[0].toLowerCase().equals("get")) {
                out = store.get(inputArgs[1]);
            }
            System.out.println(out);
        }
        sc.close();
    }
}
