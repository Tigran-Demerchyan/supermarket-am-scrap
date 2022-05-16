package com.tigran.supermarketamscrapper.scrapper;

import com.tigran.supermarketamscrapper.dto.ElectronicDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ElectronicScrapper {
    private static final String URL = "https://supermarket.am/en/categories/elektronika-texnika_7842/";


    public List<ElectronicDto> getAllElectronic() throws IOException {

        Document document = Jsoup.connect(URL).get();

        Elements selectedHtml = document.select("div.table>.td-overally");

        return selectedHtml.stream()
                .map(curr -> convertToDto(curr))
                .collect(Collectors.toList());


    }

    public static String getDescription(Element curr) {
        return curr.select("div.h3>a").text();
    }

    public static String getDiscountPercent(Element curr) {
        return curr.select("div.discountPercent").text();
    }

    public static String getLink(Element curr) {
        Elements select = curr.select(".h3>a");
        return select.attr("href");
    }

    public static double getPrice(Element curr) {
        Elements select = curr.select("div>input.price");
        String priceText = select.attr("value");
        String s = priceText.replaceAll(" ", "");

        double price = 0;

        Pattern pattern = Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            String priceString = matcher.group();
            price = Double.parseDouble(priceString);

        }
        return price;

    }

    public static double getOldPrice(Element curr) {
        Elements select1 = curr.select("div>input.old_price");
        String value = select1.attr("value");
        String replacedPrice = value.replaceAll(" ", "");

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher1 = pattern.matcher(replacedPrice);

        double price = 0;

        if (matcher1.find()) {
            String group = matcher1.group();
            price = Double.parseDouble(group);

        }
        return price;
    }

    public ElectronicDto convertToDto(Element curr) {
        ElectronicDto dto = new ElectronicDto();

        String description = getDescription(curr);
        dto.setDescription(description);

        String discountPercent = getDiscountPercent(curr);
        dto.setDiscount(discountPercent);

        String link = getLink(curr);
        dto.setLink(link);

        dto.setPrice(getPrice(curr));

        dto.setOldPrice(getOldPrice(curr));
        return dto;

    }
}
