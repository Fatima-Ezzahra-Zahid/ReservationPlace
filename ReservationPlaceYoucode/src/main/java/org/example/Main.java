package org.example;

import org.example.Entity.RoleEntity;
import org.example.Entity.StudentEntity;
import org.example.Entity.UseradminEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;


public class Main {
//    private static final SessionFactory ourSessionFactory;
//
//    static {
//        try {
//            Configuration configuration = new Configuration();
//            configuration.configure();
//
//            ourSessionFactory = configuration.buildSessionFactory();
//        } catch (Throwable ex) {
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static Session getSession() throws HibernateException {
//        return ourSessionFactory.openSession();
//    }
//
//    public static void main(final String[] args) throws Exception {
//        final Session session = getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
//    }
public static void main(final String[] args) throws Exception {
//        final Session session = HibernateUtil.getSession();
//        try {
//            System.out.println("querying all the managed entities...");
//            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
//            for (EntityType<?> entityType : metamodel.getEntities()) {
//                final String entityName = entityType.getName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
//        } finally {
//            session.close();
//        }
    ;
    //TypeActivities typeActivities = session.get(TypeActivities.class,1);
    RoleEntity roleEntity=new RoleEntity();
    Session session = HibernateUtil.getSession();
    session.beginTransaction();
    roleEntity.setRoleName("cccfdd");
    session.save(roleEntity);
    session.getTransaction().commit();
    System.out.println("add role");

    Session session1 = HibernateUtil.getSession();
    session1.beginTransaction();
    RoleEntity roleEntity1=session.get(RoleEntity.class,1);
    System.out.println(roleEntity1);
    UseradminEntity useradminEntity=new UseradminEntity("zahid","fatima","zahidmm12312@gmail.com","zahid123",12345,roleEntity1);
    session1.persist(useradminEntity);
    session1.getTransaction().commit();
    System.out.println("add useradmin");

    Session session2=HibernateUtil.getSession();
    session2.beginTransaction();
    StudentEntity studentEntity=new StudentEntity();
    studentEntity.setReservationMax(1);
    session2.persist(studentEntity);
    session2.getTransaction().commit();
    System.out.println("add apprenant");






}
}