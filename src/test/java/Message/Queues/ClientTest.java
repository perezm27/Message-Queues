//package Message.Queues;
//
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessageCreator;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import com.mockrunner.mock.jms.MockQueue;
//
//import static org.junit.Assert.*;
//
//public class ClientTest {
//
//    @RunWith(SpringJUnit4ClassRunner.class)
//    @ContextConfiguration("applicationContext-mockrunner.xml")
//    public class MockRunnerJmsSenderTest {
//        @Autowired
//        private JmsTemplate jmsTemplate;
//        @Autowired
//        private MockQueue mockQueue;
//        @Test
//        public void shouldSendMessage()
//        {
//            jmsTemplate.send(mockQueue, new MessageCreator() {
//                @Override
//                public Message createMessage(Session session) throws JMSException {
//                    TextMessage  message = session.createTextMessage();
//                    message.setText("This is test message from MockRunner");
//                    return message;
//                }
//            });
//        }
//    }