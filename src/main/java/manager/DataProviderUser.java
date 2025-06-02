package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]>list = new ArrayList<>();
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"test12@gmail.com", "vilevinQa!1234"});
        list.add(new Object[]{"test1301@gmail.com", "vilevinQa!1234"});
        list.add(new Object[]{"test3535@gmail.com", "vilevinQa!1234"});
//
        return list.iterator();
    }



    @DataProvider
    public Iterator<Object[]> loginModels(){
        List<Object[]>list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("test12@gmail.com").withPassword("vilevinQa!1234")});
        list.add(new Object[]{new User().withEmail("test1301@gmail.com").withPassword("vilevinQa!1234")});
        list.add(new Object[]{new User().withEmail("test3535@gmail.com").withPassword("vilevinQa!1234")});

        return list.iterator();
    }

}
