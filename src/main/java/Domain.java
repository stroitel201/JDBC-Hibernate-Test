import business.Util;
import entity.Address;
import service.AddressService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Domain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Address address = new Address();
        address.setId(2L);
        address.setCountry("USA");
        address.setCity("LA");
        address.setStreet("Avenue 5");
        address.setPostCode("220032");


        List<Address> list;
        new AddressService().remove(address);;
        list = new AddressService().getAll();
        for (Address i:
             list) {
            System.out.println(i);
        }
    }
}
