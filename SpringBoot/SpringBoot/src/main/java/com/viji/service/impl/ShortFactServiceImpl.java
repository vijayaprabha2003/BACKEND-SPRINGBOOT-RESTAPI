package com.viji.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viji.model.ShortFact;
import com.viji.repository.ShortFactRepository;
import com.viji.service.ShortFactService;

@Service
public class ShortFactServiceImpl implements ShortFactService
{

	@Autowired
	private ShortFactRepository factRepository;

	@Override
	public ShortFact createFact(ShortFact fact)
	{
		return factRepository.save(fact);
	}

	@Override
	public void updateFact(ShortFact fact)
	{
		factRepository.save(fact);
	}
	
	@Override
	public String getFact(int id) 
	{
		Optional<ShortFact> optional = factRepository.findById(id);
		ShortFact fact = optional.get();
		return fact.toString();
	}

	@Override
	public List<ShortFact> getFacts()
	{
		return (List<ShortFact>)factRepository.findAll();
	}

	@Override
	public void deleteFact(int id)
	{
		factRepository.deleteById(id);
	}

	@Override
	public boolean isFactExist(int id)
	{
		return factRepository.existsById(id);
	}
	
	@Override
	public List<ShortFact> findFact(String word) {
		return (List<ShortFact>) factRepository.findByDescriptionContainingIgnoreCase(word);
	}
	
	@Override
	public List<ShortFact> findName(String name) {
		return (List<ShortFact>) factRepository.findByNameContainingIgnoreCase(name);
	}
}
