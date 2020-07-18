package aforo255.ms.tes.Pay.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aforo255.ms.tes.Pay.domain.Operation;
import aforo255.ms.tes.Pay.domain.OperationRedis;
import aforo255.ms.tes.Pay.producer.PagarEventProducer;
import aforo255.ms.tes.Pay.service.IOperationService;
import com.fasterxml.jackson.core.JsonProcessingException;
@RestController
public class PagoEventController {

	
	private Logger log = LoggerFactory.getLogger(PagoEventController.class);
	
	@Autowired
	PagarEventProducer pagarproducer;
	
	@Autowired
	private IOperationService operationser;
	
	@PostMapping("/v1/pagoevent")
    public ResponseEntity<Operation> postDepositEvent(@RequestBody Operation transacionEvent) throws JsonProcessingException{
		
		log.info("antes sql ");		
		Operation tranSql= operationser.save(transacionEvent);
		log.info("despues sql ");
		log.info("antes sendDepositEvent");
		pagarproducer.sendDepositEvent(tranSql);
		log.info("despues sendDepositEvent");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tranSql);		
		
	}
	 @GetMapping("/all")
	    public Map<String, OperationRedis> all() {
	        return operationser.findAll();
	    }

}
