package com.accounts.server.springapp.Repository;

import com.accounts.server.springapp.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    Optional<Employee> findByMobileNum(String mobileNum);

    Optional<Employee> findByPanNum(String panNum);
}
