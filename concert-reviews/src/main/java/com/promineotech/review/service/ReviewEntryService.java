package com.promineotech.review.service;

import com.promineotech.review.entity.Review;
import com.promineotech.review.entity.ReviewEntry;

public interface ReviewEntryService {
	
	Review createReview(ReviewEntry review);
	
	Review update(ReviewEntry review, Long reviewPK);

	Review delete(Long reviewPK);

}
