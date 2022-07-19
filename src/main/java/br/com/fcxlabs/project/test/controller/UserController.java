package br.com.fcxlabs.project.test.controller;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<User> create(@RequestBody User userRequest) {
		try {
			User user = userService.create(userRequest);
			if (user == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(user, HttpStatus.CREATED);
			}
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
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> update(@PathVariable(name = "id") Long id,
			@RequestBody User userRequest) {
		userRequest.setId(id);
		try {
			User user = userService.update(userRequest);
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
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") Long id) {
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
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findAll(@RequestParam(name = "user", required = false) String usersfind, Pageable pageable)
	{
		Page<User> users = userService.findAll(usersfind, pageable);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Find an user by login")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/login={login}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findByLogin(@PathVariable(name = "login") String login, Pageable pageable) {
		Page<User> user = userService.findByLogin(login, pageable);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}
	
	
	@ApiOperation(value = "Find an user by id")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> findById(@PathVariable(name = "id") Long id) {
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
	@GetMapping(path = "/cpf={cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findByCpf(@PathVariable(name = "cpf") String cpf, Pageable pageable) {
		Page<User> user = userService.findByCpf(cpf, pageable);
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
	@GetMapping(path = "/status={status}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findByStatus(@PathVariable(name = "status") String userStatus, Pageable pageable) {
		Page<User> users = userService.findByStatus(userStatus, pageable);
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
	@GetMapping(path = "/birth={birthDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findByBirthDate(@PathVariable(name = "birthDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date userBirthDate, Pageable pageable) {
		Page<User> users = userService.findByBirthDate(userBirthDate , pageable);
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
	@GetMapping(path = "/insert={insertDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findByInsertDate(@PathVariable(name = "insertDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mmZ") Date userInsertDate, Pageable pageable) {
		Page<User> users = userService.findByInsertDate(userInsertDate, pageable );
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
	@GetMapping(path = "/change={changeDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findByChangeDate(@PathVariable(name = "changeDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mmZ") Date userChangeDate, Pageable pageable) {
		Page<User> users = userService.findByChangeDate(userChangeDate, pageable);
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
	@GetMapping(path = "/birthb={fromBirthDate}/{toBirthDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findByBirthDateBetween(@PathVariable(name = "fromBirthDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date userFromBirthDate, @PathVariable(name = "toBirthDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date userToBirthDate, Pageable pageable) {
		Page<User> users = userService.findByBirthDateBetween(userFromBirthDate, userToBirthDate, pageable);
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
	@GetMapping(path = "/insertb={fromInsertDate}/{toInsertDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findByInsertDateBetween(@PathVariable(name = "fromInsertDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date userFromInsertDate, @PathVariable(name = "toInsertDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date userToInsertDate, Pageable pageable) {
		Page<User> users = userService.findByInsertDateBetween(userFromInsertDate, userToInsertDate, pageable);
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
	@GetMapping(path = "/changeb={fromChangeDate}/{toChangeDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findByChangeDateBetween(@PathVariable(name = "fromChangeDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date userFromChangeDate, @PathVariable(name = "toChangeDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date userToChangeDate, Pageable pageable) {
		Page<User> users = userService.findByChangeDateBetween(userFromChangeDate, userToChangeDate, pageable);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
	}


	@ApiOperation(value = "Find Name And Status")
	@ApiResponses({
	@ApiResponse(code = 200, message = "OK"),
	@ApiResponse(code = 400, message = "Bad Request"),
	@ApiResponse(code = 404, message = "Not Found")
	})
	@GetMapping(path = "/user={name}/status={status}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<User>> findByNameContainingIgnoreCaseAndStatus(@RequestParam(name = "user") String userName, @PathVariable(name = "status") String userStatus, Pageable pageable)
	{
		Page<User> users = userService.findByNameContainingIgnoreCaseAndStatus(userName, userStatus, pageable);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}

	}
	
	
}	
	
	

