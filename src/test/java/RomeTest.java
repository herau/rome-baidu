import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Aurélien Leboulanger
 */
@RunWith(Parameterized.class)
public class RomeTest {

    @Parameterized.Parameters
    public static Iterable<? extends Object> data() {
        return Arrays.asList("http://www.lemonde.fr/m-actu/rss_full.xml",
                             "http://news.baidu.com/ns?cl=2&rn=20&tn=newsrss&word=football");
    }

    private String url;

    public RomeTest(String url) {
        this.url = url;
    }

    @Test
    public void syndFeedInput_build() throws IOException, FeedException {
        System.out.println("test with RSS : " + url);

        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));

        feed.getEntries().forEach(feedEntry -> {
            SyndEntryImpl entry = (SyndEntryImpl) feedEntry;

            Date publishedDate = entry.getPublishedDate();
            System.out.println("published date: " + publishedDate);

            String title = entry.getTitle();
            System.out.println("title: " + title);

            String description = entry.getDescription().getValue();
            System.out.println("description: " + description);

            System.out.println("\n");
        });
    }
}
