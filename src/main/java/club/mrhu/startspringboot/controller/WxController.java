package club.mrhu.startspringboot.controller;

import club.mrhu.startspringboot.config.WxMpParam;
import club.mrhu.startspringboot.config.WxMpParam2;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "wx获取配置文件信息")
@RestController
public class WxController {
    @Autowired
    WxMpParam wxMpParam;

    @Autowired
    WxMpParam2 wxMpParam2;

    @GetMapping("/wx1")
    public Map<String, String> wxConfig() {
        String appid = wxMpParam.getAppid();
        String secret = wxMpParam.getSecret();
        HashMap<String, String> resultmap = new HashMap<>();
        resultmap.put("appid", appid);
        resultmap.put("secret", secret);
        return resultmap;
    }

    @GetMapping("/wx2")
    public Map<String, String> wxConfig2() {
        String appid = wxMpParam2.getAppid();
        String secret = wxMpParam2.getSecret();
        HashMap<String, String> resultmap = new HashMap<>();
        resultmap.put("appid", appid);
        resultmap.put("secret", secret);
        return resultmap;
    }
}
