package hh.tot_systems.test.service;

import hh.tot_systems.test.enteties.HistoryOfSecurities;

import java.util.List;

public interface HistoryService {

    List<HistoryOfSecurities> getAllHistory();

    void create(HistoryOfSecurities historyOfSecurities);

    void update(String sec_id, HistoryOfSecurities historyOfSecurities);

    void delete(String sec_id, String trade_date, String num_trades);

    List<HistoryOfSecurities> getHistory(String sec_id);
}
