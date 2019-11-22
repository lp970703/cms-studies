package com.briup.cms.web.controller;

import com.briup.cms.bean.Customer;
import com.briup.cms.service.ICustomerService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "客户相关接口")  //在swagger2中告诉那个controller是个什么类型的，属性过期无所谓
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/showById/{id}")  //模板url
    @ApiOperation("根据id查询客户")  //告诉前端这个方法是干啥用的
    @ApiImplicitParam(name="id",value="顾客id",paramType = "query",dataType = "int")//修改了parameters的一些数据，描述，参数类型，数据类型等等，注意参数类型是query的作用就是如果没有query，那么这个参数就是json类型
    public Customer showById(@PathVariable int id){
        return customerService.findById(id);
    }


    @GetMapping("/aa")   //每写一个getmapping就是一个get请求
    @ApiOperation("/测试对象")
    public Message<Customer> aa(Customer customer){  //如果是个对象，就不能用上面哪种方式来写，上面那个是专门的id，那么就去它的pojo类里面的属性去写@Apixxxx
        //return new Message<>(200,xxxx);//这么写用的是util中第一个Message，但是后面要写一堆参数，所以有点麻烦

        //下面这个就是成功了呢就直接写好参数，具体写的就是上面那个new Message<>(200,xxxx)，可以看succes方法。这里面还有错误的方法等等
        return MessageUtil.success(customer);
    }

    @PostMapping("/bb")
    @ApiOperation("测试多个参数")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "顾客id", paramType = "query", dataType = "int")
            @ApiImplicitParam(name = "name", value = "顾客name", paramType = "query", dataType = "int")
    })
    public Message<String> bb(int id,String name){
        return MessageUtil.success();
    }
}
