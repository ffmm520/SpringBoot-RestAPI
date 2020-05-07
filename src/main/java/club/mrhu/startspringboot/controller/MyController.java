package club.mrhu.startspringboot.controller;

import club.mrhu.startspringboot.model.GoodsDo;
import club.mrhu.startspringboot.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "restful 基本api")
@RestController
public class MyController {
    @Autowired
    GoodsService goodsService;

    @ApiOperation(value = "查询全部商品")
    @GetMapping("/list")
    public List<GoodsDo> getGoodsList() {
        return goodsService.getGoodsList();
    }

    @ApiOperation(value = "根据id查询商品")
    @GetMapping("/list/{id}")
    public GoodsDo getGoodsById(@PathVariable("id") Long id) {
        return goodsService.getGoodsById(id);
    }

    @ApiOperation(value = "添加商品")
    @PostMapping("/list")
    public GoodsDo addGoods(@RequestBody GoodsDo goods) {
        return goodsService.addGoods(goods);
    }

    @ApiOperation(value = "根据id修改商品")
    @PutMapping("/list/{id}")
    public GoodsDo editGoods(@PathVariable("id") Long id, @RequestBody GoodsDo goods) {
        return goodsService.editGoods(id, goods);
    }

    @ApiOperation(value = "根据id删除商品")
    @DeleteMapping("/list/{id}")
    public Long removeGoods(@PathVariable("id") Long id) {
        return goodsService.removeGoods(id);
    }
}
