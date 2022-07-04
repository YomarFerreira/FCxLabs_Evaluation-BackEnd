package br.com.fcxlabs.project.test.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.swing.text.MaskFormatter;

import org.springframework.stereotype.Service;

import br.com.fcxlabs.project.test.entity.User;
import br.com.fcxlabs.project.test.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository usersRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.usersRepository = userRepository;
	}

	private User save(User user){
		try{
			String cpfUser = user.getCpf();
			if(validarCpf(cpfUser)) {
				user = usersRepository.save(user);
				return user;
			} else {
				return null;
			}
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	
	public User create(User user) {
		user.setId(null);
		return save(user);
	}

	public User update(User user) {
		Long id = user.getId();
		if (id != null && usersRepository.existsById(id)) {
			return save(user);
		} else {
			return null;
		}
	}
	
	public void deleteById(Long id) {
		if (id != null && usersRepository.existsById(id)) {
			usersRepository.deleteById(id);
		}
	}

	public void deleteAll() {
		usersRepository.deleteAllInBatch();
	}
	
	public List<User> findAll(String name) {
		if (name == null) {
			return usersRepository.findAll();
		} else {
			return usersRepository.findByNameContainingIgnoreCase(name);
		}
	}

	public User findById(Long id) {
		return usersRepository.findById(id).orElse(null);
	}

	public User findByCpf(String cpf) {
		return usersRepository.findByCpf(cpf);
	}
	
	public User findByLogin(String login) {
		return usersRepository.findByLogin(login);
	}
	
	public List<User> findByStatus(String status) {
		return usersRepository.findByStatus(status);
	}
	
	public List<User> findByBirthDate(Date birthDate) {
		return usersRepository.findByBirthDate(birthDate);
	}

	public List<User> findByInsertDate(Date insertDate) {
		return usersRepository.findByInsertDate(insertDate);
	}
	
	public List<User> findByChangeDate(Date changeDate) {
		return usersRepository.findByChangeDate(changeDate);
	}
	
	public List<User> findByBirthDateBetween(Date fromBirthDate, Date toBirthDate) {
		return usersRepository.findByBirthDateBetween(fromBirthDate, toBirthDate);
	}

	public List<User> findByInsertDateBetween(Date fromInsertDate, Date toInsertDate) {
		return usersRepository.findByInsertDateBetween(fromInsertDate, toInsertDate);
	}
	
	public List<User> findByChangeDateBetween(Date fromChangeDate, Date toChangeDate) {
		return usersRepository.findByChangeDateBetween(fromChangeDate, toChangeDate);
	}
	

	public static boolean validarCpf(String validarCpf) throws Exception { //validar CPF
		if(validarCpf.isEmpty() || validarCpf==null || validarCpf.length()<11){
			return false;
		}else {
			//Calculando o 1ºnº do Dígito verificador
			int Val1digSumNineNum = 0, Val1digdigcal = 10, Val1DigitoVerificador;
			for(int i=1 ; i<10 ; i++) {
				String Val1digitoCal = validarCpf.substring(i-1,i);
				int Val1cpfDigit = Integer.valueOf(Val1digitoCal), Val1CalcNoveNum = Val1cpfDigit * Val1digdigcal;
				Val1digdigcal = Val1digdigcal-1;
				Val1digSumNineNum = Val1digSumNineNum + Val1CalcNoveNum;
			}
			int Val1DivSomaNoveNum = Val1digSumNineNum % 11;
			if(Val1DivSomaNoveNum == 1 || Val1DivSomaNoveNum == 0) {
				Val1DigitoVerificador = 0;
			}else {
				Val1DigitoVerificador = 11 - Val1DivSomaNoveNum;
			} 
			//Calculando o 2ºnº do Dígito verificador
			int Val2digSumNineNum = 0, Val2digdigcal = 11, Val2DigitoVerificador;
			for(int i=1 ; i<11 ; i++) {
				String Val2digitoCal = validarCpf.substring(i-1,i);
				int Val2cpfDigit = Integer.valueOf(Val2digitoCal), Val2CalcNoveNum = Val2cpfDigit * Val2digdigcal;
				Val2digdigcal = Val2digdigcal-1;
				Val2digSumNineNum = Val2digSumNineNum + Val2CalcNoveNum;
			}
			int Val2DivSomaNoveNum = Val2digSumNineNum % 11;
			if(Val2DivSomaNoveNum == 1 || Val2DivSomaNoveNum == 0) {
				Val2DigitoVerificador = 0;
			}else {
				Val2DigitoVerificador = 11 - Val2DivSomaNoveNum;
			}
			//Verificando Dígito verificador
			String validador = Val1DigitoVerificador +""+ Val2DigitoVerificador, digitosFinaisCpf = validarCpf.substring(9,11);
			if (validador.equals(digitosFinaisCpf)) {
			    try {
			        MaskFormatter mask = new MaskFormatter("###.###.###-##");
			        mask.setValueContainsLiteralCharacters(false);
					String cpfFormatado =  mask.valueToString(validarCpf);
			    } catch (ParseException ex) {
			    	String erro="erro";
			    }
				return true;
			}else {
				return false;
			}
		}
	}

	
}
