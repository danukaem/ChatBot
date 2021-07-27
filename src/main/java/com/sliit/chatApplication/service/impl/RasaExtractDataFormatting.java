package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.ItemExtractRasaDTO;

public class RasaExtractDataFormatting {


    public static int getNumberFromWordFilter(String lettersNumber) {
        String input_string = lettersNumber;
        int number_output = Integer.parseInt(input_string.replaceAll("[^0-9]", ""));
        System.out.println(number_output);
        return number_output;
    }

    public static String getStringFromWordFilter(String lettersNumber) {
        String input_string = lettersNumber;
        String string_output = input_string.replaceAll("[^A-Za-z]", "").toLowerCase();
        System.out.println(string_output);
        return string_output;
    }

    public static String getFilteredItemCategory(String itemCategory) {
        String category = getStringFromWordFilter(itemCategory);
        String iCategory = "";
        if (category.equals("phone")) {
            iCategory = "phone";
        } else if (category.equals("phones")) {
            iCategory = "phone";
        } else if (category.equals("phone")) {
            iCategory = "phone";
        } else if (category.equals("smartphone")) {
            iCategory = "phone";
        } else if (category.equals("smartphones")) {
            iCategory = "phone";
        } else if (category.equals("mobile")) {
            iCategory = "phone";
        } else if (category.equals("mobiles")) {
            iCategory = "phone";
        } else if (category.equals("smartmobile")) {
            iCategory = "phone";
        } else if (category.equals("smartmobiles")) {
            iCategory = "phone";
        } else if (category.equals("telephone")) {
            iCategory = "phone";
        } else if (category.equals("telephones")) {
            iCategory = "phone";
        } else if (category.equals("laptop")) {
            iCategory = "laptop";
        } else if (category.equals("laptops")) {
            iCategory = "laptop";
        } else if (category.equals("computer")) {
            iCategory = "laptop";
        } else if (category.equals("computers")) {
            iCategory = "laptop";
        } else {
            iCategory = category;
        }
        return iCategory;

    }


    public static String getFilteredPrice(String price) {
        return Integer.toString(getNumberFromWordFilter(price));
    }

    public static String getFilteredRam(String ram) {
        String metricRam = "";
        int ramSize = getNumberFromWordFilter(ram);
        String metric = getStringFromWordFilter(ram);
        if (metric.equals("")) {
            metricRam = Integer.toString(ramSize);
        } else if (metric.equals("gb")) {
            metricRam = Integer.toString(ramSize);
        } else if (metric.equals("gbs")) {
            metricRam = Integer.toString(ramSize);
        } else if (metric.equals("mb")) {
            metricRam = Integer.toString(ramSize / 1000);
        } else if (metric.equals("mbs")) {
            metricRam = Integer.toString(ramSize / 1000);
        } else if (metric.equals("tb")) {
            metricRam = Integer.toString(ramSize * 1000);
        } else if (metric.equals("tbs")) {
            metricRam = Integer.toString(ramSize * 1000);
        } else {
            metricRam = "";
        }
        return metricRam;
    }

    public static String getFilteredScreenSize(String screen) {
        int sSize = getNumberFromWordFilter(screen);
        String metric = getStringFromWordFilter(screen);
        String screenSize = "";
        if (metric.equals("")) {
            screenSize = Integer.toString(sSize);
        } else if (metric.equals("inch")) {
            screenSize = Integer.toString(sSize);
        } else if (metric.equals("inchs")) {
            screenSize = Integer.toString(sSize);
        } else if (metric.equals("inches")) {
            screenSize = Integer.toString(sSize);
        } else if (metric.equals("mm")) {
            screenSize = Double.toString(sSize / 25.4);
        } else if (metric.equals("cm")) {
            screenSize = Double.toString(sSize / 2.54);
        } else if (metric.equals("m")) {
            screenSize = Double.toString(sSize / 0.0254);
        } else {
            screenSize = "";
        }
        return screenSize;
    }

    public static String getFilteredStotageSize(String strg) {
        String metric = getStringFromWordFilter(strg);
        int storage = getNumberFromWordFilter(strg);
        String storageSize = "";

        if (metric.equals("gb")) {
            storageSize = Integer.toString(storage);
        } else if (metric.equals("gbs")) {
            storageSize = Integer.toString(storage);
        } else if (metric.equals("tb")) {
            storageSize = Integer.toString(storage * 1000);
        } else if (metric.equals("tbs")) {
            storageSize = Integer.toString(storage * 1000);
        } else {
            storageSize = "";
        }
        return storageSize;
    }

    public static ItemExtractRasaDTO getFilteredItemExtractRasa(ItemExtractRasaDTO item) {

        if (!item.getItemCategory().equals("")) {
            item.setItemCategory(getFilteredItemCategory(item.getItemCategory()));

        }
        if (!item.getRam().equals("")) {
            item.setRam(getFilteredRam(item.getRam()));
        }
        if (!item.getScreen().equals("")) {
            item.setScreen(getFilteredScreenSize(item.getScreen()));
        }
        if (!item.getPrice().equals("")) {
            item.setPrice(getFilteredPrice(item.getPrice()));
        }
        if (!item.getStorage().equals("")) {
            item.setStorage(getFilteredStotageSize(item.getStorage()));
        }


        return item;


    }


}