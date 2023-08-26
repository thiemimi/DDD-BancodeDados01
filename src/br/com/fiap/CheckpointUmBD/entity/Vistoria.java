package br.com.fiap.CheckpointUmBD.entity;


import java.sql.Date;
import java.time.LocalDateTime;

public class Vistoria {

    private String status;
    private int Id;

    private String data;


    public String toString(){
        return "=========================" +
                "\nId: " + Id +
                "\nStatus: " + status +
                "\nData: " + data +
                "\n=========================";
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}
