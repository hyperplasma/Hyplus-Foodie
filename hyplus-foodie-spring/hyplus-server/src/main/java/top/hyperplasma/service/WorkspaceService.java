package top.hyperplasma.service;

import top.hyperplasma.vo.BusinessDataVO;
import top.hyperplasma.vo.DishOverViewVO;
import top.hyperplasma.vo.OrderOverViewVO;
import top.hyperplasma.vo.SetmealOverViewVO;

import java.time.LocalDateTime;

public interface WorkspaceService {

    /**
     * 根据时间段统计营业数据
     *
     * @param begin
     * @param end
     * @return BusinessDataVO
     */
    BusinessDataVO getBusinessData(LocalDateTime begin, LocalDateTime end);

    /**
     * 查询订单管理数据
     *
     * @return OrderOverViewVO
     */
    OrderOverViewVO getOrderOverView();

    /**
     * 查询菜品总览
     *
     * @return DishOverViewVO
     */
    DishOverViewVO getDishOverView();

    /**
     * 查询套餐总览
     *
     * @return SeatmealOverViewVO
     */
    SetmealOverViewVO getSetmealOverView();

}
