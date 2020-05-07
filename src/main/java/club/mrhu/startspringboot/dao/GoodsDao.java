package club.mrhu.startspringboot.dao;

import club.mrhu.startspringboot.model.GoodsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 商品数据访问类
 */

@Repository
public class GoodsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 新增
     */
    public int insertGoods(GoodsDo goods) {
        return jdbcTemplate.update("insert into goods(name, price, pic) values(?, ?, ?)", goods.getName(), goods.getPrice(), goods.getPic());
    }

    /**
     * 删除
     */
    public void deleteGoods(Long id) {
        jdbcTemplate.update("delete from goods where id=?", id);
    }

    /**
     * 更新
     */
    public void updateGoods(GoodsDo goods, Long id) {
        jdbcTemplate.update("update goods set name = ?, price = ?, pic = ? where id =?", goods.getName(), goods.getPrice(), goods.getPic(), id);
    }

    /**
     * 根据id查询
     */
    public GoodsDo findById(Long id) {
        return jdbcTemplate.queryForObject("select * from goods where id = ?", new RowMapper<GoodsDo>() {
            @Override
            public GoodsDo mapRow(ResultSet rs, int i) throws SQLException {
                GoodsDo goods = new GoodsDo();
                goods.setId(rs.getLong("id"));
                goods.setName(rs.getString("name"));
                goods.setPrice(rs.getString("price"));
                goods.setPic(rs.getString("pic"));
                return goods;
            }
        }, id);
    }

    /**
     * 查询全部
     */
    public List<GoodsDo> findAll() {
        return jdbcTemplate.query("select * from goods", (rs, i) -> {
            GoodsDo goods = new GoodsDo();
            goods.setId(rs.getLong("id"));
            goods.setName(rs.getString("name"));
            goods.setPrice(rs.getString("price"));
            goods.setPic(rs.getString("pic"));
            return goods;
        });
    }

}
