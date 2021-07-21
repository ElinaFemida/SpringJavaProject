package ru.geekbrins.store.exeptions;

import lombok.Data;

import java.util.Date;

@Data
public class StoreError {
    private int status;
    private String message;
    private Date timestamp;

    public StoreError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}