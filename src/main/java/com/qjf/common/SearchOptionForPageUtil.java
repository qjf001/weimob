package com.qjf.common;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/10.
 */
public class SearchOptionForPageUtil {

    /**  [id=xx value=xxx]  **/
    public static String rebuild(List<Map<String,Object>> datas,String optionValue , String OptionText)
    {
        Map map = new HashMap<>();
        map.put(optionValue," ");
        map.put(OptionText,"請選擇");
        datas.add(0,map);
        String jsonStr = JSON.toJSONString(datas).replaceAll(optionValue,"v").replaceAll(OptionText,"t");
        return jsonStr;
    }

}
