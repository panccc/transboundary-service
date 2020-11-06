package com.transample.demo.service;


public interface ITaoInterfaceService {

    /**
     * 根据controller和method名字获得接口id
     * @param controller
     * @param method
     * @return
     */
    public String getInterfaceId(String controller, String method);
}
