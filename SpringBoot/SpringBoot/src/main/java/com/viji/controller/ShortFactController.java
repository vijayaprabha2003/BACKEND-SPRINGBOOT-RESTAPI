package com.viji.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.viji.exception.FactNotfoundException;
import com.viji.model.ShortFact;
import com.viji.service.ShortFactService;
import com.viji.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ShortFactController
{
	@Autowired
	private ShortFactService factService;
	
	@Autowired
	private UserService userService;

	@PostMapping("/shortfacts")
	public ResponseEntity<Object> createFact(@RequestBody ShortFact fact)
	{
		boolean isUserExist = userService.isUserExist(fact.getName());
		
		if(isUserExist) {
			fact = factService.createFact(fact);
			return new ResponseEntity<>("Your Fact is created successfully with id = " +fact.getId(), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("Invalid Username, Please Login", HttpStatus.CREATED);
		}
	}

	@PutMapping("/shortfacts/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id, @RequestBody ShortFact fact)
	{
		boolean isFactExist = factService.isFactExist(id);
		if (isFactExist)
		{
			fact.setId(id);
			factService.updateFact(fact);
			return new ResponseEntity<>("Fact has been updated successsfully", HttpStatus.OK);
		}
		else
		{
			throw new FactNotfoundException();
		}

	}

	@GetMapping("/shortfact/{id}")
	public ResponseEntity<Object> getFact(@PathVariable("id") int id)
	{
		boolean isFactExist = factService.isFactExist(id);
		if (isFactExist)
		{
			String fact = factService.getFact(id);
			return new ResponseEntity<>(fact, HttpStatus.OK);
		}
		else
		{
			throw new FactNotfoundException();
		}

	}

	@GetMapping("/shortfacts")
	public ResponseEntity<Object> getFacts()
	{
		List<ShortFact> factList = factService.getFacts();
		return new ResponseEntity<>(factList, HttpStatus.OK);
	}
	@GetMapping("/shortfacts/{word}")
	public ResponseEntity<Object> findFacts(@PathVariable("word") String word)
	{
		List<ShortFact> factList = factService.findFact(word);
		return new ResponseEntity<>(factList, HttpStatus.OK);
	}
	 
	@GetMapping("/factprovider/{name}")
	public ResponseEntity<Object> findName(@PathVariable("name") String name)
	{
		List<ShortFact> factList = factService.findName(name);
		return new ResponseEntity<>(factList, HttpStatus.OK);
	}

	@DeleteMapping("/shortfacts/{id}")
	public ResponseEntity<Object> deleteFact(@PathVariable("id") int id)
	{
		boolean isFactExist = factService.isFactExist(id);
		if (isFactExist)
		{
			factService.deleteFact(id);
			return new ResponseEntity<>("Fact is deleted successsfully", HttpStatus.OK);
		}
		else
		{
			throw new FactNotfoundException();
		}

	}

}
