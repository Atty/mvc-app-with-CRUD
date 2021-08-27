package hh.tot_systems.test.service;

import hh.tot_systems.test.dao.HistoryDao;
import hh.tot_systems.test.enteties.HistoryOfSecurities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryDao historyDao;

    @Override
    public List<HistoryOfSecurities> getAllHistory() {
        return historyDao.getAllHistory();
    }

    @Override
    public void create(HistoryOfSecurities historyOfSecurities) {
        historyDao.create(historyOfSecurities);
    }

    @Override
    public void update(String sec_id, HistoryOfSecurities historyOfSecurities) {
        historyDao.update(sec_id, historyOfSecurities);
    }

    @Override
    public void delete(String sec_id, String trade_date, String num_trades) {
        historyDao.delete(sec_id, trade_date, num_trades);
    }

    @Override
    public List<HistoryOfSecurities> getHistory(String sec_id) {
        return historyDao.getHistory(sec_id);
    }

}
