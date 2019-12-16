package com.huai.booksystem.web.service.Impl;

import com.huai.booksystem.web.dao.MenuDao;
import com.huai.booksystem.web.entity.Menu;
import com.huai.booksystem.web.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

/**
 * @Author: laiyunjing
 * @Date: 2019/11/21 0021 17:20
 * @Version 1.0
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public Integer add(Menu menu) {
        menuDao.save(menu);
        return 1;
    }

    @Override
    public Integer update(Menu menu) {
        Menu orgin = menuDao.findId(menu.getId());
        menu = repalce(menu,orgin);
        menuDao.save(menu);
        return 1;
    }

    @Override
    public List<Menu> list(Map<String, Object> map, Integer page, Integer pageSize) {
        Pageable pageable = new PageRequest(page,pageSize, Sort.Direction.ASC,"orderNo");
        Page<Menu> list = menuDao.findAll(new Specification<Menu>() {
            @Override
            public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
              Predicate predicate = criteriaBuilder.conjunction();
               if(map.get("pId") != null){
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get("pId"),map.get("PId")));

               }
               return  predicate;
            }
        },pageable);
        return list.getContent();
    }

    @Override
    public Long getTotal(Map<String, Object> map) {

        Long count  = menuDao.count(new Specification<Menu>() {
            @Override
            public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if(map.get("pId") != null){
                    predicate.getExpressions().add(criteriaBuilder.equal(root.get("pId"),map.get("PId")));

                }
                return predicate;
            }
        });
                return count;
    }

    @Override
    public Menu findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
         menuDao.deleteById(id);
    }

    @Override
    public List<Menu> findByPId(Integer pId) {
        return menuDao.findByPid(pId);
    }


    public Menu repalce(Menu curr, Menu origin){
        if(curr.getName() == null){
            curr.setName(origin.getName());
        }


        if(curr.getPid() == null){
            curr.setPid(origin.getPid());
        }

        if(curr.getUrl() == null){
            curr.setUrl(origin.getUrl());
        }

        if(curr.getState() == null){
            curr.setState(origin.getState());
        }

        if(curr.getIcon() == null){
            curr.setIcon(origin.getIcon());
        }

        if(curr.getPerssion() == null){
            curr.setOrderNo(origin.getOrderNo());
        }

        if(curr.getType() == null){
            curr.setType(origin.getType());
        }

        if(curr.getDivId() == null){
            curr.setDivId(origin.getDivId());
        }


        return curr;
    }
}
