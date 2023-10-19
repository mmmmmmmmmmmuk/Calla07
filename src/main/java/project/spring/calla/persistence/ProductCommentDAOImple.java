package project.spring.calla.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.spring.calla.domain.ProductCommentVO;

@Repository
public class ProductCommentDAOImple implements ProductCommentDAO {
	
	private static final Logger logger =
			LoggerFactory.getLogger(ProductCommentDAOImple.class);
	
	private static final String NAMESPACE =
			"project.spring.calla.ProductCommentMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ProductCommentVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ProductCommentVO> select(int productId) {
		logger.info("select() 호출 : productId = " + productId);
		return sqlSession.selectList(NAMESPACE + ".select_all_by_product_id", productId);
	}

	@Override
	public int update(int productCommentId, String productCommentContent) {
		logger.info("update() 호출");
		logger.info("productCommentId = " + productCommentId + ", productCommentContent = " + productCommentContent);
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("productCommentId", productCommentId);
		args.put("productCommentContent", productCommentContent);
		return sqlSession.update(NAMESPACE + ".update", args);
	}

	@Override
	public int delete(int productCommentId) {
		logger.info("delete() 호출 : productCommentId = " + productCommentId);
		return sqlSession.delete(NAMESPACE + ".delete", productCommentId);
	}

}
