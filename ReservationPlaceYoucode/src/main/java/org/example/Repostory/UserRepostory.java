package org.example.Repostory;

import org.example.Entity.UseradminEntity;
import org.example.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserRepostory {

    Session session;
    public List<UseradminEntity> getAllStudents() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        List<UseradminEntity> userList = session.createQuery("From UseradminEntity  where role.roleName='student'").list();
        session.getTransaction().commit();
        return userList;
    }
}
