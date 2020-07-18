package aforo255.ms.tes.Pay.service;
import java.util.Map;

import aforo255.ms.tes.Pay.domain.Operation;
import aforo255.ms.tes.Pay.domain.OperationRedis;



public interface IOperationService {

	
	public Operation findById(Integer id );
	public Operation save(Operation transaction);
	
	
	public OperationRedis findByIdRedis(String id);
	public void save(OperationRedis operation);
	public Map<String,OperationRedis> findAll();
	
}
