package com.alexhuba.cinema_management_system;

public class Seat {
    private int row;
    private int column;
    private int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = calculatePrice(row);
    }

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public Seat() {
    }

    private static int calculatePrice(int row) {
        if(row >= 4) {
            return 8;
        }
        return 10;
    }

    //getters and setters

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
