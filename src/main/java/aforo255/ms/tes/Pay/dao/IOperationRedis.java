package aforo255.ms.tes.Pay.dao;

import java.util.Map;
import aforo255.ms.tes.Pay.domain.OperationRedis;

public interface IOperationRedis {

	void save(OperationRedis operation);
	Map<String, OperationRedis> findAll();
	OperationRedis findById(String id);	
	void update(OperationRedis operation);
	void delete(String id);
}
