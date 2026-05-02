package com.klef.fsad.exam;

import org.hibernate.*;

public class ClientDemo {
    public static void main(String[] args) {

        SessionFactory sf = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        Project p = new Project();
        p.name = "Demo";
        p.description = "Test";
        p.date = "2026";
        p.status = "Done";

        s.persist(p);
        t.commit();

        Project p2 = s.get(Project.class, p.id);
        System.out.println(p2.id + " " + p2.name);

        s.close();
        sf.close();
    }
}
