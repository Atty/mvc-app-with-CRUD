package hh.tot_systems.test.enteties;

import java.util.Date;

public class PivotList {

    private int id;

    private String sec_id;

    private String reg_number;

    private String name;

    private String emitent_title;

    private Date trade_date;

    private Double num_trades;

    private Double open;

    private Double close;

    public PivotList() {
    }

    public PivotList(int id, String sec_id, String reg_number, String name, String emitent_title, Date trade_date, Double num_trades, Double open, Double close) {
        this.id            = id;
        this.sec_id        = sec_id;
        this.reg_number    = reg_number;
        this.name          = name;
        this.emitent_title = emitent_title;
        this.trade_date    = trade_date;
        this.num_trades    = num_trades;
        this.open          = open;
        this.close         = close;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSec_id() {
        return sec_id;
    }

    public void setSec_id(String sec_id) {
        this.sec_id = sec_id;
    }

    public String getReg_number() {
        return reg_number;
    }

    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmitent_title() {
        return emitent_title;
    }

    public void setEmitent_title(String emitent_title) {
        this.emitent_title = emitent_title;
    }

    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    public Double getNum_trades() {
        return num_trades;
    }

    public void setNum_trades(Double num_trades) {
        this.num_trades = num_trades;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return "pivotList{" +
                "sec_id='" + sec_id + '\'' +
                ", reg_number='" + reg_number + '\'' +
                ", name='" + name + '\'' +
                ", emitent_title='" + emitent_title + '\'' +
                ", trade_date=" + trade_date +
                ", num_trades=" + num_trades +
                ", open=" + open +
                ", close=" + close +
                '}';
    }
}
