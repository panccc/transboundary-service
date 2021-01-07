package com.transample.demo.controller;

import com.transample.demo.common.ResponseResult;
import com.transample.demo.common.ResultCode;
import com.transample.demo.domain.*;
import com.transample.demo.service.FundService;
import com.transample.demo.service.ITaoMurakamiService;
import com.transample.demo.service.ITaoSellerService;
import com.transample.demo.service.ITaoVillagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

//@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关API")
public class UserController {

    @Autowired
    private ITaoVillagerService taoVillagerService;

//    @Autowired
//    private ITaoMurakamiService taoMurakamiService;

    @Autowired
    private ITaoSellerService taoSellerService;

    @Resource
    private FundService fundService;

    @PostMapping("/login/villager")
    @ApiOperation("村民登陆")
    public ResponseEntity<ResponseResult> villagerLogin(@RequestBody TaoVillager villager) {

        return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.login(villager)));

    }

//    @GetMapping("/login/villagerBySession")
//    @ApiOperation("村民从session获取登陆信息")
//    public ResponseEntity villagerLoginBySession(HttpSession session)
//    {
//        if(session.getAttribute("villager")==null||session.getAttribute("cart")==null)
//        {
//            return ResponseEntity.ok(ResponseResult.fail(ResultCode.ACCESS_DENIED));
//        }else
//        {
//            ModelMap modelMap = new ModelMap();
//            modelMap.put("villager",session.getAttribute("villager"));
//            modelMap.put("cart",session.getAttribute("cart"));
//            return ResponseEntity.ok(ResponseResult.ok(modelMap));
//        }
//    }

    /**
     * 村小二登陆20210107废弃
     *
     */
    /*
    @PostMapping("/login/murakami")
    @ApiOperation("村小二登陆")
    public ResponseEntity<ResponseResult> murakamiLogin(@RequestBody TaoMurakami murakami) {
        return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.login(murakami)));
    }*/

    @PostMapping("/login/seller")
    @ApiOperation("商家登陆")
    public ResponseEntity<ResponseResult> sellerLogin(@RequestBody TaoSeller seller) {
        return ResponseEntity.ok(ResponseResult.ok(taoSellerService.login(seller)));
    }

    @PostMapping("/login/fund")
    @ApiOperation("基金登陆")
    public ResponseEntity<ResponseResult> foundationLogin(@RequestBody Foundation foundation)
    {
        if (foundation.getId()==null||foundation.getPassword()==null)
            return ResponseEntity.ok(ResponseResult.fail(ResultCode.FILED_VALUE_INVALID));
        Foundation foundation1 = fundService.login(foundation.getId(),foundation.getPassword());
        if(foundation1==null)
            return ResponseEntity.ok(ResponseResult.fail(ResultCode.ACCESS_DENIED));
        return ResponseEntity.ok(ResponseResult.ok(foundation1));
    }

}
