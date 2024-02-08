package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.example.entities.Student;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {

//    public static void main_e2(String[] args) {
//
//        String puName = "my-persistence-unit";
//        Map<String, String> props = new HashMap<>();
//        props.put("hibernate.show_sql", "true");
//        props.put("hibernate.hbm2ddl.auto", "create"); // create, update, none
//
//        EntityManagerFactory emf = new HibernatePersistenceProvider()
//                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);
////        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit"); // factory pattern design object
//        EntityManager em = emf.createEntityManager(); // represents the context
//
//        try {
//            em.getTransaction().begin();
//
////            Product p = new Product();
////            p.setId(1L);
////            p.setName("Beer");
////
////            em.persist(p); // add this to the context -> Not an insert query
//
//            //
//
////            var e1 = em.find(Employee.class, 1); // Laurentiu Spi
////            e1.setName("John Doe");
////            e1.setName("Laurentiu Spi");   // there will be no update. because nothing has changed.
////
////            System.out.println(e1);
//
//            //
//            var e1 = em.find(Employee.class, 1); // Laurentiu Spi
//            em.remove(e1); // remove instance from the context
//
////            em.persist(); // -> Adding an entity to the context.
////            em.find();    // -> Finds by PK. Get from DB and add it to the context if it doesn't already exist.
////            em.remove();  // -> Marking entity for removal.
////            em.merge();   // -> Merges an entity from outside the context to the context.
////            em.refresh(); // -> Mirror the context from the database.
////            em.detach();  // -> taking the entity out of the context.
//
////            Employee e2 = new Employee();
////            e2.setId(1);
////            e2.setName("Laur");
////            e2.setAddress("123 Main St.");
////
////            em.persist(e2);
//
//            //
//
////            Employee e3 = new Employee();
////            e3.setId(1);
////            e3.setName("John Doe");
////            e3.setAddress("Something");
////            em.merge(e3);
//
//            //
//
//
//
//            em.getTransaction().commit(); // end of transaction
//        } finally {
//            em.close();
//        }
//    }

//    public static void main_e3(String[] args) {
//
//        String puName = "my-persistence-unit";
//        Map<String, String> props = new HashMap<>();
//        props.put("hibernate.show_sql", "true");
//        props.put("hibernate.hbm2ddl.auto", "update"); // create, update, none
//
//        EntityManagerFactory emf = new HibernatePersistenceProvider()
//                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);
////        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit"); // factory pattern design object
//        EntityManager em = emf.createEntityManager(); // represents the context
//
//        try {
//            em.getTransaction().begin();
//
////            var e1 = new Employee();
////            e1.setId(1);
////            e1.setName("John");
////            e1.setAddress("Address");
////
////            em.persist(e1);
////
////            e1 = em.find(Employee.class, 1); // find does not make a select query from database. because it is already in the context
////            System.out.println(e1);
//
//            // find vs getReference
////            var e1 = em.find(Employee.class, 1); // always create select query
////
////            var e2 = em.getReference(Employee.class, 1); // no query is issued to the db
////            System.out.println(e2); // it is called when you do anything with the reference. it is based on decorator pattern.
////
////            e2.setName("Anne");
////
////            System.out.println("Before " + e2);
////
////            em.refresh(e2);
////
////            System.out.println("After " + e2);
//
//            // generatedvalue.IDENTITY
//            var e1 = new Employee();
//            e1.setName("John");
//            e1.setAddress("Address");
//
//            em.persist(e1);
//
//
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }

//    public static void main_e4(String[] args) {
//
//        String puName = "my-persistence-unit";
//        Map<String, String> props = new HashMap<>();
//        props.put("hibernate.show_sql", "true");
//        props.put("hibernate.hbm2ddl.auto", "create"); // create, update, none
//
//        EntityManagerFactory emf = new HibernatePersistenceProvider()
//                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);
////        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit"); // factory pattern design object
//        EntityManager em = emf.createEntityManager(); // represents the context
//
//        try {
//            em.getTransaction().begin();
//
//            // UUIDGenerator
////            Employee e1 = new Employee();
////            e1.setName("George");
////            e1.setAddress("Some address");
////            em.persist(e1);
////
////            Product p1 = new Product();
////            p1.setCode("ABC");
////            p1.setNumber(10);
////            p1.setColor("Red");
////
////            em.persist(p1);
//
//
//            // embeddable primary key
//            StudentKey id = new StudentKey();
//            id.setCode("ABC");
//            id.setNumber(10);
//
////            Student s = new Student();
////            s.setId(id);
////            s.setName("John");
////
////            em.persist(s);
//
//            Student s = em.find(Student.class, id);
//            System.out.println(s);
//
//            em.getTransaction().commit();
//        } finally {
//
//        }
//    }

    public static void main(String[] args) {

        String puName = "my-persistence-unit";
        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create"); // create, update, none

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit"); // factory pattern design object
        EntityManager em = emf.createEntityManager(); // represents the context

        try {
            em.getTransaction().begin();

//            String jpql = """
//                    SELECT NEW org.example.dto.CountedEnrollmentStudent(s.name, count(s))
//                    From Student s
//                    GROUP BY s.name
//                    HAVING s.name LIKE '%e'
//                    ORDER BY s.name DESC
//                    """;
//            TypedQuery<CountedEnrollmentStudent> q2 =
//                    em.createQuery(jpql, CountedEnrollmentStudent.class);
//            q2.getResultStream().forEach(o -> System.out.println(o.s() + " " + o.count()));

//            TypedQuery<Student> q = em.createNamedQuery("getAllEnrolledStudents", Student.class);
//            q.getResultList().forEach(o -> System.out.println(o));

            // lesson 12: Native queries
            // SELECT s FROM Student s ->> JPQL
//            String sql = """
//                    SELECT * from student
//                    """;
//
//            Query q = em.createNativeQuery(sql, Student.class);
//            q.getResultList().forEach(
//                    s -> System.out.println(s)
//            );

            // first way to move complexity to the database layer: view
//            String sql = "select s DistinctStudent s"; // TODO create view in the database
//            TypedQuery<DistinctStudent> q = em.createQuery(sql, DistinctStudent.class);
//            q.getResultList().forEach(s -> System.out.println(s));
//
            // second way: functions and stored procedures
//            """
//                    create procedure GetStudents(IN id INT)
//                    BEGIN
//                        SELECT * from student s where s.id = id;
//                    end;
//                    """
            StoredProcedureQuery q = em.createStoredProcedureQuery("GetStudents", Student.class)
                    .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                    .setParameter("id", 2);


            q.getResultList().forEach(s -> System.out.println(s));


            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
