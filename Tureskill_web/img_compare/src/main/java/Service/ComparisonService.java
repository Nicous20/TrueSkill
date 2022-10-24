package Service;

import Dao.Comparison;
import Utils.SqlSessionFactoryUtils;
import mapper.ComparisonMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ComparisonService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public void add(Comparison comparison) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ComparisonMapper comparisonMapper = sqlSession.getMapper(ComparisonMapper.class);
        comparisonMapper.add(comparison);

        sqlSession.commit();
        sqlSession.close();
    }
}
