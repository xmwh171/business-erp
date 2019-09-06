package com.zhou.business.service.impl;

import com.zhou.business.dal.business.entity.OrderDetailDs;
import com.zhou.business.dal.business.entity.OrderHeadDs;
import com.zhou.business.dal.business.mapper.OrderHeadDsMapper;
import com.zhou.business.dal.business.model.BusinessOrderSyncModel;
import com.zhou.business.request.BusinessOrderSyncRequest;
import com.zhou.business.result.SyncResult;
import com.zhou.business.service.OrderHeadDsService;
import com.zhou.business.wdtclient.WdtApiIntegration;
import com.zhou.business.wdtclient.model.WdtStockinOrder;
import com.zhou.business.wdtclient.model.WdtStockinOrderItem;
import com.zhou.business.wdtclient.model.WdtStockoutOrderInfo;
import com.zhou.business.wdtclient.model.WdtStockoutOrderItem;
import com.zhou.business.wdtclient.result.WdtStockinOrderPushResult;
import com.zhou.business.wdtclient.result.WdtStockoutOrderPushResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/2 18:10
 */
@Slf4j
@Service
public class OrderHeadDsServiceImpl implements OrderHeadDsService {

    @Autowired
    private OrderHeadDsMapper orderHeadDsMapper;

    @Autowired
    private WdtApiIntegration wdtApiIntegration;

    @Override
    public OrderHeadDs getByOrderId(String orderId) {
        return orderHeadDsMapper.selectByOrderId(orderId);
    }

    @Override
    public List<BusinessOrderSyncModel> getBySyncRequest(BusinessOrderSyncRequest syncRequest) {
        return orderHeadDsMapper.selectBySyncRequest(syncRequest);
    }

    @Override
    public SyncResult pushToWdtStockin(List<BusinessOrderSyncModel> syncModelList) {
        SyncResult syncResult = new SyncResult();
        Date maxModifyDate = null;
        for(BusinessOrderSyncModel syncModel : syncModelList){
            Date modifyDate = syncModel.getReceiptdate();
            if (maxModifyDate == null || modifyDate.after(maxModifyDate)) {
                maxModifyDate = modifyDate;
            }
            WdtStockinOrder wdtStockinOrder = new WdtStockinOrder();
            wdtStockinOrder.setOuter_no(syncModel.getOrderid());
            wdtStockinOrder.setWarehouse_no("tumao2-test");
            wdtStockinOrder.setRemark(syncModel.getRemark());
            List<WdtStockinOrderItem> goodsList = new ArrayList<>();
            for(OrderDetailDs orderDetailDs : syncModel.getItemList()){
                WdtStockinOrderItem wdtStockinOrderItem = new WdtStockinOrderItem();
                wdtStockinOrderItem.setSpec_no(orderDetailDs.getProid());
                wdtStockinOrderItem.setStockin_num(orderDetailDs.getReceiptqty());
                wdtStockinOrderItem.setStockin_price(orderDetailDs.getReceiptprice());
                wdtStockinOrderItem.setSrc_price(orderDetailDs.getReceiptprice());
                goodsList.add(wdtStockinOrderItem);
            }
            wdtStockinOrder.setGoods_list(goodsList);
            WdtStockinOrderPushResult pushResult = wdtApiIntegration.stockinOrderPush(wdtStockinOrder);
            if(!pushResult.isSuccess() && pushResult.getCode()!=2350){
                syncResult.setSuccess(false);
                syncResult.setDetailMessage(pushResult.getMessage());
                return syncResult;
            }
        }
        syncResult.setMaxModifyDate(maxModifyDate);
        return syncResult;
    }

    @Override
    public SyncResult pushToWdtStockout(List<BusinessOrderSyncModel> syncModelList) {
        SyncResult syncResult = new SyncResult();
        Date maxModifyDate = null;
        for(BusinessOrderSyncModel syncModel : syncModelList){
            Date modifyDate = syncModel.getReceiptdate();
            if (maxModifyDate == null || modifyDate.after(maxModifyDate)) {
                maxModifyDate = modifyDate;
            }
            WdtStockoutOrderInfo wdtStockoutOrderInfo = new WdtStockoutOrderInfo();
            wdtStockoutOrderInfo.setOuter_no(syncModel.getOrderid());
            wdtStockoutOrderInfo.setWarehouse_no("tumao2-test");
            List<WdtStockoutOrderItem> orderItemList = new ArrayList<>();
            for(OrderDetailDs orderDetailDs : syncModel.getItemList()){
                WdtStockoutOrderItem wdtStockoutOrderItem = new WdtStockoutOrderItem();
                wdtStockoutOrderItem.setSpec_no(orderDetailDs.getProid());
                wdtStockoutOrderItem.setNum(orderDetailDs.getReceiptqty().abs());
                wdtStockoutOrderItem.setPrice(orderDetailDs.getReceiptprice());
                orderItemList.add(wdtStockoutOrderItem);
            }
            wdtStockoutOrderInfo.setDetail_list(orderItemList);
            WdtStockoutOrderPushResult pushResult = wdtApiIntegration.stockoutOrderPush(wdtStockoutOrderInfo);
            if(!pushResult.isSuccess() && pushResult.getCode()!=2350){
                syncResult.setSuccess(false);
                syncResult.setDetailMessage(pushResult.getMessage());
                return syncResult;
            }
        }
        syncResult.setMaxModifyDate(maxModifyDate);
        return syncResult;
    }

}
