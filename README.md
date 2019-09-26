## Lab: SQS - Message Queues
For this lab, you will be creating a few Message Queues and Broadcasters and wiring them through code.

## Feature Tasks 1
* Create 3 Standard Queues  
QueueA  
QueueB  
QueueC  
* Create command line applications in Java that use these queues
* Queue Publisher  
Sends a message to a queue, using its ARN or URL  
* Queue Client
Receives messages from a Queue (by ARN) and displays them  
* Food for thought …  
Which library will you choose to connect to the SQS system?  
How can you librarize your own solution so as not to be esoteric to a single application?

## Feature Tasks 2
- Create Lambda functions that are triggered by each of the 3 Queues
- They should perform the same task that your Java apps do
- Confirm that as you publish, you are seeing your app and the lambdas handle the queued messages at scale

## ScreenShots
![graph](/Users/permelfi/cf/401/Message-Queues/assets/graphLog.png)
![log](/Users/permelfi/cf/401/Message-Queues/assets/Logs.png)


## Collaborative Efforts
Padmapriya Ganapathi

## Works Cited
[AWS Doc Example Code](https://github.com/awsdocs/aws-doc-sdk-examples/blob/master/java/example_code/sqs/src/main/java/aws/example/sqs/SendReceiveMessages.java)  
[Sample Amazon SQS Function Code](https://docs.aws.amazon.com/lambda/latest/dg/with-sqs-create-package.html#with-sqs-example-deployment-pkg-java)