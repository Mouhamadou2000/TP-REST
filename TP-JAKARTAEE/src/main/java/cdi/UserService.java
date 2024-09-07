package cdi;

import Models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public class UserService {
    @PersistenceContext(unitName="TP-JAKARTAEE")
    private EntityManager em;

    public long createCommune(User user) {
        em.persist(user);
        return user.getId();
    }



    public User findCommuneById(long Id) {

        User com=em.find(User.class, Id, LockModeType.PESSIMISTIC_READ);
        return com;
    }

    public User update(User commune) {
        em.merge(commune);
        return commune;
    }

    public Boolean deleteCommuneById(long Id) {
        User com=findCommuneById(Id);
        if(com!=null) {

            em.remove(com);
            return true;
        }else {
            return false;

        }

    }

    public List<User> findAllCommune(){
        List<User> list;
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> i = query.from(User.class);
        query.select(i);

        list = em.createQuery(query).getResultList();

        return list;

    }



}
