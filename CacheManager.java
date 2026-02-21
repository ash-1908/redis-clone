public class CacheManager {

    private CacheStore cacheStore = new CacheStore();

    public String setKeyValue(String key, String value) {
        return cacheStore.set(key, value);
    }

    public String getKeyValue(String key) {
        return cacheStore.get(key);
    }
}
