package org.nitish.JAXB.IMCS_JAXB;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnMarshalling {
	public static void main(String[] args) {

		 try {

			File file = new File("C:\\Users\\nitis\\eclipse-workspace-IMCS\\IMCS-JAXB\\src\\main\\resources\\customer.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getAddress().getCity() + " "+ customer.getPayments().getCardType() );

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }

		}
}
