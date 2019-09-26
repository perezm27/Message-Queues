package Message.Queues;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;


public class Publisher {

    //Queue Publisher
    //Sends a message to a queue, using its ARN or URL
    private static final String QUEUE_NAMEA = "QueueA";
    private static final String QUEUE_NAMEB = "QueueB";
    private static final String QUEUE_NAMEC = "QueueC";

    public static void main(String[] args)
    {
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

        try {
            CreateQueueResult create_result = sqs.createQueue(QUEUE_NAMEB);
        } catch (AmazonSQSException e) {
            if (!e.getErrorCode().equals("QueueAlreadyExists")) {
                throw e;
            }
        }

        String queueUrlA = sqs.getQueueUrl(QUEUE_NAMEA).getQueueUrl();
        String queueUrlB = sqs.getQueueUrl(QUEUE_NAMEB).getQueueUrl();
        String queueUrlC = sqs.getQueueUrl(QUEUE_NAMEC).getQueueUrl();

        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrlB)
                .withMessageBody("hello world this is for  QB")
                .withDelaySeconds(5);
        sqs.sendMessage(send_msg_request);


        // Send multiple messages to the queue
        SendMessageBatchRequest send_batch_request = new SendMessageBatchRequest()
                .withQueueUrl(queueUrlA)
                .withEntries(
                        new SendMessageBatchRequestEntry(
                                "msg_1", "Hello message 1 QA"),
                        new SendMessageBatchRequestEntry(
                                "msg_2", "Hello message 2 QA")
                                .withDelaySeconds(10));
        sqs.sendMessageBatch(send_batch_request);


        SendMessageBatchRequest send_batch_requests = new SendMessageBatchRequest()
                .withQueueUrl(queueUrlC)
                .withEntries(
                        new SendMessageBatchRequestEntry(
                                "msg_1", "Hello from message 1 QC"),
                        new SendMessageBatchRequestEntry(
                                "msg_2", "Hello from message 2 QC")
                                .withDelaySeconds(10));
        sqs.sendMessageBatch(send_batch_requests);
    }
}
