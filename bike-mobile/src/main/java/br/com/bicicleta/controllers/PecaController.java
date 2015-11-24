package br.com.bicicleta.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bicicleta.modelo.Peca;

@Controller
public class PecaController extends BikeSystem {

	EntityManagerFactory factory;

	@RequestMapping("formpeca")
	public String formPeca() {
		return "peca/form_peca";
	}

	@RequestMapping("CadastraPeca")
	public String cadastraPeca(Peca peca) {
		EntityManagerFactory factory = getFactory();
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();    
		manager.persist(peca);
		manager.getTransaction().commit();  

		manager.close();

		return "redirect:detalhepeca?id="+peca.getId();
	}


	@SuppressWarnings("unchecked")
	@RequestMapping("buscapeca")
	public String buscaPeca(Model model){
		List<Peca> pecas = null;

		EntityManagerFactory factory = getFactory();
		EntityManager manager = factory.createEntityManager();
		pecas = (List<Peca>) manager.createQuery("select p from Peca p").getResultList();

		model.addAttribute("pecas",pecas);

		return "peca/busca";

	}

	private EntityManagerFactory getFactory() {
		if (factory == null) {
//			String databaseUrl = System.getenv("DATABASE_URL");
//			StringTokenizer st = new StringTokenizer(databaseUrl, ":@/");
//			String dbVendor = st.nextToken(); //if DATABASE_URL is set
//			String userName = st.nextToken();
//			String password = st.nextToken();
//			String host = st.nextToken();
//			String port = st.nextToken();
//			String databaseName = st.nextToken();
//			String jdbcUrl = String.format("jdbc:postgresql://%s:%s/%s?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", host, port, databaseName);
//			Map<String, String> properties = new HashMap<String, String>();
//			properties.put("javax.persistence.jdbc.url", /*"jdbc:postgresql://ec2-54-243-132-114.compute-1.amazonaws.com:5432/d1c1m15i9kltc3"*/"jdbc:postgresql://localhost:5432/DB_Bicicleta" );
//			properties.put("javax.persistence.jdbc.user", /*"tnldttykeaitlw" */"postgres" );
//			properties.put("javax.persistence.jdbc.password", /*"1e0f40E0n0KD6NtXP8EXOWYFt8"*/ "hewlett" );
//			properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
//			properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//			factory = Persistence.createEntityManagerFactory("default", properties);
			factory = getConnectionFactory();
		}
		return factory;
	}

	@RequestMapping("detalhepeca")
	public String show(Long id, Model model) {
		EntityManagerFactory factory = getFactory();
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Peca peca = entityManager.find(Peca.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		model.addAttribute("peca",peca);
		return 	"peca/detalhepeca";
	}

	@RequestMapping("home")
	public void home() {

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buscapecaresultado")
	public String buscaPeca(String nome, Model model) {

		List<Peca> pecas = null;

		EntityManagerFactory factory = getFactory();
		EntityManager manager = factory.createEntityManager();

		pecas = (List<Peca>) manager.createQuery("select p from Peca p where lower(p.nome) like '%"+nome.toLowerCase()+"%'").getResultList();

		model.addAttribute("pecas",pecas);

		return "peca/resultadoBusca";
	}

}
	