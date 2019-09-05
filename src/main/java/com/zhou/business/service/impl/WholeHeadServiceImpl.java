package com.zhou.business.service.impl;

import com.zhou.business.dal.business.entity.WholesaleDetail;
import com.zhou.business.dal.business.entity.WholesaleHead;
import com.zhou.business.dal.business.mapper.WholesaleHeadMapper;
import com.zhou.business.dal.toolmall.model.WdtStockinOrderRefundDetailSyncModel;
import com.zhou.business.dal.toolmall.model.WdtStockinOrderRefundSyncModel;
import com.zhou.business.dal.toolmall.model.WdtStockoutOrderTradeDetailSyncModel;
import com.zhou.business.dal.toolmall.model.WdtStockoutOrderTradeSyncModel;
import com.zhou.business.result.SyncResult;
import com.zhou.business.service.WholeHeadService;
import com.zhou.business.service.WholesaleDetailService;
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
public class WholeHeadServiceImpl implements WholeHeadService {

    @Autowired
    private WholesaleHeadMapper wholesaleHeadMapper;

    @Autowired
    private WholesaleDetailService wholesaleDetailService;

    private final static String WHID = "001901";

    private final static String SEATID = "08000101";

    @Override
    @Transactional(value = "businessTransactionManager", rollbackFor = { Exception.class })
    public SyncResult stockoutOrderTradeSync(List<WdtStockoutOrderTradeSyncModel> syncModelList) {
        SyncResult syncResult = new SyncResult();
        List<WholesaleHead> wholesaleHeadList = new ArrayList<>();
        List<WholesaleDetail> wholesaleDetailList = new ArrayList<>();
        List<String> wholesaleIds = new ArrayList<>();
        for(WdtStockoutOrderTradeSyncModel syncModel : syncModelList){
            if(!wholesaleIds.contains(syncModel.getOrderNo())){
                wholesaleIds.add(syncModel.getOrderNo());
            }
        }
        List<String> existWholesaleIds = wholesaleHeadMapper.selectWholesaleidsByWholesaleids(wholesaleIds);
        for(WdtStockoutOrderTradeSyncModel syncModel : syncModelList){
            if(!existWholesaleIds.contains(syncModel.getOrderNo())){
                WholesaleHead wholesaleHead = new WholesaleHead();
                wholesaleHead.setWhid(WHID);
                wholesaleHead.setWholesaleid(syncModel.getOrderNo());
                wholesaleHead.setInputdate(new Date());
                wholesaleHead.setFlag("2");
                wholesaleHead.setClientid(syncModel.getCustomerNo());
                wholesaleHead.setOperatorid("");
                wholesaleHead.setRemarks(syncModel.getOrderNo());
                wholesaleHead.setUpdatedate(syncModel.getModified());
                wholesaleHead.setStatus("0");
                wholesaleHead.setPayflag("0");
                wholesaleHead.setInvoiceflag("0");
                wholesaleHead.setPaydate(syncModel.getPayTime());
                wholesaleHead.setInvoicedate(null);
                wholesaleHead.setShdate(syncModel.getStockCheckTime());
                wholesaleHead.setShflag("0");
                wholesaleHeadList.add(wholesaleHead);
            }
            // 序号
            int serialNo = 0;
            for(WdtStockoutOrderTradeDetailSyncModel detailSyncModel : syncModel.getItemList()){
                WholesaleDetail wholesaleDetail = wholesaleDetailService.getByWholesaleidAndProid(syncModel.getOrderNo(),detailSyncModel.getSpecNo());
                if(wholesaleDetail == null){
                    wholesaleDetail = new WholesaleDetail();
                    wholesaleDetail.setProid(detailSyncModel.getSpecNo());
                    wholesaleDetail.setWholesaleid(syncModel.getOrderNo());
                    wholesaleDetail.setSeatid(SEATID);
                    wholesaleDetail.setSaleqty(detailSyncModel.getGoodsCount());
                    wholesaleDetail.setSaleprice(detailSyncModel.getSellPrice());
                    wholesaleDetail.setSaletax(detailSyncModel.getTaxRate());
                    wholesaleDetail.setCostprice(detailSyncModel.getCostPrice());
                    wholesaleDetail.setPacketqty(new BigDecimal(1));
                    wholesaleDetail.setBoxqty(new BigDecimal(1));
                    wholesaleDetail.setFlowid(++serialNo);
                    wholesaleDetailList.add(wholesaleDetail);
                }
            }
        }
        if(wholesaleHeadList.size()>0){
            wholesaleHeadMapper.batchSave(wholesaleHeadList);
        }
        if(wholesaleDetailList.size()>0){
            wholesaleDetailService.batchSave(wholesaleDetailList);
        }
        return syncResult;
    }

    @Override
    @Transactional(value = "businessTransactionManager", rollbackFor = { Exception.class })
    public SyncResult stockinOrderRefundSync(List<WdtStockinOrderRefundSyncModel> syncModelList) {
        SyncResult syncResult = new SyncResult();
        List<WholesaleHead> wholesaleHeadList = new ArrayList<>();
        List<WholesaleDetail> wholesaleDetailList = new ArrayList<>();
        List<String> wholesaleIds = new ArrayList<>();
        for(WdtStockinOrderRefundSyncModel syncModel : syncModelList){
            if(!wholesaleIds.contains(syncModel.getOrderNo())){
                wholesaleIds.add(syncModel.getOrderNo());
            }
        }
        List<String> existWholesaleIds = wholesaleHeadMapper.selectWholesaleidsByWholesaleids(wholesaleIds);
        for(WdtStockinOrderRefundSyncModel refundSyncModel : syncModelList){
            if(!existWholesaleIds.contains(refundSyncModel.getOrderNo())){
                WholesaleHead wholesaleHead = new WholesaleHead();
                wholesaleHead.setWhid(WHID);
                wholesaleHead.setWholesaleid(refundSyncModel.getOrderNo());
                wholesaleHead.setInputdate(new Date());
                wholesaleHead.setFlag("2");
                wholesaleHead.setClientid(refundSyncModel.getCustomerNo());
                wholesaleHead.setOperatorid("");
                wholesaleHead.setRemarks(refundSyncModel.getOrderNo());
                wholesaleHead.setUpdatedate(refundSyncModel.getGmtModify());
                wholesaleHead.setStatus("0");
                wholesaleHead.setPayflag("0");
                wholesaleHead.setInvoiceflag("0");
                wholesaleHead.setPaydate(null);
                wholesaleHead.setInvoicedate(null);
                wholesaleHead.setShdate(refundSyncModel.getCheckTime());
                wholesaleHead.setShflag("0");
                wholesaleHeadList.add(wholesaleHead);
            }
            // 序号
            int serialNo = 0;
            for(WdtStockinOrderRefundDetailSyncModel detailSyncModel : refundSyncModel.getItemList()){
                WholesaleDetail wholesaleDetail = wholesaleDetailService.getByWholesaleidAndProid(refundSyncModel.getOrderNo(),detailSyncModel.getSpecNo());
                if(wholesaleDetail == null){
                    wholesaleDetail = new WholesaleDetail();
                    wholesaleDetail.setWholesaleid(refundSyncModel.getOrderNo());
                    wholesaleDetail.setProid(detailSyncModel.getSpecNo());
                    wholesaleDetail.setSeatid(SEATID);
                    wholesaleDetail.setSaleqty(detailSyncModel.getGoodsCount());
                    wholesaleDetail.setSaleprice(detailSyncModel.getSrcPrice());
                    wholesaleDetail.setSaletax(detailSyncModel.getTax());
                    wholesaleDetail.setCostprice(detailSyncModel.getCostPrice());
                    wholesaleDetail.setPacketqty(new BigDecimal(1));
                    wholesaleDetail.setBoxqty(new BigDecimal(1));
                    wholesaleDetail.setFlowid(++serialNo);
                    wholesaleDetailList.add(wholesaleDetail);
                }
            }
        }
        if(wholesaleHeadList.size()>0){
            wholesaleHeadMapper.batchSave(wholesaleHeadList);
        }
        if(wholesaleDetailList.size()>0){
            wholesaleDetailService.batchSave(wholesaleDetailList);
        }
        return syncResult;
    }
}
