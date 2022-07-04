package br.com.fcxlabs.project.test.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import br.com.fcxlabs.project.test.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations="classpath:application.properties")

public class UserRepositoryTest {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Autowired
	UserRepository userRepository;

/*	
	
	@Test
	public void create() throws ParseException{
		User user = new User();
		
		user.setId(null);
		user.setName("Maria");
		user.setLogin("MARYA");
		user.setPassword("M125TY");
		user.setEmail("maria@fgtdn.com");
		user.setPhone("(81)95623-6523");
		user.setCpf("122.456.789-99");
		user.setBirthDate(sdf.parse("12/07/1980 12:00:00"));
		user.setMotherName("ANA");
		user.setStatus("ATIVO");
		user.setInsertDate(sdf.parse("30/06/2022 18:00:00"));
		user.setChangeDate(sdf.parse("01/07/2022 10:31:59"));

		user = userRepository.save(user);
	}
	
	@Test
	public void update() throws ParseException{
		User user = new User();
		
		user.setId(4L);
		user.setName("Ana");
		user.setLogin("ANAY");
		user.setPassword("Mais~20");
		user.setEmail("ana@gmail.com");
		user.setPhone("(81)91234-6789");
		user.setCpf("988.654.321-01");
		user.setBirthDate(sdf.parse("09/03/1972 12:00:00"));
		user.setMotherName("Maria");
		user.setStatus("ATIVO");
		user.setInsertDate(sdf.parse("29/06/2022 17:30:00"));
		user.setChangeDate(sdf.parse("30/06/2022 08:00:59"));

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
        List<User> users = userRepository.findAll();
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
		List<User> users = userRepository.findByNameContainingIgnoreCase(name);
		users.forEach(System.out::println);
	}

	@Test
	public void findByCpf() { 
		String cpf = "123.456.789-99";
		User user = userRepository.findByCpf(cpf);
		System.out.println(user);
	}
	
	@Test
	public void findByLogin() { 
		String login = "ANA";
		User user = userRepository.findByLogin(login);
		System.out.println(user);
	}

	@Test
	public void findByStatus() { 
		String status = "ATIVO";
		List<User> users = userRepository.findByStatus(status);
		users.forEach(System.out::println);
	}
	
*/
	
	@Test
	public void findByBirthDate() throws ParseException { 
		String StringBirthDate = "12/07/1980 00:00:00";
		Date birthDate = sdf.parse(StringBirthDate);
		List<User> users = userRepository.findByBirthDate(birthDate);
        users.forEach(System.out::println);
    }
/*
	
	
	@Test
	public void findByInsertDate() throws ParseException{ 
		String StringInsertDate = "30/06/2022 18:00:00";
		Date insertDate = sdf.parse(StringInsertDate);
		List<User> users = userRepository.findByInsertDate(insertDate);
		users.forEach(System.out::println);
    }

	@Test
	public void findByChangeDate() throws ParseException{ 
		String StringChangeDate = "30/06/2022 08:00:59";
		Date changeDate = sdf.parse(StringChangeDate);
		List<User> users = userRepository.findByChangeDate(changeDate);
		users.forEach(System.out::println);
    }

	@Test
	public void findByBirthDateBetween() throws ParseException { 
		String fromBirthDate = "12/05/1979 00:00:00";
		String toBirthDate = "31/08/2022 00:00:00";
		Date fromBirthDated = sdf.parse(fromBirthDate);
		Date toBirthDated = sdf.parse(toBirthDate);
		List<User> users = userRepository.findByBirthDateBetween(fromBirthDated, toBirthDated);
        users.forEach(System.out::println);
    }
	
	@Test
	public void findByInsertDateBetween() throws ParseException { 
		String fromInsertDate = "12/05/1979 00:00:00";
		String toInsertDate = "31/08/2022 00:00:00";
		Date fromInsertDated = sdf.parse(fromInsertDate);
		Date toInsertDated = sdf.parse(toInsertDate);
		List<User> users = userRepository.findByInsertDateBetween(fromInsertDated, toInsertDated);
        users.forEach(System.out::println);
    }
	
	@Test
	public void findByChangeDateBetween() throws ParseException { 
		String fromChangeDate = "12/05/1979 00:00:00";
		String toChangeDate = "31/08/2022 00:00:00";
		Date fromChangeDated = sdf.parse(fromChangeDate);
		Date toChangeDated = sdf.parse(toChangeDate);
		List<User> users = userRepository.findByChangeDateBetween(fromChangeDated, toChangeDated);
        users.forEach(System.out::println);
    }
    
*/
}
