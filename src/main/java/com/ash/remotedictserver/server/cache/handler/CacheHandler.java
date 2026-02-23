package src.main.java.com.ash.remotedictserver.server.cache.handler;

import src.main.java.com.ash.remotedictserver.server.cache.manager.CacheManager;

import java.util.Objects;

public class CacheHandler {

    private CacheManager cacheManager = new CacheManager();

    public String processCommand(String[] command) {
        validateCommand(command);

        return executeCommand(command);
    }

    private void validateCommand(String[] command) {
        if(Objects.isNull(command[0])) {
            // throw invalid command
        }

        if(command[0].toLowerCase().equals("get")) {
                if(command.length != 2) {
                    // throw invalid command
                }
        } else

        if(command[0].toLowerCase().equals("set")) {
                if(command.length != 3) {
                    // throw invalid command
                }
        }
    }

    private String executeCommand(String[] command) {
        switch(command[0].toLowerCase()) {
            case "get":

                return cacheManager.getKeyValue(command[1]);
            
            case "set":

                return cacheManager.setKeyValue(command[1], command[2]);
        }
        throw new RuntimeException("Invalid command");
    }
}
