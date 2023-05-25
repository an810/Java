import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;


public class Main
{
    public static void main(String[] args)
    {
        ArrayList<VuaVietNam> vuaVietNamList = new ArrayList<>();
        ArrayList<String> pagesToScrape = new ArrayList<>();

        pagesToScrape.add("https://vi.wikipedia.org/wiki/Vua_Vi%E1%BB%87t_Nam");
        scrapePages(pagesToScrape, vuaVietNamList);

        try (FileWriter writer = new FileWriter("VuaVietNam.json")) {
            writer.write(vuaVietNamList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scrapePages(ArrayList<String> pagesToScrape, ArrayList<VuaVietNam> vuaVietNamList)
    {
        for (String pageToScrape : pagesToScrape)
        {
            vuaVietNamList.addAll(scrapePage(pageToScrape));
        }
    }

    private static ArrayList<VuaVietNam> scrapePage(String pageToScrape)
    {
        Document doc;
        ArrayList<VuaVietNam> vuaVietNamList = new ArrayList<>();
        try
        {
            doc = Jsoup.connect(pageToScrape)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36" +
                            " (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                    .get();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        Elements cacViVua = doc.select("table[cellpadding='0'] tr");
        System.out.println(cacViVua );
        for (Element viVua : cacViVua)
        {
            Elements sups = cacViVua.select("sup");
            for (Element sup : sups)
            {
                sup.remove();
            }

            String vua;
            String mieuHieu;
            String thuyHieu;
            String nienHieu;
            String tenHuy;
            String theThu;
            String triVi;

            Elements vuaAttributes = viVua.select("td");
            System.out.println(vuaAttributes);
            if (vuaAttributes.size() != 10)
            {
                continue;
            }

            vua = vuaAttributes.get(1).text();
            mieuHieu = vuaAttributes.get(2).text();
            thuyHieu = vuaAttributes.get(3).text();
            nienHieu = vuaAttributes.get(4).text();
            tenHuy = vuaAttributes.get(5).text();
            theThu = vuaAttributes.get(6).text();
            triVi = vuaAttributes.get(7).text() + vuaAttributes.get(8).text() + vuaAttributes.get(9).text();

            vuaVietNamList.add(new VuaVietNam(vua, mieuHieu, thuyHieu, nienHieu, tenHuy, theThu, triVi));
        }

        return vuaVietNamList;
    }
}