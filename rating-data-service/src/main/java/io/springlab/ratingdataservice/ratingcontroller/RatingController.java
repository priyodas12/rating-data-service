package io.springlab.ratingdataservice.ratingcontroller;

import io.springlab.ratingdataservice.model.Rating;
import io.springlab.ratingdataservice.model.UserRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {



    private static Logger log= LoggerFactory.getLogger(RatingController.class);

    @Value("${eureka.instance.instance-id}")
    private String instanceId;

    @RequestMapping(path = "/{movieId}",method = RequestMethod.GET)
    public Rating getRatingsInfo(@PathVariable("movieId") String movieId){
        log.debug("getRatingsInfo() called.... ");
        return new Rating(movieId,4);
    }

    @RequestMapping(path = "/users/{userId}",method = RequestMethod.GET)
    public UserRating getRatingsInfoByUserId(@PathVariable("userId") String userId){
        log.debug("getRatingsInfoByUserId called.... {}",instanceId);
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }
}
