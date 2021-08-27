package hh.tot_systems.test.service;

import hh.tot_systems.test.enteties.Securities;

import java.util.List;

public interface SecuritiesService {

    List<Securities> getAllSecurities();

    void create(Securities securities);

    void update(int id, Securities securities);

    void delete(int id);

    Securities getSecurities(int id);
}
