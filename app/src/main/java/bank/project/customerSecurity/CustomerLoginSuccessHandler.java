//package bank.project.customerSecurity;
//
//import bank.project.dao.model.Customer;
//import bank.project.dao.service.BankService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.LockedException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ResourceBundle;
//@Component
//    public class CustomerLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//        @Override
//        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//            Customer customer= (Customer) authentication.getPrincipal();
//            logger.info(customer+" in success handler");
//// if(customer.getAttempts()==0)
//// logger.info("deactivate");
//            super.setDefaultTargetUrl("/mvn/dashboard");
//            super.onAuthenticationSuccess(request, response, authentication);
//        }
//    }

