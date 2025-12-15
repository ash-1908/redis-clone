package com.redisclone.store;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStore {
    private Map<Object, Object> store;

    public MemoryStore() {
        this.store = new ConcurrentHashMap<>();
    }

    public Object get(Object key) {
        return store.get(key);
    }

    public Object set(Object key, Object value) {
        return this.store.put(key, value);
    }
}
