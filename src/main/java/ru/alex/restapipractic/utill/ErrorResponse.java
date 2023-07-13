package ru.alex.restapipractic.utill;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String messege;

    private LocalDateTime localDateTime;

    public ErrorResponse(String messege, LocalDateTime localDateTime) {
        this.messege = messege;
        this.localDateTime = localDateTime;
    }

    public String getMessege() {
        return messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
