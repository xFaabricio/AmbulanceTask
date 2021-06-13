
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.project.models.Group;
import br.com.project.models.User;
import br.com.project.user.GroupRepositoryBean;

public class Teste {

	static GroupRepositoryBean groupRepositoryBean;

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exampleSystem");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		
		User user = new User();
		Group group = new Group();
		
		group.setName("USER");
		group.setDescription("Usuario");
		manager.persist(group);

		group.setName("ADMINISTRATOR");
		group.setDescription("Administrador do sistema");
		manager.persist(group);
		
		user.setLogin("MASTER");
		user.setPassword("MASTER");
		user.setEmail("master@exampleSystem.com");
		user.setName("Sr. Master");
		user.setGroup(groupRepositoryBean.findGroupByName("ADMINISTRATOR"));
		manager.persist(user);
		
		
		trx.commit();
		
	}
	
}
