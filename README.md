# Redis Lettuce Client #
This project has a very simple redis client written in java with the lettuce library.  There's no
connection pooling nor enterprise grade code.  It's simply meant to test your connection to redis.

## Lettuce Main Class ##
This is a stateful redis connection.  In the connection string specify the port that redis is using.  If you 
wish to explore the Async API to handle promises, check out the lettuce documentation.

``` java
public static void main(String[] args){
        RedisClient redisClient = RedisClient.create("redis://password@localhost:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.set("key", "Hello, Redis!");


        var result = syncCommands.get("key");
        System.out.println("redis key value: "+ result);
        connection.close();
        redisClient.shutdown();
    }

```
