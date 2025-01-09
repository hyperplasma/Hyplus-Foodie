package top.hyperplasma.service;

import top.hyperplasma.dto.OrdersSubmitDTO;
import top.hyperplasma.vo.OrderSubmitVO;

public interface OrderService {

    /**
     * 用户下单
     * @param ordersSubmitDTO
     * @return OrderSubmitVO
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
}
