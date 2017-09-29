package com.uprightlaw.price.engine.test.resources;


import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.uprightlaw.price.engine.test.result.Result;
import com.uprightlaw.price.engine.test.service.PriceTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;



@Controller
@Path("/sample")
public class SampleController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

	/**
	 * Get data asset metadata
	 *
	 * @return
	 */
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Result<Map<String, Object>> check() {
		LOGGER.info("Check price engine now.");

		PriceTestService priceTestService = new PriceTestService();
		int flag = priceTestService.checkPrice();
		
		LOGGER.info("Check price engine over.");
		if(flag==0){
			Result result = new Result();
			result.setCode(0);
			result.setMsg("OK");
			return result;
		}else {
			Result result = new Result();
			result.setCode(1);
			result.setMsg("error");
			return result;
		}


	}

}