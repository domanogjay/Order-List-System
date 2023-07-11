package Domanog.code.model.repositoryUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Domanog.code.model.OrderHistory;

@Repository
public interface OrderHistoryRepo extends JpaRepository<OrderHistory, Long> {

}
