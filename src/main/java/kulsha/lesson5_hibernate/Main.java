package kulsha.lesson5_hibernate;

import org.hibernate.Session;


public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils utils = new SessionFactoryUtils();
        utils.init();
        try {
            StudentDao studentDao = new StudentDaoImpl(utils);
            for (int i = 0; i < 10; i++) {
                studentDao.save(new Student("Student_" + (i + 1)));
            }

            studentDao.deleteById(1L);
//            Student student = studentDao.findById(1L);
            studentDao.updateNameById(2L, "Larry");

            System.out.println(studentDao.findAll());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            utils.shutdown();
        }

    }

}
