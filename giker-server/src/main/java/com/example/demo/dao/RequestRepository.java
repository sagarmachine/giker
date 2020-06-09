package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;

public interface RequestRepository extends JpaRepository<Request, String> {

	

	 
	
	@Query("select u from Request u where u.givercode = ?1 and u.username=?2")
   Request findByGivercodeUsername(String givercode, String username);

	
	@Query("from Request where username=?1 and requeststatus='A'")
	List<Request> findAccepted(User username);

	@Query("from Request where username=?1 and requeststatus='P'")
     List<Request> findPending(User username);

	@Query("from Request where username=?1 and requeststatus='D'")
    List<Request> findDiclined(User username);

	@Query("from Request where givercode=?1 and requeststatus='A'")

	List<Request> findSubServiceAccepted(UserSubService givercode);
	
	@Query("from Request where givercode=?1 and requeststatus='P'")

	List<Request> findSubServicePending(UserSubService givercode);

}
