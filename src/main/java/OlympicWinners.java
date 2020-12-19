import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class OlympicWinners {

    public static void main(String[] args) {

        Document doc;
        try {
            doc = Jsoup.connect("http://www.theolympicdatabase.nl/olympic/sporters").get();
            System.out.println(doc.html());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Elements rows = doc.getElementsByClass("datagrid_header_table").first().getElementsByTag("tr");
        for (Element r : rows) {
            System.out.println(r.html());
        }
    }

}
