package playwithjava.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playwithjava.in.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
