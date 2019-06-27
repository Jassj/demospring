package demo.service;

import com.alibaba.fastjson.JSONObject;

public interface LoginService { //声明接口（虚拟类）,仅包含属性和方法定义,具体实现由业务类实现
    JSONObject login(String username, String password);
}
