package hh.tot_systems.test.dao;

import hh.tot_systems.test.enteties.Securities;

import java.util.List;

public interface SecuritiesDao {

    List<Securities> getAllSecurities();

    void update(int id, Securities securities);

    void create(Securities securities);

    void delete(int id);

    Securities getSecurities(int id);

}
