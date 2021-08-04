package com.sliit.chatApplication.service.impl;

import com.sliit.chatApplication.model.ItemExtractRasaDTO;

public class RasaExtractDataFormatting {


    public static double getNumberFromWordFilter(String lettersNumber) {
        String input_string = lettersNumber;
        double number_output = Double.parseDouble(input_string.replaceAll("[^0-9.]", ""));
        return number_output;
    }

    public static String getStringFromWordFilter(String lettersNumber) {
        String input_string = lettersNumber;
        String string_output = input_string.replaceAll("[^A-Za-z]", "").toLowerCase();
        return string_output;
    }
    public static String getStringFromRemoveSpace(String lettersNumber) {
        String input_string = lettersNumber;
        String string_output = input_string.replaceAll(" ", "").toLowerCase();
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
            iCategory = "";
        }
        return iCategory;

    }


    public static String getFilteredPrice(String price) {
        return Double.toString(getNumberFromWordFilter(price));
    }

    public static String getFilteredRam(String ram) {
        String metricRam = "";
        Double ramSize = getNumberFromWordFilter(ram);
        String metric = getStringFromWordFilter(ram);
        if (metric.equals("")) {
            metricRam = Double.toString(ramSize);
        } else if (metric.equals("gb")) {
            metricRam = Double.toString(ramSize);
        } else if (metric.equals("gbs")) {
            metricRam = Double.toString(ramSize);
        } else if (metric.equals("mb")) {
            metricRam = Double.toString(ramSize / 1000);
        } else if (metric.equals("mbs")) {
            metricRam = Double.toString(ramSize / 1000);
        } else if (metric.equals("tb")) {
            metricRam = Double.toString(ramSize * 1000);
        } else if (metric.equals("tbs")) {
            metricRam = Double.toString(ramSize * 1000);
        } else {
            metricRam = "";
        }
        return metricRam;
    }

    public static String getFilteredScreenSize(String screen) {
        double sSize = getNumberFromWordFilter(screen);
        String metric = getStringFromWordFilter(screen);
        String screenSize = "";
        if (metric.equals("")) {
            screenSize = Double.toString(sSize);
        } else if (metric.equals("inch")) {
            screenSize = Double.toString(sSize);
        } else if (metric.equals("inchs")) {
            screenSize = Double.toString(sSize);
        } else if (metric.equals("inches")) {
            screenSize = Double.toString(sSize);
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
        double storage = getNumberFromWordFilter(strg);
        String storageSize = "";

        if (metric.equals("gb")) {
            storageSize = Double.toString(storage);
        } else if (metric.equals("gbs")) {
            storageSize = Double.toString(storage);
        } else if (metric.equals("tb")) {
            storageSize = Double.toString(storage * 1000);
        } else if (metric.equals("tbs")) {
            storageSize = Double.toString(storage * 1000);
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
        if (!item.getProcessor().equals("")) {
            item.setProcessor(getStringFromRemoveSpace(item.getProcessor()));
        }


        return item;


    }


}
