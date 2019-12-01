package com.learn.dao;


import com.learn.domain.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoMo {

    @Autowired
    private MongoTemplate mongoTemplate;

    public  void saveUser(User user){
        mongoTemplate.save(user);
    }
    public  User findUserByUserName(String userName){
        Query  query=new Query(Criteria.where("userName").is(userName));
        User user=mongoTemplate.findOne(query,User.class);
        return  user;
    }
    public  long updateUser(User user){
        Query query=new Query(Criteria.where("userId").is(user.getUserId()));
        Update update=new Update().set("credits",user.getCredits()).set("lastIp",user.getLastIp()).set("lastVisit",user.getLastVisit());

        UpdateResult updateResult= mongoTemplate.updateFirst(query,update,User.class);
        if(updateResult != null){
            return  updateResult.getMatchedCount();
        }
        else
            return  0;
    }
    public  void removeUser(User user){
           Query query=new Query(Criteria.where("userId").is(user.getUserId()));
           mongoTemplate.remove(query,User.class);

    }
}
