public class tinyUrlController {

    tinyUrlRepository tinyUrlRepository;
    tinyurlService tinyurlService;
    tinyUrlController()
    {
         tinyUrlRepository = tinyUrlRepository.getInstance();
         tinyurlService = new tinyurlService();
       
    }
    
    public synchronized String createTinyUrl(String longUrl)
    {
        if(tinyUrlRepository.containsLongURL(longUrl)) 
        {
            return tinyUrlRepository.getShortUrl(longUrl);
        }
         String shortUrl = tinyurlService.createUrl(longUrl);
         return shortUrl;
    }
    public String getLongUrl(String shortUrl)
    {
        String longUrl = tinyUrlRepository.getLongUrl(shortUrl);
        if(longUrl == null) return null;
        return longUrl;
    }
}
