package pl.allegro.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.allegro.model.RepositoryList;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("")
public class HomeController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("inputUsername");
		RepositoryList repoList = new RepositoryList();

		if (username != null)
		{
			repoList.getRepositories(username);
			if (repoList.isEmpty())
			{
				request.setCharacterEncoding("UTF-8");
				request.setAttribute("repo", "brak u¿ytkownika!");
			}
			else
			{
				String lastRepo = repoList.getLatestUpdated().getName();
				request.setAttribute("repo", lastRepo);
			}

		}
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("repo.jsp").forward(request, response);
	}
}
