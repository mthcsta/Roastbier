package com.roastbier.roastbier;

import java.io.Serializable;

public class DatatableSearchFormat implements Serializable {

    private Object[] data;
    private int recordsTotal;
    private int recordsFiltered;
    private int draw;

    private DatatableSearchFormat(Object[] data, int total, int filtered, int draw) {
        this.data = data;
        this.recordsTotal = total;
        this.recordsFiltered = filtered;
        this.draw = draw;
    }

    public static DatatableSearchFormat of(Object[] data, int total, int filtered, int draw) {
        DatatableSearchFormat x = new DatatableSearchFormat(data, total, filtered, draw);

        return x;
    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
