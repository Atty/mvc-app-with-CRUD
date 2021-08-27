package hh.tot_systems.test.enteties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "securities")
public class Securities {


    @Column(name = "id")
    private int id;

    @Id
    @Column(name = "sec_id")
    private String sec_id;

    @Column(name = "reg_number")
    private String reg_number;

    @Column(name = "name")
    private String name;

    @Column(name = "emitent_title")
    private String emitent_title;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "sec_id")
    private List<HistoryOfSecurities> historyOfSecuritiesList;

    public Securities() {
    }

    public Securities(int id, String sec_id, String reg_number, String name, String emitent_title) {
        this.id            = id;
        this.sec_id        = sec_id;
        this.reg_number    = reg_number;
        this.name          = name;
        this.emitent_title = emitent_title;
    }

    public List<HistoryOfSecurities> getHistoryOfSecuritiesList() {
        return historyOfSecuritiesList;
    }

    public void addHistoryToSecurities(HistoryOfSecurities historyOfSecurities) {
        if (historyOfSecuritiesList == null) {
            historyOfSecuritiesList = new ArrayList<>();
        }
        historyOfSecuritiesList.add(historyOfSecurities);
    }

    public void deleteHistoryFromSecurities(HistoryOfSecurities history) {
        for (int i = 0; i < historyOfSecuritiesList.size(); i++) {
            if (historyOfSecuritiesList.get(i).equals(history)) {
                historyOfSecuritiesList.remove(history);
                break;
            }
        }
    }

    public long getId() {
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

    @Override
    public String toString() {
        return "Securities{" +
                "id=" + id +
                ", sec_id='" + sec_id + '\'' +
                ", reg_number='" + reg_number + '\'' +
                ", name='" + name + '\'' +
                ", emitent_title='" + emitent_title + '\'' +
                '}';
    }
}
