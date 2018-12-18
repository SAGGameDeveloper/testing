package Bolsa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static org.mockito.Mockito.*;

import java.math.BigDecimal;
public class StockBrokerTest {

	@Test
	public void testPerform() {
		AnalistaMercado mercado = mock(AnalistaMercado.class);
		Portfolio portfolio = new Portfolio();
		StockBroker stockBroker = new StockBroker(mercado);
		BigDecimal decimal = new BigDecimal("1390");
		BigDecimal decimal2 = new BigDecimal("1400");
		Stock stock = new Stock("fruta", "fruta",decimal);
		Stock stock2 = new Stock("fruta", "fruta", decimal2);
		portfolio.comprar(stock2);
		when(mercado.getCotizacion(anyString())).thenReturn(stock2);
		
		stockBroker.perform(portfolio, stock);
		BigDecimal decimal3 = new BigDecimal("2790");
		assertEquals(decimal3, portfolio.getValorActual());
	}

}
