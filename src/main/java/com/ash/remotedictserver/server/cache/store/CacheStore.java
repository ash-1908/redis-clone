package src.main.java.com.ash.remotedictserver.server.cache.store;

import java.util.HashMap;

public class CacheStore {
    
    private HashMap<String, String> map = new HashMap<>();

    public String get(String key) {
        return map.get(key);
    }

    public String set(String key, String value) {
        return map.put(key,value);
    }
}
