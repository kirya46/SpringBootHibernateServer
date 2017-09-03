package com.common.dao.entity;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Kirill Stoianov on 01/09/17.
 */
public class URN {
    public static Random random = new Random(0);

    public static long generateId(){
        return Math.abs(random.nextLong());
    }

    public static URN generateURN(String entityName){
        return new URN(entityName);
    }

    public static URN generateURN(String entityName,long id){
        return new URN(id, entityName);
    }

    private long id;
    private String entityName;

    public URN(String entityName) {
        this.id = generateId();
        this.entityName = entityName;
    }

    public URN(long id, String entityName) {
        this.id = id;
        this.entityName = entityName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public String toString() {
        return "urn-"+this.entityName+"-"+this.id;
    }

    public String asUUID(){
        final String string = UUID.fromString(
                "5231b533ba17478798a3f2df37de2aD7"
                        .replaceFirst(
                                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"
                        )
        ).toString();
        return string;
    }
}
