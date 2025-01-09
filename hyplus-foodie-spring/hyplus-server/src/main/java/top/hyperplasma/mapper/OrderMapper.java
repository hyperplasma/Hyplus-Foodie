package top.hyperplasma.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.hyperplasma.entity.Orders;

@Mapper
public interface OrderMapper {

    /**
     * 插入订单数据
     *
     * @param orders
     */
    void insert(Orders orders);
}
