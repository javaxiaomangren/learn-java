//package windy.learn.mongo;
//
//import com.google.common.collect.ImmutableList;
//import com.mongodb.*;
//
//import java.net.UnknownHostException;
//import java.util.List;
//
///**
// * 统计p的贡献净增量
// * Created by yang.hua on 14-2-14.
// */
//public class CountNewPoi {
//    public static void main(String[] args) throws UnknownHostException {
//        MongoClient client = new MongoClient("192.168.3.220", 27017);
//        DB db = client.getDB("cms");
//        boolean b = db.authenticate("cms", "cms".toCharArray());
//        DBCollection coll = db.getCollection("poi_info_product");
//        List<String> list = ImmutableList.of("theater_damai_api","dining_dianping_api","groupbuy_tuan800_api","cinema_kokozu_api","hotel_ctrip_wireless_api","discount_dingding_api","hotel_elong_api","dining_xiaomishu_api","groupbuy_lashou_api","car_bitauto_api","groupbuy_meituan_api","scenic_yikuaiqu_api","ali_activity_1111","ali_qqfood","ali_qunar","ali_soufun","ali_kaifanla","ali_sinahouse","ali_fantong","qingbao_base","golf_yungao_api","hospital_dianping_api","hotel_dianping_api","education_dianping_api","shopping_dianping_api","enjoy_dianping_api","scenic_dianping_api","dianping_api","building_dianping_api","residential_dianping_api","car_dianping_api","cinema_dianping_api","theater_dianping_api","sndt","hotel_hotelvp_api","road_cross","dining_diandian_api","groupbuy_like_api","site_collect","scenic_tuniu_api","scenic_17u_api","jingpin_special_shop","event_poi","cms_cinema_merge","business_hall_lnunicom","dianxin_haobai","hotel_tujia_api","juhe_oil_api","unispark","dianping_refresh","alimama","gdgjz","hd","panorama_hainanlisheng","groupbuy_jiaodian_api","chinatelecom_114_info","hotel_tc_api");
//        for (String o : list) {
//            BasicDBObject q = getQuery(o);
//            int c = coll.find(q).count();
//            System.out.println(o+"="+c);
//        }
//    }
//
//    private static BasicDBObject getQuery(String cp) {
//        // q={"baseinfo.from.src_type":"discount_dingding_api",
////                "baseinfo.from.opt_type":{"$ne":"d"},
////        "baseinfo.checked":{"$nin":["5",5,"6",6]}}
//        BasicDBList dbList = new BasicDBList();
//        dbList.add("5");
//        dbList.add(5);
//        dbList.add("6");
//        dbList.add(6);
//        return new BasicDBObject("baseinfo.from.src_type", cp)
//                .append("baseinfo.from.opt_type", new BasicDBObject("$ne", "d"))
//                .append("baseinfo.checked", new BasicDBObject("$nin", dbList));
//    }
//
//}
