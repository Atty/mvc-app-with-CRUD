package hh.tot_systems.test.service;

import hh.tot_systems.test.dao.SecuritiesDao;
import hh.tot_systems.test.enteties.Securities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SecuritiesServiceImpl implements SecuritiesService {

    @Autowired
    private SecuritiesDao securitiesDao;

    @Override
    public List<Securities> getAllSecurities() {
        return securitiesDao.getAllSecurities();
    }

    @Override
    public void create(Securities securities) {
        securitiesDao.create(securities);
    }

    @Override
    public void update(int id, Securities securities) {
        securitiesDao.update(id, securities);
    }

    @Override
    public void delete(int id) {
        securitiesDao.delete(id);
    }

    @Override
    public Securities getSecurities(int id) {
        return securitiesDao.getSecurities(id);
    }

}
