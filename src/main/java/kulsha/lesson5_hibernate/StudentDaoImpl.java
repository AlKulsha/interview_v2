package kulsha.lesson5_hibernate;

import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao{
    private SessionFactoryUtils utils;

    public StudentDaoImpl(SessionFactoryUtils utils) {
        this.utils = utils;
    }
    @Override
    public Optional<Student> findById(Long id) {
        try(Session session = utils.getSession()){
            session.beginTransaction();
            Optional<Student> student = Optional.ofNullable(session.get(Student.class, id));
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public List<Student> findAll() {
        try(Session session = utils.getSession()){
            session.beginTransaction();
            List<Student> students = session.createQuery("select s from Student s").getResultList();
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public void save(Student student) {
        try(Session session = utils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = utils.getSession()){
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void updateNameById(Long id, String newName) {
        try(Session session = utils.getSession()){
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            student.setName(newName);
            session.getTransaction().commit();
        }
    }




}
