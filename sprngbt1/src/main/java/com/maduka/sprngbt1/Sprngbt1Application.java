package com.maduka.sprngbt1;
import com.maduka.sprngbt1.Model.Customer;
import com.maduka.sprngbt1.Model.Item;
import com.maduka.sprngbt1.Repository.CustomerRepository;
import com.maduka.sprngbt1.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  Sprngbt1Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(Sprngbt1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		Item item1 = Item.builder().name("Item1").build();

		Customer customer = Customer.builder().name("Customer1").item(item1).build();

		customerRepository.save(customer);
	}
}
