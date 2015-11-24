package br.com.bicicleta.test.add.peca;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

import br.com.bicicleta.controllers.PecaController;
import br.com.bicicleta.modelo.Peca;
import br.com.bicicleta.test.util.ListPecaTransformer;
import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class AddPecaStepsDefs {

	private PecaController pecaController = new PecaController();

	private Peca pecaResult;

	@Mock
	EntityManagerFactory factory;
	@Mock
	EntityManager manager;
	@Mock
	EntityTransaction entityTransaction;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(pecaController, "factory", factory);
		Mockito.when(factory.createEntityManager()).thenReturn(manager);
		Mockito.when(manager.getTransaction()).thenReturn(entityTransaction);

		Mockito.doAnswer(new Answer<Object>() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				pecaResult = (Peca) invocation.getArguments()[0];
				return null;
			}
		}).when(manager).persist(Mockito.any(Object.class));
	}

	@Quando("^for requisitada a insercao de pecas para adicionar a seguinte \"([^\"]*)\"$")
	public void for_requisitada_a_insercao_de_pecas_para_adicionar_a_seguinte(@Transform(ListPecaTransformer.class) List<Peca> pecas) throws Throwable {
		Peca pecaToInsert = null;
		if (!pecas.isEmpty()) {
			pecaToInsert = pecas.get(0);
		} 
		pecaController.cadastraPeca(pecaToInsert);
	}

	@Entao("^sera inserida a \"([^\"]*)\"$")
	public void sera_inserida_a(@Transform(ListPecaTransformer.class) List<Peca> pecasExpected) throws Throwable {
		if(!pecasExpected.isEmpty()) {
			Assert.assertEquals(pecasExpected.get(0), pecaResult);
		} else {
			Assert.assertNull(pecaResult);
		}
	}
}
