package com.transample.demo.controller;

import com.transample.demo.annotation.ApiQualityLog;
import com.transample.demo.common.ResponseResult;
import com.transample.demo.common.ResultCode;
import com.transample.demo.domain.TaoMurakami;
import com.transample.demo.domain.TaoSeller;
import com.transample.demo.domain.TaoShoppingCart;
import com.transample.demo.domain.TaoVillager;
import com.transample.demo.service.ITaoMurakamiService;
import com.transample.demo.service.ITaoSellerService;
import com.transample.demo.service.ITaoVillagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

//@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理相关API")
public class UserController {

    @Autowired
    private ITaoVillagerService taoVillagerService;

    @Autowired
    private ITaoMurakamiService taoMurakamiService;

    @Autowired
    private ITaoSellerService taoSellerService;

    @ApiQualityLog(methodDesc = "村民登录",indexParams = "activeVillageCountsPerDay,villageLoginCountsPerDay",calculateType = "statistics")
    @PostMapping("/login/villager")
    @ApiOperation("村民登陆")
    public ResponseEntity<ResponseResult> villagerLogin(@RequestBody TaoVillager villager) {

        /*
         * 感知逻辑（业务无关）,有效
         */
        HashMap<String,String> indexes=new HashMap<>();
        indexes.put("userName",villager.getUserName());
        return ResponseEntity.ok(ResponseResult.ok(taoVillagerService.login(villager),indexes));
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


    @PostMapping("/login/murakami")
    @ApiOperation("村小二登陆")
    public ResponseEntity<ResponseResult> murakamiLogin(@RequestBody TaoMurakami murakami) {
        return ResponseEntity.ok(ResponseResult.ok(taoMurakamiService.login(murakami)));
    }

    @ApiQualityLog(methodDesc = "商家登录",indexParams = "sellerLoginCountsPerDay",calculateType = "statistics")
    @PostMapping("/login/seller")
    @ApiOperation("商家登陆")
    public ResponseEntity<ResponseResult> sellerLogin(@RequestBody TaoSeller seller) {
        /*
         * 感知逻辑（业务无关）
         */
        HashMap<String,String> indexes=new HashMap<>();
        indexes.put("userName",seller.getSellerName());
        return ResponseEntity.ok(ResponseResult.ok(taoSellerService.login(seller),indexes));
    }

}
