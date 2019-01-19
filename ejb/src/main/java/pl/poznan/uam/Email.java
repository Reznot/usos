package pl.poznan.uam;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    @Resource(name = "java:jboss/mail/gmail")
    private Session session;

    public void sendMail(String recipient, String subject, String body) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
}
}
