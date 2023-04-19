package bank.project.app.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
//configuration for the soap webservice
public class ServiceConfigurationForLoan extends WsConfigurerAdapter {
    @Bean(name = "Loan")  //xsd bean name
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema loanSchema){
        DefaultWsdl11Definition schemaObject=new DefaultWsdl11Definition();
        schemaObject.setPortTypeName("loanPort");
        schemaObject.setTargetNamespace("http://soap.project.bank");
        schemaObject.setLocationUri("/loanPoint");
        schemaObject.setSchema(loanSchema);
        return schemaObject;
    }
    @Bean(name = "LoanScheme")   //xsd bean name
    public DefaultWsdl11Definition defaultWsdl11define(XsdSchema loanSchema) {
        DefaultWsdl11Definition schemaObject = new DefaultWsdl11Definition();
        schemaObject.setPortTypeName("loanPort");
        schemaObject.setTargetNamespace("http://soap.project.bank");
        schemaObject.setLocationUri("/loanPoint");
        schemaObject.setSchema(loanSchema);
        return schemaObject;
    }
    @Bean
    //define the xsd schema for loan
    public XsdSchema officialsSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("loan.xsd"));
    }
    @Bean
    //define the xsd schema for loanScheme
    public XsdSchema loanSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("loanScheme.xsd"));
    }
    @Bean
    //register the servlet
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet,"/loanPoint/*");
    }
}