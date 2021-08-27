package hh.tot_systems.test.enteties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "history_of_securities")
public class HistoryOfSecurities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sec_id")
    private String sec_id;

    @Column(name = "trade_date")
    private Date trade_date;

    @Column(name = "num_trades")
    private double num_trades;

    @Column(name = "open")
    private double open;

    @Column(name = "close")
    private double close;

    public HistoryOfSecurities() {
    }

    public HistoryOfSecurities(String sec_id, Date trade_date, double num_trades, double open, double close) {
        this.sec_id     = sec_id;
        this.trade_date = trade_date;
        this.num_trades = num_trades;
        this.open       = open;
        this.close      = close;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public String getSec_id() {
        return sec_id;
    }

    public void setSec_id(String sec_id) {
        this.sec_id = sec_id;
    }

    public Date getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(Date trade_date) {
        this.trade_date = trade_date;
    }

    public double getNum_trades() {
        return num_trades;
    }

    public void setNum_trades(double num_trades) {
        this.num_trades = num_trades;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HistoryOfSecurities{" +
                "sec_id='" + sec_id + '\'' +
                ", trade_date=" + trade_date +
                ", num_trades=" + num_trades +
                ", open=" + open +
                '}';
    }
}
