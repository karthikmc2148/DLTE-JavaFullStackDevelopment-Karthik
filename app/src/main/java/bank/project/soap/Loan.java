//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.17 at 12:55:16 PM IST 
//


package bank.project.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loanAppId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="loanAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="loanEmi" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="loanSchemeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loan", propOrder = {
    "loanAppId",
    "loanAmount",
    "loanEmi",
    "loanSchemeId",
    "customerId"
})
public class Loan {

    protected int loanAppId;
    protected double loanAmount;
    protected double loanEmi;
    protected int loanSchemeId;
    protected int customerId;

    /**
     * Gets the value of the loanAppId property.
     * 
     */
    public int getLoanAppId() {
        return loanAppId;
    }

    /**
     * Sets the value of the loanAppId property.
     * 
     */
    public void setLoanAppId(int value) {
        this.loanAppId = value;
    }

    /**
     * Gets the value of the loanAmount property.
     * 
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Sets the value of the loanAmount property.
     * 
     */
    public void setLoanAmount(double value) {
        this.loanAmount = value;
    }

    /**
     * Gets the value of the loanEmi property.
     * 
     */
    public double getLoanEmi() {
        return loanEmi;
    }

    /**
     * Sets the value of the loanEmi property.
     * 
     */
    public void setLoanEmi(double value) {
        this.loanEmi = value;
    }

    /**
     * Gets the value of the loanSchemeId property.
     * 
     */
    public int getLoanSchemeId() {
        return loanSchemeId;
    }

    /**
     * Sets the value of the loanSchemeId property.
     * 
     */
    public void setLoanSchemeId(int value) {
        this.loanSchemeId = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     */
    public void setCustomerId(int value) {
        this.customerId = value;
    }

}
