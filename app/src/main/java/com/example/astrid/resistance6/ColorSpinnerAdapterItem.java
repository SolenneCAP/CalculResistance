package com.example.astrid.resistance6;

public class ColorSpinnerAdapterItem {
    int color;
    String name;

    ColorSpinnerAdapterItem(int color, String name) {
        this.color = color;
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    String getDisplayName() {
        return name;
    }
}
