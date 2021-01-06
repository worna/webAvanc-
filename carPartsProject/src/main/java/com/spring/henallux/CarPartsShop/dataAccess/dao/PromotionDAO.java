package com.spring.henallux.CarPartsShop.dataAccess.dao;

import com.spring.henallux.CarPartsShop.dataAccess.entity.ProductEntity;
import com.spring.henallux.CarPartsShop.dataAccess.entity.PromotionEntity;
import com.spring.henallux.CarPartsShop.dataAccess.repository.ProductRepository;
import com.spring.henallux.CarPartsShop.dataAccess.repository.PromotionRepository;
import com.spring.henallux.CarPartsShop.dataAccess.util.ProviderConverter;
import com.spring.henallux.CarPartsShop.model.Product;
import com.spring.henallux.CarPartsShop.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class PromotionDAO implements PromotionDataAccess {
    private PromotionRepository promotionRepository;
    private ProviderConverter providerConverter;


    @Autowired
    public PromotionDAO(PromotionRepository promotionRepository, ProviderConverter providerConverter) {
        this.promotionRepository = promotionRepository;
        this.providerConverter = providerConverter;
    }

    public List<Promotion> findTodayPromotions (){
        List<Promotion> promotions = new ArrayList<>();
        List<PromotionEntity> promotionEntities = promotionRepository.findTodayPromotions(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        for(PromotionEntity promotionEntity : promotionEntities){
            promotions.add(providerConverter.promotionEntityToPromotionModel(promotionEntity));
        }

        return promotions;
    }
}
