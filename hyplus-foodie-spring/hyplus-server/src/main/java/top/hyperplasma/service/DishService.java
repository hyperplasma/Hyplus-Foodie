package top.hyperplasma.service;

import top.hyperplasma.dto.DishDTO;
import top.hyperplasma.dto.DishPageQueryDTO;
import top.hyperplasma.entity.Dish;
import top.hyperplasma.result.PageResult;
import top.hyperplasma.vo.DishVO;

import java.util.List;

public interface DishService {

    /**
     * 新增菜品和对应的口味
     *
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * 菜品分页查询
     *
     * @param dishPageQueryDTO
     * @return PageResult
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品批量删除
     *
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id查询菜品和对应的口味
     *
     * @param id
     * @return DishVO
     */
    DishVO getByIdWithFlavor(Long id);

    /**
     * 修改菜品和对应的口味
     *
     * @param dishDTO
     */
    void updateWithFlavor(DishDTO dishDTO);

    /**
     * 根据分类id查询菜品
     *
     * @param categoryId
     * @return List<Dish>
     */
    List<Dish> list(Long categoryId);

    /**
     * 菜品起售/停售
     *
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 条件查询菜品和口味
     *
     * @param dish
     * @return
     */
    List<DishVO> listWithFlavor(Dish dish);
}
