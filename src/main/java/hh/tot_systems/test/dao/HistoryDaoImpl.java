package hh.tot_systems.test.dao;

import hh.tot_systems.test.enteties.HistoryOfSecurities;
import hh.tot_systems.test.enteties.Securities;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.List;

@Repository
public class HistoryDaoImpl implements HistoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<HistoryOfSecurities> getAllHistory() {

        return entityManager.createQuery("from HistoryOfSecurities", HistoryOfSecurities.class).getResultList();
    }

    @Override
    public void create(HistoryOfSecurities historyOfSecurities) {
        try {
            Query query = entityManager.createQuery("from Securities as s where lower(s.sec_id) = : sec_idName", Securities.class);
            query.setParameter("sec_idName", historyOfSecurities.getSec_id().toLowerCase());
            Securities securities = (Securities) query.getSingleResult();
            if (securities != null) {
                securities.addHistoryToSecurities(historyOfSecurities);
                entityManager.persist(historyOfSecurities);
            }
        } catch (Exception ignored) {
        }
    }

    @Override
    public void update(String sec_id, HistoryOfSecurities historyOfSecurities) {
        try {
            HistoryOfSecurities history = entityManager.find(HistoryOfSecurities.class, sec_id);
            if (history != null) {
                history.setTrade_date(historyOfSecurities.getTrade_date());
                history.setNum_trades(historyOfSecurities.getNum_trades());
                history.setOpen(historyOfSecurities.getOpen());
                history.setClose(historyOfSecurities.getClose());
                entityManager.merge(history);
            }
        } catch (Exception ignored) {
        }
    }

    @Override
    public void delete(String sec_id, String trade_date, String num_trades) {
        try {
            HistoryOfSecurities history = entityManager
                    .createQuery("from HistoryOfSecurities as h where h.sec_id =: sec_idName and h.trade_date =: trade_dateName and h.num_trades =: num_tradesName", HistoryOfSecurities.class)
                    .setParameter("sec_idName", sec_id)
                    .setParameter("trade_dateName", Date.valueOf(trade_date))
                    .setParameter("num_tradesName", Double.parseDouble(num_trades))
                    .getSingleResult();
            Securities securities = entityManager
                    .createQuery("from Securities as s where s.sec_id =: sec_idName", Securities.class)
                    .setParameter("sec_idName", sec_id)
                    .getSingleResult();
            securities.deleteHistoryFromSecurities(history);
            if (history != null) entityManager.remove(history);
        } catch (Exception ignored) {
        }
    }

    @Override
    public List<HistoryOfSecurities> getHistory(String sec_id) {
        List<HistoryOfSecurities> historyList = null;
        try {
            historyList = entityManager
                    .createQuery("from HistoryOfSecurities as h where h.sec_id =: sec_idName", HistoryOfSecurities.class)
                    .setParameter("sec_idName", sec_id)
                    .getResultList();
        } catch (Exception ignored) {
        }
        return historyList;
    }

}
