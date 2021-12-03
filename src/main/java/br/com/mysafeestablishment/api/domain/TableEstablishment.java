package br.com.mysafeestablishment.api.domain;

public class TableEstablishment extends AbstractEntity{

    private String statusTable;
    private String locationArea;
    private Integer numberSeats;

    public String getStatusTable() {
        return statusTable;
    }

    public void setStatusTable(String statusTable) {
        this.statusTable = statusTable;
    }

    public String getLocationArea() {
        return locationArea;
    }

    public void setLocationArea(String locationArea) {
        this.locationArea = locationArea;
    }

    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }

    public TableEstablishment() {
    }

    @Override
    public String toString() {
        return "TableEstablishment{" +
                "statusTable='" + statusTable + '\'' +
                ", locationArea='" + locationArea + '\'' +
                '}';
    }
}
