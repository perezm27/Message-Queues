package Message.Queues;

import com.amazonaws.services.sqs.model.Message;

import java.util.List;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

public class Client {
    public static void main(String[] args) {
        final AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

        final String QUEUE_NAMEA = "QueueA";
        final String QUEUE_NAMEB = "QueueB";
        final String QUEUE_NAMEC = "QueueC";

        String queueUrlA = sqs.getQueueUrl(QUEUE_NAMEA).getQueueUrl();
        String queueUrlB = sqs.getQueueUrl(QUEUE_NAMEB).getQueueUrl();
        String queueUrlC = sqs.getQueueUrl(QUEUE_NAMEC).getQueueUrl();
        // receive messages from the queue
        List<Message> messages = sqs.receiveMessage(queueUrlB).getMessages();

        for (Message m : messages) {
            System.out.println(m);
        }

    // delete messages from the queue
        for (Message m : messages) {
        sqs.deleteMessage(queueUrlB, m.getReceiptHandle());
     }


//        package example;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.amazonaws.services.lambda.runtime.events.SQSEvent;
//import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;
//
//        public class Handler implements RequestHandler<SQSEvent, Void>{
//            @Override
//            public Void handleRequest(SQSEvent event, Context context)
//            {
//                for(SQSMessage msg : event.getRecords()){
//                    System.out.println(new String(msg.getBody()));
//                }
//                return null;
//            }
//        }
    }
}
