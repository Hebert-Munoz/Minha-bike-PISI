package br.com.bicicleta.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bicicleta.modelo.Bicicleta;
import br.com.bicicleta.modelo.Comentario;
import br.com.bicicleta.modelo.Peca;

@Controller
public class BicicletaController extends BikeSystem {

	EntityManagerFactory factory;

	@SuppressWarnings("unchecked")
	@RequestMapping("buscabicicleta")
	public String buscaBicicleta(Model model){

		List<Bicicleta> bicicletas = null;

		EntityManagerFactory factory = getFactory();
		EntityManager manager = factory.createEntityManager();

		bicicletas = (List<Bicicleta>) manager.createQuery("select p from Bicicleta p").getResultList();
		model.addAttribute("bicicletas",bicicletas);
		return "bicicleta/buscabicicleta";
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


	@SuppressWarnings("unchecked")
	@RequestMapping("formbicicleta")
	public String formBicicleta(Model model){

		List<Peca> bancos = null;
		List<Peca> cambios = null;
		List<Peca> guidaos = null;
		List<Peca> quadros = null;
		List<Peca> rodas = null;

		EntityManagerFactory factory = getFactory();
		EntityManager manager = factory.createEntityManager();

		bancos = (List<Peca>) manager.createQuery(
				"select p from Peca p where p.tipo = :banco").setParameter("banco", "Banco")
				.getResultList();


		quadros = (List<Peca>) manager.createQuery(
				"select p from Peca p where p.tipo = :quadro").setParameter("quadro", "Quadro")
				.getResultList();

		cambios = (List<Peca>) manager.createQuery(
				"select p from Peca p where p.tipo = :cambio").setParameter("cambio", "Cambio")
				.getResultList();

		guidaos = (List<Peca>) manager.createQuery(
				"select p from Peca p where p.tipo = :guidao").setParameter("guidao", "Guidao")
				.getResultList();


		rodas = (List<Peca>) manager.createQuery(
				"select p from Peca p where p.tipo = :roda").setParameter("roda", "Rodas")
				.getResultList();

		model.addAttribute("cambios", cambios);
		model.addAttribute("bancos", bancos);
		model.addAttribute("guidaos", guidaos);
		model.addAttribute("rodas", rodas);
		model.addAttribute("quadros", quadros);

		return "bicicleta/formbicicleta";

	}

	@RequestMapping("cadastrabicicleta")
	public String cadastraBicicleta(Bicicleta bicicleta, Model model, Long bancoId, Long rodasId, Long guidaoId,
			Long quadroId, Long cambioId) {

		Peca banco;
		Peca quadro;
		Peca guidao;
		Peca cambio;
		Peca rodas;

		EntityManagerFactory factory = getFactory();
		EntityManager manager = factory.createEntityManager();

		banco = manager.find(Peca.class, bancoId);
		quadro = manager.find(Peca.class, quadroId);
		guidao = manager.find(Peca.class, guidaoId);
		cambio = manager.find(Peca.class, cambioId);
		rodas =  manager.find(Peca.class, rodasId);

		List<Peca> pecas = new ArrayList<Peca>();

		pecas.add(banco);
		pecas.add(quadro);
		pecas.add(guidao);
		pecas.add(cambio);
		pecas.add(rodas);

		bicicleta.setPecas(pecas);

		manager.getTransaction().begin();    
		manager.persist(bicicleta);
		manager.getTransaction().commit();  

		return "redirect:showbicicleta?id="+bicicleta.getId()+"&cn=true";
	}


	@RequestMapping("showbicicleta")
	public String showBicicleta(Model model, Long id, boolean cn) {

		EntityManagerFactory factory = getFactory();
		EntityManager manager = factory.createEntityManager();

		Bicicleta bicicleta = manager.find(Bicicleta.class, id);

		model.addAttribute("bicicleta", bicicleta);

		if(cn == true){

			model.addAttribute("cn",cn);
		}

		model.addAttribute("comentarios",bicicleta.getComentarios());

		return "bicicleta/bicicletacadastrada";	
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("buscabicicletaresultado")
	public String buscaBicicletaResultado(String nome, Model model) {

		List<Bicicleta> bicicletas = null;

		EntityManagerFactory factory = getFactory();
		EntityManager manager = factory.createEntityManager();

		bicicletas = (List<Bicicleta>) manager.createQuery("select p from Bicicleta p where lower(p.nome) like '%"+nome.toLowerCase()+"%'").getResultList();

		model.addAttribute("bicicletas",bicicletas);

		return "bicicleta/resultadobicicletaBusca";
	}
	
	@RequestMapping("gravacomentario")
	public String gravaComentario(Comentario comentario, Long idBicicleta) {

		EntityManagerFactory factory = getFactory();
		EntityManager manager = factory.createEntityManager();

		Bicicleta bicicleta = manager.find(Bicicleta.class, idBicicleta);	  

		List<Comentario> comentarios = bicicleta.getComentarios();

		comentarios.add(comentario);

		bicicleta.setComentarios(comentarios);

		manager.getTransaction().begin();
		manager.persist(comentario);
		manager.getTransaction().commit();

		manager.getTransaction().begin();    

		manager.merge(bicicleta);
		manager.getTransaction().commit(); 

		manager.close();

		return "redirect:showbicicleta?id="+bicicleta.getId()+"&cn=false";
	}

}
