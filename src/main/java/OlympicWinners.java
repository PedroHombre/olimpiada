import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class OlympicWinners {

    public static void main(String[] args) {

        Document doc;
        ArrayList<Olympian> olympians = new ArrayList<Olympian>();
        try {
            doc = Jsoup.connect("http://www.theolympicdatabase.nl/olympic/sporters").get();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        Elements rows = doc.getElementsByClass("datagrid_header_table").first().getElementsByTag("tr");


        for (Element r : rows) {
            Elements data = r.getElementsByTag("td");
            String name = data.get(1).getElementsByTag("a").text();
            String country = data.get(2).getElementsByTag("a").attr("title");
            try {
                int gold = Integer.parseInt(data.get(3).getElementsByTag("b").text(), 10);
                int silver = Integer.parseInt(data.get(4).getElementsByTag("b").text(), 10);
                int bronze = Integer.parseInt(data.get(5).getElementsByTag("b").text(), 10);
                olympians.add( new Olympian(name, country, gold, silver, bronze) );
            } catch (NumberFormatException e) { continue; }
        }

        String csvFileContents = "Nazwisko,Kraj,Złote Medale,Srebrne Medale,Brązowe Medale\n";
        for(Olympian o : olympians) {
            csvFileContents += o.getDataAsCsvRow();
        }

        try {
            FileWriter myWriter = new FileWriter("olimpiczycy.csv");
            myWriter.write(csvFileContents);
            myWriter.close();
        } catch (IOException e) {  e.printStackTrace(); }
    }

}
