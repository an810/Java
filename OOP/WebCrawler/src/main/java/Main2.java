import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;


public class Main2 {
    public static void main(String[] args)
    {
        ArrayList<DiTich1> diTich1List = new ArrayList<>();
        ArrayList<String> pagesToScrape = new ArrayList<>();

        pagesToScrape.add("https://vi.wikipedia.org/wiki/Di_t%C3%ADch_qu%E1%BB%91c_gia_%C4%91%E1%BA%B7c_bi%E1%BB%87t_(Vi%E1%BB%87t_Nam)#H%C3%ACnh_%E1%BA%A3nh_m%E1%BB%99t_s%E1%BB%91_di_t%C3%ADch_qu%E1%BB%91c_gia_%C4%91%E1%BA%B7c_bi%E1%BB%87t");
        scrapePages(pagesToScrape, diTich1List);

        try (FileWriter writer = new FileWriter("DiTich2.json")) {
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
        Elements cacDiTich = doc.select("table.wikitable.sortable tr");
        System.out.println(cacDiTich);
        for (Element element : cacDiTich)
        {
            Elements sups = element.select("sup");
            sups.remove();
            Elements spans = element.select("span");
            spans.remove();

            String tenDiTich;
            String diaDiem;
            String hangMuc;
            String ghiChu;

            Elements diTichAttributes = element.select("td");

            if (diTichAttributes.size() != 5) {
                continue;
            }
            tenDiTich = diTichAttributes.get(0).text();
            diaDiem = diTichAttributes.get(2).text();
            hangMuc = diTichAttributes.get(3).text();
            ghiChu = diTichAttributes.get(4).text();
            diTich1List.add(new DiTich1(tenDiTich, diaDiem, hangMuc, ghiChu));
        }
        return diTich1List;
    }
}
