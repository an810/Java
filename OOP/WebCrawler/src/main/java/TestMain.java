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


        // Elements nextElements = doc.select("a.btn.btn-sm.btn-secondary.next");
        // String completeUrl = "";

        // // Looking for the "Next"
        // while (baseUrl.compareTo(completeUrl) != 0 && (!nextElements.isEmpty())) {
        //     // Getting the "Next"
        //     Element nextElement = nextElements.first();
        //     // Extracting the relative URL of the next page
        //     String relativeUrl = nextElement.attr("href");
        //     completeUrl = "https://nguoikesu.com" + relativeUrl;
        //     System.out.println(completeUrl);

        //     doc = Jsoup
        //             .connect(completeUrl)
        //             .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
        //             .get();

        //     // Collect data
        //     ArrayList<String> nhanVatLienQuan = new ArrayList<>();
        //     DiaDanh diaDanh = new DiaDanh();
        //     // Get title
        //     Element titleElement = doc.selectFirst("h2.headline");
        //     if (titleElement != null) {
        //         diaDanh.setTenDiaDanh(titleElement.text());
        //     }

        //     // Get description
        //     Element desElement = doc.selectFirst("p");
        //     if (desElement != null) {
        //         diaDanh.setDescription(desElement.text());
        //     }

        //     // Relative person
        //     Elements refElements = doc.select("ref[href~=/nhan-vat]");
        //     for (Element refElement : refElements) {
        //         String name = refElement.attr("title");
        //         nhanVatLienQuan.add(name);
        //     }
        //     diaDanh.setNhanVatLienQuan(nhanVatLienQuan);
        //     diaDanhList.add(diaDanh);
        //     nextElements = doc.select("a.btn.btn-sm.btn-secondary.next");
        // }




        // Print all data in json file
        try (FileWriter writer = new FileWriter("DiaDanh.json")) {
            writer.write(diaDanhList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
