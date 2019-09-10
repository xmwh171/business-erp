package com.zhou.business.service.impl;

import com.zhou.business.dal.business.entity.WholesaleDetailDs;
import com.zhou.business.dal.business.entity.WholesaleHeadDs;
import com.zhou.business.dal.business.mapper.WholesaleHeadDsMapper;
import com.zhou.business.dal.toolmall.model.WdtStockinOrderRefundDetailSyncModel;
import com.zhou.business.dal.toolmall.model.WdtStockinOrderRefundSyncModel;
import com.zhou.business.dal.toolmall.model.WdtStockoutOrderTradeDetailSyncModel;
import com.zhou.business.dal.toolmall.model.WdtStockoutOrderTradeSyncModel;
import com.zhou.business.result.SyncResult;
import com.zhou.business.service.WholeHeadDsService;
import com.zhou.business.service.WholesaleDetailDsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/9/4 18:46
 */
@Service
public class WholeHeadDsDsServiceImpl implements WholeHeadDsService {

    @Autowired
    private WholesaleHeadDsMapper wholesaleHeadDsMapper;

    @Autowired
    private WholesaleDetailDsService wholesaleDetailDsService;

    private final static String WHID = "01901";

    private final static String SEATID = "08000101";

    @Override
    @Transactional(value = "businessTransactionManager", rollbackFor = { Exception.class })
    public SyncResult stockoutOrderTradeSync(List<WdtStockoutOrderTradeSyncModel> syncModelList) {
        SyncResult syncResult = new SyncResult();
        List<WholesaleHeadDs> wholesaleHeadDsList = new ArrayList<>();
        List<WholesaleDetailDs> wholesaleDetailDsList = new ArrayList<>();
        List<String> wholesaleIds = new ArrayList<>();
        for(WdtStockoutOrderTradeSyncModel syncModel : syncModelList){
            if(!wholesaleIds.contains(syncModel.getOrderNo())){
                wholesaleIds.add(syncModel.getOrderNo());
            }
        }
        List<String> existWholesaleIds = wholesaleHeadDsMapper.selectWholesaleidsByWholesaleids(wholesaleIds);
        for(WdtStockoutOrderTradeSyncModel syncModel : syncModelList){
            if(!existWholesaleIds.contains(syncModel.getOrderNo())){
                WholesaleHeadDs wholesaleHeadDs = new WholesaleHeadDs();
                wholesaleHeadDs.setWhid(WHID);
                wholesaleHeadDs.setWholesaleid(syncModel.getOrderNo());
                wholesaleHeadDs.setInputdate(new Date());
                wholesaleHeadDs.setFlag("2");
                wholesaleHeadDs.setClientid(syncModel.getCustomerNo());
                wholesaleHeadDs.setOperatorid("");
                wholesaleHeadDs.setRemarks(syncModel.getOrderNo());
                wholesaleHeadDs.setUpdatedate(syncModel.getModified());
                wholesaleHeadDs.setStatus("0");
                wholesaleHeadDs.setPayflag("0");
                wholesaleHeadDs.setInvoiceflag("0");
                wholesaleHeadDs.setPaydate(syncModel.getPayTime());
                wholesaleHeadDs.setInvoicedate(null);
                wholesaleHeadDs.setShdate(syncModel.getStockCheckTime());
                wholesaleHeadDs.setShflag("0");
                wholesaleHeadDsList.add(wholesaleHeadDs);
            }
            // 序号
            int serialNo = 0;
            for(WdtStockoutOrderTradeDetailSyncModel detailSyncModel : syncModel.getItemList()){
                WholesaleDetailDs wholesaleDetailDs = wholesaleDetailDsService.getByWholesaleidAndProid(syncModel.getOrderNo(),detailSyncModel.getSpecNo());
                if(wholesaleDetailDs == null){
                    wholesaleDetailDs = new WholesaleDetailDs();
                    wholesaleDetailDs.setProid(detailSyncModel.getSpecNo());
                    wholesaleDetailDs.setWholesaleid(syncModel.getOrderNo());
                    wholesaleDetailDs.setSeatid(SEATID);
                    wholesaleDetailDs.setSaleqty(detailSyncModel.getGoodsCount());
                    wholesaleDetailDs.setSaleprice(detailSyncModel.getSellPrice());
                    wholesaleDetailDs.setSaletax(detailSyncModel.getTaxRate());
                    wholesaleDetailDs.setCostprice(detailSyncModel.getCostPrice());
                    wholesaleDetailDs.setPacketqty(new BigDecimal(1));
                    wholesaleDetailDs.setBoxqty(new BigDecimal(1));
                    wholesaleDetailDs.setFlowid(++serialNo);
                    wholesaleDetailDsList.add(wholesaleDetailDs);
                }
            }
        }
        if(wholesaleHeadDsList.size()>0){
            wholesaleHeadDsMapper.batchSave(wholesaleHeadDsList);
        }
        if(wholesaleDetailDsList.size()>0){
            wholesaleDetailDsService.batchSave(wholesaleDetailDsList);
        }
        return syncResult;
    }

    @Override
    @Transactional(value = "businessTransactionManager", rollbackFor = { Exception.class })
    public SyncResult stockinOrderRefundSync(List<WdtStockinOrderRefundSyncModel> syncModelList) {
        SyncResult syncResult = new SyncResult();
        List<WholesaleHeadDs> wholesaleHeadDsList = new ArrayList<>();
        List<WholesaleDetailDs> wholesaleDetailDsList = new ArrayList<>();
        List<String> wholesaleIds = new ArrayList<>();
        for(WdtStockinOrderRefundSyncModel syncModel : syncModelList){
            if(!wholesaleIds.contains(syncModel.getOrderNo())){
                wholesaleIds.add(syncModel.getOrderNo());
            }
        }
        List<String> existWholesaleIds = wholesaleHeadDsMapper.selectWholesaleidsByWholesaleids(wholesaleIds);
        for(WdtStockinOrderRefundSyncModel refundSyncModel : syncModelList){
            if(!existWholesaleIds.contains(refundSyncModel.getOrderNo())){
                WholesaleHeadDs wholesaleHeadDs = new WholesaleHeadDs();
                wholesaleHeadDs.setWhid(WHID);
                wholesaleHeadDs.setWholesaleid(refundSyncModel.getOrderNo());
                wholesaleHeadDs.setInputdate(new Date());
                wholesaleHeadDs.setFlag("2");
                wholesaleHeadDs.setClientid(refundSyncModel.getCustomerNo());
                wholesaleHeadDs.setOperatorid("");
                wholesaleHeadDs.setRemarks(refundSyncModel.getOrderNo());
                wholesaleHeadDs.setUpdatedate(refundSyncModel.getGmtModify());
                wholesaleHeadDs.setStatus("0");
                wholesaleHeadDs.setPayflag("0");
                wholesaleHeadDs.setInvoiceflag("0");
                wholesaleHeadDs.setPaydate(null);
                wholesaleHeadDs.setInvoicedate(null);
                wholesaleHeadDs.setShdate(refundSyncModel.getCheckTime());
                wholesaleHeadDs.setShflag("0");
                wholesaleHeadDsList.add(wholesaleHeadDs);
            }
            // 序号
            int serialNo = 0;
            for(WdtStockinOrderRefundDetailSyncModel detailSyncModel : refundSyncModel.getItemList()){
                WholesaleDetailDs wholesaleDetailDs = wholesaleDetailDsService.getByWholesaleidAndProid(refundSyncModel.getOrderNo(),detailSyncModel.getSpecNo());
                if(wholesaleDetailDs == null){
                    wholesaleDetailDs = new WholesaleDetailDs();
                    wholesaleDetailDs.setWholesaleid(refundSyncModel.getOrderNo());
                    wholesaleDetailDs.setProid(detailSyncModel.getSpecNo());
                    wholesaleDetailDs.setSeatid(SEATID);
                    wholesaleDetailDs.setSaleqty(detailSyncModel.getGoodsCount().multiply(new BigDecimal(-1)));
                    wholesaleDetailDs.setSaleprice(detailSyncModel.getSrcPrice());
                    wholesaleDetailDs.setSaletax(detailSyncModel.getTax());
                    wholesaleDetailDs.setCostprice(detailSyncModel.getCostPrice());
                    wholesaleDetailDs.setPacketqty(new BigDecimal(1));
                    wholesaleDetailDs.setBoxqty(new BigDecimal(1));
                    wholesaleDetailDs.setFlowid(++serialNo);
                    wholesaleDetailDsList.add(wholesaleDetailDs);
                }
            }
        }
        if(wholesaleHeadDsList.size()>0){
            wholesaleHeadDsMapper.batchSave(wholesaleHeadDsList);
        }
        if(wholesaleDetailDsList.size()>0){
            wholesaleDetailDsService.batchSave(wholesaleDetailDsList);
        }
        return syncResult;
    }
}
