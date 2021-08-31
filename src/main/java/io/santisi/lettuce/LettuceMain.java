package io.santisi.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class LettuceMain {

    public static void main(String[] args){
        RedisClient redisClient = RedisClient.create("redis://password@localhost:32222/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.set("key", "Hello, Redis!");


        var result = syncCommands.get("key");
        System.out.println("redis key value: "+ result);
        connection.close();
        redisClient.shutdown();
    }

}
