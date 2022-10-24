package mapper;
import Dao.Comparison;
import org.apache.ibatis.annotations.Param;

public interface ComparisonMapper {
    void add(@Param("comparison") Comparison comparison);
}
