package windy.learn.mongo;

import com.mongodb.BasicDBObject;

/**
 *
 * Created by yang.hua on 14-2-14.
 */
public class TestBson {
    public static void main(String[] args) {
        BasicDBObject doc = new BasicDBObject("name", "MongoDB").
                append("type", "database").
                append("count", 1).
                append("info", new BasicDBObject("x", 203).append("y", 102));
        System.out.println(doc.toString());
    }
}
