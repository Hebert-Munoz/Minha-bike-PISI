package br.com.bicicleta.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BikeSystem {

	public EntityManagerFactory getConnectionFactory() {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://ec2-54-243-132-114.compute-1.amazonaws.com:5432/d1c1m15i9kltc3"/* "jdbc:postgresql://localhost:5432/DB_Bicicleta" */);
		properties.put("javax.persistence.jdbc.user", "tnldttykeaitlw" /*"postgres" */);
		properties.put("javax.persistence.jdbc.password", "1e0f40E0n0KD6NtXP8EXOWYFt8"/* "hewlett" */);
		properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return Persistence.createEntityManagerFactory("default", properties);
	}
	
}
