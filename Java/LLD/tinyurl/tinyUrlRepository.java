package LLD.tinyurl;

import java.util.concurrent.ConcurrentHashMap;

public class tinyUrlRepository {
    private static tinyUrlRepository instance = new tinyUrlRepository();
    
    private tinyUrlRepository() {}
    
    public static tinyUrlRepository getInstance() {
        return instance;
    }

    private ConcurrentHashMap<String, String> urlStorage = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> LongtoShort = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Integer> count = new ConcurrentHashMap<>();

    public synchronized String getLongUrl(String shortUrl) {
        if(!urlStorage.containsKey(shortUrl)) return null;
        count.put(shortUrl, count.getOrDefault(shortUrl, 0) + 1);
        return urlStorage.get(shortUrl);
    }
    
    public synchronized void addMapping(String longUrl, String shortUrl)
    {
        count.put(shortUrl, 1);
        urlStorage.put(shortUrl, longUrl);
        LongtoShort.put(longUrl, shortUrl);
    }

    public boolean containsKey(String shortCode) {
        return urlStorage.containsKey(shortCode);
    }

    public boolean containsLongURL(String longUrl)
    {
        return urlStorage.containsValue(longUrl);
    }

    public String getShortUrl(String longUrl) {
        return LongtoShort.get(longUrl);
    }
}

