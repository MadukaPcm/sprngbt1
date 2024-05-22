package com.maduka.sprngbt1.Repository;
import com.maduka.sprngbt1.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Integer> {

}
