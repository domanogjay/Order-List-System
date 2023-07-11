package Domanog.code.model.repositoryUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Domanog.code.model.Order;

@Repository
public interface orderRepo extends JpaRepository<Order, Long> {
	//Employee findByEmail(String email);
}
