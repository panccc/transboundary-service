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
    public String getInterfaceId(String uri) {

        String tmp = uri;
        TaoInterface taoInterface = null;
        while(tmp.length()>0)
        {
            taoInterface = taoInterfaceDao.selectByUri(tmp);
            if(taoInterface!=null)
            {
                return taoInterface.getInterfaceId();
            }
            tmp = tmp.substring(0,tmp.length()-1);
        }

        return null;

    }
}
