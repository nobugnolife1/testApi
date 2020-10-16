package com.DoAn.HairStyle.respositiry;

import com.DoAn.HairStyle.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


public interface BlogRespository extends JpaRepository<BlogEntity, Long> {
    @Transactional
    void  deleteByBlogID(Long id);


}
