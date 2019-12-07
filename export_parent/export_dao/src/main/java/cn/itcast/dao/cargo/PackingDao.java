package cn.itcast.dao.cargo;

import cn.itcast.domain.cargo.Packing;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PackingDao {
    List<Packing> findAll(String companyId);

    void save(Packing packing);

    void update(Packing packing);

    Packing findById(String packingListId);

    List<Packing> findByState(@Param("state") Integer state, @Param("companyId") String companyId);

    void delete(String packingListId);
}
