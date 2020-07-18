package aforo255.ms.tes.Pay.service;





import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aforo255.ms.tes.Pay.dao.IOperationRedis;
import aforo255.ms.tes.Pay.dao.OperationDao;
import aforo255.ms.tes.Pay.domain.Operation;
import aforo255.ms.tes.Pay.domain.OperationRedis;


@Service
public class IOperationServiceImpl implements IOperationService {

	
	@Autowired
	private OperationDao transactionDao;

	
	@Autowired
	private IOperationRedis operationredisDao;
	
	@Override
	@Transactional(readOnly = true)
	public Operation findById(Integer id) {
		return transactionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Operation save(Operation transaction) {
				return transactionDao.save(transaction);
	}

	@Override
	public OperationRedis findByIdRedis(String id) {
		return  operationredisDao.findById(id);
	}

	@Override
	public void save(OperationRedis operation) {
		// TODO Auto-generated method stub
		 operationredisDao.save(operation);
	}

	@Override
	public Map<String, OperationRedis> findAll() {
		// TODO Auto-generated method stub
		return operationredisDao.findAll();
	}

	

}
