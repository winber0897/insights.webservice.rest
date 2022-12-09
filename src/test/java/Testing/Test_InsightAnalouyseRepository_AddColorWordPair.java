package Testing;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.*;

import org.junit.Test;

import com.insights.webservice.insights.webservice.rest.core.IInsightAnalyseRepository;
import com.insights.webservice.insights.webservice.rest.core.InsightAnalyse;
import com.insights.webservice.insights.webservice.rest.core.InsightAnalyseRepository;
import com.insights.webservice.insights.webservice.rest.core.InsightConfig;
import org.mockito.*;

public class Test_InsightAnalouyseRepository_AddColorWordPair {
	
	@Test
	public void test() {
		InsightConfig config;
		
		//when(true).thenReturn(false);
		
		//given(true).willReturn(true);
		
		// assign
		IInsightAnalyseRepository insightAnalyseRepo = new InsightAnalyseRepository(mock(InsightConfig.class));
		boolean colorWasAdd = insightAnalyseRepo.addColorWordPair("gruen", "vielleicht");
		
		assertFalse(colorWasAdd);
		//fail("Not yet implemented");
	}


}
