package LLD.tinyurl;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class tinyurlService {
    public final String baseUrl = "https://tinyurl.com/";
    tinyUrlRepository tinyUrlRepository;
    public tinyurlService() {
        this.tinyUrlRepository = tinyUrlRepository.getInstance();
    }
    public synchronized String createUrl(String longUrl)
    {
        String shortCode = "";
        String url = "";

    do {
        shortCode = UUID.randomUUID().toString()
            .replace("-", "")
            .substring(0, 8);
            url = baseUrl + shortCode;
    } while (tinyUrlRepository.containsKey(url));
    tinyUrlRepository.addMapping(longUrl, url);
    return url;
    }

    public String generateShortUrl() {
    String shortCode = UUID.randomUUID().toString()
        .replace("-", "")
        .substring(0, 8);   // 8 chars, enough for demo

    return shortCode;
    }
}