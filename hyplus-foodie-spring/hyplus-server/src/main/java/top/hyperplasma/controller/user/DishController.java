package top.hyperplasma.controller.user;

import org.springframework.data.redis.core.RedisTemplate;
import top.hyperplasma.constant.StatusConstant;
import top.hyperplasma.entity.Dish;
import top.hyperplasma.result.Result;
import top.hyperplasma.service.DishService;
import top.hyperplasma.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("userDishController")
@RequestMapping("/user/dish")
@Slf4j
@Api(tags = "菜品浏览接口")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据分类id查询菜品
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<DishVO>> list(Long categoryId) {
        // 构造Redis中的key：dish_{categoryId}
        String key = "dish_" + categoryId;

        // 查询Redis中是否有菜品数据（返回类型强转成与返回结果中的data一致）
        List<DishVO> list = (List<DishVO>) redisTemplate.opsForValue().get(key);
        if (list != null && !list.isEmpty()) {
            // 若存在则无需查询数据库，直接返回
            return Result.success(list);
        }

        // 若不存在则查询数据库
        Dish dish = new Dish();
        dish.setCategoryId(categoryId);
        dish.setStatus(StatusConstant.ENABLE);// 查询起售中的菜品
        list = dishService.listWithFlavor(dish);

        // 并将结果存入Redis中
        redisTemplate.opsForValue().set(key, list);

        return Result.success(list);
    }

}
