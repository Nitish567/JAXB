package org.nitish.JAXB.IMCS_JAXB;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Marshalling {

	public static void main(String[] args) {
		Payment payment = new Payment();
		payment.setCardName("Nitish Chinthagda");
		payment.setCardNumber(1234567890);
		payment.setCardType("Debit");
		String date = "11/2019";
		payment.setDateFrom(getDate(date));

		String date1 = "11/2021";
		payment.setDateTo(getDate(date1));

		Address address = new Address();
		address.setAddressLine("1503");
		address.setCity("Charlotte");
		address.setCountry("USA");
		address.setState("NC");
		address.setZip(28262);

		Customer customer = new Customer();
		customer.setCustomerId(567);
		customer.setCustomerName("Nitish");
		customer.setSalary(150000);
		customer.setAddress(address);
		customer.setPayments(payment);

		customer.setDateOfBirth("02/25/1992");

		try {

			File file = new File("C:\\Users\\nitis\\eclipse-workspace-IMCS\\IMCS-JAXB\\src\\main\\resources\\customer.xml");
			if (!file.exists()) {
				file.createNewFile();
			}
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static XMLGregorianCalendar getDate(String givenDate) {
		SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
		Date startDate;
		try {
			startDate = format.parse(givenDate);
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(startDate);
			XMLGregorianCalendar dateMade = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			return dateMade;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
		
			e.printStackTrace();
		}
		return null;

	}
}
