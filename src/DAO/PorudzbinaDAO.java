package DAO;

import java.util.Collection;

import Model.Porudzbina;

public interface PorudzbinaDAO {

	public Collection<Porudzbina> getAll() throws Exception;
	public void add(Porudzbina Porudzbina) throws Exception;
}
