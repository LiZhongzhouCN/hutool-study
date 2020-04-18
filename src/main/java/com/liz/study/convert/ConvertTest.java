package com.liz.study.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

/**
 * @author liz
 * @Description:
 * @date: 2020/3/27 10:42
 */
@Slf4j
public class ConvertTest {

    public static void main(String[] args) {
        int a = 1;
        //aStr为"1"
        String aStr = Convert.toStr(a);
        log.info(aStr);

        long[] b = {1,2,3,4,5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        log.info(bStr);

        String c = "2017-05-06";
        Date value = Convert.toDate(c);
        log.info(String.valueOf(value));

        Object[] d = {"a", "你", "好", "", 1};
        List<?> list = Convert.toList(d);
        log.info(String.valueOf(list));


        Object[] e = { "a", "你", "好", "", 1 };
        List<String> list1 = Convert.convert(new TypeReference<List<String>>() {}, e);
        log.info(list1.toString());

        String f = "我不是乱码";
        //转换后result为乱码
        String result = Convert.convertCharset(f, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
        log.info("{},{}",result,raw);
    }
}
