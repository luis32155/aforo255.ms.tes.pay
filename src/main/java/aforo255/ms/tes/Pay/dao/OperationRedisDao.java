package aforo255.ms.tes.Pay.dao;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import aforo255.ms.tes.Pay.domain.OperationRedis;

@Repository
public class OperationRedisDao implements IOperationRedis {

	@Autowired
	private RedisTemplate<String,OperationRedis> redistemplate;
	
	private HashOperations hashoperation;
	
	@PostConstruct
	private void init() {
		hashoperation = redistemplate.opsForHash();
	}
	
	
	@Override
	public void save(OperationRedis operation) {
		hashoperation.put("OPERATION", operation.getId(),operation);
		
	}

	@Override
	public Map<String, OperationRedis> findAll() {
		// TODO Auto-generated method stub
		  return hashoperation.entries("OPERATION");
	}

	@Override
	public OperationRedis findById(String id) {
		// TODO Auto-generated method stub
		return (OperationRedis)hashoperation.get("OPERATION", id);
	}

	@Override
	public void update(OperationRedis operation) {
		// TODO Auto-generated method stub
		save(operation);
	}

	@Override
	public void delete(String id) {
		hashoperation.delete("OPERATION", id);
		
	}
	
	

}
