package thinkInJava.enumtest;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.Iterator;

/**
 * 在职责连（chain of responsibility）设计模式中，程序员
 * 以多种不同的方式来解决一个问题，然后将它们链接在一起。
 * 当一个请求到来时，它就遍历这个链，直到链中的某种方法能够处理这个请求。
 * @author lijianfu
 * 2017年12月7日
 * 下午1:34:22
 */

class Mail{
	enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}
	enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}
	enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}
	enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}
	enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}
	
	GeneralDelivery generalDelivery;
	Scannability scannability;
	Readability readability;
	Address address;
	ReturnAddress returnAddress;
	
	static long counter = 0;
	long id = counter++;
	
	public String toString(){
		return "Main" + id;
	}
	
	public String details(){
		return toString() + 
				", General Delivery: " + generalDelivery +
				", Address Scanability: " + scannability +
				", Address Readability: " + readability +
				", Address Address: " + address + 
				", ReturnAddress ReturnAddress: " + returnAddress;
	}
	
	//Generate test Main:
	public static Mail randomMain(){
		Mail m = new Mail();
		m.generalDelivery = Enums.random(GeneralDelivery.class);
		m.scannability = Enums.random(Scannability.class);
		m.readability = Enums.random(Readability.class);
		m.address = Enums.random(Address.class);
		m.returnAddress = Enums.random(ReturnAddress.class);
		return m;
	}
	
	public static Iterable<Mail> generator(final int count){
		return new Iterable<Mail>() {
			int n = count;
			
			@Override
			public Iterator<Mail> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Mail>() {
					public boolean hasNext(){
						return n-- > 0 ;
					}
					public Mail next(){
						return randomMain();
					}
					public void remove(){
						throw new UnsupportedAddressTypeException();
					}
				};
			}
		};
	}
}
/**
 * @author lijianfu
 * 2017年12月7日
 * 下午2:15:17
 */
/**
 * @author lijianfu
 * 2017年12月7日
 * 下午2:15:36
 */
public class PostOffice {

	enum MailHandler{
		
		GENERAL_DELIVERY{
			boolean handle(Mail m){
				switch(m.generalDelivery){
					case YES:
						System.out.println("Using general delivery for " + m);
						return true;
					default:
						return false;
				}
			}
		},
		
		MACHINE_SCAN{
			boolean handle(Mail m){
				switch(m.scannability){
				case UNSCANNABLE: 
					return false;
					default:
						switch(m.address){
						case INCORRECT:
							return false;
							default:
								System.out.println("Delivery " + m + " automatically");
								return true;
						}
				}
			}
		},
		
		VISUAL_INSPECTION {
			boolean handle(Mail m){
				switch(m.readability){
				case ILLEGIBLE: return false;
				default:
					switch(m.address){
					case INCORRECT: return false;
					default:
						System.out.println("Delivering " + m + " normally");
						return true;
					}
				}
			}
		},
		
		RETURN_TO_SENDER {
			boolean handle (Mail m){
				switch(m.returnAddress){
				case MISSING: return false;
				default:
					System.out.println("Returning " + m + " to sender");
					return true;
				}
			}
		};
		abstract boolean handle(Mail m);		
	}
	
	static void handle(Mail m){
		for (MailHandler handle : MailHandler.values()) {
			if (handle.handle(m)) {
				return;
			}
			System.out.println( m + " is a dead letter");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Mail mail : Mail.generator(10)) {
			System.out.println(mail.details());
			handle(mail);
			System.out.println("***************************");
		}
	}

}
