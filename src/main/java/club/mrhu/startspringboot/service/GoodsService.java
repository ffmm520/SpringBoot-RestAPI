package club.mrhu.startspringboot.service;

import club.mrhu.startspringboot.dao.GoodsDao;
import club.mrhu.startspringboot.model.GoodsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao;
    /**
     * 获取商品列表
     * @return 商品列表
     */
    public List<GoodsDo> getGoodsList() {
        /*List<GoodsDo> goodsList = new ArrayList<>();
        GoodsDo goods = new GoodsDo();
        goods.setId(1L);
        goods.setName("苹果");
        goods.setPrice("8.8");
        goods.setPic("apple.png");
        goodsList.add(goods);
        return goodsList;*/
       return goodsDao.findAll();
    }

    /**
     * 根据商品id查询商品信息
     * @param id 商品id
     * @return 商品详细信息
     */
    public GoodsDo getGoodsById(Long id) {
        /*GoodsDo goods = new GoodsDo();
        goods.setId(id);
        goods.setName("苹果");
        goods.setPic("apple.jpg");
        goods.setPrice("3.5");*/
        GoodsDo goods = goodsDao.findById(id);
        if (goods.getId() != null) {
            return goods;
        }
        return null;
    }

    /**
     * 添加商品
     * @param goods 商品信息
     * @return 商品信息
     */
    public GoodsDo addGoods(GoodsDo goods) {
        int result = goodsDao.insertGoods(goods);
        if (result == 1) {
            return goods;
        }
        return null;
    }

    /**
     * 修改商品
     * @param id 商品id
     * @return 被修改商品id
     */
    public GoodsDo editGoods(Long id, GoodsDo goods) {
        GoodsDo dbGoods = goodsDao.findById(id);
        if (dbGoods.getId() != null) {
            goodsDao.updateGoods(goods,id);
        }
        return goods;
    }

    /**
     * 删除商品
     * @param id 商品id
     * @return 被删除商品id
     */
    public Long removeGoods(Long id) {
        goodsDao.deleteGoods(id);
        return id;
    }
}
