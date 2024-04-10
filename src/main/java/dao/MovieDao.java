package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;
import dto.Movie;


public class MovieDao {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("anu");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();

	public void saveMovie(Movie movie) {
		transaction.begin();
		manager.persist(movie);
		transaction.commit();
	}
	
	public List<Movie> fetchMovies(){
		return manager.createNativeQuery("select x from movie x").getResultList();
	}
}