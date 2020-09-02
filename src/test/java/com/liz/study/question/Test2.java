package com.liz.study.question;

import cn.hutool.json.JSONUtil;

/**
 * @author liz
 * @Description:
 * @date: 2020/7/20 16:23
 */
public class Test2 {

    public static void main(String[] args) {

        String str = "{\n" +
                "  \"ipAddress\": null,\n" +
                "  \"ipv6Address\": null,\n" +
                "  \"portNo\": null,\n" +
                "  \"protocol\": \"HTTP\",\n" +
                "  \"macAddress\": null,\n" +
                "  \"eventType\": \"vehicleRcogResult\",\n" +
                "  \"eventDescription\": \"vehicleRcogResult\",\n" +
                "  \"vehicleRcogResult\": [\n" +
                "    {\n" +
                "      \"taskID\": null,\n" +
                "      \"algorithmType\": 2,\n" +
                "      \"targetPicUrl\": \"http://172.18.43.162:6120/pic?3d1*\\u003d0s\\u003d\\u003d4170*8b8\\u003d750p*314601\",\n" +
                "      \"targetAttrs\": {\n" +
                "        \"passID\": \"bc13dedcda8f9729a542a6d6b5ec3722\",\n" +
                "        \"motorVehicleId\": \"320117170413200040129920200712133214440000262550\",\n" +
                "        \"passTime\": \"2020-07-12T13:32:14.000+08:00\",\n" +
                "        \"vehicleLen\": null,\n" +
                "        \"platePicUrl\": \"http://172.18.43.162:6120/pic?\\u003dd969*598\\u003d7b8*3118\\u003d8sp*1\\u003d112\",\n" +
                "        \"vehiclePicNum\": null,\n" +
                "        \"vehiclePicUrl1\": null,\n" +
                "        \"vehiclePicUrl2\": null,\n" +
                "        \"vehiclePicUrl3\": null,\n" +
                "        \"vehiclePicUrl4\": null,\n" +
                "        \"vehiclePicUrl5\": null,\n" +
                "        \"vehiclePicUrl6\": null,\n" +
                "        \"imageServerId\": null,\n" +
                "        \"facePicUrl\": null,\n" +
                "        \"crossingId\": 40000474,\n" +
                "        \"crossingIndexCode\": \"32012433001210002278\",\n" +
                "        \"cameraIndexCode\": \"32011717041320004012\",\n" +
                "        \"imageServerCode\": null,\n" +
                "        \"linkFaceVehicleId\": null,\n" +
                "        \"linkVehicleMacId\": null,\n" +
                "        \"longitude\": null,\n" +
                "        \"latitude\": null,\n" +
                "        \"cascade\": null,\n" +
                "        \"multiVehicle\": null,\n" +
                "        \"subFeature\": null,\n" +
                "        \"areaCode\": \"b5ce9905d52d484bae3f9b5bf005d3e2\",\n" +
                "        \"regionIndexCode\": \"b5ce9905d52d484bae3f9b5bf005d3e2\",\n" +
                "        \"recognitionSign\": 1,\n" +
                "        \"checkResult\": null,\n" +
                "        \"laneNo\": 2,\n" +
                "        \"licenseBright\": null,\n" +
                "        \"vehicleColorDepth\": null,\n" +
                "        \"vehicleEntryExitingStatus\": null,\n" +
                "        \"vehicleSpeed\": null,\n" +
                "        \"illegalTrafficEvent\": null,\n" +
                "        \"ecolabel\": null,\n" +
                "        \"directionIndex\": \"northSouth\",\n" +
                "        \"vehicleLamp\": null\n" +
                "      },\n" +
                "      \"target\": [\n" +
                "        {\n" +
                "          \"algorithmId\": \"1\",\n" +
                "          \"rect\": null,\n" +
                "          \"targetModelData\": null,\n" +
                "          \"vehicle\": {\n" +
                "            \"plateRect\": null,\n" +
                "            \"plateNo\": {\n" +
                "              \"value\": \"苏A0G9L5\",\n" +
                "              \"confidence\": null\n" +
                "            },\n" +
                "            \"plateType\": {\n" +
                "              \"value\": \"unknown\",\n" +
                "              \"confidence\": null\n" +
                "            },\n" +
                "            \"vehicleColor\": {\n" +
                "              \"value\": \"unknown\",\n" +
                "              \"confidence\": null\n" +
                "            },\n" +
                "            \"plateColor\": {\n" +
                "              \"value\": \"blue\",\n" +
                "              \"confidence\": null\n" +
                "            },\n" +
                "            \"vehicleType\": {\n" +
                "              \"value\": \"smallCar\",\n" +
                "              \"confidence\": null\n" +
                "            },\n" +
                "            \"vehicleLogo\": {\n" +
                "              \"value\": \"0\",\n" +
                "              \"confidence\": null\n" +
                "            },\n" +
                "            \"vehicleSubLogo\": null,\n" +
                "            \"vehicleModel\": null,\n" +
                "            \"pilotSafebelt\": {\n" +
                "              \"value\": \"no\",\n" +
                "              \"confidence\": null\n" +
                "            },\n" +
                "            \"vicePilotSafebelt\": null,\n" +
                "            \"pilotSunvisor\": {\n" +
                "              \"value\": \"no\",\n" +
                "              \"confidence\": null\n" +
                "            },\n" +
                "            \"vicePilotSunvisor\": null,\n" +
                "            \"uphone\": {\n" +
                "              \"value\": \"yes\",\n" +
                "              \"confidence\": null\n" +
                "            },\n" +
                "            \"dangmark\": null,\n" +
                "            \"envprosign\": null,\n" +
                "            \"tricycleCanopy\": null,\n" +
                "            \"tempplateNo\": null,\n" +
                "            \"pdvs\": null,\n" +
                "            \"copilot\": null,\n" +
                "            \"decoration\": null,\n" +
                "            \"tissueBox\": null,\n" +
                "            \"frontChild\": null,\n" +
                "            \"vehicleHead\": null,\n" +
                "            \"pendant\": null,\n" +
                "            \"card\": null,\n" +
                "            \"cardNum\": null,\n" +
                "            \"cardType\": null,\n" +
                "            \"cardPosition\": null,\n" +
                "            \"muckTruck\": null,\n" +
                "            \"vehicleState\": null,\n" +
                "            \"sunroof\": null,\n" +
                "            \"luggageRack\": null,\n" +
                "            \"vehicleSprayPainted\": null,\n" +
                "            \"spareTire\": null,\n" +
                "            \"coverPlate\": null,\n" +
                "            \"label\": null,\n" +
                "            \"labelNum\": null,\n" +
                "            \"labelPosition\": null,\n" +
                "            \"decorationPosition\": null,\n" +
                "            \"tissueBoxPosition\": null,\n" +
                "            \"pendantPosition\": null,\n" +
                "            \"pdvsPosition\": null,\n" +
                "            \"pilotPosition\": null,\n" +
                "            \"vicePilotPosition\": null\n" +
                "          },\n" +
                "          \"analysis_status\": null\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        String s = JSONUtil.parseObj(str).toString();
        System.out.println(s);

    }
}
