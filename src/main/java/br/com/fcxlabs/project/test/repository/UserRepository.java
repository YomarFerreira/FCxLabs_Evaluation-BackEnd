package br.com.fcxlabs.project.test.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fcxlabs.project.test.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
	Page<User> findByCpf(String cpf, Pageable pageable);
	
	Page<User> findByLogin(String login, Pageable pageable);
	
	Page<User> findByStatus(String status, Pageable pageable);

	Page<User> findByBirthDate(Date birthDate, Pageable pageable);
	
	Page<User> findByInsertDate(Date insertDate, Pageable pageable);
	
	Page<User> findByChangeDate(Date changeDate, Pageable pageable);

	Page<User> findByBirthDateBetween(Date fromBirthDate, Date toBirthDate, Pageable pageable);
	
	Page<User> findByInsertDateBetween(Date fromInsertDate, Date toInsertDate, Pageable pageable);
	
	Page<User> findByChangeDateBetween(Date fromChangeDate, Date toChangeDate, Pageable pageable);

	Page<User> findByNameContainingIgnoreCaseAndStatus(String Name, String Status, Pageable pageable);
	
	
}