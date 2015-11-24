package br.com.bicicleta.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BikeSystem {

	public EntityManagerFactory getConnectionFactory() {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/DB_Bicicleta");
		properties.put("javax.persistence.jdbc.user", "postgres");
		properties.put("javax.persistence.jdbc.password", "hewlett");
		properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return Persistence.createEntityManagerFactory("default", properties);
	}
	
}
