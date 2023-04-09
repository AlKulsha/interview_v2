package kulsha.lesson5_hibernate;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    Optional<Student> findById(Long id);
    List<Student> findAll();
    void updateNameById(Long id, String newName);
    void save(Student student);
    void deleteById(Long id);
}
