package org.example;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.example.entities.Author;
import org.example.entities.Book;
import org.example.entities.BookShop;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Locale;
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

            CriteriaBuilder builder = em.getCriteriaBuilder();

            // =============
//            CriteriaQuery<Tuple> cq = builder.createTupleQuery();
//
//            // Author, Book
//            Root<Book> bookRoot = cq.from(Book.class); // SELECT b From Book b;
//            Join<Book, Author> joinAuthor = bookRoot.join("authorsList", JoinType.LEFT);
//            Join<Book, BookShop> joinBookShop = bookRoot.join("bookShopList", JoinType.INNER);
//
//            cq.multiselect(bookRoot, joinAuthor, joinBookShop); // select b, a From Book b Inner join Author a
//
//            TypedQuery<Tuple> q = em.createQuery(cq);
//            q.getResultStream().forEach(t -> System.out.println(t.get(0) + " "
//                                                                + t.get(1) + " "
//                                                                + t.get(2)));
            // ==============

            CriteriaQuery<Author> mainQuery = builder.createQuery(Author.class);
            // Select a, (Select count(b) from Book b where b.id in a.bookList) n from Author a where n > 2
            // better: select a, (select count(b) from Book b join Author a on b.id in a.booksList) n from author a where n > 2
            Root<Author> authorRoot = mainQuery.from(Author.class);

            Subquery<Long> subquery = mainQuery.subquery(Long.class);
            Root<Author> subRootAuthor = subquery.correlate(authorRoot); // we correlate the inside with the outside
            Join<Author, Book> authorBookJoin = subRootAuthor.join("booksList");

            subquery.select(builder.count(authorBookJoin));
            mainQuery.select(authorRoot)
                    .where(builder.greaterThan(subquery, 1L));

            TypedQuery<Author> q = em.createQuery(mainQuery);
            q.getResultStream()
                            .forEach(a -> System.out.println(a));


            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
