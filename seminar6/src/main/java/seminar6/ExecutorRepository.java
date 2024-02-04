package seminar6;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, Long> {

    List<Executor> findByTask(Task task);

}
