package br.com.fcxlabs.project.test.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import br.com.fcxlabs.project.test.entity.User;
import br.com.fcxlabs.project.test.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(path = "/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService service) {
		super();
		this.userService = service;
	}

	
	@ApiOperation(value = "Save an user")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Created"), 
		@ApiResponse(code = 400, message = "Bad Request") 
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> create(@RequestBody User user) {
		try {
			user = userService.create(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	
	@ApiOperation(value = "Update an user")
	@ApiResponses({ 
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@PutMapping(path = "/{user_id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> update(@PathVariable(name = "user_id") Long id,
			@RequestBody User user) {
		user.setId(id);
		try {
			user = userService.update(user);
			if (user == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(user, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	
	@ApiOperation(value = "Delete an user")
	@ApiResponses({
		@ApiResponse(code = 204, message = "No Content")
	})
	@DeleteMapping(path = "/{user_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "user_id") Long id) {
		userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@ApiOperation(value = "Delete all users")
	@ApiResponses({
		@ApiResponse(code = 204, message = "No Content")
	})
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAll() {
		userService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@ApiOperation(value = "Find all users")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK")
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userService.findAll(null);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	
	@ApiOperation(value = "Find an user by id")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> findById(@PathVariable(name = "user_id") Long id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}


	@ApiOperation(value = "Find an user by cpf")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/cpf={user_cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> findByCpf(@PathVariable(name = "user_cpf") String cpf) {
		User user = userService.findByCpf(cpf);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}


	@ApiOperation(value = "Find an user by login")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/login={user_login}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> findByLogin(@PathVariable(name = "user_login") String login) {
		User user = userService.findByLogin(login);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}


	@ApiOperation(value = "Find users by status")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/status={user_status}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<User>> findByStatus(@PathVariable(name = "user_status") String userStatus) {
		List<User> users = userService.findByStatus(userStatus);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}

	
	@ApiOperation(value = "Find users by birth date")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/birth={user_birthDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<User>> findByBirthDate(@PathVariable(name = "user_birthDate") Date userBirthDate) {
		List<User> users = userService.findByBirthDate(userBirthDate);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}
		
			
	@ApiOperation(value = "Find users by insert date")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/insert={user_insertDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<User>> findByInsertDate(@PathVariable(name = "user_insertDate") Date userInsertDate) {
		List<User> users = userService.findByInsertDate(userInsertDate);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}

	
	@ApiOperation(value = "Find users by change date")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/change={user_changeDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<User>> findByChangeDate(@PathVariable(name = "user_changeDate") Date userChangeDate) {
		List<User> users = userService.findByChangeDate(userChangeDate);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}
	
	
	@ApiOperation(value = "Find users by birth date between")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/birthb={user_birthDateBetween}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<User>> findByBirthDateBetween(@PathVariable(name = "user_fromBirthDate") Date userFromBirthDate, @PathVariable(name = "user_ToBirthDate") Date userToBirthDate) {
		List<User> users = userService.findByBirthDateBetween(userFromBirthDate, userToBirthDate);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}
	
	
	@ApiOperation(value = "Find users by insert date between")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/insertb={user_insertDateBetween}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<User>> findByInsertDateBetween(@PathVariable(name = "user_fromInsertDate") Date userFromInsertDate, @PathVariable(name = "user_ToInsertDate") Date userToInsertDate) {
		List<User> users = userService.findByInsertDateBetween(userFromInsertDate, userToInsertDate);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}
	
	
	@ApiOperation(value = "Find users by change date between")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/changeb={user_changeDateBetween}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<User>> findByChangeDateBetween(@PathVariable(name = "user_fromChangeDate") Date userFromChangeDate, @PathVariable(name = "user_ToChangeDate") Date userToChangeDate) {
		List<User> users = userService.findByChangeDateBetween(userFromChangeDate, userToChangeDate);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}

}