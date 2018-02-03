package pl.allegro.utils;

import org.eclipse.egit.github.core.service.RepositoryService;

public class RepositoryServiceUtil
{
	private static RepositoryService service;

	/**
	 * Wzorzec singleton obiektu RepositoryService
	 * 
	 * @return instancja RepositoryService
	 */
	public static RepositoryService getInstance()
	{
		if (service == null)
		{
			service = new RepositoryService();
		}

		return service;
	}
}
