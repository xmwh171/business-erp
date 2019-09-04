package com.zhou.business.util;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class ListUtils {


    /**
     * 将dataList中的数据分割,平均每个part份
     *
     * @param dataList
     * @param part
     * @return
     */
    public static <E> List<List<E>> part(List<E> dataList, int part) {
        if (dataList.size() == 0) {
            return new ArrayList<List<E>>(0);
        }
        int count = dataList.size() / part;
        if (count * part != dataList.size()) {
            count = count + 1;
        }
        return average(dataList, count);
    }

    /**
     * 将dataList中的数据，平均分成resultCount份，返回
     *
     * @param dataList
     * @param resultCount
     * @return
     */
    public static <E> List<List<E>> average(List<E> dataList, int resultCount) {
        List<List<E>> resultList = new ArrayList<List<E>>();
        int eachSize = dataList.size() / resultCount;
        if ((eachSize * resultCount) / 2 < dataList.size() / 2) {
            eachSize = eachSize + 1;
        }
        for (int i = 0; i < resultCount; i++) {
            List<E> eachList = new ArrayList<E>();
            resultList.add(eachList);
            int endIndex = (i + 1) * eachSize;
            endIndex = endIndex >= dataList.size() ? dataList.size() : endIndex;
            if (i + 1 == resultCount) {
                endIndex = dataList.size();
            }
            if (i * eachSize < dataList.size()) {
                eachList.addAll(dataList.subList(i * eachSize, endIndex));
            }
        }
        return (List<List<E>>) resultList;
    }
}
