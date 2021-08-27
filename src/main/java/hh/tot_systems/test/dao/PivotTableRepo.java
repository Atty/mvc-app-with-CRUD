package hh.tot_systems.test.dao;


import hh.tot_systems.test.enteties.PivotList;
import hh.tot_systems.test.enteties.Securities;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PivotTableRepo extends CrudRepository<Securities, String> {

    @Query("select new hh.tot_systems.test.enteties.PivotList(s.id, s.sec_id, s.reg_number, s.name, s.emitent_title, h.trade_date, h.num_trades, h.open, h.close) " +
            "FROM Securities AS s LEFT JOIN HistoryOfSecurities AS h ON s.sec_id = h.sec_id ORDER BY s.sec_id ASC")
    List<PivotList> findPivot();
}
