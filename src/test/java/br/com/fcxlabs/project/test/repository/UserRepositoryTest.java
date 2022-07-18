package br.com.fcxlabs.project.test.repository;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import br.com.fcxlabs.project.test.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations="classpath:application.properties")

public class UserRepositoryTest {

	SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd HH:mm-0300");
	Pageable pageable;

	@Autowired
	UserRepository userRepository;


	
	@Test
	public void create() throws ParseException{
		User user = new User();
		
		user.setId(null);
		user.setName("Ana Barcelos");
		user.setLogin("ANABAR");
		user.setPassword("aNaBaR1982");
		user.setEmail("ana.barcellos@gmail.com");
		user.setPhone("(81)94567-0923");
		user.setCpf("987.654.321-01");
		user.setBirthDate(sdfd.parse("1982-10-23"));
		user.setMotherName("Silvia Maria");
		user.setStatus("ATIVO");
		user.setInsertDate(sdft.parse("2022-07-06 23:01-0300"));
		user.setChangeDate(sdft.parse("2022-07-07 09:05-0300"));

		user = userRepository.save(user);
	}

	@Test
	public void update() throws ParseException{
		User user = new User();
		
		user.setId(3L);
		user.setName("Ana");
		user.setLogin("ANAY");
		user.setPassword("Mais~20");
		user.setEmail("ana@gmail.com");
		user.setPhone("(81)91234-6789");
		user.setCpf("988.654.321-01");
		user.setBirthDate(sdfd.parse("1972/03/09"));
		user.setMotherName("Maria");
		user.setStatus("ATIVO");
		user.setInsertDate(sdft.parse("2022/06/29 17:30-0300"));
		user.setChangeDate(sdft.parse("2022/06/30 08:00-0300"));

		user = userRepository.save(user);
	}	

	@Test
    public void deleteById() {
        Long id = 1L;
        if(userRepository.existsById(id)) {
        	userRepository.deleteById(id);
        }
    }

//    @Test
//    public void deleteAll() {
//    	userRepository.deleteAllInBatch();
//    }

	@Test
    public void findAll() {
		Page<User> users = userRepository.findAll(pageable);
        users.forEach(System.out::println);
    }
   
	@Test
	public void findById() { 
		Long id = 3L;
		User user = userRepository.findById(id).orElse(null);
		System.out.println(user);
	}
    
	@Test
	public void findByNameContainingIgnoreCase() { 
		String name = "An";
		Page<User> users = userRepository.findByNameContainingIgnoreCase(name, pageable);
		users.forEach(System.out::println);
	}

	@Test
	public void findByCpf() { 
		String cpf = "123.456.789-99";
		Page<User> user = userRepository.findByCpf(cpf, pageable);
		System.out.println(user);
	}
	
	@Test
	public void findByLogin() { 
		String login = "ANA";
		Page<User> user = userRepository.findByLogin(login, pageable);
		System.out.println(user);
	}

	@Test
	public void findByStatus() { 
		String status = "ATIVO";
		Page<User> users = userRepository.findByStatus(status, pageable);
		users.forEach(System.out::println);
	}
	

	
	@Test
	public void findByBirthDate() throws ParseException { 
		String stringBirthDate = "1980-07-12";
		Date birthDate = sdfd.parse(stringBirthDate);
		Page<User> users = userRepository.findByBirthDate(birthDate, pageable);
        users.forEach(System.out::println);
    }

	
	
	@Test
	public void findByInsertDate() throws ParseException{ 
		String StringInsertDate = "2022/06/29 17:30-0300";
		Date insertDate = sdft.parse(StringInsertDate);
		Page<User> users = userRepository.findByInsertDate(insertDate, pageable);
		users.forEach(System.out::println);
    }

	@Test
	public void findByChangeDate() throws ParseException{ 
		String StringChangeDate = "2022/06/30 08:00-0300";
		Date changeDate = sdft.parse(StringChangeDate);
		Page<User> users = userRepository.findByChangeDate(changeDate, pageable);
		users.forEach(System.out::println);
    }

	@Test
	public void findByBirthDateBetween() throws ParseException { 
		String fromBirthDate = "1979/05/01";
		String toBirthDate = "2022/08/23";
		Date fromBirthDated = sdfd.parse(fromBirthDate);
		Date toBirthDated = sdfd.parse(toBirthDate);
		Page<User> users = userRepository.findByBirthDateBetween(fromBirthDated, toBirthDated, pageable);
        users.forEach(System.out::println);
    }
	
	@Test
	public void findByInsertDateBetween() throws ParseException { 
		String fromInsertDate = "1979/05/12";
		String toInsertDate = "2022/08/25";
		Date fromInsertDated = sdft.parse(fromInsertDate);
		Date toInsertDated = sdft.parse(toInsertDate);
		Page<User> users = userRepository.findByInsertDateBetween(fromInsertDated, toInsertDated, pageable);
        users.forEach(System.out::println);
    }
	
	@Test
	public void findByChangeDateBetween() throws ParseException { 
		String fromChangeDate = "1979/05/12";
		String toChangeDate = "2022/08/31";
		Date fromChangeDated = sdft.parse(fromChangeDate);
		Date toChangeDated = sdft.parse(toChangeDate);
		Page<User> users = userRepository.findByChangeDateBetween(fromChangeDated, toChangeDated, pageable);
        users.forEach(System.out::println);
    }
    

}
