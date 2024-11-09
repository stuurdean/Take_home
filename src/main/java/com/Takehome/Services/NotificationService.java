package com.Takehome.Services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.Takehome.Model.WithdrawalEvent;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private final SnsClient snsClient;


    public NotificationService() {
        this.snsClient = SnsClient.builder()
                .region(Region.US_EAST_1)
                .build();
    }

    public void publishWithdrawalEvent(WithdrawalEvent event) {
        String eventJson = event.toJson();
        String snsTopicArn = "arn:aws:sns:YOUR_REGION:YOUR_ACCOUNT_ID:YOUR_TOPIC_NAME";
        PublishRequest publishRequest = PublishRequest.builder()
                .message(eventJson)
                .topicArn(snsTopicArn)
                .build();

        try {
            PublishResponse response = snsClient.publish(publishRequest);
            logger.info("Withdrawal event published to SNS with Message ID: {}", response.messageId());
        } catch (Exception e) {
            logger.error("Failed to publish withdrawal event to SNS", e);
        }
    }
}
