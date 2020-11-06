package com.transample.demo.service.impl;

import com.transample.demo.domain.TaoInterface;
import com.transample.demo.domain.TaoInterfaceExample;
import com.transample.demo.mapper.TaoInterfaceMapper;
import com.transample.demo.service.ITaoInterfaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaoInterfaceServiceImpl implements ITaoInterfaceService {
    @Resource
    private TaoInterfaceMapper taoInterfaceDao;

    @Override
    public String getInterfaceId(String controller, String method) {
        TaoInterfaceExample example = new TaoInterfaceExample();
        TaoInterfaceExample.Criteria criteria = example.createCriteria();
        criteria.andControllerEqualTo(controller);
        criteria.andMethodNameEqualTo(method);

        List<TaoInterface> list = taoInterfaceDao.selectByExample(example);

        if(list.size()==0)return null;
        return list.get(0).getInterfaceId();

    }
}
