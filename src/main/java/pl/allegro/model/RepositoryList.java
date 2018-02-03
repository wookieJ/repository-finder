package pl.allegro.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.egit.github.core.Repository;

import pl.allegro.utils.RepositoryServiceUtil;

public class RepositoryList
{
	private List<Repository> repositoriesList;

	public List<Repository> getRepositoriesList()
	{
		return repositoriesList;
	}

	public void setRepositoriesList(List<Repository> repositories)
	{
		this.repositoriesList = repositories;
	}

	public RepositoryList(List<Repository> repositoriesList)
	{
		this.repositoriesList = repositoriesList;
	}

	public RepositoryList()
	{
		repositoriesList = new ArrayList<Repository>();
	}
	
	/**
	 * Zwraca informacjê o tym czy dany u¿ytkownik posiada repozytoria
	 * 
	 * @return true jeœli nie posiada, false jeœli posiada
	 */
	public boolean isEmpty()
	{
		return getRepositoriesList().isEmpty();
	}

	/**
	 * Pobiera wszystkie repozytoria z github
	 * 
	 * @param userName
	 *            Nazwa u¿ytkownika github
	 */
	public void getRepositories(String userName)
	{
		try
		{
			repositoriesList = RepositoryServiceUtil.getInstance().getRepositories(userName);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Metoda zwraca ostatnio modyfikowane repozytorium
	 * 
	 * @return ostatnio zmodyfikowane repozytorium
	 */
	public Repository getLatestUpdated()
	{
		if (getRepositoriesList().isEmpty() == false)
		{
			List<Repository> repositories = getRepositoriesList();
			// pobranie pierwszego elementu listy
			Repository lastUpdated = repositories.get(0);

			// szukanie w pêtli ostatnio modyfikowanego projektu
			for (Repository repo : repositories)
			{
				if (repo.getPushedAt().compareTo(lastUpdated.getPushedAt()) > 0)
					lastUpdated = repo;
			}

			return lastUpdated;
		}
		
		return null;
	}
}
