package com.example.accessingdatamysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @InterfaceName CommentRepository
 * @Description TODO
 * @Author XiaoShuMu
 * @Version 1.0
 * @Create 2021-12-06 14:55
 * @Blog https://www.cnblogs.com/WLCYSYS/
 **/
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
