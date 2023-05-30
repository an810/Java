import crawler.diadanh.DiaDanh;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class TestMain {
    public static void main(String[] args) throws IOException {
        // Home page
        String baseUrl = "https://nguoikesu.com/dia-danh/dinh-doc-lap";
        // List
        List<DiaDanh> diaDanhList = new ArrayList<>();
        Document doc;
        try {
            doc =  Jsoup
                    .connect(baseUrl)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e ){
            throw new RuntimeException(e);
        }


        Set<String> nhanVatLienQuan = new HashSet<>();
        // Get title
        Element titleElement = doc.selectFirst("h2");
        if (titleElement != null) {
            System.out.println(titleElement.text());
        }

        // Get description
        StringBuffer desBuffer = new StringBuffer();
        Elements desElements = doc.select("div.com-content-article__body > p");
        for(Element element : desElements) {
            String text = element.text();
            if (text.length() > 50) {
                desBuffer.append(text);
                desBuffer.append("\n");
                break;
            }
        }
        System.out.println(desBuffer);

        // Relative person
        Elements refElements = desElements.select("a[href*=/nhan-vat/]");
        for (Element refElement : refElements) {
            String name = refElement.text();
            nhanVatLienQuan.add(name);
            System.out.println("\"" + name + "\"");
        }
        System.out.println(nhanVatLienQuan);

        // Print all data in json file
        try (FileWriter writer = new FileWriter("DiaDanh.json")) {
            writer.write(diaDanhList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
