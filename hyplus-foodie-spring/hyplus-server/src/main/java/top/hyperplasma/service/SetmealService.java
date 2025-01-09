package top.hyperplasma.service;

import top.hyperplasma.dto.SetmealDTO;
import top.hyperplasma.dto.SetmealPageQueryDTO;
import top.hyperplasma.entity.Setmeal;
import top.hyperplasma.result.PageResult;
import top.hyperplasma.vo.DishItemVO;
import top.hyperplasma.vo.SetmealVO;

import java.util.List;

public interface SetmealService {

    /**
     * 新增套餐，同时保存套餐与菜品的关联关系
     *
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);

    /**
     * 套餐分页查询
     *
     * @param setmealPageQueryDTO
     * @return PageResult
     */
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 套餐批量删除
     *
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据套餐id查询套餐和关联的菜品信息
     *
     * @param id
     * @return SetmealVO
     */
    SetmealVO getByIdWithDish(Long id);

    /**
     * 修改套餐
     *
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);

    /**
     * 套餐起售/停售
     *
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 条件查询
     *
     * @param setmeal
     * @return List<Setmeal>
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据套餐id查询菜品选项
     *
     * @param id
     * @return List<DishItemVO>
     */
    List<DishItemVO> getDishItemById(Long id);
}
