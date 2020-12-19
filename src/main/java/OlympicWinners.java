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
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Elements rows = doc.getElementsByClass("datagrid_header_table").first().getElementsByTag("tr");
        for (Element r : rows) {
            Elements data = r.getElementsByTag("td");
            System.out.println(data.get(1).getElementsByTag("a").text());
            System.out.println(data.get(2).getElementsByTag("a").attr("title"));
            System.out.println(data.get(3).getElementsByTag("b").text());
            System.out.println(data.get(4).getElementsByTag("b").text());
            System.out.println(data.get(5).getElementsByTag("b").text());
            System.out.println("\n\n\n");
        }
    }

}
