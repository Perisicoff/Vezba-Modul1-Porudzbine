package DAO;

import java.util.Collection;

import Model.Proizvod;

public interface ProizvodDAO {

	public Collection<Proizvod> getAll() throws Exception;
}
