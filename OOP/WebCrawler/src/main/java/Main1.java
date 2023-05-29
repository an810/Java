import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;


public class Main1
{
    public static void main(String[] args)
    {
        ArrayList<DiTich1> diTich1List = new ArrayList<>();
        ArrayList<String> pagesToScrape = new ArrayList<>();

        pagesToScrape.add("https://vi.wikipedia.org/wiki/Danh_s%C3%A1ch_Di_t%C3%ADch_qu%E1%BB%91c_gia_Vi%E1%BB%87t_Nam");
        scrapePages(pagesToScrape, diTich1List);

        try (FileWriter writer = new FileWriter("DiTich1.json")) {
            writer.write(diTich1List.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scrapePages(ArrayList<String> pagesToScrape, ArrayList<DiTich1> diTich1List)
    {
        for (String pageToScrape : pagesToScrape)
        {
            diTich1List.addAll(scrapePage(pageToScrape));
        }
    }

    private static ArrayList<DiTich1> scrapePage(String pageToScrape)
    {
        Document doc;
        ArrayList<DiTich1> diTich1List = new ArrayList<>();
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
        Elements cacDiTich = doc.select("table.wikitable tr");
        System.out.println(cacDiTich);
        for (Element element : cacDiTich)
        {
//            Elements sups = element.select("sup");
//            sups.remove();
            String diTich;
            String viTri;
            String loaiDiTich;
            String namCongNhan;

            Elements diTichAttributes = element.select("td");
            if (diTichAttributes.size() != 5) {
                continue;
            }
            diTich = diTichAttributes.get(0).text();
            viTri = diTichAttributes.get(1).text();
            loaiDiTich = diTichAttributes.get(2).text();
            namCongNhan = diTichAttributes.get(3).text();
            diTich1List.add(new DiTich1(diTich, viTri, loaiDiTich, namCongNhan));
        }
        return diTich1List;
    }
}
