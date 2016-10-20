package net.patisco.password.component;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import net.patisco.password.exception.PasswordFatalError;

@Component("emailSender")
public class EMailSender {
	
	//TODO USE JMX
//	private final JmsTemplate jmsTemplate;
//	
//	@Autowired
//	public EMailServiceImpl(JmsTemplate jmsTemplate) {
//	
//		this.jmsTemplate = jmsTemplate;
//		
//	}
	
	private JavaMailSender javaMailSender;

	@Autowired(required = false)
    public EMailSender(final JavaMailSender javaMailSender) {
		
        this.javaMailSender = javaMailSender;

    }
	
	private void sendEmail(String receiver, String subject, String msg) 
			throws AddressException, MessagingException {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message);		
        helper.setTo(new InternetAddress(receiver));
        helper.setSubject(subject);
        helper.setText(msg);

        javaMailSender.send(message);
		
	}

	@Async
	public void send(long token, String email) throws PasswordFatalError {
		
		//TODO 組EMail內容
		String subject = "(Contact Person)";
		String msg = "THIS IS A TEST EMAIL.";
		
		try {
			
			sendEmail(email, subject, msg);
			
		}
		catch(AddressException ae) {
			
			throw new PasswordFatalError(ae);
			
		} 
		catch (MessagingException e) {

			throw new PasswordFatalError(e);

		}
		
		
	}	

}
