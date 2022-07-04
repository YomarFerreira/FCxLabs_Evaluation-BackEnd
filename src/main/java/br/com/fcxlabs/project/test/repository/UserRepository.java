package br.com.fcxlabs.project.test.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fcxlabs.project.test.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	List<User> findByNameContainingIgnoreCase(String name);
	
	User findByCpf(String cpf);
	
	User findByLogin(String login);
			
	List<User> findByStatus(String status);

	List<User> findByBirthDate(Date birthDate);
	
	List<User> findByInsertDate(Date insertDate);
	
	List<User> findByChangeDate(Date changeDate);

	List<User> findByBirthDateBetween(Date fromBirthDate, Date toBirthDate);
	
	List<User> findByInsertDateBetween(Date fromInsertDate, Date toInsertDate);
	
	List<User> findByChangeDateBetween(Date fromChangeDate, Date toChangeDate);

	
	
	
}
