package listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import model.User;

import java.util.Date;

@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getName().equals("user")) {
            System.out.println("User with " + ((User) event.getValue()).getUsername() + " username logged in at " + new Date());
        }
    }

}
