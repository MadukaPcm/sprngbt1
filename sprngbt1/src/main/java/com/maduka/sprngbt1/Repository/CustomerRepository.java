package com.maduka.sprngbt1.Repository;
import com.maduka.sprngbt1.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
