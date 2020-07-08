package com.liz.study.file;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liz
 * @Description:
 * @date: 2020/7/3 16:55
 */
public class RouteFile {
    private static List<RouteInfo> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        RouteFile routeFile = new RouteFile();
        routeFile.readJson("doc/");
        routeFile.export(list);
    }

    private void setRouteInfo(String str){
        JSONObject jsonObject = JSONUtil.parseObj(str);
        JSONArray features = jsonObject.getJSONArray("features");

        for (Object feature : features) {
            long region_code;
            long parent_region_code;
            String properties;
            String center;
            String centroid;
            int childrenNum;
            int subFeatureIndex;
            String region_name;
            String geometry;

            JSONObject pro = JSONUtil.parseObj(feature).getJSONObject("properties");
            JSONObject geo = JSONUtil.parseObj(feature).getJSONObject("geometry");
            region_code = pro.getLong("adcode");
            parent_region_code = pro.getJSONObject("parent").getLong("adcode");
            properties = formatStr2(pro.getJSONArray("acroutes").toString(),String.valueOf(region_code));
            center = formatStr1(pro.getJSONArray("center").toString());
//            centroid = formatStr1(pro.getJSONArray("centroid").toString());
            centroid = "";
            childrenNum = pro.getInt("childrenNum");
            subFeatureIndex = pro.getInt("subFeatureIndex");
            region_name = pro.getStr("name");
            JSONArray coordinates = geo.getJSONArray("coordinates");
            JSONArray arrays = coordinates.getJSONArray(0).getJSONArray(0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MULTIPOLYGON(((");
            for (Object array : arrays) {
                stringBuilder.append(formatStr3(JSONUtil.parseArray(array).toString())).append(',');
            }
            geometry = stringBuilder.deleteCharAt(stringBuilder.length() - 1).append(")))").toString();

            RouteInfo info = new RouteInfo();
            info.setRegion_code(region_code);
            info.setParent_region_code(parent_region_code);
            info.setProperties(properties);
            info.setCenter(center);
            info.setCentroid(centroid);
            info.setChildrenNum(childrenNum);
            info.setRegion_name(region_name);
            info.setGeometry(geometry);
            info.setSubFeatureIndex(subFeatureIndex);
            list.add(info);
        }
    }

    private void export(List list){
        ExcelWriter writer = ExcelUtil.getBigWriter("E:\\idea_project\\hutool-study\\result\\nj.xlsx");
        String[] names = {"region_code", "parent_region_code", "properties", "center", "centroid","childrenNum","subFeatureIndex","region_name","geometry"};
        String[] names2 = {"region_code", "parent_region_code", "properties", "center", "centroid","childrenNum","subFeatureIndex","region_name","geometry"};
        for (int i = 0; i < names.length; i++) {
            writer.addHeaderAlias(names[i], names2[i]);
        }
        writer.setColumnWidth(4, 25);
        writer.write(list, true);
        writer.close();
    }

    /**
     *
     * [114.548151, 38.047501]转为  114.548151,38.047501
     * @param str
     * @return
     */
    private String formatStr1(String str){

        return str.substring(1,str.length() - 1);
    }

    /**
     * [100000, 130000, 130100]转为100000/130000/130700/130723
     * @param str
     * @return
     */
    private String formatStr2(String str, String str1){

        return str.substring(1,str.length() - 1).replace(',','/') + "/" + str1;
    }

    /**
     *
     * [114.548151, 38.047501]转为  114.548151 38.047501
     * @param str
     * @return
     */
    private String formatStr3(String str){

        return str.substring(1,str.length() - 1).replace(","," ");
    }

    private void readJson(String path) throws IOException {
        File[] files = new File(path).listFiles();
        FileInputStream fileInputStream = null;
        try {
            for (File file : files) {
                StringBuilder sb = new StringBuilder();
                fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }
                setRouteInfo(sb.toString());
            }
        }finally {
            fileInputStream.close();
        }
    }
}

@Data
class RouteInfo{
    private Long region_code;
    private Long parent_region_code;
    private String properties;
    private String center;
    private String centroid ;
    private Integer childrenNum;
    private Integer subFeatureIndex;
    private String region_name;
    private String geometry;
}
