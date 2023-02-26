package com.viji.service;

import java.util.List;

import com.viji.model.ShortFact;

public interface ShortFactService
{
	public abstract ShortFact createFact(ShortFact fact);

	public abstract void updateFact(ShortFact fact);
	
	public abstract String getFact(int id);
	
	public abstract List<ShortFact> getFacts();
	
	public abstract void deleteFact(int id);
	
	public abstract List<ShortFact> findFact(String word);
	
	public abstract List<ShortFact> findName(String name);
	
	public abstract boolean isFactExist(int id);
}
