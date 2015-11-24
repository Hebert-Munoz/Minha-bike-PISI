package br.com.bicicleta.test.peca;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;

import br.com.bicicleta.controllers.PecaController;
import br.com.bicicleta.modelo.Peca;
import br.com.bicicleta.test.util.ListPecaTransformer;
import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ListaPecaStepsDefs {

	private PecaController pecaController = new PecaController();
	
	List<Peca> pecasDB;
	List<Peca> pecasResult;
	
	@Mock
	EntityManagerFactory factory;
	@Mock
	EntityManager manager;
	
	@Mock
	Query query;
	
	@Mock
	Model model;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(pecaController, "factory", factory);
		Mockito.when(factory.createEntityManager()).thenReturn(manager);
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		
		Mockito.doAnswer(new Answer<Object>() {

			@SuppressWarnings("unchecked")
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				pecasResult = (List<Peca>) invocation.getArguments()[1];
				return null;
			}
		}).when(model).addAttribute(Mockito.anyString(), Mockito.any(List.class));
		
	}
	
	@Dado("^que o banco de dados possua as seguintes \"([^\"]*)\"$")
	public void que_o_banco_de_dados_possua_as_seguintes(@Transform(ListPecaTransformer.class) List<Peca> pecas) throws Throwable {
		pecasDB = pecas;
		Mockito.when(query.getResultList()).thenReturn(pecasDB);
	}

	@Quando("^for requisitada a listagem de pecas$")
	public void for_requisitada_a_listagem_de_pecas() throws Throwable {
		pecaController.buscaPeca(model);
	}

	@Entao("^serao retornadas as seguintes \"([^\"]*)\"$")
	public void serao_retornadas_as_seguintes(@Transform(ListPecaTransformer.class) List<Peca> pecasExpected) throws Throwable {
		Assert.assertEquals(pecasExpected, pecasResult);
	}
	
}
