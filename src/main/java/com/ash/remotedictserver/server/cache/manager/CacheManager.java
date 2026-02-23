package src.main.java.com.ash.remotedictserver.server.cache.manager;

import src.main.java.com.ash.remotedictserver.server.cache.store.CacheStore;

public class CacheManager {

    private CacheStore cacheStore = new CacheStore();

    public String setKeyValue(String key, String value) {
        return cacheStore.set(key, value);
    }

    public String getKeyValue(String key) {
        return cacheStore.get(key);
    }
}
