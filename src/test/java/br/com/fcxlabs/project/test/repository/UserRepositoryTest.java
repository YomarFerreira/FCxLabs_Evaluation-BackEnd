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

	SimpleDateFormat sdfd = new SimpleDateFormat("yyyy/MM/dd");
	SimpleDateFormat sdft = new SimpleDateFormat("yyyy/MM/dd HH:mm-0300");

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
		user.setCpf("122.454.789-99");
		user.setBirthDate(sdfd.parse("1980/07/12"));
		user.setMotherName("ANA");
		user.setStatus("ATIVO");
		user.setInsertDate(sdft.parse("2022/06/30 18:00-0300"));
		user.setChangeDate(sdft.parse("2022/07/01 10:31-0300"));

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
	

	
	@Test
	public void findByBirthDate() throws ParseException { 
		String stringBirthDate = "1980/07/12";
		Date birthDate = sdfd.parse(stringBirthDate);
		List<User> users = userRepository.findByBirthDate(birthDate);
        users.forEach(System.out::println);
    }

	
	
	@Test
	public void findByInsertDate() throws ParseException{ 
		String StringInsertDate = "2022/06/29 17:30-0300";
		Date insertDate = sdft.parse(StringInsertDate);
		List<User> users = userRepository.findByInsertDate(insertDate);
		users.forEach(System.out::println);
    }

	@Test
	public void findByChangeDate() throws ParseException{ 
		String StringChangeDate = "2022/06/30 08:00-0300";
		Date changeDate = sdft.parse(StringChangeDate);
		List<User> users = userRepository.findByChangeDate(changeDate);
		users.forEach(System.out::println);
    }

	@Test
	public void findByBirthDateBetween() throws ParseException { 
		String fromBirthDate = "1979/05/01";
		String toBirthDate = "2022/08/23";
		Date fromBirthDated = sdfd.parse(fromBirthDate);
		Date toBirthDated = sdfd.parse(toBirthDate);
		List<User> users = userRepository.findByBirthDateBetween(fromBirthDated, toBirthDated);
        users.forEach(System.out::println);
    }
	
	@Test
	public void findByInsertDateBetween() throws ParseException { 
		String fromInsertDate = "1979/05/12";
		String toInsertDate = "2022/08/25";
		Date fromInsertDated = sdft.parse(fromInsertDate);
		Date toInsertDated = sdft.parse(toInsertDate);
		List<User> users = userRepository.findByInsertDateBetween(fromInsertDated, toInsertDated);
        users.forEach(System.out::println);
    }
	
	@Test
	public void findByChangeDateBetween() throws ParseException { 
		String fromChangeDate = "1979/05/12";
		String toChangeDate = "2022/08/31";
		Date fromChangeDated = sdft.parse(fromChangeDate);
		Date toChangeDated = sdft.parse(toChangeDate);
		List<User> users = userRepository.findByChangeDateBetween(fromChangeDated, toChangeDated);
        users.forEach(System.out::println);
    }
    
*/
}
