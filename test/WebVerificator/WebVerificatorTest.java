package C;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class WebVerificatorTest {

	private WebVerificator verificator;
	
	private Server server = mock(Server.class);
	private Web web = mock(Web.class);
	private Logger log = mock(Logger.class);
	private Result result = mock(Result.class);
	
	@Before
	public void setup() {
		verificator = new WebVerificator(log);
		
		when(server.connect(web)).thenReturn(result);
	}
	
	@Test
	public void testWebOkay() {
		when(result.isOk()).thenReturn(true);
		
		verificator.checkWeb(server, web);
		
		verify(log).registerWebisOk(web);		
		verify(log, never()).registerWebReturnedError(any(Web.class), any(Result.class));	
	}
	
	@Test
	public void testWebError() {
		when(result.isOk()).thenReturn(false);
		
		verificator.checkWeb(server, web);
		
		verify(log).registerWebReturnedError(web, result);	
		verify(log, never()).registerWebisOk(any(Web.class));	
	}

}
