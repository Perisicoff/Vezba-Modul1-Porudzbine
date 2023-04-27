package DAO;

import java.util.Collection;

import Model.Proizvod;

public interface ProizvodDAO {

	public Proizvod get(long id) throws Exception;
	public Collection<Proizvod> getAll() throws Exception;
}
