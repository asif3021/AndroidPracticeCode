package com.example.asifahmed.checkboxdemo;

import java.util.ArrayList;

public class CheckedItemList {
    ArrayList<String> items = new ArrayList<>();
    StringBuilder sbv = new StringBuilder();
    void addItem(String str) {
        if (!items.contains(str)){
            items.add(str);
        }
    }


    void removeItem(String str) {
        if (items.contains(str)){
            items.remove(str);
        }
    }

    void removeAllItem(){
        items.clear();
    }


    ArrayList displayItems() { return items; }

    Boolean emptyItemList(){
        if (items.isEmpty()){
            return true;
        }
        return false;
    }
}
