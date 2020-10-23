package com.transample.demo.service.impl;

import java.util.List;

import com.transample.demo.domain.TaoShoppingCart;
import com.transample.demo.mapper.TaoShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transample.demo.mapper.TaoVillagerMapper;
import com.transample.demo.domain.TaoVillager;
import com.transample.demo.service.ITaoVillagerService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;

/**
 * 村民 服务层实现
 *
 * @author youcaihua
 * @date 2020-10-13
 */
@Service
public class TaoVillagerServiceImpl implements ITaoVillagerService {
    @Resource
    private TaoVillagerMapper taoVillagerMapper;

    @Resource
    private TaoShoppingCartMapper taoShoppingCartMapper;

    @Override
    public TaoVillager getTaoVillagerById(Integer villagerId) {
        return taoVillagerMapper.selectTaoVillagerById(villagerId);
    }

    @Override
    public List<TaoVillager> getTaoVillagerList(TaoVillager taoVillager) {
        return taoVillagerMapper.selectTaoVillagerList(taoVillager);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertTaoVillager(TaoVillager taoVillager) {
        try {
            taoVillagerMapper.insertTaoVillager(taoVillager);

            TaoShoppingCart cart = new TaoShoppingCart();
            cart.setVillagerId(taoVillager.getVillagerId());
            taoShoppingCartMapper.insertTaoShoppingCart(cart);
//		cart = taoShoppingCartMapper.selectTaoShoppingCartList(cart).get(0);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateTaoVillager(TaoVillager taoVillager) {
        return taoVillagerMapper.updateTaoVillager(taoVillager);
    }

    @Override
    public int deleteTaoVillagerByIds(String ids) {
        return taoVillagerMapper.deleteTaoVillagerByIds(ids.split(","));
    }

    @Override
    public ModelMap login(TaoVillager taoVillager) {
        ModelMap map = new ModelMap();
        TaoVillager villager = new TaoVillager();
        villager.setUserName(taoVillager.getUserName());
        List<TaoVillager> villagers = taoVillagerMapper.selectTaoVillagerList(villager);
        try {

            if (villagers.size() == 1 && villagers.get(0).getPassword().equals(taoVillager.getPassword())) {
                map.put("villager", villagers.get(0));
                TaoShoppingCart cart = new TaoShoppingCart();
                cart.setVillagerId(villagers.get(0).getVillagerId());
                map.put("cart", taoShoppingCartMapper.selectTaoShoppingCartList(cart).get(0));
                return map;
            } else {
                return null;
            }
        }catch (Exception e)
        {
            return null;
        }
    }

}
