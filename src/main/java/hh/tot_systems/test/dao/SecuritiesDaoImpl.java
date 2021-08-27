package hh.tot_systems.test.dao;

import hh.tot_systems.test.enteties.Securities;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SecuritiesDaoImpl implements SecuritiesDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Securities> getAllSecurities() {
        List<Securities> securitiesList = null;
        try {
            securitiesList = entityManager.createQuery("from Securities s order by s.id asc", Securities.class).getResultList();
            return securitiesList;
        } catch (Exception ignored) {
        }
        return securitiesList;
    }

    @Override
    public void create(Securities securities) {
        try {
            entityManager.persist(securities);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void update(int id, Securities securities) {
        try {
            Securities s = entityManager.find(Securities.class, id);
            if (s != null) {
                s.setReg_number(securities.getReg_number());
                s.setEmitent_title(securities.getEmitent_title());
                s.setName(securities.getName());
                entityManager.merge(s);
            }
        } catch (Exception ignored) {
        }
    }

    @Override
    public void delete(int id) {
        try {
            Query query = entityManager.createQuery("delete from Securities where id = : idName").setParameter("idName", id);
            query.executeUpdate();
        } catch (Exception ignored) {
        }
    }

    @Override
    public Securities getSecurities(int id) {
        Securities securities = null;
        try {
            securities = entityManager.find(Securities.class, id);
        } catch (Exception ignored) {
        }
        return securities;
    }

}
